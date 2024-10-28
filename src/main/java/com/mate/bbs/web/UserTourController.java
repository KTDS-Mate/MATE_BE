package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;
import com.mate.user.vo.UserVO;

import jakarta.validation.Valid;

@Controller
public class UserTourController {

	@Autowired
	private UserTourService userTourService;
	
	/**클라이언트가 등록한 가이드 구인 게시글 목록 조회 페이지**/
	@GetMapping("/usertour/list")
	public String viewAllUserTourPage(Model model
									 , SearchUserTourVO searchUserTourVO) {
		UserTourListVO userTourListVO = this.userTourService.getAllUserTour(searchUserTourVO);
		model.addAttribute("userTourListVO", userTourListVO);
		model.addAttribute("searchUserTourVO", searchUserTourVO);
		
		return "usertour/tour_list";
	}
	
	/**클라이언트가 등록한 가이드 구인 게시글 상세 조회 페이지**/
	@GetMapping("/usertour/view")
	public String viewOneUserTourPage(@RequestParam String usrTrPstId
									 , Model model) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);
		model.addAttribute("userTourVO", userTourVO);
		return "usertour/GuideRecruitmentPage";
	}
	
	/**클라이언트가 등록한 가이드 구인 게시글 작성 페이지**/
	@GetMapping("/usertour/insert")
	public String viewUserTourInsertPage() {
		return "usertour/Tourist_TourInsert";
	}
	
	/**클라이언트가 작성 가이드 구인 게시글을 받아와서 DB에 저장하는 페이지**/
	@PostMapping("/usertour/insert")
	public String doCreateNewUserTour(@Valid UserTourWriteVO userTourWriteVO
									, BindingResult bindingResult
									, Model model
									, @SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO
									) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("userTourWriteVO", userTourWriteVO);
			return "usertour/Tourist_TourInsert";
		}
		if (loginUserVO == null) {
			return "redirect:/user/login";
		}
		
		userTourWriteVO.setAthrId(loginUserVO.getUsrLgnId());
		
		this.userTourService.createNewUserTour(userTourWriteVO);
		
		return "redirect:/usertour/list";
	}
}
