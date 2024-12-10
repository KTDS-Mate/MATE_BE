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

}
