package com.mate.common.beans.security.jwt;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.beans.Sha;
import com.mate.common.vo.ApiResponse;
import com.mate.user.dao.UserDao;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.UserVO;

@RestController
public class JsonWebToeknEntryPoint {

	@Autowired
	private JsonWebTokenProvider jsonWebTokenProvider;
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/token")
	public ApiResponse generateToken(@RequestBody LoginUserVO loginUserVO) {
		
		String lgnId = loginUserVO.getUsrLgnId();
		UserVO userVO = this.userDao.selectUserByLoginId(lgnId);
		// 아이디 검증
		if (userVO == null) {
			ApiResponse errorResponse = new ApiResponse(HttpStatus.FORBIDDEN);
			errorResponse.setErrors(List.of("아이디 또는 비밀번호가 일치하지 않습니다."));
			return errorResponse;
		}
		
		String password = loginUserVO.getUsrPwd();
		Sha sha = new Sha();
		String salt = userVO.getSalt();
		String encryptedPassword = sha.getEncrypt(password, salt);
		
		// 패스워드 검증
		if (!encryptedPassword.equals(userVO.getUsrPwd())) {
			ApiResponse errorResponse = new ApiResponse(HttpStatus.FORBIDDEN);
			errorResponse.setErrors(List.of("아이디 또는 비밀번호가 일치하지 않습니다."));
			return errorResponse;
		}
		
		// 토큰 생성
		String jwt = this.jsonWebTokenProvider.generateJwt(Duration.ofHours(12), userVO);
		
		// status Ok이면 body에 jwt를 넣어서 보낸다.
		return new ApiResponse(jwt);
	}
}
