package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.SearchGuideTourVO;

@Controller
public class GuideTourController {

	@Autowired
	private GuideTourService guideTourService;
	
	/**
	 * 가이드 투어 목록 조회하는 페이지
	 */
	@GetMapping("/guidetour/list")
	public String viewAllGuideTourPage(Model model, SearchGuideTourVO searchGuideTourVO) {
		GuideTourListVO guideTourListVO = this.guideTourService.getAllGuideTour(searchGuideTourVO);
		model.addAttribute("guideTourListVO", guideTourListVO);
		model.addAttribute("searchGuideTourVO", searchGuideTourVO);
		return "guidetour/guide_total_tourlist";
	}

	@GetMapping("/guidetour/info")
	public String viewOneGuideTourPage(@RequestParam String gdTrPstId , Model model) {
		GuideTourVO guideTourVO = this.guideTourService.getOneGuideTour(gdTrPstId);
		model.addAttribute("guideTourVO",guideTourVO);
		return "guidetour/GuideTourInfo";
	}
	@GetMapping("/guidetour/insert")
	public String viewGuideTourInsertPage() {
		return "guide/Guide_TourInsert";
	}
}
