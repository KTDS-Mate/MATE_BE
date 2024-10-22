package com.mate.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.access.vo.AccessLogVO;
import com.mate.common.beans.Sha;
import com.mate.common.utils.RequestUtil;
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
	
//	@Autowired
//	private AccessLogDao accessLogDao;

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
		boolean isIpBlock = this.accessLogDao.selectLoginFailCount(RequestUtil.getIp()) >= 5;
		
		if (isIpBlock) {
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르게 입력되지 않았습니다.");
		}
		
		String salt = this.userDao.selectSalt(loginUserVO.getUsrId());
		if (salt == null) {
			AccessLogVO accessLogVO = new AccessLogVO();
		}
		
		return null;
	}

	@Override
	public boolean safeDeleteMember(String usrId) {
		return false;
	}
}
