package com.mate.bbs.vo;

import java.util.List;

public class GuideTourReviewListVO {

	private int reviewCnt;
	
	private List<GuideTourReviewVO> guideTourReviewList;

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public List<GuideTourReviewVO> getGuideTourReviewList() {
		return guideTourReviewList;
	}

	public void setGuideTourReviewList(List<GuideTourReviewVO> guideTourReviewList) {
		this.guideTourReviewList = guideTourReviewList;
	}
	
}
