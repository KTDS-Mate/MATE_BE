package com.mate.mypage.service;

import com.mate.mypage.vo.MyApplyTourListVO;

public interface MyApplyTourService {

	public MyApplyTourListVO getAllMyApplyTourList(String athrId);
	
	public boolean updateTourStts(String usrTrPstId);
	
}
