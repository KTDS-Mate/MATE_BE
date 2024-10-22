//package com.mate.common.handler;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.ktdsuniversity.edu.hello_spring.common.exceptions.FileNotExistException;
//import com.ktdsuniversity.edu.hello_spring.common.exceptions.MakeXlsxFileException;
//import com.ktdsuniversity.edu.hello_spring.common.exceptions.PageNotExistsFoundException;
//import com.ktdsuniversity.edu.hello_spring.common.exceptions.UserIdendifyNotMatchException;
//
//@ControllerAdvice // Spring application에서 예외를 일괄 처리한다.
//public class GlobalExceptionHandler {
//	
//	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//	
//	
//	@ExceptionHandler(PageNotExistsFoundException.class)	
//	public String viewPageNotFoundPage() {
//		if(logger.isDebugEnabled()) {
//			logger.debug("Page를 찾을 수 없습니다.");
//		}
//		return "error/404";
//	}
//	
//	@ExceptionHandler({FileNotExistException.class, MakeXlsxFileException.class})
//	public String asdfasdf(Model model, RuntimeException re) {
//		if(re instanceof FileNotExistException) {
//			FileNotExistException fnee = (FileNotExistException) re;
//			model.addAttribute("message", fnee.getMessage());
//		}else if (re instanceof MakeXlsxFileException) {
//			MakeXlsxFileException mxfe = (MakeXlsxFileException) re;
//			model.addAttribute("message", mxfe.getMessage());
//		}
//		
//		return "error/500";
//	}
//	
//	
//	
//	
//	@ExceptionHandler(UserIdendifyNotMatchException.class)
//	public String viewLoiginErrorPage(Model model, UserIdendifyNotMatchException uinme) {
//		
//		if(logger.isDebugEnabled()) {
//			logger.debug("아이디 또는 비밀번호가 일치하지 않아요!");
//		}
//		
//		model.addAttribute("message", uinme.getMessage());
//		model.addAttribute("loginMemberVO", uinme.getLoginMemberVO() );
//		
//		return "member/memberlogin";	
//	}
//	
//	
//	
//}
