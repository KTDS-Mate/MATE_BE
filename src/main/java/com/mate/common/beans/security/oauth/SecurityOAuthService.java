package com.mate.common.beans.security.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.mate.common.beans.security.oauth.provider.SecurityGoogleUserInfo;
import com.mate.common.beans.security.oauth.provider.SecurityNaverUserInfo;
import com.mate.user.dao.UserDao;
import com.mate.user.vo.UserVO;

@Service
public class SecurityOAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		// 요청을 수락하는 객체 생성(OAuth인증 요청)
		OAuth2UserService<OAuth2UserRequest, OAuth2User> OAuthRequest = new DefaultOAuth2UserService();
		
		// OAuthProvider(naver, google)에게 인증을 요청하고 사용자의 정보(scope)를 받아온다.
		OAuth2User oAuth2User = OAuthRequest.loadUser(userRequest);
		
		// provider 인증 객체 생성
		// 1. OAuth 요청을 보낼 Provider의 이름 취득
		String provider = userRequest.getClientRegistration().getRegistrationId();
		
		SecurityOAuth2UserInfo oAuthUserScope = null;
		
		if (provider.equals("naver")) {
			oAuthUserScope = new SecurityNaverUserInfo(oAuth2User.getAttributes());
		} else if (provider.equals("google")) {
			oAuthUserScope = new SecurityGoogleUserInfo(oAuth2User.getAttributes());
		}
		
		UserVO oAuthUser = new UserVO();
		oAuthUser.setUsrEml(oAuthUserScope.getEmailInScope());
		oAuthUser.setUsrLgnId(oAuthUserScope.getNameInScope());
		oAuthUser.setUsrPwd("none");
		oAuthUser.setSalt(provider);
		oAuthUser.setRole("ROLE_USER");
		oAuthUser.setProvider(provider);
		
		// oAuth 인증 유저 데이터베이스에 저장.
		userDao.mergeUser(oAuthUser);
		oAuthUser = this.userDao.selectUserByLoginId(oAuthUser.getUsrLgnId());
		
		SecurityOAuthUserDetails oAuthUserDetails = new SecurityOAuthUserDetails(oAuthUser, oAuthUserScope); 
		
		return oAuthUserDetails;
	}
}
