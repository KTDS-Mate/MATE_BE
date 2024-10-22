package com.mate.websocket.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionRegistry {
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    public void register(String user, WebSocketSession session) {
        sessions.put(user, session);
    }

    public void unregister(String user) {
        sessions.remove(user);
    }

    public WebSocketSession getSession(String user) {
        return sessions.get(user);
    }
}
