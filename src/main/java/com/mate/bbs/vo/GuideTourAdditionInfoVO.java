package com.mate.bbs.vo;

/**
 * 가이드 투어 추가정보 VO
 */
public class GuideTourAdditionInfoVO {

	/**
	 * 가이드 등록 투어에 대한 추가정보 pk
	 */
	private String trAddInfId;
	/**
	 * 가이드가 등록한 투어 게시글 아이디
	 */
	private String gdTrPstId;
	/**
	 * 투어에 대한 추가정보
	 */
	private String trAddInf;
	
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
	public String getTrAddInf() {
		return trAddInf;
	}
	public void setTrAddInf(String trAddInf) {
		this.trAddInf = trAddInf;
	}
}
