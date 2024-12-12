package com.mate.common.beans.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.mate.common.beans.Sha;

public class SecurityPasswordEncoder extends Sha implements PasswordEncoder {
	
	private String salt;
	
	/**
	 * passwordEncoder 객체를 사용할 때, 사용자별 salt 값 설정
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 사용자가 인증 요청한 비밀번호(rawPassword)를 암호화
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		// rawPassword를 Sha 암호화 수행 + salt 적용 -> String 타입으로 반환
		return super.getEncrypt(String.valueOf(rawPassword), this.salt);
	}

	/**
	 * 암호화된 사용자의 비밀번호와 데이터베이스의 암호화된 비밀번호가 일치하는지 확인
	 * CharSequence = String
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// 사용자가 입력한 비밀번호 암호화
		String password = this.encode(rawPassword);
		return password.equals(encodedPassword);
	}

}
