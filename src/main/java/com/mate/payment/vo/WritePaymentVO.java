package com.mate.payment.vo;

public class WritePaymentVO {
	/**
	 * 여행자의 PK
	 */
	String trstId;

	/**
	 * 가이드의 PK
	 */
	String gdId;
	
	/**
	 * 투어 타입 (TOURIST, GUIDE)
	 */
	String payTrTp;
	
	/**
	 * 투어 PK
	 */
	String payTrId;
	
	/**
	 * 투어 가격
	 */
	String payCsh;
	
	/**
	 * 수수료
	 */
	String payCmmssn;

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

	public String getPayCsh() {
		return payCsh;
	}

	public void setPayCsh(String payCsh) {
		this.payCsh = payCsh;
	}

	public String getPayCmmssn() {
		return payCmmssn;
	}

	public void setPayCmmssn(String payCmmssn) {
		this.payCmmssn = payCmmssn;
	}
	
	
}
