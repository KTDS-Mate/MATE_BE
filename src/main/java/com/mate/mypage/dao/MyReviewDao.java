package com.mate.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.mypage.vo.GuideReviewVO;
import com.mate.mypage.vo.GuideTourReviewVO;
import com.mate.mypage.vo.SearchGuideReviewVO;
import com.mate.mypage.vo.SearchGuideTourReviewVO;
import com.mate.mypage.vo.SearchMyBoardVO;

public interface MyReviewDao {

    public String NAMESPACE = "com.mate.mypage.dao.MyReviewDao";
    
    
//  -------------------------------------------------------------------------가이드파트
    
    
    public int countGuideReview(@Param("loginId") String usrLgnId , @Param("search") SearchGuideReviewVO searchGuideReviewVO);
    
    public List<GuideReviewVO> selectAllGuideReview(@Param("loginId") String usrLgnId);
    public List<GuideReviewVO> selectAllGuideReview(@Param("loginId") String usrLgnId , @Param("search") SearchGuideReviewVO searchGuideReviewVO);
    
    public int deleteGuideReview(String gdRvwId);
    
    
//  -------------------------------------------------------------------------투어리스트파트
    
    
    public int countGuideTourReview(@Param("loginId") String usrLgnId , @Param("search") SearchGuideTourReviewVO searchGuideTourReviewVO);
  
    public List<GuideTourReviewVO> selectAllGuideTourReview(@Param("loginId") String usrLgnId);
    public List<GuideTourReviewVO> selectAllGuideTourReview(@Param("loginId") String usrLgnId , @Param("search") SearchGuideTourReviewVO searchGuideTourReviewVO);
    
    public int deleteGuideTourReview(String gdTrRvwId);
}
