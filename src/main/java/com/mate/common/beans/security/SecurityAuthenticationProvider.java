package com.mate.common.beans.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityAuthenticationProvider implements AuthenticationProvider {
	
	/**
	 * 인증 회원 정보 조회
	 */
	private UserDetailsService userDetailsService;
	
	/**
	 * 인증 비밀번호 검증 및 암호화
	 */
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 생성자 주입으로 userDetailsService, passwordEncoder 받음.
	 */
	public SecurityAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsService = userDetailsService;
	}

	/**
	 * support에 정의된 인증 방식으로 사용자가 제출한 인증 정보를 기반으로 인증 수행.
	 * 인증 성공 시 Authentication 객체 반환 - 인증에 대한 결과를 담고 있음. 
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// ID, Password를 authentication에서 추출
		String requestAuthenticationId = authentication.getName();
		String requestAuthenticationPassword = authentication.getCredentials().toString();
		
		// 사용자의 권한은 loadUserByUsername으로 DB에 있는 권한을 넣어준다.
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(requestAuthenticationId);
		
		// 데이터베이스에 저장된 암호화된 비밀번호
		String storedUserPassword = userDetails.getPassword();
		
		// salt는 SecurityUser가 가지고 있음.
		String storedUserSalt = ((SecurityUser) userDetails).getSalt();
		// 가져온 salt값을 넣어주기 위해 형변환
		((SecurityPasswordEncoder) this.passwordEncoder).setSalt(storedUserSalt);
		
		// 비밀번호 비교
		boolean isMatchPassword = this.passwordEncoder.matches(requestAuthenticationPassword, storedUserPassword);
		
		if (isMatchPassword) {
			// 인증 컨텍스트(securityContext에 저장). 권한 정보는 토큰에 들어 있음.
			return new UsernamePasswordAuthenticationToken(((SecurityUser)userDetails).getUserVO(), storedUserPassword, userDetails.getAuthorities());
		} else {
			throw new BadCredentialsException("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	}

	/**
	 * 인증 수단을 정의하는 메서드 -> UsernamePasswordAuthenticationToken 방식
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
