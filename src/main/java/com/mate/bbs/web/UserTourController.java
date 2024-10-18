package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.UserTourListVO;

@Controller
public class UserTourController {

	@Autowired
	private UserTourService userTourService;
	
	@GetMapping("/usertour/list")
	public String viewUserTourBoard(Model model) {
		UserTourListVO userTourListVO = this.userTourService.readAllUserTour();
		model.addAttribute("userTourListVO", userTourListVO);
		return "all/tour_list";
	}
	
}
