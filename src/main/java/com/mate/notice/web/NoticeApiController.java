package com.mate.notice.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mate.common.beans.security.jwt.JsonWebTokenProvider;
import com.mate.notice.service.NoticeService;
import com.mate.notice.vo.NoticeVO;
import com.mate.notice.vo.NotificationRequestVO;
import com.mate.user.vo.UserVO;

@RestController
@RequestMapping("/api/v1/notice")
public class NoticeApiController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeApiController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private JsonWebTokenProvider jsonWebTokenProvider;
	
	// 1. 읽지 않은 알림 조회
	@GetMapping("/unread")
	public ResponseEntity<List<NoticeVO>> getUnreadNotices(@RequestHeader("Authorization") String token) throws JsonProcessingException {
		UserVO userVO = jsonWebTokenProvider.getUserFromJwt(token.replace("Bearer ", ""));
		logger.info("Fetching unread notices for user: {}", userVO.getUsrLgnId());
		List<NoticeVO> unreadNotices = noticeService.getUnreadNoticesByRecipientId(userVO.getUsrLgnId());
		return ResponseEntity.ok(unreadNotices);
	}

	// 2. 알림 생성
	@PostMapping("/create")
	public ResponseEntity<String> createNotice(@RequestBody NoticeVO noticeVO) {
		noticeService.createNotice(noticeVO);
		logger.info("Created new notice for recipient: {}", noticeVO.getRcpntId());
		return ResponseEntity.ok("Notice created successfully.");
	}

	// 3. 알림 읽음 상태 업데이트 (POST 방식)
	@PostMapping("/read")
	public ResponseEntity<String> markNoticeAsRead(@RequestBody NoticeVO noticeVO) {
		noticeService.markNoticeAsRead(noticeVO.getNtcId());
		logger.info("Marked notice as read: {}", noticeVO.getNtcId());
		return ResponseEntity.ok("Notice marked as read.");
	}

	// 4. 알림 삭제 (POST 방식)
	@PostMapping("/delete")
	public ResponseEntity<String> deleteNotice(@RequestBody NoticeVO noticeVO) {
		noticeService.removeNotice(noticeVO.getNtcId());
		logger.info("Deleted notice: {}", noticeVO.getNtcId());
		return ResponseEntity.ok("Notice deleted successfully.");
	}

	// 5. 모든 알림 조회 (수신자 기준)
	@GetMapping("/all")
	public ResponseEntity<List<NoticeVO>> getAllNotices(@RequestHeader("Authorization") String token) throws JsonProcessingException {
		UserVO userVO = jsonWebTokenProvider.getUserFromJwt(token.replace("Bearer ", ""));
		logger.info("Fetching all notices for user: {}", userVO.getUsrLgnId());
		List<NoticeVO> allNotices = noticeService.getUnreadNoticesByRecipientId(userVO.getUsrLgnId());
		return ResponseEntity.ok(allNotices);
	}
	
	/**
     * 특정 유저에게 알림을 전송하는 API
     * 프론트에서 이벤트 발생 시 호출
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequestVO notificationRequestVO) {
        // 토큰이 유효한지 확인 (필요 시 JsonWebTokenProvider 활용)
        if (notificationRequestVO.getToken() == null || notificationRequestVO.getToken().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token");
        }

        boolean isSent = noticeService.sendNotification(notificationRequestVO.getToken(), notificationRequestVO.getMessage());

        if (isSent) {
            logger.info("Notification sent successfully to token: {}", notificationRequestVO.getToken());
            return ResponseEntity.ok("Notification sent successfully.");
        } else {
            logger.error("Failed to send notification to token: {}", notificationRequestVO.getToken());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send notification.");
        }
    }
}
