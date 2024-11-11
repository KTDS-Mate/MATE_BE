package com.mate.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.mate.bbs.service.GuideTourReviewService;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourReviewListVO;
import com.mate.bbs.vo.GuideTourReviewWriteVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;
import com.mate.bbs.vo.SearchGuideTourVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.user.vo.UserVO;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

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
		
		//System.out.println("타입" + searchGuideTourVO.getSearchType());
		//System.out.println("키워드" + searchGuideTourVO.getSearchKeyword());
		
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
		if(loginUserVO == null) {
			return "redirect:/user/login";
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

	@GetMapping("/guidetour/random")
	@ResponseBody
	public List<GuideTourVO> getRandomGuideTours() {
		// 서비스에서 랜덤 가이드 투어 리스트 가져오기
		List<GuideTourVO> guideTours = guideTourService.getRandomGuideTours();

		// 빈 배열을 반환할 수 있도록 처리 (없으면 빈 배열로 대체)
		if (guideTours == null || guideTours.isEmpty()) {
			return new ArrayList<>();
		}

		return guideTours;
	}

	@PostMapping("/guidetour/info")
	public String doCreateNewGuideTourReview(@RequestParam String gdTrPstId
										   , GuideTourReviewWriteVO guideTourReviewWriteVO
										   , @SessionAttribute("_LOGIN_USER_") UserVO loginUserVO) {
		guideTourReviewWriteVO.setGdTrPstId(gdTrPstId);
		guideTourReviewWriteVO.setAthrId(loginUserVO.getUsrLgnId());

		this.guideTourReviewService.createNewGuideTourReview(guideTourReviewWriteVO);

		return "redirect:/guidetour/info?gdTrPstId=" + gdTrPstId;
	}


}
