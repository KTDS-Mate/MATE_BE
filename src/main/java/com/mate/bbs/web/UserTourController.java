package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourVO;

@Controller
public class UserTourController {

	@Autowired
	private UserTourService userTourService;
	
	@GetMapping("/usertour/list")
	public String viewUserTourList(Model model) {
		UserTourListVO userTourListVO = this.userTourService.getAllUserTour();
		model.addAttribute("userTourListVO", userTourListVO);
		
		return "all/tour_list";
	}
	
	@GetMapping("/usertour/view") // http://localhost:8080/usertour/view?usrTrPstId=?
	public String viewOneUserTour(@RequestParam String usrTrPstId
								, Model model) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);
		model.addAttribute("userTourVO", userTourVO);
		
		return "all/GuideRecruitmentPage";
	}
	
	@GetMapping("/usertour/insert")
	public String viewUserTourInsertPage() {
		return "all/Tourist_TourInsert";
	}
	
}
