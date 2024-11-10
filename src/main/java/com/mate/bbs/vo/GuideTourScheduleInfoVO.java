package com.mate.bbs.vo;

public class GuideTourScheduleInfoVO {

	/**
	 * 가이드 등록 투어에 대한 추가정보 pk
	 */
	private String trAddInfId;
	/**
	 * 가이드가 등록한 투어 게시글 아이디
	 */
	private String gdTrPstId;
	/**
	 * 투어세부 일정에 대한 세부 장소
	 */
	private String trDtlLct;
	/**
	 * 투어 세부 일정
	 */
	private String trDtlSchd;
	
	public String getTrAddInfId() {
		return trAddInfId;
	}
	public void setTrAddInfId(String trAddInfId) {
		this.trAddInfId = trAddInfId;
	}
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
	public String getTrDtlLct() {
		return trDtlLct;
	}
	public void setTrDtlLct(String trDtlLct) {
		this.trDtlLct = trDtlLct;
	}
	public String getTrDtlSchd() {
		return trDtlSchd;
	}
	public void setTrDtlSchd(String trDtlSchd) {
		this.trDtlSchd = trDtlSchd;
	}
	
	
}
