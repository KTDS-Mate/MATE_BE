package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mate.mypage.service.MyReviewService;
import com.mate.mypage.vo.MyReviewListVO;

@Controller
public class MyReviewController {

	@Autowired
	private MyReviewService myReviewService;
	
	@GetMapping("/mypage/myreview")
	public String viewMyReviewList(Model model) {
		MyReviewListVO myReviewListVO = this.myReviewService.getAllMyReview();
		
		model.addAttribute("myReviewListVO",myReviewListVO);
		
		return "mypage/Mypage_Tourist_MyReview";
	}
}
