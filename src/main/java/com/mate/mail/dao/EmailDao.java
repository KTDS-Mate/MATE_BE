package com.mate.mail.dao;

import com.mate.mail.vo.EmailVO;

public interface EmailDao {

	public String NAMESPACE = "com.mate.mail.dao.EmailDao";
	
	// emailVO 객체를 받아서 인증정보 저장.
	public void saveAuthInfo(EmailVO emailVO);
	
	// email을 받아서 인증 코드 반환
	public String getAuthCodeByEmail(String email);
	
}
