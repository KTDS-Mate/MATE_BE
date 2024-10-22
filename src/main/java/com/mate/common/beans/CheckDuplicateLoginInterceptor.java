//package com.mate.common.beans;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
///**
// * 로그인 되어있는 상태에서 로그인 페이지에 접근하면
// * /board/list 로 이동시키는 Interceptor
// */
//public class CheckDuplicateLoginInterceptor implements HandlerInterceptor{
//
//	@Override
//	public boolean preHandle(HttpServletRequest request
//						, HttpServletResponse response
//						, Object handler)
//			throws Exception {
//		
//		HttpSession session = request.getSession();
//		
//		MemberVO memberVO = (MemberVO)session.getAttribute("_LOGIN_USER_");
//		if (memberVO != null) {
//			// 로그인 했으면 해당 URL로 리다이렉트
//			response.sendRedirect("/board/list");
//			// /member/login URL을 실행하지 말아라
//			return false;
//		}
//		
//		return true;
//	}
//	
//}
