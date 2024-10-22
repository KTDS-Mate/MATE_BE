package com.mate.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebSocketMessageSender extends TextWebSocketHandler {

    @Autowired
    private WebSocketSessionManager sessionManager;

    @Autowired
    private ObjectMapper objectMapper;

    
}
