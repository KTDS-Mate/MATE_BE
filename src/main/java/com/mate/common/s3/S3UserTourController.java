package com.mate.common.s3;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// 필요한 Spring 애노테이션 및 클래스 임포트
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usertour/s3")
public class S3UserTourController {

    private final Logger log = LoggerFactory.getLogger(S3UserTourController.class);
    
    private final S3Service s3Service;
    
    private final String bucketName;
    
    @Autowired
    public S3UserTourController(S3Service s3Service) {
        this.s3Service = s3Service;
        this.bucketName = s3Service.getBucketName();
    }
    
    /**
     * 사용자 투어 이미지 업로드를 위한 프리사인드 URL 생성
     */
    @GetMapping("/presigned-url/upload")
    public ResponseEntity<Map<String, Object>> generateUserTourUploadUrl(
            @RequestParam String originalFileName,
            @RequestParam String contentType,
            Authentication authentication
    ) {
        try {
            if (authentication == null || authentication.getPrincipal() == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(createErrorResponse("인증되지 않은 접근입니다."));
            }

            // UserVO userVO = extractUserVO(authentication);

            Pair<String, String> presignedData = s3Service.generateUploadUrl(originalFileName, contentType);
            
            Map<String, String> data = new HashMap<>();
            data.put("uploadUrl", presignedData.getLeft());
            data.put("fileName", presignedData.getRight());
            data.put("fileUrl", String.format("https://%s.s3.ap-northeast-2.amazonaws.com/%s",
                    bucketName, presignedData.getRight()));
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.OK.value());
            response.put("statusMessage", "성공");
            response.put("data", data);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("업로드 프리사인드 URL 생성 오류: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createErrorResponse("업로드 URL 생성에 실패했습니다."));
        }
    }
    
    /**
     * 사용자 투어 이미지 다운로드를 위한 프리사인드 URL 생성
     */
    @GetMapping("/presigned-url/download")
    public ResponseEntity<Map<String, Object>> generateUserTourDownloadUrl(
            @RequestParam String fileName,
            Authentication authentication
    ) {
        try {
            if (authentication == null || authentication.getPrincipal() == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(createErrorResponse("인증되지 않은 접근입니다."));
            }
            
            // 필요에 따라 사용자 접근 권한 검증
            // UserVO userVO = extractUserVO(authentication);
            // 권한 검증 로직 추가

            String presignedUrl = s3Service.generateDownloadUrl(fileName);
            
            if (presignedUrl == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(createErrorResponse("다운로드 URL 생성에 실패했습니다."));
            }
            
            Map<String, String> data = new HashMap<>();
            data.put("downloadUrl", presignedUrl);
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.OK.value());
            response.put("statusMessage", "성공");
            response.put("data", data);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("다운로드 프리사인드 URL 생성 오류: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createErrorResponse("다운로드 URL 생성에 실패했습니다."));
        }
    }
    
    /**
     * 오류 응답을 생성하는 유틸리티 메서드
     */
    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("statusMessage", "오류");
        errorResponse.put("error", message);
        return errorResponse;
    }
    
    /**
     * 필요 시 Authentication에서 UserVO 추출 메서드
     */
    /*
    private UserVO extractUserVO(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserVO) {
            return (UserVO) principal;
        }
        return null;
    }
    */
}
