package com.mate.cms.customerService.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * 사용자가 고객센터에 문의할 때 사용 할 VO
 */
public class CustomerServiceWriteVO {

	/** 문의를 남긴 회원의 ID (FK) **/
	private String usrLgnId;
	/** 문의 내용 **/
	@NotEmpty(message = "문의 내용을 작성해주세요!")
	@Size(min = 5, message = "5글자 이상 작성해주세요!")
	private String srvcCntrDtl;
	/** 문의 유형 GD_RQ="가이드 구인", RQST="해주세요", GD_RCRT="가이드 투어", PI="결제" **/
	private String cstmrSrvcCtgry;
	/** 문의 제목 **/
	private String srvcCntrTtl;

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

	public String getCstmrSrvcCtgry() {
		return cstmrSrvcCtgry;
	}

	public void setCstmrSrvcCtgry(String cstmrSrvcCtgry) {
		this.cstmrSrvcCtgry = cstmrSrvcCtgry;
	}

	public String getSrvcCntrTtl() {
		return srvcCntrTtl;
	}

	public void setSrvcCntrTtl(String srvcCntrTtl) {
		this.srvcCntrTtl = srvcCntrTtl;
	}

}
