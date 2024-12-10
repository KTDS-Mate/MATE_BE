package com.mate.cms.customerService.vo;

public class CustomerServiceAnswerVO {

	/** 고객센터 테이블 PK **/
	private String cstmrSrvcCntrId;
	/** 해당 문의에 답변한 관리자 (FK) **/
	private String manId;
	/** 해당 문의에 답변한 내용 **/
	private String answrDtl;

	public String getCstmrSrvcCntrId() {
		return cstmrSrvcCntrId;
	}

	public void setCstmrSrvcCntrId(String cstmrSrvcCntrId) {
		this.cstmrSrvcCntrId = cstmrSrvcCntrId;
	}

	public String getManId() {
		return manId;
	}

	public void setManId(String manId) {
		this.manId = manId;
	}

	public String getAnswrDtl() {
		return answrDtl;
	}

	public void setAnswrDtl(String answrDtl) {
		this.answrDtl = answrDtl;
	}

}
