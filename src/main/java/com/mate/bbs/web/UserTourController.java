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

import com.mate.bbs.service.TourApplyService;
import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.RequestGuideApplyWriteVO;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.TourApplyVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;
import com.mate.user.vo.UserVO;

import jakarta.validation.Valid;

@Controller
public class UserTourController {

	@Autowired
	private UserTourService userTourService;
	
	@Autowired
	private TourApplyService tourApplyService;

	/** 클라이언트가 등록한 가이드 구인 게시글 목록 조회 페이지 **/
	@GetMapping("/usertour/list")
	public String viewAllUserTourPage(Model model, SearchUserTourVO searchUserTourVO) {
		UserTourListVO userTourListVO = this.userTourService.getAllUserTour(searchUserTourVO);
		model.addAttribute("userTourListVO", userTourListVO);
		model.addAttribute("searchUserTourVO", searchUserTourVO);

		return "usertour/tour_list";
	}

	/** 클라이언트가 등록한 가이드 구인 게시글 상세 조회 페이지 **/
	@GetMapping("/usertour/view")
	public String viewOneUserTourPage(@RequestParam String usrTrPstId, Model model) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);
		model.addAttribute("userTourVO", userTourVO);
		return "usertour/GuideRecruitmentPage";
	}
	
	/** 클라이언트가 등록한 가이드 구인 게시글 작성 페이지 **/
	@GetMapping("/usertour/insert")
	public String viewUserTourInsertPage() {
		return "usertour/Tourist_TourInsert";
	}

	/** 클라이언트가 작성 가이드 구인 게시글을 받아와서 DB에 저장하는 페이지 **/
	@PostMapping("/usertour/insert")
	public String doCreateNewUserTour(@Valid UserTourWriteVO userTourWriteVO, BindingResult bindingResult, Model model,
			@SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("userTourWriteVO", userTourWriteVO);
			return "usertour/Tourist_TourInsert";
		}
		userTourWriteVO.setAthrId(loginUserVO.getUsrLgnId());

		this.userTourService.createNewUserTour(userTourWriteVO);

		return "redirect:/usertour/list";
	}

	@GetMapping("/usertour/modify/{usrTrPstId}")
	public String viewUserTourModifyPage(@PathVariable String usrTrPstId, Model model,
			@SessionAttribute("_LOGIN_USER_") UserVO loginUserVO) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);
		if (!userTourVO.getAthrId().equals(loginUserVO.getUsrLgnId())) {
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}

		model.addAttribute("userTourVO", userTourVO);

		return "usertour/Tourist_Modify";
	}

	@PostMapping("/usertour/modify/{usrTrPstId}")
	public String doUserTourModify(@PathVariable String usrTrPstId, @Valid UserTourModifyVO userTourModifyVO,
			BindingResult bindingResult, @SessionAttribute("_LOGIN_USER_") UserVO loginUserVO) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);

		if (!userTourVO.getAthrId().equals(loginUserVO.getUsrLgnId())) {
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}

		String loginId = loginUserVO.getUsrLgnId();
		userTourModifyVO.setAthrId(loginId);

		this.userTourService.modifyUserTour(userTourModifyVO);

		return "redirect:/mypage/edit-profile/tr-profile/" + loginId;
	}

	@GetMapping("/usertour/reserve/{usrTrPstId}/{usrLgnId}")
	public String doReserveUserTour(@PathVariable String usrTrPstId, @PathVariable String usrLgnId) {
		this.userTourService.reserveUserTour(usrTrPstId, usrLgnId);

		return "redirect:/usertour/view?usrTrPstId=" + usrTrPstId;
	}

	@GetMapping("/usertour/insert/request")
	public String viewRequestInsertPage() {
		return "usertour/tourist_request_insert";
	}

	@PostMapping("/usertour/insert/request")
	public String doCreateRequestTour(@Valid UserTourWriteVO userTourWriteVO, BindingResult bindingResult, Model model,
			@SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("userTourWriteVO", userTourWriteVO);
			return "usertour/tourist_request_insert";
		}
		userTourWriteVO.setAthrId(loginUserVO.getUsrLgnId());

		this.userTourService.createNewRequestTour(userTourWriteVO);

		return "redirect:/usertour/list";
	}

	@GetMapping("/usertour/view/request")
	public String viewRequestPage(@RequestParam String usrTrPstId, Model model) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);
		model.addAttribute("userTourVO", userTourVO);
		return "usertour/request_view";
	}
	
	@GetMapping("/tourApply/list")
	public String viewTourApplyList(
//			@RequestParam String usrTrPstId,
			Model model) {
		return "usertour/tour_apply_list";
	}

	@GetMapping("/mypage/mytour/tr-mytour/tourApply/detail")
	public String viewTourApply(@RequestParam String gdApplyId, Model model) {
		TourApplyVO tourApplyVO = this.tourApplyService.getOneTourApply(gdApplyId);
		model.addAttribute("tourApplyVO", tourApplyVO);
		model.addAttribute("userTourVO", tourApplyVO.getUserTourVO());
		model.addAttribute("guideVO", tourApplyVO.getGuideVO());
		return "usertour/tour_apllyInfo";
	}
	
	@GetMapping("/tourApply/accept")
	public String acceptApply( @RequestParam String gdApplyId,
			@SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		try {
			this.tourApplyService.acceptTourApply(gdApplyId, loginUserVO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/mypage/mytour/tr-mytour/tourApply/detail?gdApplyId=" + gdApplyId;
		}
		return "redirect:/mypage/payment/list/" + loginUserVO.getUsrLgnId();
	}
	
	@GetMapping("/tourApply/refusal")
	public String refusalApply(@RequestParam String gdApplyId, 
			@SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		try {
			this.tourApplyService.refusalTourApply(gdApplyId, loginUserVO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/mypage/mytour/tr-mytour/tourApply/detail?gdApplyId=" + gdApplyId;
		}
		return "redirect:/mypage/mytour/tr-mytour/" + loginUserVO.getUsrLgnId();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/usertour/view/request")
	public String doCreateNewRequestGuideApply(@RequestParam String usrTrPstId,
											   @Valid RequestGuideApplyWriteVO requestGuideApplyWriteVO,
			 								   BindingResult result,
			 								   Model model,
			 								   @SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		if (result.hasErrors()) {
			model.addAttribute("requestGuideApplyWriteVO", requestGuideApplyWriteVO);
			return "usertour/request_view";
		}
		requestGuideApplyWriteVO.setGdId(loginUserVO.getUsrLgnId());
		// 기존 requestGuideAppplyVO에 usrTrPstId가 (usrTrPstId, usrTrPstId)형태로 들어있어서 다시 받아옴
		requestGuideApplyWriteVO.setUsrTrPstId(usrTrPstId);
		
		this.userTourService.createNewRequestGuideApply(requestGuideApplyWriteVO);
		
		return "redirect:/usertour/view/request?usrTrPstId="+ usrTrPstId;
	}
}
