package com.mate.notice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mate.common.beans.security.jwt.JsonWebTokenProvider;
import com.mate.notice.service.NoticeService;
import com.mate.notice.vo.NoticeVO;
import com.mate.user.vo.UserVO;

import java.util.List;

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
}
