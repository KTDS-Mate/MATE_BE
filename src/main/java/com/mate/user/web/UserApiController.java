package com.mate.user.web;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.beans.Sha;
import com.mate.common.beans.security.jwt.JsonWebTokenProvider;
import com.mate.common.vo.ApiResponse;
import com.mate.common.vo.CountriesListVO;
import com.mate.common.vo.CountriesVO;
import com.mate.user.dao.UserDao;
import com.mate.user.service.UserService;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

	private static Logger log = LoggerFactory.getLogger(UserApiController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
    @Autowired
    private Sha sha;

    @Autowired
    private JsonWebTokenProvider jsonWebTokenProvider;
    
    @GetMapping("/regist")
    public ApiResponse getRegistrationData() {
        List<CountriesVO> countriesList = userService.getAllCountries();
        
        Map<String, Object> body = new HashMap<>();
        body.put("countriesList", countriesList);

        return new ApiResponse(body);
    }
    
    @PostMapping("/regist")
    public ApiResponse doCreateUser(@RequestBody RegistUserVO registUserVO) {

        // 이메일 인증 여부, 비밀번호 일치 여부 등 검증
        if (!"true".equals(registUserVO.getAuthVerified())) {
            ApiResponse error = new ApiResponse(HttpStatus.BAD_REQUEST);
            error.setErrors(List.of("이메일 인증을 완료해야 합니다."));
            return error;
        }

        if (!registUserVO.getUsrPwd().equals(registUserVO.getConfirmPwd())) {
            ApiResponse error = new ApiResponse(HttpStatus.BAD_REQUEST);
            error.setErrors(List.of("비밀번호가 일치하지 않습니다."));
            return error;
        }

        boolean isCreated = this.userService.createNewUser(registUserVO);
        if (!isCreated) {
            ApiResponse error = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR);
            error.setErrors(List.of("회원가입에 실패하였습니다."));
            return error;
        }

        return new ApiResponse("회원가입이 완료되었습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> doLogin(@RequestBody LoginUserVO loginUserVO) {
        String loginId = loginUserVO.getUsrLgnId();
        UserVO userVO = this.userDao.selectUserByLoginId(loginId);

        if (userVO == null) {
            ApiResponse error = new ApiResponse(HttpStatus.FORBIDDEN);
            error.setErrors(List.of("아이디 또는 비밀번호가 일치하지 않습니다."));
            return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
        }

        String inputPassword = loginUserVO.getUsrPwd();
        String salt = userVO.getSalt();
        String encryptedInputPwd = sha.getEncrypt(inputPassword, salt);

        log.debug("inputPassword: {}", inputPassword);
        log.debug("encryptPassword: {}", encryptedInputPwd);
            
        if (!encryptedInputPwd.equals(userVO.getUsrPwd())) {
            ApiResponse error = new ApiResponse(HttpStatus.FORBIDDEN);
            error.setErrors(List.of("아이디 또는 비밀번호가 일치하지 않습니다."));
            return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
        }

        // JWT 발급
        String jwt = this.jsonWebTokenProvider.generateJwt(Duration.ofHours(12), userVO);
        ApiResponse success = new ApiResponse(HttpStatus.OK);
        success.setBody(jwt);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
	
	/**
     * 아이디 사용 가능 여부 확인
     */
    @GetMapping("/regist/availableid")
    public ApiResponse doCheckAvailableId(@RequestParam String usrLgnId, Authentication authentication) {
        boolean isAvailableId = this.userService.checkAvailableId(usrLgnId);
        
        ApiResponse response = new ApiResponse();
        Map<String, Object> body = new HashMap<>();
        body.put("usrLgnId", usrLgnId);
        body.put("available", isAvailableId);
        response.setBody(body);

        return response;
    }

    /**
     * 이메일 사용 가능 여부 확인
     */
    @GetMapping("/regist/availableemail")
    public ApiResponse doCheckAvailableEmail(@RequestParam String usrEml, Authentication authentication) {
        boolean isAvailableEmail = this.userService.checkAvailableEmail(usrEml);
        
        ApiResponse response = new ApiResponse();
        Map<String, Object> body = new HashMap<>();
        body.put("usrEml", usrEml);
        body.put("available", isAvailableEmail);
        response.setBody(body);

        return response;
    }

    /**
     * 휴대전화번호 사용 가능 여부 확인
     * (기존에는 sessionAttribute `_LOGIN_USER_`를 사용했으나, Authentication에서 추출)
     */
    @GetMapping("/regist/availablephn")
    public ApiResponse doCheckAvailablePhn(@RequestParam String usrPhn, Authentication authentication) {
        UserVO userVO = extractUserVO(authentication);
        String usrLgnId = (userVO != null) ? userVO.getUsrLgnId() : null;
        
        boolean isAvailablePhn = this.userService.checkAvailablePhn(usrPhn, usrLgnId);
        
        ApiResponse response = new ApiResponse();
        Map<String, Object> body = new HashMap<>();
        body.put("usrPhn", usrPhn);
        body.put("available", isAvailablePhn);
        response.setBody(body);
        
        return response;
    }

    /**
     * 휴대전화번호 수정
     */
    @PostMapping("/editphone")
    public ApiResponse doEditPhone(@RequestBody UserVO userVO, Authentication authentication) {
        ApiResponse response = new ApiResponse();
        
        // SecurityContext에서 인증된 사용자 정보 추출
        UserVO authenticatedUser = (UserVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (authenticatedUser == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED);
            response.setErrors(List.of("로그인이 필요합니다."));
            return response;
        }

        String usrPhn = userVO.getUsrPhn();
        if (usrPhn == null || !usrPhn.matches("^\\+?[0-9]{8,15}$")) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setErrors(List.of("휴대 전화번호를 올바르게 입력해 주세요."));
            return response;
        }

        usrPhn = usrPhn.replaceAll("[^+0-9]", "");
        if (!usrPhn.matches("^\\+?[0-9]{8,15}$")) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setErrors(List.of("휴대 전화번호를 올바르게 입력해 주세요."));
            return response;
        }
        
    	userVO.setUsrLgnId(authenticatedUser.getUsrLgnId());
    	userVO.setUsrPhn(usrPhn);
        
        try {
        	// 전화번호 업데이
        	boolean isUpdated = userService.updateUserPhoneNumber(userVO);
            if (isUpdated) {
                response.setBody("휴대전화번호가 성공적으로 변경되었습니다.");
            } else {
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                response.setErrors(List.of("휴대전화번호 변경에 실패했습니다."));
            }
        } catch(IllegalArgumentException e) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setErrors(List.of(e.getMessage()));
        }
        
        return response;
    }

    /**
     * 비밀번호 재발급 요청
     * POST /api/user/reissue-password
     * @throws jakarta.mail.MessagingException 
     */
    @PostMapping("/reissue-password")
    public ApiResponse reissuePassword(@RequestBody UserVO userVO) throws jakarta.mail.MessagingException {
        String usrLgnId = userVO.getUsrLgnId();
        String usrEml = userVO.getUsrEml();
        
        try {
        	boolean isReissued = userService.reissueUserPassword(userVO);
            ApiResponse response = new ApiResponse();
            
            if (isReissued) {
                Map<String, Object> body = new HashMap<>();
                body.put("message", "입력하신 이메일로 임시 비밀번호가 발급되었습니다.");
                body.put("messageType", "success");
                response.setBody(body);
                response.setStatus(HttpStatus.OK);
            } else {
                response.setStatus(HttpStatus.BAD_REQUEST);
                response.setErrors(List.of("일치하는 회원 정보가 없습니다."));
            }
            
            return response;
            
        } catch (MessagingException e) {
        	log.error("비밀번호 재발급 이메일 전송 실패: {}", usrEml, e);
        	ApiResponse errorResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR);
            errorResponse.setErrors(List.of("비밀번호 재발급 이메일 전송에 실패했습니다. 다시 시도해 주세요."));
            return errorResponse;
        }
    }

    
    /**
     * 비밀번호 변경
     */
    @PostMapping("/changePassword")
    public ApiResponse updatePassword(@RequestBody UserVO userVO,
                                      Authentication authentication) {
        ApiResponse response = new ApiResponse();

        // SecurityContext에서 인증된 사용자 정보 추출
        UserVO authenticatedUser = (UserVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (authenticatedUser == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED);
            response.setErrors(List.of("로그인이 필요합니다."));
            return response;
        }
        
        String currentPwd = userVO.getCurrentPwd();  // 클라이언트가 보낸 현재 비밀번호
        String newPwd = userVO.getNewPwd();          // 클라이언트가 보낸 새 비밀번호
        String confirmPwd = userVO.getConfirmPwd();
        
        // 현재 비밀번호 확인
        if (!userService.checkCurrentPassword(authenticatedUser.getUsrLgnId(), currentPwd)) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setErrors(List.of("기존의 비밀번호가 일치하지 않습니다."));
            return response;
        }

        // 새 비밀번호와 확인 비밀번호 일치 확인
        if (!newPwd.equals(confirmPwd)) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setErrors(List.of("새 비밀번호가 일치하지 않습니다."));
            return response;
        }

        // 비밀번호 정규식 검증
        if (!isValidPassword(newPwd)) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setErrors(List.of("비밀번호 형식이 올바르지 않습니다."));
            return response;
        }

        // 비밀번호 변경 처리
        try {
            boolean isUpdated = userService.updateUserPassword(authenticatedUser, newPwd);
            if (isUpdated) {
                response.setBody("비밀번호가 변경되었습니다.");
            } else {
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                response.setErrors(List.of("비밀번호 변경에 실패했습니다."));
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setErrors(List.of("비밀번호 변경에 실패했습니다."));
        }
        return response;
    }

    /**
     * 현재 비밀번호 확인
     */
    @PostMapping("/checkCurrentPassword")
    public ApiResponse checkCurrentPassword(@RequestParam String currentPwd, Authentication authentication) {
        ApiResponse response = new ApiResponse();
        
        UserVO userVO = extractUserVO(authentication);
        if (userVO == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED);
            response.setErrors(List.of("로그인이 필요합니다."));
            return response;
        }
        
        boolean isValid = userService.checkCurrentPassword(userVO.getUsrLgnId(), currentPwd);
        
        Map<String, Object> body = new HashMap<>();
        body.put("isValid", isValid);
        
        if (!isValid) {
            body.put("message", "현재 비밀번호가 일치하지 않습니다.");
        }
        
        response.setBody(body);
        return response;
    }
    
    /**
     * 아이디 찾기 요청
     * POST /api/user/find-id
     * @throws jakarta.mail.MessagingException 
     */
    @PostMapping("/find-id")
    public ApiResponse findUserId(@RequestBody Map<String, String> request) throws jakarta.mail.MessagingException {
		String usrEml = request.get("usrEml");
        
        if (usrEml == null || usrEml.trim().isEmpty()) {
            ApiResponse errorResponse = new ApiResponse();
            errorResponse.setStatus(HttpStatus.BAD_REQUEST);
            errorResponse.setErrors(List.of("이메일을 입력하세요."));
            return errorResponse;
        }
        
        try {
            boolean isFound = userService.findUserIdByEmail(usrEml);
            ApiResponse response = new ApiResponse();
            
            if (isFound) {
                Map<String, Object> body = new HashMap<>();
                body.put("message", "입력하신 이메일로 아이디가 전송되었습니다.");
                body.put("messageType", "success");
                response.setBody(body);
                response.setStatus(HttpStatus.OK); 
            } else {
                response.setStatus(HttpStatus.BAD_REQUEST);
                response.setErrors(List.of("일치하는 회원 정보가 없습니다."));
            }
            
            return response;
            
        } catch (MessagingException e) {
            log.error("아이디 찾기 이메일 전송 실패: {}", usrEml, e);
            ApiResponse errorResponse = new ApiResponse();
            errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR); 
            errorResponse.setErrors(List.of("아이디 찾기 이메일 전송에 실패했습니다. 다시 시도해 주세요."));
            return errorResponse;
        }
    
    }
    
    /**
     * 국가 목록을 조회하는 엔드포인트
     * GET /api/user/countries
     */
    @GetMapping("/countries")
    public ApiResponse getAllCountries() {
        List<CountriesVO> countriesList = userService.getAllCountries();
        CountriesListVO responseVO = new CountriesListVO();
        responseVO.setCountriesCount(countriesList.size());
        responseVO.setCountriesList(countriesList);
        
        ApiResponse response = new ApiResponse();
        response.setBody(responseVO);
        return response;
    }

    /**
     * Authentication에서 UserVO 추출
     */
    private UserVO extractUserVO(Authentication authentication) {
        if (authentication == null || authentication.getPrincipal() == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserVO user) {
            return user;
        }
        return null;
    }
    
    /**
     * 비밀번호 유효성 검증 메서드
     */
    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\-=/]).{8,16}$";
        return password.matches(passwordRegex);
    }
	
}
