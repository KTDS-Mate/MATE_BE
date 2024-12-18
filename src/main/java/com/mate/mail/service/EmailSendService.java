package com.mate.mail.service;

import java.util.Map;

import com.mate.mail.vo.EmailVO;

import jakarta.mail.MessagingException;

public interface EmailSendService {

	public void sendAuthMail(EmailVO emailVO);
	
	public String sendPasswordAuthMail(EmailVO emailVO) throws MessagingException;
	
	public Map<String, Object> verifyAuthCode(EmailVO emailVO);
	
	public void sendUserIdEmail(String usrEml, String userId) throws MessagingException;
}
