package com.mate.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 요청과 관련되어있는 것을 가져오기 위해
 */
public final class RequestUtil {

	/**
	 * 요청자의 요청정보를 가져온다
	 * @return 요청정보
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes request =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		return request.getRequest();
	}
	
	/**
	 * 요청자의 IP를 가져온다
	 * @return IP
	 */
	public static String getIp() {
		return getRequest().getRemoteAddr();
	}
	
}
