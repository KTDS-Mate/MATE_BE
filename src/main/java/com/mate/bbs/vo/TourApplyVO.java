package com.mate.bbs.vo;

import java.util.List;

import com.mate.user.vo.UserVO;

public class TourApplyVO {
	
	/**
	 * 유저의 투어요청 게시글에 대한 가이드의 제안 PK
	 */
	private String gdApplyId;
	
	/**
	 * 가이드의 PK
	 */
	private String gdId;
	
	/**
	 * 게시글의 아이디. Pk
	 */
	private String usrTrPstId;
	
	/**
	 * 가이드가 제안한 총 투어 금액
	 */
	private String gdApplyPrc;
	
	/**
	 * 가이드가 작성한 일시
	 */
	private String gdApplyRstrDt;
	
	/**
	 * 가이드가 투어에 제안한 포스트의 삭제여부
	 */
	private String gdApplyIsDlt;
	
	/**
	 * 가이드가 투어에 제안한 포스트의 삭제일시
	 */
	private String gdApplyDltDt;
	
	/**
	 * 가이드가 투어에 제안한 포스트의 제목
	 */
	private String gdApplyTtl;
	
	/**
	 * 가이드가 투어에 제안한 포스트의 요약
	 */
	private String trGdApplyDtl;
	
	/**
	 * 가이드가 투어에 제안한 포스트의 미팅장소
	 */
	private String trGdApplyMp;
	
	/**
	 * 생년월일으로 DB에서 연산 후 가져온 가이드의 나이
	 */
	private int gdAge; 
	
	/**
	 * 가이드가 투어에 제안한 투어의 기본정보
	 */
	private UserTourVO userTourVO;
	
	/**
	 * 신청한 가이드의 정보
	 */
	private UserVO guideVO;
	
	/**
	 * 투어 일정 정보리스트
	 */
	private List<UserTourSchdlVO> trSchdlList;

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

	public String getGdApplyPrc() {
		return gdApplyPrc;
	}

	public void setGdApplyPrc(String gdApplyPrc) {
		this.gdApplyPrc = gdApplyPrc;
	}

	public String getGdApplyRstrDt() {
		return gdApplyRstrDt;
	}

	public void setGdApplyRstrDt(String gdApplyRstrDt) {
		this.gdApplyRstrDt = gdApplyRstrDt;
	}

	public String getGdApplyIsDlt() {
		return gdApplyIsDlt;
	}

	public void setGdApplyIsDlt(String gdApplyIsDlt) {
		this.gdApplyIsDlt = gdApplyIsDlt;
	}

	public String getGdApplyDltDt() {
		return gdApplyDltDt;
	}

	public void setGdApplyDltDt(String gdApplyDltDt) {
		this.gdApplyDltDt = gdApplyDltDt;
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
	
	public int getGdAge() {
		return gdAge;
	}

	public void setGdAge(int gdAge) {
		this.gdAge = gdAge;
	}

	public UserTourVO getUserTourVO() {
		return userTourVO;
	}

	public void setUserTourVO(UserTourVO userTourVO) {
		this.userTourVO = userTourVO;
	}

	public UserVO getGuideVO() {
		return guideVO;
	}

	public void setGuideVO(UserVO guideVO) {
		this.guideVO = guideVO;
	}

	public List<UserTourSchdlVO> getTrSchdlList() {
		return trSchdlList;
	}

	public void setTrSchdlList(List<UserTourSchdlVO> trSchdlList) {
		this.trSchdlList = trSchdlList;
	}

}
