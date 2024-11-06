package com.mate.mypage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.mypage.dao.CalendarDao;
import com.mate.mypage.service.CalendarService;
import com.mate.mypage.vo.CalendarVO;

@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	private CalendarDao calendarDao;
	
	@Override
	public List<CalendarVO> calenList(String usrLgnId) {
		
		List<CalendarVO> list = this.calendarDao.calenList(usrLgnId);
		return list;
	}

}
