package com.mate.mypage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.vo.UserTourVO;
import com.mate.mypage.dao.MyApplyTourDao;
import com.mate.mypage.service.MyApplyTourService;
import com.mate.mypage.vo.MyApplyTourListVO;

@Service
public class MyApplyTourServiceImpl implements MyApplyTourService {

	@Autowired
	private MyApplyTourDao myApplyTourDao;
	
	@Override
	public MyApplyTourListVO getAllMyApplyTourList(String athrId) {
		List<UserTourVO> myApplyTourList = this.myApplyTourDao.selectAllMyTours(athrId);
		int myApplyTourCount = this.myApplyTourDao.selectMyTourCount(athrId);
		
		MyApplyTourListVO myApplyTourListVO = new MyApplyTourListVO();
		myApplyTourListVO.setMyApplyTourCount(myApplyTourCount);
		myApplyTourListVO.setMyApplyTourList(myApplyTourList);
		
		return myApplyTourListVO;
	}

	@Override
	public boolean updateTourStts(String usrTrPstId) {
		return this.myApplyTourDao.updateUserTourStts(usrTrPstId) > 0;
	}

}
