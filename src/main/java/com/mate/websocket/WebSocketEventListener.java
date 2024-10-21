package com.mate.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.mate.chat.vo.ChatVO;

@Component
public class WebSocketEventListener extends TextWebSocketHandler {
    private ChatVO chatVO;
    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    public WebSocketEventListener(ChatVO chatVO) {
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.put(session.getId(), session);
        System.out.println("웹소켓이 연결되었습니다.");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session.getId());
        System.out.println("웹소켓이 연결 해제되었습니다.");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        // TODO: 메시지에서 ChatVO 객체를 추출하고 해당 정보를 이용해서 원하는 세션에 메시지를 전송해야 합니다.
        // 클라이언트로부터 메시지 수신
        String payload = message.getPayload();

        // 추출한 ChatVO에서 채팅 수신자를 가져오고,
        // 해당 수신자의 WebSocketSession을 찾아 메시지 전송일과 같이 전송한다고 가정합니다.
        WebSocketSession receiverSession = sessions.get(chatVO.getChatReceiverId());
        if(receiverSession != null) {
            receiverSession.sendMessage(new TextMessage("서버에서 받은 메시지: " + payload));
        }
    }
}