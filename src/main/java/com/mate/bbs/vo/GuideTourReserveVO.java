package com.mate.bbs.vo;

public class GuideTourReserveVO {

	/**
	 * 가이드 투어 게시글 아이디
	 */
	private String gdTrPstId;
	/**
	 * 투어를 예약한 여행자 아이디
	 */
	private String usrId;
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
}
