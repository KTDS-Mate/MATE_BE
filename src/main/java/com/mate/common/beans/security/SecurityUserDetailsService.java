package com.mate.common.beans.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mate.user.dao.UserDao;
import com.mate.user.vo.UserVO;

/**
 * SpringSecurity에서 사용자의 인증을 처리하기 위해 사용자가 요청한 정보가 DB에 있는지 조회하는 클래스
 * SecurityUser 객체 반환
 */
public class SecurityUserDetailsService implements UserDetailsService {

	/**
	 * 사용자 정보를 조회할 Dao
	 */
	private UserDao userDao;
	
	/**
	 * 생성자 주입 방식을 사용하여 UserDao 주입 -> DB 연동을 위해 DAO 사용하는 것.
	 */
	public SecurityUserDetailsService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 사용자가 입력한 아이디(이메일)을 사용하여 데이터베이스에서 사용자의 정보를 조회
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserVO userVO = this.userDao.selectUserByLoginId(username);
		
		if (userVO == null) {
			throw new UsernameNotFoundException("아이디 또는 비밀번호가 올바르지 않습니다.");
		}
		// SecurityUser 객체 반환. (사용자 인증 정보 저장)
		return new SecurityUser(userVO);
	}
	
}
