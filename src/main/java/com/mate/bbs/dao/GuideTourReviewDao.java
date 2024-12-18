package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.GuideTourReviewVO;
import com.mate.bbs.vo.GuideTourReviewWriteVO;

public interface GuideTourReviewDao {
	
	public String NAMESPACE = "com.mate.bbs.dao.GuideTourReviewDao";
	
	/**
     * 가이드 투어 게시글에 모든 리뷰를 조회
     * @return
     */
    public List<GuideTourReviewVO> selectGuideTourAllReview(String gdTrPstId);
	
    public int selectGuideTourReviewCount(String gdTrPstId);
    
    /**
     * 하나의 리뷰를 조회
     * @param gdTrRvwId
     * @return
     */
    public GuideTourReviewVO selectOneGuideTourReview(String gdTrRvwId);
    
    /**
     * 가이드 투어에 새로운 리뷰를 생성 
     * @return
     */
    public int insertNewGuideTourReview(GuideTourReviewWriteVO guideTourReviewWriteVO);
    
    /**
     * 가이드 투어에 등록한 리뷰를 수정
     * @param guideTourReviewVO
     * @return
     */
    public int updateGuideTourReview(GuideTourReviewVO guideTourReviewVO);
    
    /**
     * 가이드 투어에 등록한 리뷰를 삭제
     * @param gdTrRvwId
     * @return
     */
    public int deleteGuideTourReview(String gdTrRvwId);
    /** 최근 리뷰 가져오기 **/
    public GuideTourReviewVO selectLateGuideTourReview();
}
