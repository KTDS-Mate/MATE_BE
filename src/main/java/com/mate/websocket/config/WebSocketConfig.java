package com.mate.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.mate.websocket.handler.MateWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final MateWebSocketHandler mateWebSocketHandler;

    public WebSocketConfig(MateWebSocketHandler mateWebSocketHandler) {
        this.mateWebSocketHandler = mateWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(mateWebSocketHandler, "/ws")
        		.setAllowedOrigins("*");
        registry.addHandler(mateWebSocketHandler, "/ws/notice")
        		.setAllowedOrigins("*");
        registry.addHandler(mateWebSocketHandler, "/ws/chat")
        		.setAllowedOrigins("*");
 
    }
}
