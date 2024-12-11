package com.mate.common.beans.security.oauth;

import java.util.Map;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.mate.common.beans.security.SecurityUser;
import com.mate.user.vo.UserVO;

public class SecurityOAuthUserDetails extends SecurityUser implements OAuth2User {

	private static final long serialVersionUID = -827689625744405919L;
	
	private SecurityOAuth2UserInfo securityOAuth2UserInfo;
	
	public SecurityOAuthUserDetails(UserVO userVO, SecurityOAuth2UserInfo securityOAuth2UserInfo) {
		super(userVO);
		this.securityOAuth2UserInfo = securityOAuth2UserInfo;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return this.securityOAuth2UserInfo.getScope();
	}

	@Override
	public String getName() {
		return super.getUserVO().getUsrLgnId();
	}

	public String getEmail() {
		return super.getUserVO().getUsrEml();
	}
}
