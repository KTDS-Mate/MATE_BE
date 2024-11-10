package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mate.bbs.service.GuideListService;

@Controller
public class GuideListController {
	
	@Autowired
	private GuideListService guideListService;

	@GetMapping("/guidelist/list")
	public String viewAllGuideListPage(Model model) {

		
		return "guidelist/guide_list";
	}
	
	@GetMapping("/guidelist/list/delete")
	public String deleteGuideListPage(Model model) {
		
		
		return "guidelist/guide_list";
	}
}
