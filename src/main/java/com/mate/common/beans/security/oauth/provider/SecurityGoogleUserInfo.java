package com.mate.common.beans.security.oauth.provider;

import java.util.Map;

import com.mate.common.beans.security.oauth.SecurityOAuth2UserInfo;

public class SecurityGoogleUserInfo implements SecurityOAuth2UserInfo {

	private Map<String, Object> scope;
	
	public SecurityGoogleUserInfo(Map<String, Object> scope) {
		this.scope = scope;
	}
	
	@Override
	public Map<String, Object> getScope() {
		return this.scope;
	}

	@Override
	public String getNameInScope() {
		return this.scope.get("name").toString();
	}

	@Override
	public String getEmailInScope() {
		return this.scope.get("email").toString();
	}
}
