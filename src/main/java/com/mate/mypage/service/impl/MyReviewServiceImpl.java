package com.mate.mypage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.mypage.dao.MyReviewDao;
import com.mate.mypage.service.MyReviewService;
import com.mate.mypage.vo.GuideReviewListVO;
import com.mate.mypage.vo.GuideReviewVO;
import com.mate.mypage.vo.GuideTourReviewListVO;
import com.mate.mypage.vo.GuideTourReviewVO;
import com.mate.mypage.vo.SearchGuideReviewVO;
import com.mate.mypage.vo.SearchGuideTourReviewVO;
import com.mate.mypage.vo.SearchMyBoardVO;

@Service
public class MyReviewServiceImpl implements MyReviewService{

	@Autowired
	private MyReviewDao myReviewDao;
	

	@Override
	public GuideReviewListVO selectAllGuideReview(String usrLgnId, SearchGuideReviewVO searchGuideReviewVO) {
		
		int count = this.myReviewDao.countGuideReview(usrLgnId, searchGuideReviewVO);
		
		if(count == 0) {
			GuideReviewListVO guideReviewListVO = new GuideReviewListVO();
			guideReviewListVO.setReviewCount(0);
			guideReviewListVO.setReviewList(new ArrayList<>());
			
			return guideReviewListVO;
		}
		
		List<GuideReviewVO> guideReviewVO = null;
    	if(searchGuideReviewVO == null) { 
    				// 페이지 처리를 하지 않을경우 
    		guideReviewVO = this.myReviewDao.selectAllGuideReview(usrLgnId);
    		}
    		else {
    		// 페이지네이션을 위한 게시글 조회
    			guideReviewVO = this.myReviewDao.selectAllGuideReview(usrLgnId ,searchGuideReviewVO);
    			//총 페이지 개수를 구한다
    			searchGuideReviewVO.setPageCount(count);
    			}
    	
    	GuideReviewListVO guideReviewListVO = new GuideReviewListVO();

    	guideReviewListVO.setReviewCount(count);
    	guideReviewListVO.setReviewList(guideReviewVO);
		
		
		return guideReviewListVO;
	}

	@Override
	public int deleteGuideReview(String gdRvwId) {
		int success = this.myReviewDao.deleteGuideReview(gdRvwId);
		
		return success;
	}
	
	
//  -------------------------------------------------------------------------가이드투어파트
	
	
	
	
	@Override
	public GuideTourReviewListVO selectAllGuideTourReview(String usrLgnId, SearchGuideTourReviewVO searchGuideTourReviewVO) {
		
		int count = this.myReviewDao.countGuideTourReview(usrLgnId, searchGuideTourReviewVO);
		
		if(count == 0) {
			GuideTourReviewListVO guideTourReviewListVO = new GuideTourReviewListVO();
			guideTourReviewListVO.setReviewCount(count);
			guideTourReviewListVO.setReviewList(new ArrayList<>());
			
			return guideTourReviewListVO;
		}
		
		List<GuideTourReviewVO> guideTourReviewVO = null;
		if(searchGuideTourReviewVO == null) { 
			// 페이지 처리를 하지 않을경우 
			guideTourReviewVO = this.myReviewDao.selectAllGuideTourReview(usrLgnId);
		}
		else {
			// 페이지네이션을 위한 게시글 조회
			guideTourReviewVO = this.myReviewDao.selectAllGuideTourReview(usrLgnId ,searchGuideTourReviewVO);
			//총 페이지 개수를 구한다
			searchGuideTourReviewVO.setPageCount(count);
		}
		
		GuideTourReviewListVO guideTourReviewListVO = new GuideTourReviewListVO();
		
		guideTourReviewListVO.setReviewCount(count);
		guideTourReviewListVO.setReviewList(guideTourReviewVO);
		
		
		return guideTourReviewListVO;
	}
	
	@Override
	public int deleteGuideTourReview(String gdTrRvwId) {
		int success = this.myReviewDao.deleteGuideTourReview(gdTrRvwId);
		
		return success;
	}
	
}
