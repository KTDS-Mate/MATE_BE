package com.mate.notice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mate.common.beans.security.jwt.JsonWebTokenProvider;
import com.mate.notice.service.NoticeService;
import com.mate.user.vo.UserVO;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class NoticeSSEController {

    private final CopyOnWriteArrayList<PrintWriter> clients = new CopyOnWriteArrayList<>();

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private JsonWebTokenProvider jsonWebTokenProvider;

    @GetMapping(value = "/api/v1/notice/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public void stream(
            @RequestHeader(value = "Authorization", required = false) String authHeader,
            HttpServletResponse response) throws IOException {

        // JWT 인증 검증
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.flushBuffer();
            return;
        }

        String token = authHeader.substring(7);
        try {
            UserVO user = jsonWebTokenProvider.getUserFromJwt(token);
            if (user == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.flushBuffer();
                return;
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.flushBuffer();
            return;
        }

        // SSE 처리 시작
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        clients.add(writer);

        try {
            writer.write("data: 연결되었습니다.\n\n");
            writer.flush();

            while (!response.isCommitted()) {
                Thread.sleep(10000);
                writer.write("data: Heartbeat " + LocalTime.now() + "\n\n");
                writer.flush();
            }
        } catch (Exception e) {
            System.out.println("Client disconnected");
        } finally {
            clients.remove(writer);
            writer.close();
        }
    }

    // 알림 전송 메서드
    public void sendNotification(String message) {
        String jsonMessage = "{ \"message\": \"" + message + "\" }"; // JSON 형식으로 메시지 구성
        for (PrintWriter client : clients) {
            client.write("data: " + jsonMessage + "\n\n");
            client.flush();
        }
    }
}
