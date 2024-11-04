package com.mate.mypage.service;

import com.mate.mypage.vo.MyApplyGuideTourListVO;
import com.mate.mypage.vo.MyApplyUserTourListVO;
import com.mate.mypage.vo.SearchMyApplyTourVO;

public interface MyApplyTourService {

	public MyApplyUserTourListVO getAllMyApplyTourList(String athrId, SearchMyApplyTourVO searchMyApplyTourVO);
	
	public boolean updateGuideTourStts(String gdTrPstId);
	
	// --------------------------------------
	
	public MyApplyGuideTourListVO getAllMyApplyTourListForGuide(String athrId, SearchMyApplyTourVO searchMyApplyTourVO);
	
	public boolean updateUserTourStts(String usrTrPstId);
	
}
