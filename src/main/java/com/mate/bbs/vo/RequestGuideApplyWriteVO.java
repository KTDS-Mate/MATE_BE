package com.mate.bbs.vo;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class RequestGuideApplyWriteVO {
	
	/** 유저의 투어요청 게시글에 대한 가이드의 제안 PK **/
	private String gdApplyId;
	/** 가이드의 PK **/
	private String gdId;
	/** 게시글의 아이디. Pk **/
	private String usrTrPstId;
	/** 가이드가 제안한 총 투어 금액 **/
	private int gdApplyPrc;
	/** 가이드가 투어에 제안한 포스트의 제목 **/
	@NotEmpty(message = "제목을 입력해주세요!")
	private String gdApplyTtl;
	/** 가이드가 투어에 제안하 포스트의 요약 **/
	@NotEmpty(message = "요약을 입력해주세요")
	private String trGdApplyDtl;
	/** 가이드가 투어에 제안한 포스트의 미팅장소 **/
	private String trGdApplyMp;

	private List<UserTourSchdlVO> userTourSchdlList;

	public String getGdApplyId() {
		return gdApplyId;
	}

	public void setGdApplyId(String gdApplyId) {
		this.gdApplyId = gdApplyId;
	}

	public String getGdId() {
		return gdId;
	}

	public void setGdId(String gdId) {
		this.gdId = gdId;
	}

	public String getUsrTrPstId() {
		return usrTrPstId;
	}

	public void setUsrTrPstId(String usrTrPstId) {
		this.usrTrPstId = usrTrPstId;
	}

	public int getGdApplyPrc() {
		return gdApplyPrc;
	}

	public void setGdApplyPrc(int gdApplyPrc) {
		this.gdApplyPrc = gdApplyPrc;
	}

	public String getGdApplyTtl() {
		return gdApplyTtl;
	}

	public void setGdApplyTtl(String gdApplyTtl) {
		this.gdApplyTtl = gdApplyTtl;
	}

	public String getTrGdApplyDtl() {
		return trGdApplyDtl;
	}

	public void setTrGdApplyDtl(String trGdApplyDtl) {
		this.trGdApplyDtl = trGdApplyDtl;
	}

	public String getTrGdApplyMp() {
		return trGdApplyMp;
	}

	public void setTrGdApplyMp(String trGdApplyMp) {
		this.trGdApplyMp = trGdApplyMp;
	}

	public List<UserTourSchdlVO> getUserTourSchdlList() {
		return userTourSchdlList;
	}

	public void setUserTourSchdlList(List<UserTourSchdlVO> userTourSchdlList) {
		this.userTourSchdlList = userTourSchdlList;
	}

}
