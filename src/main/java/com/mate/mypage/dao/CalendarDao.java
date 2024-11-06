package com.mate.mypage.dao;

import java.util.List;

import com.mate.mypage.vo.CalendarVO;

public interface CalendarDao {

	
	public String NAMESPACE = "com.mate.mypage.dao.CalendarDao";
	
	public List<CalendarVO> calenList(String usrLgnId);
}
