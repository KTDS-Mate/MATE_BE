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
	
	@GetMapping("/user/login")
	public String viewLoginPage(HttpSession session) {
		
		if (session.getAttribute("_LOGIN_USER_") != null) {
			return "redirect:/";
		}
		
		return "user/userlogin";
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
	@GetMapping("/user/editphone/modal")
	public String viewEditPhonePage(@SessionAttribute(name = "_LOGIN_USER_", required= false) UserVO userVO, Model model) {
		
		logger.debug("UserVO null check: {}", userVO);
		
		if (userVO == null) {
			return "redirect:/user/login";
		}
		model.addAttribute("userVO", userVO);
		return "user/frag-editphn";
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
		return "user/frag-editpwd";
	}
	
	// 비밀번호 유효성 검증 메서드
	public boolean isValidPassword(String password) {
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\-=/]).{8,16}$";
		return password.matches(passwordRegex);
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
