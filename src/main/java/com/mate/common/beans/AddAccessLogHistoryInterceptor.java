//package com.mate.common.beans;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao;
//import com.ktdsuniversity.edu.hello_spring.access.vo.AccessLogVO;
//import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class AddAccessLogHistoryInterceptor implements HandlerInterceptor{
//
//	private AccessLogDao accessLogDao;
//	
//	public AddAccessLogHistoryInterceptor(AccessLogDao accessLogDao) {
//		this.accessLogDao = accessLogDao;
//	}
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
//		String email = memberVO == null ? null : memberVO.getEmail();
//		
//		String controller = handler.toString();
//		String packageName = controller.replace("com.ktdsuniversity.edu.hello_spring.", "");
//		packageName = packageName.substring(0, packageName.indexOf(".")).toUpperCase();
//		
//		AccessLogVO accessLogVO = new AccessLogVO();
//		accessLogVO.setAccessType(packageName);
//		accessLogVO.setAccessEmail(email);
//		accessLogVO.setAccessUrl(request.getRequestURI());
//		accessLogVO.setAccessMethod(request.getMethod().toUpperCase());
//		accessLogVO.setAccessIp(request.getRemoteAddr());
//		accessLogVO.setLoginSuccessYn(memberVO == null ? "N" : "Y");
//		
//		this.accessLogDao.insertNewAccessLog(accessLogVO);
//		
//		return true;
//	}
//	
//}
