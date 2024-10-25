package com.mate.mypage.vo;

import java.util.List;

public class MyReviewListVO {

	/**
	 * 조회된 리뷰 게시글의 수
	 */
	private int rvwCnt;
	/**
	 * 조회된 리뷰 게시글의 목록
	 */
	private List<MyReviewVO> myReviewList;
	
	public int getRvwCnt() {
		return rvwCnt;
	}
	public void setRvwCnt(int rvwCnt) {
		this.rvwCnt = rvwCnt;
	}
	public List<MyReviewVO> getMyReviewList() {
		return myReviewList;
	}
	public void setMyReviewList(List<MyReviewVO> myReviewList) {
		this.myReviewList = myReviewList;
	}
}