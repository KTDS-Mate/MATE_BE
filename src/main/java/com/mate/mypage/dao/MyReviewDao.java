package com.mate.mypage.dao;

import java.util.List;

import com.mate.mypage.vo.MyReviewVO;

public interface MyReviewDao {

    public String NAMESPACE = "com.mate.mypage.dao.MyReviewDao";
    
    public int selectMyReviewAllCount();
    
    public List<MyReviewVO> selectAllMyReview();
}
