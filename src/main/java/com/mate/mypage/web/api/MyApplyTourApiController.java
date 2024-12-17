package com.mate.mypage.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.vo.ApiResponse;
import com.mate.mypage.service.MyApplyTourService;
import com.mate.mypage.vo.MyApplyGuideTourListVO;
import com.mate.mypage.vo.MyApplyUserTourListVO;
import com.mate.mypage.vo.SearchMyApplyTourVO;

@RestController
@RequestMapping("/api/v1/mypage")
public class MyApplyTourApiController {
	
	@Autowired
	private MyApplyTourService myApplyTourService;
	
	//  -------------------- 일반 회원 마이페이지
	//    ------------------ tourist 내가 신청한 투어 목록을 확인
	@GetMapping("/tr-apply-tour/{usrLgnId}")
    public ApiResponse viewTouristMyApplyTour(@PathVariable String usrLgnId, SearchMyApplyTourVO searchMyApplyTourVO) {
		MyApplyUserTourListVO myApplyTourListVO = this.myApplyTourService.getAllMyApplyTourList(usrLgnId, searchMyApplyTourVO);
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(myApplyTourListVO);
		
    	return apiResponse;
    }
	
	@GetMapping("/tr-apply-tour/complete/{gdTrPstId}")
	public ApiResponse doUpdateGuideTourStts(@PathVariable String gdTrPstId) {
		// 내가 신청한 가이드 투어의 상태 업데이트 => COMPLETE
		boolean isUpdate = this.myApplyTourService.updateGuideTourStts(gdTrPstId);
		return new ApiResponse(isUpdate);
	}
	
	
	
	
	
	
	// --------------------- 가이드 마이페이지
	@GetMapping("/gd-apply-tour/{usrLgnId}")
    public ApiResponse viewGuideMyApplyTour(@PathVariable String usrLgnId, SearchMyApplyTourVO searchMyApplyTourVO) {
		MyApplyGuideTourListVO myApplyGuideTourListVO = this.myApplyTourService.getAllMyApplyTourListForGuide(usrLgnId, searchMyApplyTourVO);
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(myApplyGuideTourListVO);
		
    	return apiResponse;
    }
	
	@GetMapping("/gd-apply-tour/complete/{usrTrPstId}")
	public ApiResponse doUpdateUserTourStts(@PathVariable String usrTrPstId) {
		boolean isUpdate = this.myApplyTourService.updateUserTourStts(usrTrPstId);
		return new ApiResponse(isUpdate);
	}
	
	
}
