package com.mate.bbs.vo;

import java.util.List;

public class GuideTourListVO {

	/**
	 * 조회된 가이드 투어 게시글 수
	 */
	private int gdTrPstCnt;
	
	/**
	 * 조회된 가이드 투어 게시글 목록
	 */
	
	private List<GuideTourVO> guideTourList;
	
	private List<GuideTourDetailInfoVO> guideTourDetailList;
	
	public int getGdTrPstCnt() {
		return gdTrPstCnt;
	}

	public void setGdTrPstCnt(int gdTrPstCnt) {
		this.gdTrPstCnt = gdTrPstCnt;
	}

	public List<GuideTourVO> getGuideTourList() {
		return guideTourList;
	}

	public void setGuideTourList(List<GuideTourVO> guideTourList) {
		this.guideTourList = guideTourList;
	}

	public List<GuideTourDetailInfoVO> getGuideTourDetailList() {
		return guideTourDetailList;
	}

	public void setGuideTourDetailList(List<GuideTourDetailInfoVO> guideTourDetailList) {
		this.guideTourDetailList = guideTourDetailList;
	}
}
