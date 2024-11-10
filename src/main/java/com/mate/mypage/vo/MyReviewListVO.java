package com.mate.mypage.vo;

import java.util.List;

public class MyReviewListVO {

	/**
	 * 조회된 리뷰 게시글의 수
	 */
	private int reviewCnt;
	/**
	 * 조회된 리뷰 게시글의 목록
	 */
	private List<GuideReviewVO> myReviewList;
	

	public int getReviewCnt() {
		return reviewCnt;
	}
	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}
	public List<GuideReviewVO> getMyReviewList() {
		return myReviewList;
	}
	public void setMyReviewList(List<GuideReviewVO> myReviewList) {
		this.myReviewList = myReviewList;
	}
}