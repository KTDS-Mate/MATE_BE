package com.mate.cms.paymentService.vo;

public class PaymentServiceVO {

	/** 결제 정보의 PK **/
	private String payId;
	/** 여행자의 회원아이디 **/
	private String trstId;
	/** 가이드 아이디 **/
	private String gdId;
	/** 투어 종류(TOURIST, GUIDE) **/
	private String payTrTp;
	/** 결제할 투어게시글 아이디 FK **/
	private String payTrId;
	/** 결제 금액 **/
	private double payCsh;
	/** 결제 상태(WAITING, CANCEL, REFUND, COMPLETE) **/
	private String payStt;
	/** 결제 요청일 **/
	private String payCrtDt;
	/** 결제 완료일 **/
	private String payCmpltDt;
	/** 포트원 식별번호 **/
	private String impUid;
	/** 결제를 한 수단 (CARD, ACCOUNT 등) **/
	private String payMthd;
	/** 결제 통화(DOLLAR, WON 등) **/
	private String payCrrnc;
	/** 결제 수수료 **/
	private double payCmmssn;
	/** 포트원에 제공한 결제번호 **/
	private String impMid;

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getTrstId() {
		return trstId;
	}

	public void setTrstId(String trstId) {
		this.trstId = trstId;
	}

	public String getGdId() {
		return gdId;
	}

	public void setGdId(String gdId) {
		this.gdId = gdId;
	}

	public String getPayTrTp() {
		return payTrTp;
	}

	public void setPayTrTp(String payTrTp) {
		this.payTrTp = payTrTp;
	}

	public String getPayTrId() {
		return payTrId;
	}

	public void setPayTrId(String payTrId) {
		this.payTrId = payTrId;
	}

	public double getPayCsh() {
		return payCsh;
	}

	public void setPayCsh(double payCsh) {
		this.payCsh = payCsh;
	}

	public String getPayStt() {
		return payStt;
	}

	public void setPayStt(String payStt) {
		this.payStt = payStt;
	}

	public String getPayCrtDt() {
		return payCrtDt;
	}

	public void setPayCrtDt(String payCrtDt) {
		this.payCrtDt = payCrtDt;
	}

	public String getPayCmpltDt() {
		return payCmpltDt;
	}

	public void setPayCmpltDt(String payCmpltDt) {
		this.payCmpltDt = payCmpltDt;
	}

	public String getImpUid() {
		return impUid;
	}

	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}

	public String getPayMthd() {
		return payMthd;
	}

	public void setPayMthd(String payMthd) {
		this.payMthd = payMthd;
	}

	public String getPayCrrnc() {
		return payCrrnc;
	}

	public void setPayCrrnc(String payCrrnc) {
		this.payCrrnc = payCrrnc;
	}

	public double getPayCmmssn() {
		return payCmmssn;
	}

	public void setPayCmmssn(double payCmmssn) {
		this.payCmmssn = payCmmssn;
	}

	public String getImpMid() {
		return impMid;
	}

	public void setImpMid(String impMid) {
		this.impMid = impMid;
	}

}
