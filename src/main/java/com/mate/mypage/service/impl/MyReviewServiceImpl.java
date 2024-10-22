package com.mate.mypage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.mypage.dao.MyReviewDao;
import com.mate.mypage.service.MyReviewService;
import com.mate.mypage.vo.MyReviewListVO;
import com.mate.mypage.vo.MyReviewVO;

@Service
public class MyReviewServiceImpl implements MyReviewService{

	@Autowired
	private MyReviewDao myReviewDao;
	
	@Override
	public MyReviewListVO getAllMyReview() {
		int myReviewCount = this.myReviewDao.selectMyReviewAllCount();
		
		List<MyReviewVO> myReviewList = this.myReviewDao.selectAllMyReview();
		
		MyReviewListVO myReviewListVO = new MyReviewListVO();
		myReviewListVO.setRvwCnt(myReviewCount);
		myReviewListVO.setMyReviewList(myReviewList);
		
		return myReviewListVO;
	}
	
}
