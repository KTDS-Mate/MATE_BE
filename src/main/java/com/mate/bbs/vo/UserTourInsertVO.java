package com.mate.bbs.vo;

public class UserTourInsertVO {

	/**게시글 작성할 때 필요한 컬럼들**/
	
	/**
	 * 여행자가 등록한 투어 게시글의 제목
	 */
	private String usrTrTtl;
	/**
	 * 해당 투어를 작성한 여행자 FK
	 */
	private String athrId;
	/**
	 * 여행자가 입력한 투어 일시
	 */
	private String usrTrDt;
	/**
	 * 여행자가 입력한 투어의 목적
	 */
	private String usrTrPrps;
	/**
	 * 여행자가 등록한 가이드와 만날 지점에 대한 정보
	 */
	private String usrTrMp;
	/**
	 * 가이드에게 간단하게 요청할 사안
	 */
	private String usrTrGdRq;
	/**
	 * 여행자가 가이드에게 제시하는 고용 금액
	 */
	private double usrTrGdHrPrc;
	/**
	 * 여행자의 총 투어 인원
	 */
	private int usrTrNp;
	/**
	 * 여행자의 투어 소요 시간(분 단위)
	 */
	private int usrTrTm;
	/**
	 * 여행자가 등록한 투어 지역의 도시명. FK
	 */
	private String trCtId;
	/**
	 * 여행자의 가이드 구인 게시글의 세부 요구사항 내용
	 */
	private String usrTrRqDtl;
	
	public String getUsrTrTtl() {
		return usrTrTtl;
	}
	public void setUsrTrTtl(String usrTrTtl) {
		this.usrTrTtl = usrTrTtl;
	}
	public String getAthrId() {
		return athrId;
	}
	public void setAthrId(String athrId) {
		this.athrId = athrId;
	}
	public String getUsrTrDt() {
		return usrTrDt;
	}
	public void setUsrTrDt(String usrTrDt) {
		this.usrTrDt = usrTrDt;
	}
	public String getUsrTrPrps() {
		return usrTrPrps;
	}
	public void setUsrTrPrps(String usrTrPrps) {
		this.usrTrPrps = usrTrPrps;
	}
	public String getUsrTrMp() {
		return usrTrMp;
	}
	public void setUsrTrMp(String usrTrMp) {
		this.usrTrMp = usrTrMp;
	}
	public String getUsrTrGdRq() {
		return usrTrGdRq;
	}
	public void setUsrTrGdRq(String usrTrGdRq) {
		this.usrTrGdRq = usrTrGdRq;
	}
	public double getUsrTrGdHrPrc() {
		return usrTrGdHrPrc;
	}
	public void setUsrTrGdHrPrc(double usrTrGdHrPrc) {
		this.usrTrGdHrPrc = usrTrGdHrPrc;
	}
	public int getUsrTrNp() {
		return usrTrNp;
	}
	public void setUsrTrNp(int usrTrNp) {
		this.usrTrNp = usrTrNp;
	}
	public int getUsrTrTm() {
		return usrTrTm;
	}
	public void setUsrTrTm(int usrTrTm) {
		this.usrTrTm = usrTrTm;
	}
	public String getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(String trCtId) {
		this.trCtId = trCtId;
	}
	public String getUsrTrRqDtl() {
		return usrTrRqDtl;
	}
	public void setUsrTrRqDtl(String usrTrRqDtl) {
		this.usrTrRqDtl = usrTrRqDtl;
	}
	
}
