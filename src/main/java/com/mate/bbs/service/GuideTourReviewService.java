package com.mate.bbs.service;

import com.mate.bbs.vo.GuideTourReviewListVO;
import com.mate.bbs.vo.GuideTourReviewVO;
import com.mate.bbs.vo.GuideTourReviewWriteVO;

public interface GuideTourReviewService {
	
	/**
	 * 전체 리뷰 조회
	 * @param gdTrPstId
	 * @return
	 */
	public GuideTourReviewListVO getAllGuideTourReview(String gdTrPstId);
	
	/**
	 * 새로운 리뷰 등록
	 * @return
	 */
	public boolean createNewGuideTourReview(GuideTourReviewWriteVO guideTourReviewWriteVO);
	/**
	 * 사용자가 등록한 리뷰 수정
	 * @return
	 */
	public boolean modifyGuideTourOneReview(GuideTourReviewVO guideTourReviewVO);
	
	/**
	 * 사용자가 본인이 등록한 리뷰 삭제
	 * @param athrId
	 * @param gdTrRvwId
	 * @return
	 */
	public boolean deleteGuideTourReview(String athrId, String gdTrRvwId);
	
	public GuideTourReviewVO getLateGuideTourReview();
}
