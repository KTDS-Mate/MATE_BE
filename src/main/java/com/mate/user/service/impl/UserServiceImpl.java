package com.mate.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.access.dao.AccessLogDao;
import com.mate.access.vo.AccessLogVO;
import com.mate.common.beans.Sha;
import com.mate.common.utils.RequestUtil;
import com.mate.common.vo.CountriesVO;
import com.mate.user.dao.UserDao;
import com.mate.user.service.UserService;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;


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
		String password = registUserVO.getUsrPwd();
		password = this.sha.getEncrypt(password, salt);
		
		// salt DB에 저장.(비밀번호 찾기용)
		registUserVO.setUsrPwd(password);
		registUserVO.setSalt(salt);
		
		int insertCount = this.userDao.insertNewUser(registUserVO);
		return insertCount > 0;
	}

	@Override
	public boolean checkAvailableEmail(String email) {
		return this.userDao.getEmailCount(email) == 0;
	}

	@Override
	public boolean checkAvailablePaypalEmail(String paypalEmail) {
		return this.userDao.getPaypalEmailCount(paypalEmail) == 0;
	}
	
	@Override
	public boolean checkAvailableId(String usrId) {
		return this.userDao.getIdCount(usrId) == 0;
	}
	
	@Override
	public boolean checkAvailablePhn(String usrPhn) {
		return this.userDao.getPhnCount(usrPhn) == 0;
	}
	
	@Override
	public UserVO readUser(LoginUserVO loginUserVO) {
		boolean isIpBlock = this.accessLogDao.selectLoginFailCount(RequestUtil.getIp()) >= 5;
		
		log.info("로그인 시도 아이디: {}", loginUserVO.getUsrLgnId());
		
		// return null을 하는 이유. 로그인 오류시 사용자를 읽어올때 예외를 던지면 화이트라벨 페이지로 넘어가게 된다. 따라서 null을 던지면
		// controller에서 null을 잡아 로그인 페이지로 다시 이동하도록 만들기 위한 설정
		if (isIpBlock) {
//			throw new IllegalArgumentException("해당 IP의 로그인 시도가 잦습니다. 잠시 후 다시 시도해 주세요.");
			return null;
		}
		
		// salt 조회
		String salt = this.userDao.selectSalt(loginUserVO.getUsrLgnId());
		// 유저 ID가 잘못된 경우
		if (salt == null) {
			log.warn("SALT를 찾을 수 없습니다. 아이디가 잘못되었습니다: {}", loginUserVO.getUsrLgnId());
			
			this.insertAccessLog(loginUserVO, "N");
			// 잘못된 아이디인 경우 Null 반환
			return null; 
			//this.accessLogDao.insertNewAccessLog(accessLogVO);
			//throw new IllegalArgumentException("잘못된 아이디 또는 비밀번호입니다.");
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
			
			this.insertAccessLog(loginUserVO, "N");
			
			//this.accessLogDao.insertNewAccessLog(accessLogVO);
			
			return null;
			
			//throw new IllegalArgumentException("잘못된 아이디 또는 비밀번호입니다.");
		}
		
		// LOGIN_FAIL_COUNT가 5회 이상 & 5회 count 이후 1시간이 지나지 않았을 경우 로그인 실패 처리
		boolean isBlockState = this.userDao.selectLoginRestrictionCount(loginUserVO.getUsrLgnId()) > 0;
		
		if (isBlockState) {
			//throw new IllegalArgumentException("로그인이 불가능합니다. 잠시 후 다시 시도해주세요.");
			return null;
		}
		
		loginUserVO.setIp(RequestUtil.getIp());
		this.userDao.upadateLoginSuccessState(loginUserVO);
		this.insertAccessLog(loginUserVO, "Y");

		// 성공 로그
		//this.accessLogDao.insertNewAccessLog(accessLogVO);
		
		log.info("로그인 성공: {}", userVO);
		return userVO;
	}

	// accessLog를 기록하는 메서드 분리
	private void insertAccessLog(LoginUserVO loginUserVO, String successYn) {
		
		AccessLogVO accessLogVO = new AccessLogVO();
		accessLogVO.setAccessType("LOGIN");
		accessLogVO.setAccessId(loginUserVO.getUsrLgnId());
		accessLogVO.setAccessUrl(RequestUtil.getRequest().getRequestURI());
		accessLogVO.setAccessMethod(RequestUtil.getRequest().getMethod().toUpperCase());
		accessLogVO.setAccessIp(RequestUtil.getIp());
		accessLogVO.setAccessLogId(loginUserVO.getUsrIsGd());
		accessLogVO.setLoginSuccessYn(successYn);
		
		this.accessLogDao.insertNewAccessLog(accessLogVO);
	}
	
	@Override
	public boolean softDeleteUser(String usrLgnId) {
		return this.userDao.softDeleteOneUser(usrLgnId) > 0;
	}
	
	@Override
	public boolean updateUserPhoneNumber(String usrLgnId, String newPhn) {

		if (!checkAvailablePhn(newPhn)) {
			throw new IllegalArgumentException("이미 사용중인 휴대전화번호입니다.");
		}
		
		UserVO userVO = new UserVO();
		userVO.setUsrLgnId(usrLgnId);
		userVO.setUsrPhn(newPhn);
		return userDao.updateUserPhoneNumber(userVO) > 0;
	}
	
	@Override
	public boolean updateUserPaypalEmail(String usrLgnId, String usrPypEml) {
		
		if(!checkAvailablePaypalEmail(usrPypEml)) {
			throw new IllegalArgumentException("이미 사용중인 Paypal 이메일입니다.");
		}
		
		UserVO userVO = new UserVO();
		userVO.setUsrLgnId(usrLgnId);
		userVO.setUsrPypEml(usrPypEml);
		log.debug("usrPypEml 값 확인: {}", usrPypEml);
		
		return userDao.upadateUserPaypalEmail(userVO) > 0;
	}
	
	@Override
	public boolean updateUserPassword(UserVO userVO, String newPassword) {

		// salt 생성 및 사용자가 입력한 새로운 비밀번호 암호화
		String salt = sha.generateSalt();
		String encryptedPassword = sha.getEncrypt(newPassword, salt);
		
		// 암호화된 비밀번호를 DB에 저장.
		userVO.setUsrPwd(encryptedPassword);
		userVO.setSalt(salt);
		
		int updateCount = userDao.updateUserPassword(userVO);
		
		return updateCount > 0;
	}
	
	/**
	 * 모든 국가 정보를 조회함.
	 * @return 국가 정보를 담은 List
	 */
	@Override
	public List<CountriesVO> getAllCountries() {
		return userDao.selectAllCountries();
	}
}
