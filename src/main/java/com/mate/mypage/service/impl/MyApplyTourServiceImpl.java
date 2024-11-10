package com.mate.mypage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.mypage.dao.MyApplyTourDao;
import com.mate.mypage.service.MyApplyTourService;
import com.mate.mypage.vo.MyApplyGuideTourListVO;
import com.mate.mypage.vo.MyApplyGuideTourVO;
import com.mate.mypage.vo.MyApplyUserTourListVO;
import com.mate.mypage.vo.MyApplyUserTourVO;
import com.mate.mypage.vo.SearchMyApplyTourVO;

@Service
public class MyApplyTourServiceImpl implements MyApplyTourService {

	@Autowired
	private MyApplyTourDao myApplyTourDao;
	
	@Override
	public MyApplyUserTourListVO getAllMyApplyTourList(String usrId, SearchMyApplyTourVO searchMyApplyTourVO) {
		int myApplyTourCount = this.myApplyTourDao.selectMyTourCount(usrId, searchMyApplyTourVO);
		
		if (myApplyTourCount == 0) {
			MyApplyUserTourListVO myApplyuserTourListVO = new MyApplyUserTourListVO();
			myApplyuserTourListVO.setMyApplyUserTourCount(0);
			myApplyuserTourListVO.setMyApplyUserTourList(new ArrayList<>());
			
			return myApplyuserTourListVO;
		}
		
		
		searchMyApplyTourVO.setListSize(5);
		searchMyApplyTourVO.setPageCount(myApplyTourCount);
		
		List<MyApplyUserTourVO> myApplyTourList = this.myApplyTourDao.selectAllMyApplyTours(usrId, searchMyApplyTourVO);
		
		MyApplyUserTourListVO myApplyuserTourListVO = new MyApplyUserTourListVO();
		myApplyuserTourListVO.setMyApplyUserTourCount(myApplyTourCount);
		myApplyuserTourListVO.setMyApplyUserTourList(myApplyTourList);
		
		return myApplyuserTourListVO;
	}

	@Override
	public boolean updateUserTourStts(String gdTrPstId) {
		return this.myApplyTourDao.updateGuideTourStts(gdTrPstId) > 0;
	}

	// ---------------------------------------------------------------------------
	
	@Override
	public MyApplyGuideTourListVO getAllMyApplyTourListForGuide(String athrId, SearchMyApplyTourVO searchMyApplyTourVO) {
		int myApplyTourCount = this.myApplyTourDao.selectMyTourCountForGuide(athrId, searchMyApplyTourVO);
		
		if (myApplyTourCount == 0) {
			MyApplyGuideTourListVO myApplyGuideTourListVO = new MyApplyGuideTourListVO();
			myApplyGuideTourListVO.setMyApplyGuideTourCount(0);
			myApplyGuideTourListVO.setMyApplyGuideTourList(new ArrayList<>());
			
			return myApplyGuideTourListVO;
		}
		
		searchMyApplyTourVO.setListSize(5);
		searchMyApplyTourVO.setPageCount(myApplyTourCount);
		
		List<MyApplyGuideTourVO> myApplyTourList =  this.myApplyTourDao.selectAllMyApplyToursForGuide(athrId, searchMyApplyTourVO);
		
		MyApplyGuideTourListVO myApplyGuideTourListVO = new MyApplyGuideTourListVO();
		myApplyGuideTourListVO.setMyApplyGuideTourCount(myApplyTourCount);
		myApplyGuideTourListVO.setMyApplyGuideTourList(myApplyTourList);
		
		return myApplyGuideTourListVO;
	}

	@Override
	public boolean updateGuideTourStts(String gdTrPstId) {
		return this.myApplyTourDao.updateUserTourStts(gdTrPstId) > 0;
	}
	
	
}
