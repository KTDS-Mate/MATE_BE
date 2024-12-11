package com.mate.common.beans.security.oauth;

import java.util.Map;

public interface SecurityOAuth2UserInfo {
	
	/**
	 * OAuth 인증이 완료된 사용자의 scope 데이터를 돌려준다.
	 * @return
	 */
	public Map<String, Object> getScope();
	
	public String getNameInScope();
	
	public String getEmailInScope();

}
