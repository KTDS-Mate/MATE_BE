package com.mate.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.access.dao.AccessLogDao;
import com.mate.access.vo.AccessLogVO;
import com.mate.common.beans.Sha;
import com.mate.common.utils.RequestUtil;
import com.mate.user.dao.UserDao;
import com.mate.user.service.UserService;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

import io.socket.engineio.client.transports.PollingXHR.Request;


@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class); 
	
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
		boolean isIpBlock = this.accessLogDao.selectLoginFailCount(RequestUtil.getIp()) >= 5;
		
		log.info("로그인 시도 아이디: {}", loginUserVO.getUsrLgnId());
		
		if (isIpBlock) {
			throw new IllegalArgumentException("해당 IP의 로그인 시도가 잦습니다. 잠시 후 다시 시도해 주세요.");
		}
		
		// salt 조회
		String salt = this.userDao.selectSalt(loginUserVO.getUsrLgnId());
		// 유저 ID가 잘못된 경우
		if (salt == null) {
			log.warn("SALT를 찾을 수 없습니다. 아이디가 잘못되었습니다: {}", loginUserVO.getUsrLgnId());
			
			AccessLogVO accessLogVO = new AccessLogVO();
			accessLogVO.setAccessType("LOGIN");
			accessLogVO.setAccessUrl( RequestUtil.getRequest().getRequestURI() );
			accessLogVO.setAccessMethod( RequestUtil.getRequest().getMethod().toUpperCase() );
			accessLogVO.setAccessIp( RequestUtil.getIp());
			accessLogVO.setAccessId(loginUserVO.getUsrLgnId());
			accessLogVO.setAccessLogId(loginUserVO.getUsrId());
			accessLogVO.setLoginSuccessYn("N");
		
			this.accessLogDao.insertNewAccessLog(accessLogVO);
			
			throw new IllegalArgumentException("잘못된 아이디 또는 비밀번호입니다.");
		}
		
		// 유저 입력 비밀번호 암호화
		String password = loginUserVO.getUsrPwd();
		password = this.sha.getEncrypt(password, salt);
		loginUserVO.setUsrPwd(password);
		
		// 이메일과 암호화된 비밀번호로 데이터베이스에서 회원 정보 조회
		log.info("암호화된 비밀번호: {}", password);
		UserVO userVO = this.userDao.selectOneMember(loginUserVO);
		// 유저의 비밀번호가 잘못된 경우
		if (userVO == null) {
			log.warn("로그인 실패 - 잘못된 비밀번호");
			loginUserVO.setIp(RequestUtil.getIp());
			this.userDao.updateLoginFailState(loginUserVO);
			
			AccessLogVO accessLogVO = new AccessLogVO();
			accessLogVO.setAccessType("LOGIN");
			accessLogVO.setAccessId(loginUserVO.getUsrLgnId());
			accessLogVO.setAccessIp(RequestUtil.getIp());
			accessLogVO.setAccessMethod(RequestUtil.getRequest().getMethod().toUpperCase());
			accessLogVO.setAccessUrl(RequestUtil.getRequest().getRequestURI());
			accessLogVO.setLoginSuccessYn("N");
			log.info("비밀번호 실패 로그 - 유저의 ID는 : {}", accessLogVO.getAccessId());
			
			this.accessLogDao.insertNewAccessLog(accessLogVO);
			
			throw new IllegalArgumentException("잘못된 아이디 또는 비밀번호입니다.");
		}
		
		// LOGIN_FAIL_COUNT가 5회 이상 & 5회 count 이후 1시간이 지나지 않았을 경우 로그인 실패 처리
		boolean isBlockState = this.userDao.selectLoginRestrictionCount(loginUserVO.getUsrLgnId()) > 0;
		
		if (isBlockState) {
			throw new IllegalArgumentException("로그인이 불가능합니다. 잠시 후 다시 시도해주세요.");
		}
		
		loginUserVO.setIp(RequestUtil.getIp());
		this.userDao.upadateLoginSuccessState(loginUserVO);
		
		AccessLogVO accessLogVO = new AccessLogVO();
		accessLogVO.setAccessType("LOGIN");
		accessLogVO.setAccessId(loginUserVO.getUsrLgnId());
		accessLogVO.setAccessUrl(RequestUtil.getRequest().getRequestURI());
		accessLogVO.setAccessMethod(RequestUtil.getRequest().getMethod().toUpperCase());
		accessLogVO.setAccessIp(RequestUtil.getIp());
		accessLogVO.setLoginSuccessYn("Y");
		
		// 성공 로그
		this.accessLogDao.insertNewAccessLog(accessLogVO);
		
		log.info("로그인 성공: {}", userVO);
		return userVO;
	}

	@Override
	public boolean softDeleteUser(String usrLgnId) {
		return this.userDao.softDeleteOneUser(usrLgnId) > 0;
	}
}
