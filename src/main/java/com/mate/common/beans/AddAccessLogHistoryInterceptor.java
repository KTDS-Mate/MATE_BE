package com.mate.common.beans;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mate.access.dao.AccessLogDao;
import com.mate.access.vo.AccessLogVO;
import com.mate.user.vo.UserVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddAccessLogHistoryInterceptor implements HandlerInterceptor{

	private AccessLogDao accessLogDao;
	
	public AddAccessLogHistoryInterceptor(AccessLogDao accessLogDao) {
		this.accessLogDao = accessLogDao;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request
						, HttpServletResponse response
						, Object handler)
			throws Exception {
		
		// 현재 인증이 되어있는 사용자의 정보를 가지고 올 수 있다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		boolean isAuthenticated = authentication != null && authentication.getPrincipal() instanceof UserVO;
		
		// principal에 UserVO가 들어있냐?
		UserVO userVO = isAuthenticated ? (UserVO) authentication.getPrincipal() : null ; 
		
		String usrLgnId = userVO == null ? null : userVO.getUsrLgnId();
		
		String controller = handler.toString();
		String packageName = controller.replace("com.mate.", "");
		packageName = packageName.substring(0, packageName.indexOf(".")).toUpperCase();
		
		AccessLogVO accessLogVO = new AccessLogVO();
		accessLogVO.setAccessType(packageName);
		accessLogVO.setAccessId(usrLgnId);
		accessLogVO.setAccessUrl(request.getRequestURI());
		accessLogVO.setAccessMethod(request.getMethod().toUpperCase());
		accessLogVO.setAccessIp(request.getRemoteAddr());
		accessLogVO.setLoginSuccessYn(userVO == null ? "N" : "Y");
		
		this.accessLogDao.insertNewAccessLog(accessLogVO);
		
		return true;
	}
	
}
