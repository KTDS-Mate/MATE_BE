package com.mate.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mate.common.vo.CountriesVO;
import com.mate.user.service.UserService;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/regist")
	public String viewCreateUserPage(Model model) {
		model.addAttribute("registUserVO", new RegistUserVO());
		
		// countries 리스트 추가
		List<CountriesVO> countriesList = userService.getAllCountries();
		model.addAttribute("countriesList", countriesList);
		
		return "user/userregist";
	}
	
	@PostMapping("/user/regist")
	public String doCreateUser(@Valid RegistUserVO registUserVO, BindingResult bindingResult, Model model) {
		
		logger.debug("countryId Pk값 들어오는지 확인 (gdRpCntId): {}", registUserVO.getGdRpCntId());
		
		// 이메일 인증이 되지 않을 경우 회원가입 진행 불가 설정
		if (!"true".equals(registUserVO.getAuthVerified())) {
			bindingResult.rejectValue("authVerified", "error.authVerified", "이메일 인증을 완료해야 회원가입이 완료됩니다. 이메일을 인증해주세요.");
			return "user/userregist";
		}
		
		// 비밀번호가 불일치될 경우 회원 가입 진행 불가 설정
		if (!registUserVO.getUsrPwd().trim().equals(registUserVO.getConfirmPwd().trim())) {
			bindingResult.rejectValue("confirmPwd", "error_password", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("registUserVO", registUserVO);
			return "user/userregist";
		}
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("registUserVO", registUserVO);
			return "user/userregist";
		}
		
		boolean isCreated = this.userService.createNewUser(registUserVO);
		return "redirect:/user/login";
	}
	
	@ResponseBody
	@GetMapping("/user/regist/availableid")
	public Map<String, Object> doCheckAvailableId(@RequestParam String usrLgnId) {
		
		boolean isAvailableId = this.userService.checkAvailableId(usrLgnId);
		
		Map<String, Object> response = new HashMap<>();
		response.put("usrLgnId", usrLgnId);
		response.put("available", isAvailableId);
		
		return response;
	}
	
	@ResponseBody
	@GetMapping("/user/regist/availableemail")
	public Map<String, Object> doCheckAvailableEmail(@RequestParam String usrEml) {
		boolean isAvailableEmail = this.userService.checkAvailableEmail(usrEml);
		
		Map<String, Object> response = new HashMap<>();
		response.put("usrEml", usrEml);
		response.put("available", isAvailableEmail);
		
		return response;
	}
	
	@ResponseBody
	@GetMapping("/user/regist/availablephn")
	public Map<String, Object> doCheckAvailablePhn(@RequestParam String usrPhn) {
		boolean isAvailablePhn = this.userService.checkAvailablePhn(usrPhn);
		
		Map<String, Object> response = new HashMap<>();
		response.put("usrPhn", usrPhn);
		response.put("available", isAvailablePhn);
		
		return response;
	}
	
	@GetMapping("/user/login")
	public String viewLoginPage(HttpSession session) {
		
		if (session.getAttribute("_LOGIN_USER_") != null) {
			return "redirect:/";
		}
		
		return "user/userlogin";
	}
	
	@PostMapping("/user/login")
	public String doLogin(@Valid LoginUserVO loginUserVO, BindingResult bindingResult, HttpSession session, Model model) {
		
		// 아이디나 비밀번호가 입력되지 않았을 경우 개별적으로 에러를 추가.
//		if (loginUserVO.getUsrLgnId() == null || loginUserVO.getUsrLgnId().trim().isEmpty()) {
//			bindingResult.rejectValue("usrLgnId", "error.usrLgnId", "아이디를 입력해주세요.");
//		}
//		if (loginUserVO.getUsrPwd() == null || loginUserVO.getUsrPwd().trim().isEmpty()) {
//			bindingResult.rejectValue("usrPwd", "error.usrPwd", "비밀번호를 입력해주세요.");
//		}
		// 위 두개의 바인딩 에러가 있으면 로그인 페이지로 돌아간다.
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginUserVO", loginUserVO);
			return "user/userlogin";
		}
		
		UserVO userVO = this.userService.readUser(loginUserVO);
		
		// 아이디 또는 비밀번호가 잘못 입력된 경우
		if (userVO == null) { 
			// 에러메세지 설정
			model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
			// 폼 데이터 유지
			//model.addAttribute("loginUserVO", loginUserVO);
			//bindingResult.reject("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
			return "user/userlogin"; 
		}
		
		// 로그인 성공 시 세션 저장 및 리다이렉트
		session.setAttribute("_LOGIN_USER_", userVO);
		String nextUrl = loginUserVO.getNextUrl();
		return "redirect:" + (nextUrl != null && !nextUrl.isEmpty() ? nextUrl : "/");
		//return "redirect:/";
	}

	@GetMapping("/user/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/user/reissue-password")
	public String viewReissuePasswordPage(HttpSession session, Model model) {
		if (session.getAttribute("_LOGIN_USER_") != null) {
			return "redirect:/";
		}
		
		model.addAttribute("userVO", new UserVO());
		return "user/reissue-password";
	}
	
	@PostMapping("/user/reissue-password")
	public String reissuePassword(@RequestParam String usrLgnId,
								  @RequestParam String usrEml, Model model) {
		UserVO userVO = new UserVO();
		userVO.setUsrLgnId(usrLgnId);
		userVO.setUsrEml(usrEml);
		
		boolean isReissued = userService.reissueUserPassword(userVO);
		if (isReissued) {
			model.addAttribute("message", "입력하신 이메일로 임시 비밀번호가 발급되었습니다.");
			model.addAttribute("messageType", "success");
			return "user/userlogin";
		} else {
			model.addAttribute("message", "일치하는 회원 정보가 없습니다.");
			model.addAttribute("messageType", "error");
			return "user/reissue-password";
		}
	}
	
	// 휴대전화번호 수정
	@GetMapping("/user/editphone")
	public String viewEditPhonePage(@SessionAttribute(name = "_LOGIN_USER_", required= false) UserVO userVO, Model model) {
		
		logger.debug("UserVO null check: {}", userVO);
		
		if (userVO == null) {
			return "redirect:/user/login";
		}
		model.addAttribute("userVO", userVO);
		return "user/editphn";
	}
	
	@PostMapping("/user/editphone")
	public String doEditPhone(@SessionAttribute(name = "_LOGIN_USER_", required= false) UserVO userVO , 
							  @RequestParam String newPhn, Model model) {
		
		if (userVO == null ) {
			return "redirect:/user/login";
		}
		
		try {
			boolean isUpdated = userService.updateUserPhoneNumber(userVO.getUsrLgnId(), newPhn);

			if (isUpdated) {
				userVO.setUsrPhn(newPhn);
				model.addAttribute("success", "휴대전화번호가 성공적으로 변경되었습니다.");
			} else {
				model.addAttribute("errorMessage", "휴대전화번호 변경에 실패하였습니다.");
			}
		} catch(IllegalArgumentException e) {
			model.addAttribute("phoneError", e.getMessage());
		}
		if(userVO.getUsrIsGd().equals("N")) {
            return "redirect:/mypage/edit-profile/tr-profile/"+ userVO.getUsrLgnId();
    	} else if(userVO.getUsrIsGd().equals("Y")) {
    		return "redirect:/mypage/edit-profile/gd-profile/"+ userVO.getUsrLgnId();
    	}
    	return "";
	}
	
	@GetMapping("/user/editpypeml")
	public String viewEditPaypalPage(@SessionAttribute(name="_LOGIN_USER_", required=false) UserVO userVO, Model model) {
		
		if (userVO == null) {
			return "redirect:/user/login";
		}
		model.addAttribute("userVO", userVO);
		return "user/editpypeml";
		
	}	
	
	@PostMapping("/user/editpypeml")
	public String doEditPaypalEmail(@SessionAttribute(name = "_LOGIN_USER_", required= false) UserVO userVO, 
									@RequestParam String usrPypEml, Model model) {
		if (userVO == null) {
			return "redirect:/user/login";
		}
		
		try {
			boolean isUpdated = userService.updateUserPaypalEmail(userVO.getUsrLgnId(), usrPypEml);
			
			if (isUpdated) {
				userVO.setUsrPypEml(usrPypEml);
				model.addAttribute("success", "페이팔 이메일이 성공적으로 변경되었습니다.");
			} else {
				model.addAttribute("errorMessage", "휴대전화번호 변경에 실패하였습니다.");
			}
		} catch(IllegalArgumentException e) {
			model.addAttribute("paypalEmailError", e.getMessage());
		}
		return "redirect:mypage/edit-profile/choice";
	}
	
	@GetMapping("/user/editpwd")
	public String viewEditPassword(@SessionAttribute(name = "_LOGIN_USER_", required= false) UserVO userVO, Model model) {
		if (userVO == null) {
			return "redirect:/user/login";
		}
		model.addAttribute("userVO", userVO);
		return "user/editpwd";
	}
	
	@PostMapping("/user/editpwd")
	public String updatePassword(@SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO, 
								@RequestParam String newPwd,
								@RequestParam String currentPwd,
								@RequestParam String confirmPwd,
								Model model) {
		if (userVO == null) {
			return "redirect:/user/login";
		}
		
		// 현재 비밀번호 확인
		if (!userService.checkCurrentPassword(userVO.getUsrLgnId(), currentPwd)) {
			model.addAttribute("currentPwdError", "현재 비밀번호가 일치하지 않습니다.");
			return "user/editpwd";
		}
		
		// 새 비밀번호와 확인 비밀번호 일치 확인
		if (!newPwd.equals(confirmPwd)) {
			model.addAttribute("confirmPwdError", "새 비밀번호가 일치하지 않습니다.");
			return "user/editpwd";
		}
		
		try {
			boolean isUpdated = userService.updateUserPassword(userVO, newPwd);
			if (isUpdated) {
				model.addAttribute("successMessage", "비밀번호가 변경되었습니다.");
				if(userVO.getUsrIsGd().equals("N")) {
		            return "redirect:/mypage/edit-profile/tr-profile/"+ userVO.getUsrLgnId();
		    	} else if(userVO.getUsrIsGd().equals("Y")) {
		    		return "redirect:/mypage/edit-profile/gd-profile/"+ userVO.getUsrLgnId();
		    	}
			} else {
				model.addAttribute("errorMessage", "비밀번호 변경에 실패했습니다.");
				return "redirect:/user/editpwd";
			}
		} catch (IllegalArgumentException e) {
			model.addAttribute("errorMessage", "오류가 발생했습니다: " + e.getMessage());
		}
		
		return userVO.getUsrIsGd().equals("Y") ? 
			"redirect:/mypage/edit-profile/tr-profile/"+ userVO.getUsrLgnId() : "redirect:/mypage/edit-profile/gd-profile/"+ userVO.getUsrLgnId();
	}
	
	
	@ResponseBody
	@PostMapping("/user/checkCurrentPassword")
	public Map<String, Object> checkCurrentPassword(@SessionAttribute(name = "_LOGIN_USER_", required = false) UserVO userVO,
													@RequestParam String currentPwd) {
	    Map<String, Object> response = new HashMap<>();
	    if (userVO == null) {
	        response.put("isValid", false);
	        response.put("error", "로그인이 필요합니다.");
	        return response;
	    }
	    boolean isValid = userService.checkCurrentPassword(userVO.getUsrLgnId(), currentPwd);
	    response.put("isValid", isValid);
	    return response;
	}

	/*
	 * 회원탈퇴 기능 수행은 마이페이지
	 */
	@GetMapping("/user/soft-delete")
	public String doSoftDeleteUser(@SessionAttribute("_LOGIN_USER_") UserVO userVO, HttpSession session) {
		
		if (userVO == null) {
			return "redirect:/user/login";
		}
		
		boolean isDeleted = this.userService.softDeleteUser(userVO.getUsrLgnId());
		if (!isDeleted) {
			return "redirect:/user/fail-soft-delete";
		}
		session.invalidate();
		return "redirect:/user/success-soft-delete";
	}
	
	@GetMapping("/user/{result}-soft-delete")
	public String viewSoftDeletePage(@PathVariable String result) {
		result = result.toLowerCase();
		if (!result.equals("fail") && !result.equals("success")) {
			return "/error/404";
		}
		return "user/" + result + "softdelete";
	}
}
