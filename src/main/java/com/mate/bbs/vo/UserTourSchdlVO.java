package com.mate.bbs.vo;

public class UserTourSchdlVO {

	/**
	 * 투어일정 아이디 PK
	 */
	private String trSchdlId;
	/**
	 * 게시글의 아이디. Pk
	 */
	private String usrTrPstId;
	/**
	 * 투어를 원하는 장소의 이름
	 */
	private String trLctns;
	/**
	 * 투어 일정 내용
	 */
	private String trRqst;
	
	/**
	 * 일정 진행 시간
	 */
	private String trTm;
	
	public String getTrSchdlId() {
		return trSchdlId;
	}
	public void setTrSchdlId(String trSchdlId) {
		this.trSchdlId = trSchdlId;
	}
	public String getUsrTrPstId() {
		return usrTrPstId;
	}
	public void setUsrTrPstId(String usrTrPstId) {
		this.usrTrPstId = usrTrPstId;
	}
	public String getTrLctns() {
		return trLctns;
	}
	public void setTrLctns(String trLctns) {
		this.trLctns = trLctns;
	}
	public String getTrRqst() {
		return trRqst;
	}
	public void setTrRqst(String trRqst) {
		this.trRqst = trRqst;
	}
	public String getTrTm() {
		return trTm;
	}
	public void setTrTm(String trTm) {
		this.trTm = trTm;
	}
	
}
