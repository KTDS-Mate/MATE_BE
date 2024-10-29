package com.mate.payment.vo;

public class PaymentVO {

	/**
	 * 결제 정보의 PK
	 */
	private String payId;

	/**
	 * 여행자의 회원아이디
	 */
	private String trstId;
	
	/**
	 * 여행자의 이름
	 */
	private String trstName;

	/**
	 * 가이드 아이디
	 */
	private String gdId;

	/**
	 * 가이드 이름
	 */
	private String gdFnm;

	/**
	 * 투어 종류(TOURIST, GUIDE)
	 */
	private String payTrTp;

	/**
	 * 결제할 투어게시글 아이디 FK
	 */
	private String payTrId;

	/**
	 * 결제할 여행자 투어게시글의 이름
	 */
	private String usrTrTtl;

	/**
	 * 결제할 가이드 투어게시글의 이름
	 */
	private String gdTrTtl;

	/**
	 * 결제 금액
	 */
	private double payCsh;

	/**
	 * 결제 상태(WAITING, CANCEL, REFUND, COMPLETE)
	 */
	private String payStt;

	/**
	 * 결제 요청일
	 */
	private String payCrtDt;

	/**
	 * 결제 완료일
	 */
	private String payCmpltDt;

	/**
	 * 포트원 식별번호(iam_uid)
	 */
	private String iamUid;

	/**
	 * 포트원에 부여한 식별번호
	 */
	private String iamMid;
	
	/**
	 * 결제를 한 수단 (CARD, ACCOUNT 등)
	 */
	private String payMthd;

	/**
	 * 결제 통화(DOLLAR, WON 등)
	 */
	private String payCrrnc;

	/**
	 * 결제 수수료
	 */
	private double payCmmssn;
	
	
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

	public String getTrstName() {
		return trstName;
	}

	public void setTrstName(String trstName) {
		this.trstName = trstName;
	}

	public String getGdId() {
		return gdId;
	}

	public void setGdId(String gdId) {
		this.gdId = gdId;
	}

	public String getGdFnm() {
		return gdFnm;
	}

	public void setGdFnm(String gdFnm) {
		this.gdFnm = gdFnm;
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

	public String getUsrTrTtl() {
		return usrTrTtl;
	}

	public void setUsrTrTtl(String usrTrTtl) {
		this.usrTrTtl = usrTrTtl;
	}

	public String getGdTrTtl() {
		return gdTrTtl;
	}

	public void setGdTrTtl(String gdTrTtl) {
		this.gdTrTtl = gdTrTtl;
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

	public String getIamUid() {
		return iamUid;
	}

	public void setIamUid(String iamUid) {
		this.iamUid = iamUid;
	}

	public String getIamMid() {
		return iamMid;
	}

	public void setIamMid(String iamMid) {
		this.iamMid = iamMid;
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

	

}
