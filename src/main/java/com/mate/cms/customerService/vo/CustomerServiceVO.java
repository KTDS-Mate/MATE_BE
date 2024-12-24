package com.mate.cms.customerService.vo;

import com.mate.user.vo.UserVO;

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
	/** 삭제 상태(default = 'N') **/
	private String cstmrSrvcIsDlt;
	/** 문의 유형 GD_RQ="가이드 구인", RQST="해주세요", GD_RCRT="가이드 투어", PI="결제" **/
	private String cstmrSrvcCtgry;
	/** 문의 제목 **/
	private String srvcCntrTtl;

	private UserVO userVO;

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

	public String getCstmrSrvcIsDlt() {
		return cstmrSrvcIsDlt;
	}

	public void setCstmrSrvcIsDlt(String cstmrSrvcIsDlt) {
		this.cstmrSrvcIsDlt = cstmrSrvcIsDlt;
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

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

}
