package com.mate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
	
	@GetMapping("/")
	public String viewMainPage(){
		return "all/MT_M001";
	}

	@GetMapping("/test/guide/tourlist")
	public String viewGuideTotalList() {
		return "all/guide_total_tourlist";
	}

	@GetMapping("/test/guide/tourinfo")
	public String viewGuideTourInfoPage(){
		return "all/GuideTourInfo";
	}

	@GetMapping("/test/guide/guideprofile")
	public String viewGuideProfilePage() {
		return "all/GuideProfile";
	}

//	@GetMapping("/test/sample")
//	public String viewSamplePage(){return "all/GuideProfile copy 2"; }

	@GetMapping("/test/mypage/guide/calendar")
	public String viewGuideCalendar(){
		return "all/Mypage_Guide_Calendar";
	}
	
	@GetMapping("/test/mypage/guide/editinfo")
	public String viewEditInfo() {
		return "all/Mypage_Guide_EditInfo";
	}
	// sidebar 부분 공통되게 스타일 수정해야함
	
	
	@GetMapping("/test/mypage/guide/mytourlist")
	public String viewGuidsTourList () {
		return "all/Mypage_Guide_MyTour";
	}
	
	@GetMapping("/test/mypage/guide/wishlist")
	public String viewGuideWishList() {
		return "all/Mypage_Guide_Wishlist";
	}
	
	@GetMapping("/test/mypage/tourist/calendar")
	public String viewTouristCalendar() {
		return "all/Mypage_Tourist_Calendar";
	}
	
	@GetMapping("/test/mypage/tourist/editinfo")
	public String viewTouristEditInfo() {
		return "all/Mypage_Tourist_EditInfo";
	}
	// 위와 마찬가지로 사이드바 공통되게
	
	@GetMapping("/test/mypage/tourist/reviewlist")
	public String viewTouristReviewList() {
		return "all/Mypage_Tourist_MyReview";
	}
	
	@GetMapping("/test/mypage/tourist/tourlist")
	public String viewTouristTourList() {
		return "all/Mypage_Tourist_MyTour";
	}
	
	@GetMapping("/test/mypage/tourist/whislist")
	public String viewTouristWishList() {
		return "all/Mypage_Tourist_Wishlist";
	}
	
	@GetMapping("/test/mypage/tourist/payment/Details")
	public String viewTouristPaymentDetails() {
		return "all/MyPageLayout_PaymentDetails";
	}
	
	@GetMapping("/test/mypage/guide/salesManagement")
	public String viewGuideSalesManagement() {
		return "all/MyPageLayout_SalesManagement";
	}
	
	@GetMapping("/test/guide/regist")
	public String viewGuideRegistPage () {
		return "all/reigst_Guide";
	}
	
	
	@GetMapping("/test/guide/tour/write")
	public String viewGuideTourWrite() {
		return "all/Guide_TourInsert";
	}  
	  
	@GetMapping("/test/tourist/recruitment")
	public String viewGuideRecruitment() {
		return "all/GuideRecruitmentPage";
	}
	
	@GetMapping("/test/tourist/tour/write")
	public String viewTouristTourWrite() {
		return "all/Tourist_TourInsert";
	}
	
	@GetMapping("/test/message/receive")
	public String viewReceiveMessage(){return "all/receive_message";}

	@GetMapping("/test/message/send")
	public String viewSendMessage(){return "all/send_message";}

	@GetMapping("/test/tour/list")
	public String viewTourListPage(){return "all/tour_list";}
}
