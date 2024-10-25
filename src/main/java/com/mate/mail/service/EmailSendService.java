package com.mate.mail.service;

import com.mate.mail.vo.EmailVO;

public interface EmailSendService {

	public String sendAuthMail(EmailVO emailVO);
	
	public boolean verifyAuthCode(EmailVO emailVO);
}
