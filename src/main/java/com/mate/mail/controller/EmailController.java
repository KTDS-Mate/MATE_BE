package com.mate.mail.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.mail.service.EmailSendService;
import com.mate.mail.vo.EmailVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/regist")
public class EmailController {

	@Autowired
	private EmailSendService emailSendService;
	
	@PostMapping("/send-auth-mail")
	public Map<String, String> sendAuthMail(@RequestBody 
											@Valid EmailVO emailVO) {
		// 인증 메일 전송하고 인증 코드를 code에 저장
		String code = emailSendService.sendAuthMail(emailVO);
		
		// 응답용 hashmap 객체 생성
		Map<String, String> response = new HashMap<>();
		// 맵에 code(Key)로 code(value) 저장
		response.put("code", code);
		
		return response;
	}
	
	@PostMapping("/verify-auth-code")
	public Map<String, Object> verifyAuthCode(@RequestBody EmailVO emailVO) {
		// emailSendService.verifyAuthCode에서 이미 response를 만들어서 반환하기 때문에 service에서 반환한 값을 그대로 전달한다.
		return emailSendService.verifyAuthCode(emailVO);
	}
}