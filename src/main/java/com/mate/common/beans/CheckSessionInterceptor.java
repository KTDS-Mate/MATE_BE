//package com.mate.common.beans;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
///**
// * 요청과 응답을 가로채는 인터셉터
// */
//public class CheckSessionInterceptor implements HandlerInterceptor {
//
//	/**
//	 * Controller 가 실행 되기 전에 실행 되는 Handler
//	 */
//	@Override
//	public boolean preHandle(HttpServletRequest request
//						, HttpServletResponse response
//						, Object handler)
//			throws Exception {
//		
//		/*
//		 * Controller 가 실행되기 전에
//		 * 로그인 세션을 검사해서 로그인이 되어있지 않다면
//		 * 로그인 페이지를 보여주도록 함
//		 */
//		// 1. 세션 가져오기
//		HttpSession session = request.getSession();
//		// 2. 세션이 존재한다면 컨트롤러 실행
//		MemberVO memberVO = (MemberVO)session.getAttribute("_LOGIN_USER_");
//		
//		if (memberVO != null) {
//			// 로그인 했음
//			return true; // Controller 를 계속해서 실행
//		}
//		// 3. 세션이 존재하지 않는다면 로그인페이지 보여주기
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/memberlogin.jsp");
//		rd.forward(request, response);
//		
//		return false; // Controller 를 실행시키지 않음
//	}
//	
////	@Override
////	public void postHandle(HttpServletRequest request
////						, HttpServletResponse response
////						, Object handler
////						, ModelAndView modelAndView) 
////			throws Exception {
////		System.out.println("CheckSessionInterceptor.postHandle : " + handler);
////		System.out.println("CheckSessionInterceptor.postHandle : " + modelAndView);
////	}
////	
////	@Override
////	public void afterCompletion(HttpServletRequest request
////						, HttpServletResponse response
////						, Object handler
////						, Exception ex)
////			throws Exception {
////		System.out.println("CheckSessionInterceptor.afterCompletion : " + handler);
////	}
////	
//}
