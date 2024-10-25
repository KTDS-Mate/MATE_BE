//package com.mate.websocket;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.WebSocketSession;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Configuration
//public class WebSocketSessionManager {
//    // 상대방의 정보와 WebSocket Session을 매핑하기 위한 Map
//    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
//
//    // WebSocket Session을 저장하는 메서드
//    public void addSession(String userId, WebSocketSession session) {
//        sessions.put(userId, session);
//    }
//
//    // 상대방의 WebSocket Session을 가져오는 메서드
//    public WebSocketSession getSession(String userId) {
//        return sessions.get(userId);
//    }
//
//    // WebSocket Session을 삭제하는 메서드 (연결 종료 시 호출)
//    public void removeSession(String userId) {
//        sessions.remove(userId);
//    }
//}
