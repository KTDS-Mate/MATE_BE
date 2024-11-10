package com.mate.bbs.vo;

public class GuideTourReviewWriteVO {

	/**
	 * 리뷰작성자의 PK
	 */
	private String athrId;
	/**
	 * 가이드가 등록한 투어 게시글 아이디
	 */
	private String gdTrPstId;
	/**
	 * 리뷰의 제목
	 */
	private String gdTrRvwTtl;
	/**
	 * 리뷰의 내용
	 */
	private String gdTrRvwCntnt;
	/**
	 * 투어에 대한 평점
	 */
	private int gdTrRvwRtng;
	/**
	 * 상위 리뷰 아이디(대댓글)
	 */
	private String prGdTrRvwId;
	
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
	public int getGdTrRvwRtng() {
		return gdTrRvwRtng;
	}
	public void setGdTrRvwRtng(int gdTrRvwRtng) {
		this.gdTrRvwRtng = gdTrRvwRtng;
	}
	public String getPrGdTrRvwId() {
		return prGdTrRvwId;
	}
	public void setPrGdTrRvwId(String prGdTrRvwId) {
		this.prGdTrRvwId = prGdTrRvwId;
	}
}
