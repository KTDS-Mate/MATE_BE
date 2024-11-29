package com.mate.websocket.config;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mate.user.vo.UserVO;
import com.mate.websocket.service.ChattingService;
import com.mate.websocket.vo.MessageVO;

@Controller
public class ChattingWebsocketHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChattingWebsocketHandler.class);

    @Autowired
    private ChattingService chattingService;

    private final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        logger.info("새로운 세션 연결됨: {}", session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("수신된 메시지: {}", message.getPayload());

        // JSON 문자열을 MessageVO 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        MessageVO msg = objectMapper.readValue(message.getPayload(), MessageVO.class);

        // DB에 메시지 저장
        int result = chattingService.insertMessage(msg);

        if (result > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            msg.setSendTime(sdf.format(new Date()));

            // 접속 중인 모든 사용자에게 메시지 전송
            for (WebSocketSession s : sessions) {
                UserVO loginUser = (UserVO) s.getAttributes().get("loginUser");
                if (loginUser != null) {
                    String loginMemberId = loginUser.getUsrLgnId();

                    // 송신자 또는 수신자에게만 메시지 전달
                    if (loginMemberId.equals(msg.getSenderId()) || loginMemberId.equals(msg.getTargetId())) {
                        s.sendMessage(new TextMessage(new Gson().toJson(msg)));
                        logger.debug("메시지 전송됨: {}", msg);
                    }
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        logger.info("세션 종료됨: {}", session.getId());
    }
}
