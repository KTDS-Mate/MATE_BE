package com.mate.cms.customerService.vo;

/**
 * 1대1 고객센터 VO
 */
public class CustomerServiceVO {

	/** 고객센터 테이블 PK **/
	private String cstmrSrvcCntrId;
	/** 문의를 남긴 회원의 ID (FK) **/
	private String usrLgnId;
	/** 문의 내용 **/
	private String srvcCntrDtl;
	/** 문의 작성 날짜 **/
	private String srvcCrtDt;
	/** 해당 문의에 답변한 관리자 (FK) **/
	private String manId;
	/** 해당 문의에 답변한 내용 **/
	private String answrDtl;
	/** 해당 문의 답변 날짜 **/
	private String answrDt;
	/** 답변 상태(default = 'N') **/
	private String cstmrSrvcCntrStts;

	public String getCstmrSrvcCntrId() {
		return cstmrSrvcCntrId;
	}

	public void setCstmrSrvcCntrId(String cstmrSrvcCntrId) {
		this.cstmrSrvcCntrId = cstmrSrvcCntrId;
	}

	public String getUsrLgnId() {
		return usrLgnId;
	}

	public void setUsrLgnId(String usrLgnId) {
		this.usrLgnId = usrLgnId;
	}

	public String getSrvcCntrDtl() {
		return srvcCntrDtl;
	}

	public void setSrvcCntrDtl(String srvcCntrDtl) {
		this.srvcCntrDtl = srvcCntrDtl;
	}

	public String getSrvcCrtDt() {
		return srvcCrtDt;
	}

	public void setSrvcCrtDt(String srvcCrtDt) {
		this.srvcCrtDt = srvcCrtDt;
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

	public String getAnswrDt() {
		return answrDt;
	}

	public void setAnswrDt(String answrDt) {
		this.answrDt = answrDt;
	}

	public String getCstmrSrvcCntrStts() {
		return cstmrSrvcCntrStts;
	}

	public void setCstmrSrvcCntrStts(String cstmrSrvcCntrStts) {
		this.cstmrSrvcCntrStts = cstmrSrvcCntrStts;
	}

}
