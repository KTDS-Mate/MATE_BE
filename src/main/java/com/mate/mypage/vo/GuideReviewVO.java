package com.mate.mypage.vo;

public class MyReviewVO {

	/**
	 * 가이드 투어 리뷰 PK id
	 */
	private String gdTrRvwId;
	/**
	 * 리뷰작성자 PK id
	 */
	private String athrId;
	/**
	 * 가이드가 등록한 투어의 게시글 id
	 */
	private String gdTrPstId;
	/**
	 * 리뷰 제목
	 */
	private String gdTrRvwTtl;
	/**
	 * 리뷰 내용
	 */
	private String gdTrRvwCntnt;
	/**
	 * 리뷰 작성 일자
	 */
	private String gdTrRvwCrtdat;
	/**
	 * 리뷰 삭제 일자
	 */
	private String gdTrRvwDltAt;
	/**
	 * 리뷰 삭제 여부
	 */
	private String gdTrRvwIsDlt;
	/**
	 * 투어에 대한 평점
	 */
	private int gdTrRvwRtng;
	
	public String getGdTrRvwId() {
		return gdTrRvwId;
	}
	public void setGdTrRvwId(String gdTrRvwId) {
		this.gdTrRvwId = gdTrRvwId;
	}
	public String getAthrId() {
		return athrId;
	}
	public void setAthrId(String athrId) {
		this.athrId = athrId;
	}
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
	public String getGdTrRvwTtl() {
		return gdTrRvwTtl;
	}
	public void setGdTrRvwTtl(String gdTrRvwTtl) {
		this.gdTrRvwTtl = gdTrRvwTtl;
	}
	public String getGdTrRvwCntnt() {
		return gdTrRvwCntnt;
	}
	public void setGdTrRvwCntnt(String gdTrRvwCntnt) {
		this.gdTrRvwCntnt = gdTrRvwCntnt;
	}
	public String getGdTrRvwCrtdat() {
		return gdTrRvwCrtdat;
	}
	public void setGdTrRvwCrtdat(String gdTrRvwCrtdat) {
		this.gdTrRvwCrtdat = gdTrRvwCrtdat;
	}
	public String getGdTrRvwDltAt() {
		return gdTrRvwDltAt;
	}
	public void setGdTrRvwDltAt(String gdTrRvwDltAt) {
		this.gdTrRvwDltAt = gdTrRvwDltAt;
	}
	public String getGdTrRvwIsDlt() {
		return gdTrRvwIsDlt;
	}
	public void setGdTrRvwIsDlt(String gdTrRvwIsDlt) {
		this.gdTrRvwIsDlt = gdTrRvwIsDlt;
	}
	public int getGdTrRvwRtng() {
		return gdTrRvwRtng;
	}
	public void setGdTrRvwRtng(int gdTrRvwRtng) {
		this.gdTrRvwRtng = gdTrRvwRtng;
	}
}