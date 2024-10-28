package com.mate.mail.dao;

import com.mate.mail.vo.EmailVO;

public interface EmailDao {

	public String NAMESPACE = "com.mate.mail.dao.EmailDao";
	
	// EmailVO 객체를 받아서 인증 정보 저장 및 인증 코드 재발급 시 인증 코드 업데이트
	public void insertNewAuthCode(EmailVO emailVO);
	
	// email을 받아서 authCode와 issueTime 반환
	EmailVO getAuthCodeByEmail(String email);

	// 이전에 발급한 코드를 무효화
	public int invalidatePrevAuthCode(String email);
}
