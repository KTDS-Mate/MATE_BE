package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mate.mypage.service.MyApplyTourService;
import com.mate.mypage.vo.MyApplyGuideTourListVO;
import com.mate.mypage.vo.MyApplyUserTourListVO;
import com.mate.mypage.vo.SearchMyApplyTourVO;

@Controller
public class MyApplyTourController {

	@Autowired
	private MyApplyTourService myApplyTourService;
	
	//    ------------------ 내가 신청한 투어 목록을 확인
	@GetMapping("/mypage/tr-apply-tour/{usrLgnId}")
    public String viewTouristMyApplyTour(@PathVariable String usrLgnId
    								    , SearchMyApplyTourVO searchMyApplyTourVO
    									, Model model) {
		MyApplyUserTourListVO myApplyTourListVO = this.myApplyTourService.getAllMyApplyTourList(usrLgnId, searchMyApplyTourVO);
		model.addAttribute("myApplyTourListVO", myApplyTourListVO);
		model.addAttribute("searchMyApplyTourVO", searchMyApplyTourVO);
		
    	return "mypage/Mypage_Tourist_Apply";
    }
	
	@GetMapping("/mypage/tr-apply-tour/complete/{usrTrPstId}/{usrLgnId}")
	public String doUpdateUserTourStts(@PathVariable String usrTrPstId
									 , @PathVariable String usrLgnId) {
		this.myApplyTourService.updateUserTourStts(usrTrPstId);
		return "redirect:/mypage/tr-apply-tour/" + usrLgnId;
	}
	
	// -----------------------------------------------------------
	@GetMapping("/mypage/gd-apply-tour/{usrLgnId}")
    public String viewGuideMyApplyTour(@PathVariable String usrLgnId
    								  , SearchMyApplyTourVO searchMyApplyTourVO
    								  , Model model) {
		MyApplyGuideTourListVO myApplyGuideTourListVO = this.myApplyTourService.getAllMyApplyTourListForGuide(usrLgnId, searchMyApplyTourVO);
		model.addAttribute("myApplyGuideTourListVO", myApplyGuideTourListVO);
		model.addAttribute("searchMyApplyTourVO", searchMyApplyTourVO);
		
    	return "mypage/Mypage_Guide_Apply";
    }
	
	@GetMapping("/mypage/gd-apply-tour/complete/{gdTrPstId}/{usrLgnId}")
	public String doUpdateGuideTourStts(@PathVariable String gdTrPstId
			 						  , @PathVariable String usrLgnId) {
		this.myApplyTourService.updateGuideTourStts(gdTrPstId);
		return "redirect:/mypage/gd-apply-tour/" + usrLgnId;
	}
	
	
}
