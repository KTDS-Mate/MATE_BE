package com.mate.common.beans.security.oauth.provider;

import java.util.Map;

import com.mate.common.beans.security.oauth.SecurityOAuth2UserInfo;

public class SecurityNaverUserInfo implements SecurityOAuth2UserInfo {
	
	// response 데이터 저장
	private Map<String, Object> scope;
	
	// 데이터를 넣을 생성자
	@SuppressWarnings("unchecked")
	public SecurityNaverUserInfo(Map<String, Object> scope) {
		this.scope = (Map<String, Object>) scope.get("response");
	}

	public Map<String, Object> getScope() {
		return this.scope;
	}
	
	public String getNameInScope() {
		return this.scope.get("name").toString();
	}
	
	public String getEmailInScope() {
		return this.scope.get("email").toString();
	}
}
