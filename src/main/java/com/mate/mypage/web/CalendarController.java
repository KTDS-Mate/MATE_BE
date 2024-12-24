package com.mate.mypage.web;

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
import com.mate.mypage.service.CalendarService;
import com.mate.mypage.vo.CalendarVO;

@Controller
@RequestMapping("/mypage/calendar")
public class CalendarController {
	
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
    @ResponseBody
    public String responseTrCalendar(@PathVariable String usrLgnId
    										  ,Model model) {

    	List<CalendarVO> list = this.calendarService.calenList(usrLgnId);

    	String jsonResponse = gson.toJson(list);
    	
        
        return jsonResponse;
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
