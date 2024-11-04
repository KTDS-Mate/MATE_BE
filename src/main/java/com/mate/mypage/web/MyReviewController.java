package com.mate.mypage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mate.mypage.service.MyBoardService;
import com.mate.mypage.service.MyReviewService;
import com.mate.mypage.vo.GuideReviewListVO;
import com.mate.mypage.vo.GuideReviewVO;
import com.mate.mypage.vo.GuideTourReviewListVO;
import com.mate.mypage.vo.GuideTourReviewVO;
import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.SearchGuideReviewVO;
import com.mate.mypage.vo.SearchGuideTourReviewVO;
import com.mate.mypage.vo.SearchMyBoardVO;
import com.mate.mypage.vo.TrMyBoardListVO;
import com.mate.mypage.vo.TrMyBoardVO;

@Controller
@RequestMapping("/mypage/review")
public class MyReviewController {

    @Autowired
    private MyReviewService myReviewService;
    
    
    

//  -------------------------------------------------------------------------가이드리뷰파트

    @GetMapping("/tr-guide/{usrLgnId}")
    public String viewTrGuideReview(@PathVariable String usrLgnId,SearchGuideReviewVO searchGuideReviewVO, Model model) {

    	GuideReviewListVO guideReviewListVO = this.myReviewService.selectAllGuideReview(usrLgnId , searchGuideReviewVO);
    	
    	int count = guideReviewListVO.getReviewCount();
    	List<GuideReviewVO> reviewListVO = guideReviewListVO.getReviewList();
    	
    	System.out.println("갯수는 " + count);
    	System.out.println("리스트는 " + reviewListVO.get(0));
    	
    	
    	System.out.println("타입은 " + searchGuideReviewVO.getSearchType());
    	System.out.println("검색어는 " + searchGuideReviewVO.getSearchKeyword());
    	
        model.addAttribute("guideReviewListVO", guideReviewListVO);
        model.addAttribute("searchGuideReviewVO", searchGuideReviewVO);


        return "mypage/Mypage_Tourist_MyReview_Guide";
    }
    
    


    @GetMapping("/tr-guide/{usrLgnId}/delete-{gdRvwId}")
    public String deleteReview(@PathVariable String usrLgnId , @PathVariable String gdRvwId 
    						   			   ,Model model) {
    	
    	int success = this.myReviewService.deleteGuideReview(gdRvwId);
    	System.out.println("삭제결과는 " + success);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/review/tr-guide/"+usrLgnId;
    } 
    
    
    
    
    
    
    
//  -------------------------------------------------------------------------가이드투어파트
    
    
    @GetMapping("/tr-guidetour/{usrLgnId}")
    public String viewGuideTourReview(@PathVariable String usrLgnId,SearchGuideTourReviewVO searchGuideTourReviewVO, Model model) {
    	
    	GuideTourReviewListVO guideTourReviewListVO = this.myReviewService.selectAllGuideTourReview(usrLgnId , searchGuideTourReviewVO);
    	
    	int myBoardListVO = guideTourReviewListVO.getReviewCount();
    	List<GuideTourReviewVO> reviewListVO = guideTourReviewListVO.getReviewList();
    	
    	System.out.println("갯수는 " + myBoardListVO);
    	System.out.println("리스트는 " + reviewListVO.get(0));
    	
    	
    	System.out.println("타입은 " + searchGuideTourReviewVO.getSearchType());
    	System.out.println("검색어는 " + searchGuideTourReviewVO.getSearchKeyword());
    	
        model.addAttribute("guideTourReviewListVO", guideTourReviewListVO);
        model.addAttribute("searchGuideTourReviewVO", searchGuideTourReviewVO);
    	
    	
    	return "mypage/Mypage_Tourist_MyReview_GuideTour";
    }
    

    
    
    @GetMapping("/tr-guidetour/{usrLgnId}/delete-{gdTrRvwId}")
    public String deleteGuideTourReview(@PathVariable String usrLgnId , @PathVariable String gdTrRvwId 
    						   			   ,Model model) {
    	
    	int success = this.myReviewService.deleteGuideTourReview(gdTrRvwId);
    	System.out.println("삭제결과는 " + success);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/review/tr-guidetour/"+usrLgnId;
    }
    
    


}
