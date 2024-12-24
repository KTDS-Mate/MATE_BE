package com.mate.common.beans.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mate.user.vo.UserVO;

/**
 * SpringSeurity와 DB의 사용자 정보를 연결하는 역
 */
public class SecurityUser implements UserDetails {

	private static final long serialVersionUID = 624020502481443669L;

	private UserVO userVO;
	
	/**
	 * UserVO 객체를 매개변수로 받아서 초기화
	 */
	public SecurityUser(UserVO userVO) {
		this.userVO = userVO;
	}
	
	/**
	 * pw 암호화시 사용되는 salt 값을 반환
	 * @return
	 */
	public String getSalt() {
		return this.userVO.getSalt();
	}
	
	/**
	 * 외부에서 사용자 정보에 대해 직접 접근 (getter 역할)
	 */
	public UserVO getUserVO() {
		return this.userVO;
	}
	
	/**
	 * 로그인을 요청한 사용자의 권한 정보를 세팅 -> 로그인 이후 해당 사용자의 권한 정보를 DB에서 조회 후 권한 부여
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		// 역할 세팅(ROLE)
		authorities.add(new SimpleGrantedAuthority(this.userVO.getUsrRole()));
		// 권한 세팅(Authority)
		authorities.addAll(this.userVO.getAuthority().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthorityName())).toList());
		
		return authorities;
	}
	
	/**
	 * 로그인을 요청한 사용자의 비밀번호 반환
	 */
	@Override
	public String getPassword() {
		return this.userVO.getUsrPwd();
	}

	/**
	 * 로그인을 요청한 사용자의 아이디를 반환
	 */
	@Override
	public String getUsername() {
		return this.userVO.getUsrLgnId();
	}
	
	@Override
    public boolean isAccountNonExpired() { 
		return true; 
	}

    @Override
    public boolean isAccountNonLocked() { 
    	return true; 
    }

    @Override
    public boolean isCredentialsNonExpired() { 
    	return true; 
    }

    @Override
    public boolean isEnabled() { 
    	return ((UserDetails) this.userVO).isEnabled(); 
    }
	
}
