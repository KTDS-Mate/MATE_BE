package com.mate.common.beans.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mate.user.dao.UserDao;
import com.mate.user.vo.UserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 시큐리티 인증에 성공했을 경우를 처리하는 클래스
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	private UserDao userDao;
	
	public LoginSuccessHandler(UserDao userDao) {
		this.userDao = userDao;
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		
		String authenticatedEmail = authentication.getName();
		
		// TODO 로그인 날짜를 현재 시간으로 변경
		
		// 인증 객체에서 UserVO 추출(principal에서)
		UserVO userVO = (UserVO) authentication.getPrincipal();
		
		String nextUrl = request.getParameter("nextUrl");
		
		response.sendRedirect(nextUrl);
	}
}
