package com.mate.user.web;

import java.util.HashMap;
import java.util.Map;

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

import com.mate.user.service.UserService;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user/regist")
	public String viewCreateUserPage(Model model) {
		model.addAttribute("registUserVO", new RegistUserVO());
		return "user/userregist";
	}
	
	@PostMapping("/user/regist")
	public String doCreateUser(@Valid RegistUserVO registUserVO, BindingResult bindingResult, Model model) {
		
		// 이메일 인증이 되지 않을 경우 회원가입 진행 불가 설정
		if (!"true".equals(registUserVO.getAuthVerified())) {
			bindingResult.rejectValue("authVerified", "error.authVerified", "이메일 인증을 완료해야 회원가입이 완료됩니다. 이메일을 인증해주세요.");
			return "user/userregist";
		}
		
		// 비밀번호가 불일치될 경우 회원 가입 진행 불가 설정
		if (!registUserVO.getUsrPw().trim().equals(registUserVO.getConfirmPw().trim())) {
			bindingResult.rejectValue("confirmPw", "error_password", "비밀번호가 일치하지 않습니다.");
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
	public String viewLoginPage() {
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
