package com.mate.notice.web;

import java.util.List;
import java.util.Map;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.beans.security.jwt.JsonWebTokenProvider;
import com.mate.common.vo.ApiResponse;
import com.mate.notice.service.NoticeService;
import com.mate.notice.vo.NoticeVO;
import com.mate.user.vo.UserVO;

@RestController
@RequestMapping("/api/v1/notice")
public class NoticeApiController {

    private static final Logger logger = LoggerFactory.getLogger(NoticeApiController.class);

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private JsonWebTokenProvider jsonWebTokenProvider;

    // 공통 메서드: JWT 검증 및 사용자 정보 추출
    private UserVO getUserFromToken(String token) {
        try {
            return jsonWebTokenProvider.getUserFromJwt(token.replace("Bearer ", ""));
        } catch (Exception e) {
            //logger.error("Failed to parse JWT and extract user data: {}", e.getMessage());
            return null;
        }
    }

    // 1. 읽지 않은 알림 조회
    @GetMapping("/unread")
    public ResponseEntity<?> getUnreadNotices(@RequestHeader("Authorization") String token) {
        UserVO userVO = getUserFromToken(token);
        if (userVO == null || userVO.getUsrLgnId() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }

        //logger.info("Fetching unread notices for user: {}", userVO.getUsrLgnId());
        List<NoticeVO> unreadNotices = noticeService.getUnreadNoticesByRecipientId(userVO.getUsrLgnId());
        return ResponseEntity.ok(unreadNotices);
    }

    // 2. 알림 생성
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createNotification(@RequestBody NoticeVO noticeVO) {
        try {
        	
        	if (noticeVO.getNtcUrl() == null || noticeVO.getNtcUrl().isEmpty()) {
        		noticeVO.setNtcUrl("/");
        	}

        	// 알림 생성
            NoticeVO newNotice = noticeService.createNotice(noticeVO);

            
            // 반환 데이터에 새로 생성된 알림 객체 포함
            ApiResponse response = new ApiResponse(HttpStatus.OK, newNotice);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
        	 //logger.error("Error creating notification", e); 
            ApiResponse errorResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR);
            errorResponse.setErrors(List.of("Failed to create notification."));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorResponse);
        }
    }

    // 3. 알림 읽음 상태 업데이트
    @PostMapping("/read")
    public ResponseEntity<?> markNoticeAsRead(@RequestHeader("Authorization") String token,
                                              @RequestBody NoticeVO noticeVO) {
        UserVO userVO = getUserFromToken(token);
        if (userVO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }

        try {
            noticeService.markNoticeAsRead(noticeVO.getNtcId());
            return ResponseEntity.ok().body(Map.of("message", "Notice marked as read."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Failed to mark notice as read."));
        }
    }

    // 4. 알림 삭제 처리
    @PostMapping("/delete")
    public ResponseEntity<String> deleteNotice(@RequestHeader("Authorization") String token,
                                               @RequestBody NoticeVO noticeVO) {
        UserVO userVO = getUserFromToken(token);
        if (userVO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }

        noticeService.deleteNotice(noticeVO.getNtcId());
        //logger.info("Deleted notice: {}", noticeVO.getNtcId());
        return ResponseEntity.ok("Notice deleted successfully.");
    }

    // 5. 알림 전체 조회
    @GetMapping("/all")
    public ResponseEntity<?> getAllNotices(@RequestHeader("Authorization") String token) {
        UserVO userVO = getUserFromToken(token);
        if (userVO == null || userVO.getUsrLgnId() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }

        try {
            //logger.info("Fetching all notices for user: {}", userVO.getUsrLgnId());
            List<NoticeVO> allNotices = noticeService.getNoticeByRecipientId(userVO.getUsrLgnId());
            return ResponseEntity.ok(allNotices);
        } catch (Exception e) {
            //logger.error("Error fetching all notices", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Failed to fetch notices."));
        }
    }
}
