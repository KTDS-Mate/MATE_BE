package com.mate.mypage.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.vo.ApiResponse;
import com.mate.mypage.service.MyReviewService;
import com.mate.mypage.vo.GuideReviewListVO;
import com.mate.mypage.vo.GuideReviewVO;
import com.mate.mypage.vo.GuideTourReviewListVO;
import com.mate.mypage.vo.GuideTourReviewVO;
import com.mate.mypage.vo.SearchGuideReviewVO;
import com.mate.mypage.vo.SearchGuideTourReviewVO;
import com.mate.mypage.vo.TrWishlistVO;

@RestController
@RequestMapping("/api/v1/mypage/review")
public class MyReviewApiController {

    @Autowired
    private MyReviewService myReviewService;
    
    
    

//  -------------------------------------------------------------------------가이드리뷰파트

    @GetMapping("/tr-guide/{usrLgnId}")
    public ApiResponse viewTrGuideReview(@PathVariable String usrLgnId,SearchGuideReviewVO searchGuideReviewVO) {

    	
    	System.out.println("유저아이디는 " + usrLgnId);
    	GuideReviewListVO guideReviewListVO = this.myReviewService.selectAllGuideReview(usrLgnId , searchGuideReviewVO);
    	System.out.println("가이드리뷰 갯수는 " + guideReviewListVO.getReviewCount());
    	
    	int count = guideReviewListVO.getReviewCount();
    	List<GuideReviewVO> reviewListVO = guideReviewListVO.getReviewList();
    	


        return new ApiResponse(guideReviewListVO);
    }
    
    


    @GetMapping("/tr-guide/{usrLgnId}/delete-{gdRvwId}")
    public String deleteReview(@PathVariable String usrLgnId , @PathVariable String gdRvwId 
    						   			   ,Model model) {
    	
    	int success = this.myReviewService.deleteGuideReview(gdRvwId);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/review/tr-guide/"+usrLgnId;
    } 
    
    
    
    
    
    
    
//  -------------------------------------------------------------------------가이드투어파트
    
    
    @GetMapping("/tr-guidetour/{usrLgnId}")
    public ApiResponse viewGuideTourReview(@PathVariable String usrLgnId,SearchGuideTourReviewVO searchGuideTourReviewVO) {
    	
    	
    	
    	System.out.println("유저아이디는 " + usrLgnId);
    	GuideTourReviewListVO guideTourReviewListVO = this.myReviewService.selectAllGuideTourReview(usrLgnId , searchGuideTourReviewVO);
    	System.out.println("투어리뷰 갯수는 " + guideTourReviewListVO.getReviewCount());
    	
    	int myBoardListVO = guideTourReviewListVO.getReviewCount();
    	List<GuideTourReviewVO> reviewListVO = guideTourReviewListVO.getReviewList();
    	
    	
    	
    	return new ApiResponse(guideTourReviewListVO);
    }
    

    
    
    @GetMapping("/tr-guidetour/{usrLgnId}/delete-{gdTrRvwId}")
    public String deleteGuideTourReview(@PathVariable String usrLgnId , @PathVariable String gdTrRvwId 
    						   			   ,Model model) {
    	
    	int success = this.myReviewService.deleteGuideTourReview(gdTrRvwId);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/review/tr-guidetour/"+usrLgnId;
    }
    
    


}
