package com.mate.mail.service;

import java.util.Map;

import com.mate.mail.vo.EmailVO;

public interface EmailSendService {

	public void sendAuthMail(EmailVO emailVO);
	
	public String sendPasswordAuthMail(EmailVO emailVO);
	
	public Map<String, Object> verifyAuthCode(EmailVO emailVO);
}
