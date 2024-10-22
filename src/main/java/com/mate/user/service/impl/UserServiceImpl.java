package com.mate.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.access.dao.AccessLogDao;
import com.mate.common.beans.Sha;
import com.mate.user.dao.UserDao;
import com.mate.user.service.UserService;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Sha sha;
	
	@Autowired
	private AccessLogDao accessLogDao;

	@Override
	public boolean createNewUser(RegistUserVO registUserVO) {
		
		int usrIdCount = this.userDao.getIdCount(registUserVO.getUsrId());
		int usrEmailCount = this.userDao.getEmailCount(registUserVO.getUsrEml());
		
		if (usrIdCount > 0) {
			throw new IllegalArgumentException("해당 아이디는 사용중인 아이디입니다.");
		} else if (usrEmailCount > 0) {
			throw new IllegalArgumentException("해당 이메일은 사용중인 이메일입니다.");
		}
		
		// salt 발급.
		String salt = this.sha.generateSalt();
		
		// user 비밀번호 암호화
		String password = registUserVO.getUsrPw();
		password = this.sha.getEncrypt(password, salt);
		
		// salt DB에 저장.(비밀번호 찾기용)
		registUserVO.setUsrPw(password);
		registUserVO.setSalt(salt);
		
		int insertCount = this.userDao.insertNewUser(registUserVO);
		return insertCount > 0;
	}

	@Override
	public boolean checkAvailableEmail(String email) {
		return this.userDao.getEmailCount(email) == 0;
	}

	@Override
	public boolean checkAvailableId(String usrId) {
		return this.userDao.getIdCount(usrId) == 0;
	}
	
	@Override
	public UserVO readUser(LoginUserVO loginUserVO) {
		
		
		
		return null;
	}

	@Override
	public boolean safeDeleteMember(String usrId) {
		return false;
	}
}
