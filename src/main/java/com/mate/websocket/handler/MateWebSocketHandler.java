package com.mate.websocket.handler;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mate.chatting.service.ChattingService;
import com.mate.chatting.vo.MessageVO;
import com.mate.common.beans.security.jwt.JsonWebTokenProvider;
import com.mate.user.vo.UserVO;

@Component
public class MateWebSocketHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(MateWebSocketHandler.class);

    @Autowired
    private ChattingService chattingService;

    @Autowired
    private JsonWebTokenProvider jsonWebTokenProvider;

    private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());

    private Map<String, WebSocketSession> connectedSessionMap;
    
    private Map<String, List<String>> sessionGroupMap;
    
    private Gson gson;
    
    private MateWebSocketHandler() {
    	this.connectedSessionMap = new HashMap<>();
    	this.sessionGroupMap = new HashMap<>();
    	
    	this.gson = new Gson();
    }
    
    /**
     * WebSocket 연결 수립
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 세션 추가
        sessions.add(session);
        logger.info("웹소켓 연결됨: {}", session.getId());
    }

    /**
     * 메시지 수신 처리
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("수신 메시지: {}", message.getPayload());

        // JWT 검증 및 사용자 추출
        UserVO userVO = extractUserFromToken(session);
        if (userVO == null) {
            session.close(CloseStatus.NOT_ACCEPTABLE);
            return;
        }
        
        // 메시지 파싱
        ObjectMapper objectMapper = new ObjectMapper();
        MessageVO msg = objectMapper.readValue(message.getPayload(), MessageVO.class);
        msg.setSenderId(userVO.getUsrId());

        // DB에 메시지 저장
        int result = chattingService.insertMessage(msg);

        if (result > 0) {
            // 메시지 전송 시간 설정
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            msg.setSendTime(sdf.format(new Date()));

            // 접속 중인 모든 사용자에게 메시지 전송
            for (WebSocketSession s : sessions) {
                UserVO connectedUser = extractUserFromToken(s);
                if (connectedUser == null) continue;

                if (connectedUser.getUsrId().equals(msg.getTargetId()) || connectedUser.getUsrId().equals(msg.getSenderId())) {
                    s.sendMessage(new TextMessage(new Gson().toJson(msg)));
                }
            }
        }
    }

    /**
     * WebSocket 연결 종료 처리
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        logger.info("웹소켓 연결 종료됨: {}", session.getId());
    }

    /**
     * JWT 토큰으로부터 사용자 정보 추출
     */
    private UserVO extractUserFromToken(WebSocketSession session) {
        try {
            String token = session.getHandshakeHeaders().getFirst("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
                return jsonWebTokenProvider.getUserFromJwt(token);
            }
        } catch (Exception e) {
            logger.error("JWT 검증 실패: {}", e.getMessage());
        }
        return null;
    }
    
    private void sendToOtherSessions(Map<String, String> textMessageMap, WebSocketSession session) {
    	
    	TextMessage textMessage = new TextMessage(this.gson.toJson(textMessageMap));
    	
    	this.connectedSessionMap.entrySet()
    							.stream()
    							.filter(entry -> entry.getValue() != session)
    							.forEach(entry -> {
    								try {
    									WebSocketSession each = entry.getValue();
    									if(each.isOpen()) {
    										synchronized(each) {
    											each.sendMessage(textMessage);
    										}
    									}
    								} catch (IOException e) {
    									logger.error(e.getMessage(), e);
    								}
    							});
    }
    
    private void sendToOneSession(Map<String, String> textMessageMap, String receiverEmail) {

        // 1. receiverEmail 사용자가 로그인해있는가?
        if(!this.connectedSessionMap.containsKey(receiverEmail)) {
            // receiverEmail 사용자가 로그인하지 않았음.
            return;
        }

        TextMessage textMessage = new TextMessage(this.gson.toJson(textMessageMap));
        WebSocketSession session = this.connectedSessionMap.get(receiverEmail);
        if (session.isOpen()) {
            try {
                synchronized (session) {
                    session.sendMessage(textMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendToGroupMembers(String groupId, Map<String, String> textMessageMap) {

        if( this.sessionGroupMap.get(groupId) == null) {
            return;
        }

        TextMessage textMessage = new TextMessage(this.gson.toJson(textMessageMap));

        this.sessionGroupMap.get(groupId)
                .stream()
                .map(email -> this.connectedSessionMap.get(email))
                .forEach(session -> {
                    if (session.isOpen()) {
                        try {
                            synchronized (session) {
                                session.sendMessage(textMessage);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}