//package com.mate.websocket;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class MyWebSocketHandler extends TextWebSocketHandler {
//
//    public String searchUserName(WebSocketSession session) throws Exception {
//        String userName = null;
//        Map<String, WebSocketSession> map = new HashMap<>();
//        Map<String, Object> attributes = session.getAttributes();
//        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
//            if (entry.getValue() instanceof WebSocketSession) {
//                map.put(entry.getKey(), (WebSocketSession) entry.getValue());
//            }
//        }
//        if (map.containsKey("userName")) {
//            userName = (String) ((WebSocketSession) map.get("userName")).getAttributes().get("userName");
//        }
//        return userName;
//    }
//
//    // Map to hold WebSocketSession objects, keyed by user name
//    Map<String, WebSocketSession> sessions = new HashMap<>();
//
//    // WebSocket 연결 성공 시 동작
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        String userName = searchUserName(session);
//        if (userName != null) {
//            sessions.put(userName, session);
//            System.out.println("웹소켓이 연결되었으며 유저 네임은" + userName + "입니다.");
//        } else {
//            System.out.println("웹소켓이 연결되었으나 유저 네임을 찾을 수 없습니다.");
//        }
//    }
//
//    // WebSocket 연결 해제(종료) 시 동작
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        String userName = searchUserName(session);
//        if (userName != null) {
//            sessions.remove(userName);
//            System.out.println(userName + " 사용자의 웹소켓 연결이 해제되었습니다.");
//        } else {
//            System.out.println("알 수 없는 사용자의 웹소켓 연결이 해제되었습니다.");
//        }
//    }
//
//    // 메시지 수신 시 동작
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        // 클라이언트로부터 메시지 수신
//        String payload = message.getPayload();
//
//        // 받은 메시지를 그대로 다시 클라이언트(수신자)로 전송하는 예시를 보여줌.
//        for(Map.Entry<String, WebSocketSession> entry : sessions.entrySet()) {
//            WebSocketSession webSocketSession = entry.getValue();
//            String userName = entry.getKey();
//            if (userName != null) {
//                webSocketSession.sendMessage(new TextMessage(userName + "님에게 보내는 서버 메시지: " + payload));
//            } else {
//                webSocketSession.sendMessage(new TextMessage("알 수 없는 사용자에게 보내는 서버 메시지: " + payload));
//            }
//        }
//    }
//}