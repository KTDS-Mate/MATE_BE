package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourListVO;

@Controller
public class GuideTourController {

	@Autowired
	private GuideTourService guideTourService;
	
	@GetMapping("/guideTour/list")
	public String viewGuideTourList(Model model) {
		GuideTourListVO guideTourListVO = this.guideTourService.getAllGuideTour();
		model.addAttribute("guideTourListVO", guideTourListVO);
		return "guide/Guide_TourInsert";
	}
	@GetMapping("/message")
	public String view() {
		return "all/send_message";
	}
}
