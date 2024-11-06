package com.mate.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.GuideTourReviewDao;
import com.mate.bbs.service.GuideTourReviewService;
import com.mate.bbs.vo.GuideTourReviewListVO;
import com.mate.bbs.vo.GuideTourReviewVO;
import com.mate.bbs.vo.GuideTourReviewWriteVO;

@Service
public class GuideTourReviewServiceImpl implements GuideTourReviewService{

	@Autowired
	private GuideTourReviewDao guideTourReviewDao;
	
	@Override
	public GuideTourReviewListVO getAllGuideTourReview(String gdTrPstId) {
		List<GuideTourReviewVO> tourReviewList = this.guideTourReviewDao.selectGuideTourAllReview(gdTrPstId);
		int reviewCnt = this.guideTourReviewDao.selectGuideTourReviewCount(gdTrPstId);
		
		GuideTourReviewListVO guideTourReviewListVO = new GuideTourReviewListVO();
		guideTourReviewListVO.setGuideTourReviewList(tourReviewList);
		guideTourReviewListVO.setReviewCnt(reviewCnt);
		
		return guideTourReviewListVO;
	}
	@Override
	public boolean createNewGuideTourReview(GuideTourReviewWriteVO guideTourReviewWriteVO) {
		int insertReviewCount = this.guideTourReviewDao.insertNewGuideTourReview(guideTourReviewWriteVO);
		return insertReviewCount > 0;
	}
	
	@Override
	public boolean modifyGuideTourOneReview(GuideTourReviewVO guideTourReviewVO) {
		GuideTourReviewVO reviewVO = this.guideTourReviewDao.selectOneGuideTourReview(guideTourReviewVO.getGdTrRvwId());
		
		
		return false;
	}
	@Override
	public boolean deleteGuideTourReview(String athrId, String gdTrRvwId) {
		return false;
	}
	
}
