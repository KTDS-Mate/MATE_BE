package com.mate.bbs.vo;

public class TourGuideApplyWriteVO {
	
	/** 유저의 투어요청 게시글에 대한 가이드의 제안 PK **/
	private String gdApplyId;
	/** 가이드의 PK **/
	private String gdId;
	/** 게시글의 아이디. Pk **/
	private String usrTrPstId;
	/** 가이드가 제안한 총 투어 금액 **/
	private int gdApplyPrc;
	public String getGdApplyId() {
		return gdApplyId;
	}
	public void setGdApplyId(String gdApplyId) {
		this.gdApplyId = gdApplyId;
	}
	public String getGdId() {
		return gdId;
	}
	public void setGdId(String gdId) {
		this.gdId = gdId;
	}
	public String getUsrTrPstId() {
		return usrTrPstId;
	}
	public void setUsrTrPstId(String usrTrPstId) {
		this.usrTrPstId = usrTrPstId;
	}
	public int getGdApplyPrc() {
		return gdApplyPrc;
	}
	public void setGdApplyPrc(int gdApplyPrc) {
		this.gdApplyPrc = gdApplyPrc;
	}

}
