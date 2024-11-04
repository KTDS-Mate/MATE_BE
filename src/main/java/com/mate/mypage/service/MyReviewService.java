package com.mate.mypage.service;

import com.mate.mypage.vo.GuideReviewListVO;
import com.mate.mypage.vo.GuideTourReviewListVO;
import com.mate.mypage.vo.SearchGuideReviewVO;
import com.mate.mypage.vo.SearchGuideTourReviewVO;
import com.mate.mypage.vo.SearchMyBoardVO;

public interface MyReviewService {


    public GuideReviewListVO selectAllGuideReview(String usrLgnId , SearchGuideReviewVO searchGuideReviewVO);
    
    public int deleteGuideReview(String gdRvwId);
    
    public GuideTourReviewListVO selectAllGuideTourReview(String usrLgnId , SearchGuideTourReviewVO searchGuideTourReviewVO);
    
    public int deleteGuideTourReview(String gdTrRvwId);
}
