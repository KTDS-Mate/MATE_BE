package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mate.mypage.service.MyApplyTourService;
import com.mate.mypage.vo.MyApplyTourListVO;

@Controller
public class MyApplyTourController {

	@Autowired
	private MyApplyTourService myApplyTourService;
	
	//    ------------------ 내가 작성한 투어 목록을 확인
	@GetMapping("/mypage/tr-apply-tour/{usrLgnId}")
    public String viewTouristMyApplyTour(@PathVariable String usrLgnId
    									, Model model) {
		MyApplyTourListVO myApplyTourListVO = this.myApplyTourService.getAllMyApplyTourList(usrLgnId);
		model.addAttribute("myApplyTourListVO", myApplyTourListVO);
		
    	return "mypage/Mypage_Tourist_Apply";
    }
	
	@GetMapping("/mypage/gd-apply-tour")
    public String viewGuideMyApplyTour() {
    	return "mypage/Mypage_Guide_Apply";
    }
}
