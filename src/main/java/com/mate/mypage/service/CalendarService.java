package com.mate.mypage.service;

import java.util.List;

import com.mate.mypage.vo.CalendarVO;

public interface CalendarService {
	
	public List<CalendarVO> calenList(String usrLgnId);

}
