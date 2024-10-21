package com.mate.chat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mate.chat.vo.ChatVO;
import com.mate.websocket.service.SessionRegistry;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ChatController {

    private SessionRegistry sessionRegistry;

    @Autowired
    public ChatController(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public void sendMessage(@RequestBody ChatVO chatVO, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Received message: " + chatVO);

        // 메시지를 수신자에게 전송
        WebSocketSession recipientSession = sessionRegistry.getSession(chatVO.getChatReceiverId());

        if (recipientSession != null && recipientSession.isOpen()) {
            try {
                recipientSession.sendMessage(new TextMessage(new ObjectMapper().writeValueAsString(chatVO)));
                System.out.println("Message sent to destination: " + chatVO.getChatReceiverId());
            } catch (Exception e) {
                System.err.println("Failed to send message: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}