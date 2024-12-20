package com.mate.common.s3;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.mate.common.vo.ApiResponse;
import com.mate.common.vo.LicenseVO;
import com.mate.user.service.GuideService;
import com.mate.user.vo.RegistGuideVO;
import com.mate.user.vo.UserVO;

@RestController
@RequestMapping("/api/v1/s3")
public class S3Controller {


    private final Logger log = LoggerFactory.getLogger(S3Controller.class);
    
    private final S3Service s3Service;
    
    private final GuideService guideService; 

    private final String bucketName;
    
    public S3Controller(S3Service s3Service, GuideService guideService) {
        this.s3Service = s3Service;
        this.guideService = guideService;
        this.bucketName = s3Service.getBucketName();
    }

    /**
     * 가이드 등록 (이미지 업로드 포함)
     * 기존에 @Controller에서 @ModelAttribute로 받아왔던 것을
     * @RequestPart / @RequestParam 으로 처리할 수 있음.(생략 가능)
     */
    @PostMapping("/updateGuideImage")
    public ApiResponse updateGuideImage(@RequestBody Map<String, String> requestBody, 
                                        Authentication authentication) {
        try {
            String usrId = requestBody.get("usrId");
            String imageUrl = requestBody.get("imageUrl");
            String imageType = requestBody.get("imageType");

            UserVO authenticatedUser = extractUserVO(authentication);
            if (authenticatedUser == null || !authenticatedUser.getUsrId().equals(usrId)) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "권한이 없습니다.");
            }

            // 라이센스 이미지 처리
            if (imageType != null && imageType.startsWith("license-")) {
                // 새 라이센스 ID 생성
                String lcnId = guideService.getNextLicenseId();
                LicenseVO licenseVO = new LicenseVO();
                licenseVO.setUsrId(usrId);
                licenseVO.setLcnId(lcnId);
                licenseVO.setLcnImg(imageUrl);
                licenseVO.setLcnNm("임시 라이센스");
                
                boolean updated = guideService.updateGuideLicenseApi(licenseVO);
                if (updated) {
                    Map<String, Object> responseBody = new HashMap<>();
                    responseBody.put("lcnId", lcnId);
                    responseBody.put("lcnImg", imageUrl);
                    
                    ApiResponse response = new ApiResponse(HttpStatus.OK);
                    response.setBody(responseBody);
                    return response;
                }
                return new ApiResponse(HttpStatus.BAD_REQUEST);
            }

            // 기본 이미지 처리
            RegistGuideVO registGuideVO = new RegistGuideVO();
            registGuideVO.setUsrId(usrId);

            switch (imageType) {
                case "gdPrflImg" -> registGuideVO.setGdPrflImg(imageUrl);
                case "gdIdImg" -> registGuideVO.setGdIdImg(imageUrl);
                case "gdCbcImg" -> registGuideVO.setGdCbcImg(imageUrl);
            }

            boolean updated = guideService.updateGuideProfile(registGuideVO);
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("imageUrl", imageUrl);
            responseBody.put("status", updated ? "success" : "failed");
            
            ApiResponse response = new ApiResponse(updated ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
            response.setBody(responseBody);
            return response;

        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/presigned-url/upload")
    public ResponseEntity<Map<String, Object>> getUploadUrl(
        @RequestParam String fileName,
        @RequestParam String contentType,
        Authentication authentication
    ) {
        try {
            if (authentication == null || authentication.getPrincipal() == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                        "status", HttpStatus.UNAUTHORIZED.value(),
                        "statusMessage", "Unauthorized",
                        "error", "인증이 필요합니다."
                    ));
            }

            UserVO userVO = extractUserVO(authentication);

            Pair<String, String> presignedData = s3Service.generatePresignedUrl(
                fileName,
                HttpMethod.PUT,
                3600 * 1000,
                contentType
            );

            Map<String, Object> response = new HashMap<>();
            Map<String, String> data = new HashMap<>();
            data.put("uploadUrl", presignedData.getLeft());
            data.put("fileName", presignedData.getRight());
            data.put("fileUrl", String.format("https://%s.s3.ap-northeast-2.amazonaws.com/%s",
                bucketName, presignedData.getRight()));

            response.put("status", HttpStatus.OK.value());
            response.put("statusMessage", "Success");
            response.put("data", data);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                    "status", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "statusMessage", "Internal Server Error",
                    "error", e.getMessage()
                ));
        }
    }

    @GetMapping("/presigned-url/download")
    public ResponseEntity<Map<String, Object>> getDownloadUrl(
            @RequestParam String fileName,
            Authentication authentication
    ) {
        try {
            if (authentication == null || authentication.getPrincipal() == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of(
                            "status", HttpStatus.UNAUTHORIZED.value(),
                            "statusMessage", "Unauthorized",
                            "error", "인증이 필요합니다."
                        ));
            }

            log.info("다운로드 URL 요청 - 파일명: {}", fileName);

            // contentType 파라미터 제거하고 메서드 호출
            String presignedUrl = s3Service.generatePresignedUrlForDownload(
                    fileName,
                    HttpMethod.GET,
                    3600 * 1000  // 1시간
            );

            if (presignedUrl == null) {
                throw new RuntimeException("Presigned URL 생성 실패");
            }

            log.info("생성된 다운로드 URL: {}", presignedUrl);

            Map<String, Object> data = new HashMap<>();
            data.put("url", presignedUrl);

            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.OK.value());
            response.put("statusMessage", "Success");
            response.put("data", data);

            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("다운로드 URL 생성 중 에러 발생: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of(
                        "status", HttpStatus.FORBIDDEN.value(),
                        "statusMessage", "Forbidden",
                        "error", e.getMessage()
                    ));
        }
    }
    
    private ResponseEntity<Map<String, Object>> createErrorResponse(String message, HttpStatus status) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", status.value());
        errorResponse.put("error", message);
        return ResponseEntity
            .status(status)
            .contentType(MediaType.APPLICATION_JSON)
            .body(errorResponse);
    }

    /**
     * Authentication에서 UserVO 추출
     */
    private UserVO extractUserVO(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        
        Object principal = authentication.getPrincipal();
        
        if (principal instanceof UserVO) {
            return (UserVO) principal;
        } else {
            return null;
        }
    }
}
