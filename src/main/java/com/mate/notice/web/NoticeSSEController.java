package com.mate.notice.web;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mate.common.beans.security.jwt.JsonWebTokenProvider;
import com.mate.notice.service.NoticeService;
import com.mate.notice.vo.NoticeVO;
import com.mate.user.vo.UserVO;

import reactor.core.publisher.Flux;

@RestController
public class NoticeSSEController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private JsonWebTokenProvider jsonWebTokenProvider;

    @GetMapping(value = "/api/v1/notice/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NoticeVO> streamNotices(@RequestHeader("Authorization") String token) throws JsonProcessingException {
        // JWT 검증 및 사용자 정보 추출
        UserVO user = jsonWebTokenProvider.getUserFromJwt(token.replace("Bearer ", ""));
        String userId = user.getUsrLgnId();

        // 3초마다 사용자별 읽지 않은 알림 목록을 반환
        return Flux.interval(Duration.ofSeconds(3))
                .flatMap(tick -> Flux.fromIterable(noticeService.getUnreadNoticesByRecipientId(userId)));
    }
}