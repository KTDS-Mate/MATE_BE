package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourVO;

@Controller
public class UserTourController {

	@Autowired
	private UserTourService userTourService;
	
	/**클라이언트가 등록한 가이드 투어 게시글 목록 조회 페이지**/
	@GetMapping("/usertour/list")
	public String viewAllUserTourPage(Model model
									 , SearchUserTourVO searchUserTourVO) {
		UserTourListVO userTourListVO = this.userTourService.getAllUserTour(searchUserTourVO);
		model.addAttribute("userTourListVO", userTourListVO);
		model.addAttribute("searchUserTourVO", searchUserTourVO);
		
		return "all/tour_list";
	}
	
	/**클라이언트가 등록한 가이드 투어 게시글 상세 조회 페이지**/
	@GetMapping("/usertour/view")
	public String viewOneUserTourPage(@RequestParam String usrTrPstId
									 , Model model) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);
		model.addAttribute("userTourVO", userTourVO);
		return "all/GuideRecruitmentPage";
	}
	
}
