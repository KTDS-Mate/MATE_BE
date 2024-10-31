package com.mate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String viewMainPage(){
		return "all/MT_M001";
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
		return "all/guide_total_tourlist";
	}

	@GetMapping("/guide/tourinfo")
	public String viewGuideTourInfoPage(){
		return "guidetour/GuideTourInfo";
		}

	@GetMapping("/guide/guideprofile")
	public String viewGuideProfilePage(){
		return "all/GuideProfile"; 
		}
	
	
	@GetMapping("/guide/regist")
	public String viewGuideRegistPage () {
		return "all/reigst_Guide";
	}
	
	
	@GetMapping("/guide/tour/write")
	public String viewGuideTourWrite() {
		return "guidetour/Guide_TourInsert";
	}
	@GetMapping("/guide/recruitment")
	public String viewGuideRecruitment() {
		return "all/GuideRecruitmentPage";
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
	public String viewTourListPage(){return "all/tour_list";}
}
