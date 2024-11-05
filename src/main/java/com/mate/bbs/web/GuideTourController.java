package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mate.bbs.service.GuideTourReviewService;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourReviewListVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;
import com.mate.bbs.vo.SearchGuideTourVO;
import com.mate.user.vo.UserVO;

import jakarta.validation.Valid;

@Controller
public class GuideTourController {

	@Autowired
	private GuideTourService guideTourService;
	
	@Autowired
	private GuideTourReviewService guideTourReviewService;
	
	/**
	 * 가이드 투어 목록 조회하는 페이지
	 */
	@GetMapping("/guidetour/list")
	public String viewAllGuideTourPage(Model model, SearchGuideTourVO searchGuideTourVO) {
		GuideTourListVO guideTourListVO = this.guideTourService.getAllGuideTour(searchGuideTourVO);
		model.addAttribute("guideTourListVO", guideTourListVO);
		model.addAttribute("searchGuideTourVO", searchGuideTourVO);
		
		System.out.println("타입" + searchGuideTourVO.getSearchType());
		System.out.println("키워드" + searchGuideTourVO.getSearchKeyword());
		
		return "guidetour/guide_total_tourlist";
	}

	@GetMapping("/guidetour/info")
	public String viewOneGuideTourPage(@RequestParam String gdTrPstId , Model model) {
		GuideTourVO guideTourVO = this.guideTourService.getOneGuideTour(gdTrPstId);
		GuideTourReviewListVO reviewList = this.guideTourReviewService.getAllGuideTourReview(gdTrPstId);
		
		model.addAttribute("guideTourVO",guideTourVO);
		model.addAttribute("reviewList", reviewList);
		
		return "guidetour/GuideTourInfo";
	}
	/** 가이드가 가이드의 투어를 등록하는 페이지 */
	@GetMapping("/guidetour/insert")
	public String viewGuideTourInsertPage() {
		return "guidetour/Guide_TourInsert";
	}
	/** 가이드의 투어 등록 게시글을 받아와 DB에 저장하는 메소드. */
	@PostMapping("/guidetour/insert")
	public String doCreateNewGuideTour(@Valid GuideTourWriteVO guideTourWriteVO
									   , BindingResult bindingResult
									   , Model model
									   , @SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		if(loginUserVO == null) {
			return "redirect:/user/login";
		}
		if(bindingResult.hasErrors()) {
			model.addAttribute("guideTourWriteVO", guideTourWriteVO);
			return "guidetour/Guide_TourInsert";
		}
		guideTourWriteVO.setAthrId(loginUserVO.getUsrLgnId());
		
		this.guideTourService.createNewGuideTour(guideTourWriteVO);
		
		return "redirect:/guidetour/list";
	}
	@GetMapping("/guidetour/Modify/{gdTrPstId}")
	public String viewGuideTourModifyPage(@PathVariable String gdTrPstId
										, Model model
										, @SessionAttribute("_LOGIN_USER_") UserVO loginUserVO) {
		GuideTourVO guideTourVO = this.guideTourService.getOneGuideTour(gdTrPstId);
		if(!guideTourVO.getAthrId().equals(loginUserVO.getUsrLgnId())) {
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}
		model.addAttribute("guideTourVO", guideTourVO);
		
		return "guidetour/Tourist_Modify";
	}
}
