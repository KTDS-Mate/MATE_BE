package com.mate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/demo")
	public String calendar() {
		return "mypage/Calendar_demo";
	}
	@GetMapping("/test")
	public String Testcalendar() {
		return "mypage/Test_Tourist_Calendar";
	}

	@GetMapping("/favicon.ico")
    public String favicon() {
        return "forward:/static/favicon.ico";
    }

	@GetMapping("/")
	public String viewMainPage(){
		return "all/MainPage";
		}

	@GetMapping("header")
	public String viewHeader(){
		return "header";
		}

	@GetMapping("footer")
	public String viewFooter(){
		return "footer";
		}

	@GetMapping("/guide/tourlist")
	public String viewGuideTotalList() {
		return "guidetour/guide_total_tourlist";
	}

	@GetMapping("/guide/tourinfo")
	public String viewGuideTourInfoPage(){
		return "guidetour/GuideTourInfo";
		}

	@GetMapping("/user/guideprofile")
	public String viewGuideProfilePage(){
		return "user/GuideProfile";
		}
	
	@GetMapping("/guide/regist")
	public String viewGuideRegistPage () {
		return "user/reigstguide";
	}
	
	@GetMapping("/guide/tour/write")
	public String viewGuideTourWrite() {
		return "guidetour/Guide_TourInsert";
	}
	@GetMapping("/guide/recruitment")
	public String viewGuideRecruitment() {
		return "usertour/GuideRecruitmentPage";
	}
	
	@GetMapping("/tourist/tour/write")
	public String viewTouristTourWrite() {
		return "usertour/Tourist_TourInsert";
	}
	
	@GetMapping("/message/receive")
	public String viewReceiveMessage(){return "all/receive_message";}

	@GetMapping("/message/send")
	public String viewSendMessage(){return "all/send_message";}

	@GetMapping("/tour/list")
	public String viewTourListPage(){return "usertour/tour_list";}
}
