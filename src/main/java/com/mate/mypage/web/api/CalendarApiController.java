package com.mate.mypage.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mate.common.vo.ApiResponse;
import com.mate.mypage.service.CalendarService;
import com.mate.mypage.vo.CalendarVO;

@RestController
@RequestMapping("/api/v1/mypage/calendar")
public class CalendarApiController {
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private Gson gson;
	
	@GetMapping("/tr-calendar/{usrLgnId}")
    public String viewTrCalendar(@PathVariable String usrLgnId
			  								  ,Model model) {

        
        return "mypage/Mypage_Tourist_Calendar";

    }
	

    @GetMapping("/tr-calendar/{usrLgnId}/cal")
    public ApiResponse responseTrCalendar(@PathVariable String usrLgnId) {

    	System.out.println("유저아이디 :" + usrLgnId);
    	List<CalendarVO> list = this.calendarService.calenList(usrLgnId);
//    	String jsonResponse = gson.toJson(list);
    	System.out.println("달력크기 :" + list.size());

    	
        
        return new ApiResponse(list);
    }
    
    

    @GetMapping("/gd-calendar/{usrLgnId}")
    public String viewGdCalendar(@PathVariable String usrLgnId
			  								  ,Model model) {

        
        return "mypage/Mypage_Guide_Calendar";

    }
    
    @GetMapping("/gd-calendar/{usrLgnId}/cal")
    @ResponseBody
    public String responseGdCalendar(@PathVariable String usrLgnId
    									,Model model) {
    	
    	List<CalendarVO> list = this.calendarService.calenList(usrLgnId);
    	
    	String jsonResponse = gson.toJson(list);
    	
    	return jsonResponse;
    }

}
