package com.mate.bbs.vo;

public class TourApplyListVO {
	
	/**
	 * 조회된 지원 게시글 수
	 */
	int tourApplyCnt;
	
	/**
	 * 조회된 지원 게시글 목록
	 */
	private TourApplyVO tourapplyVO;

	public int getTourApplyCnt() {
		return tourApplyCnt;
	}

	public void setTourApplyCnt(int tourApplyCnt) {
		this.tourApplyCnt = tourApplyCnt;
	}

	public TourApplyVO getTourapplyVO() {
		return tourapplyVO;
	}

	public void setTourapplyVO(TourApplyVO tourapplyVO) {
		this.tourapplyVO = tourapplyVO;
	}
	
	
	
}
