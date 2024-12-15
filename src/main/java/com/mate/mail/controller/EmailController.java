package com.mate.mail.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.vo.ApiResponse;
import com.mate.mail.service.EmailSendService;
import com.mate.mail.vo.EmailVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class EmailController {

    @Autowired
    private EmailSendService emailSendService;
    
    /**
     * 인증 메일 발송 엔드포인트
     * @param emailVO 인증 메일 발송을 위한 이메일 정보
     * @return ApiResponse<String> 인증 코드
     */
    @PostMapping("/send-auth-mail")
    public ResponseEntity<ApiResponse> sendAuthMail(@RequestBody @Valid EmailVO emailVO) {
    	try {
            // 인증 메일 전송 (DB에 인증 코드 저장)
            emailSendService.sendAuthMail(emailVO);
            
            // ApiResponse 생성 (인증 코드 제외)
            ApiResponse response = new ApiResponse(HttpStatus.OK, "인증 메일이 성공적으로 발송되었습니다.");
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR);
            errorResponse.setErrors(List.of("인증 메일 발송에 실패하였습니다."));
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * 인증 코드 검증 엔드포인트
     * @param emailVO 인증 코드 검증을 위한 이메일 및 코드 정보
     * @return ApiResponse<Boolean> 인증 성공 여부
     */
    @PostMapping("/verify-auth-code")
    public ResponseEntity<ApiResponse> verifyAuthCode(@RequestBody @Valid EmailVO emailVO) {
        Map<String, Object> verificationResult = emailSendService.verifyAuthCode(emailVO);
        boolean isValid = verificationResult.get("valid") != null && (Boolean) verificationResult.get("valid");
        String message = (String) verificationResult.get("message");
        
        ApiResponse response;
        if (isValid) {
            response = new ApiResponse(HttpStatus.OK, true);
            response.setStatusMessage(message);
        } else {
            response = new ApiResponse(HttpStatus.BAD_REQUEST);
            response.setErrors(List.of(message)); // 'errors' 필드에 메시지 추가
        }
        
        return new ResponseEntity<>(response, isValid ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
