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
	public String viewCreateUserPage() {
		return "user/userregist";
	}
	
	@PostMapping("/user/regist")
	public String doCreateUser(@Valid RegistUserVO registUserVO, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("userVO", registUserVO);
			return "user/userregist";
		}
		
		if (!registUserVO.getConfirmPw().equals(registUserVO.getUsrPw())) {
			model.addAttribute("error_password", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("userVO", registUserVO);
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
	
	@GetMapping("/user/login")
	public String viewLoginPage() {
		return "user/userlogin";
	}
	
	@PostMapping("/user/login")
	public String doLogin(@Valid LoginUserVO loginUserVO, BindingResult bindingResult, HttpSession session, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginUserVO", loginUserVO);
			return "user/userlogin";
		}
		
		UserVO userVO = this.userService.readUser(loginUserVO);
		session.setAttribute("_LOGIN_USER_", userVO);
		
		return "redirect:" + loginUserVO.getNextUrl();
//		return "redirect:/user/userregist";
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
