package com.mate.common.beans.security;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.mate.user.dao.UserDao;
import com.mate.user.vo.LoginUserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 인증 절차를 실패했을 경우 예외를 처리할 클래스
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

	private UserDao userDao;
	
	public LoginFailureHandler(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// 예외 메세지(UsernameNotFoundException, BadCredentialException
		String exceptionMessage = exception.getMessage();
		
		// 인증을 요청한 이메일
		String email = request.getParameter("email");
		
		// TODO - 로그인 실패 횟수 관리
		
		
		// email과 message를 받아서 로그인 페이지에 노출
		// model 전송
		request.setAttribute("message", exceptionMessage);
		
		LoginUserVO loginUserVO = new LoginUserVO();
		loginUserVO.setUsrLgnId(email);
	}
	
	

}
