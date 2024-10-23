package com.mate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("mate")
	public String viewMainPage(){return "all/MT_M001";}

	@GetMapping("header")
	public String viewHeader(){return "header";}

	@GetMapping("footer")
	public String viewFooter(){return "footer";}

	@GetMapping("/guide/tourlist")
	public String viewGuideTotalList() {
		return "all/guide_total_tourlist";
	}

	@GetMapping("/guide/tourinfo")
	public String viewGuideTourInfoPage(){return "all/GuideTourInfo";}

	@GetMapping("/guide/guideprofile")
	public String viewGuideProfilePage(){return "all/GuideProfile"; }

//	@GetMapping("/sample")
//	public String viewSamplePage(){return "all/GuideProfile copy 2"; }

	@GetMapping("/mypage/guide/calendar")
	public String viewGuideCalendar(){
		return "all/Mypage_Guide_Calendar";
	}
	
	@GetMapping("/mypage/guide/editinfo")
	public String viewEditInfo() {
		return "all/Mypage_Guide_EditInfo";
	}
	// sidebar 부분 공통되게 스타일 수정해야함
	
	
	@GetMapping("/mypage/guide/mytourlist")
	public String viewGuidsTourList () {
		return "all/Mypage_Guide_MyTour";
	}
	
	@GetMapping("/mypage/guide/wishlist")
	public String viewGuideWishList() {
		return "all/Mypage_Guide_Wishlist";
	}
	
	@GetMapping("/mypage/tourist/calendar")
	public String viewTouristCalendar() {
		return "all/Mypage_Tourist_Calendar";
	}
	
	@GetMapping("/mypage/tourist/editinfo")
	public String viewTouristEditInfo() {
		return "all/Mypage_Tourist_EditInfo";
	}
	// 위와 마찬가지로 사이드바 공통되게
	
	@GetMapping("/mypage/tourist/reviewlist")
	public String viewTouristReviewList() {
		return "all/Mypage_Tourist_MyReview";
	}
	
	@GetMapping("/mypage/tourist/tourlist")
	public String viewTouristTourList() {
		return "all/Mypage_Tourist_MyTour";
	}
	
	@GetMapping("/mypage/tourist/whislist")
	public String viewTouristWishList() {
		return "all/Mypage_Tourist_Wishlist";
	}
	
	@GetMapping("/mypage/tourist/payment/Details")
	public String viewTouristPaymentDetails() {
		return "all/MyPageLayout_PaymentDetails";
	}
	
	@GetMapping("/mypage/guide/salesManagement")
	public String viewGuideSalesManagement() {
		return "all/MyPageLayout_SalesManagement";
	}
	
	@GetMapping("/guide/regist")
	public String viewGuideRegistPage () {
		return "all/reigst_Guide";
	}
	
	
	@GetMapping("/guide/tour/write")
	public String viewGuideTourWrite() {
		return "guide/Guide_TourInsert";
	}  
	  
	@GetMapping("/guide/recruitment")
	public String viewGuideRecruitment() {
		return "all/GuideRecruitmentPage";
	}
	
	@GetMapping("/tourist/tour/write")
	public String viewTouristTourWrite() {
		return "all/Tourist_TourInsert";
	}
	
	@GetMapping("/message/receive")
	public String viewReceiveMessage(){return "all/receive_message";}

	@GetMapping("/message/send")
	public String viewSendMessage(){return "all/send_message";}

	@GetMapping("/tour/list")
	public String viewTourListPage(){return "all/tour_list";}
}
