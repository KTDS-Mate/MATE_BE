package com.mate.bbs.vo;

import java.util.List;

import com.mate.user.vo.UserVO;

public class UserTourVO {

	/***USRTRRQST 테이블***/
	/**
	 * 게시글의 아이디. Pk
	 */
	private String usrTrPstId;
	/**
	 * 해당 투어를 작성한 여행자 FK
	 */
	private String athrId;
	/**
	 * 투어를 예약한 가이드 FK
	 */
	private String gdId;
	/**
	 * 여행자가 등록한 투어 게시글의 제목
	 */
	private String usrTrTtl;
	/**
	 * 여행자가 입력한 투어 일시
	 */
	private String usrTrDt;
	/**
	 * 여행자가 입력한 투어의 목적
	 */
	private String usrTrPrps;
	/**
	 * 여행자가 등록한 가이드와 만날 지점에 대한 정보
	 */
	private String usrTrMp;
	/**
	 * 가이드에게 간단하게 요청할 사안
	 */
	private String usrTrGdRq;
	/**
	 * 여행자가 가이드에게 제시하는 고용 금액
	 */
	private double usrTrGdHrPrc;
	/**
	 * 여행자의 총 투어 인원
	 */
	private int usrTrNp;
	/**
	 * 논리적 삭제를 위한 게시글 삭제 여부
	 */
	private String usrTrIsDlt;
	/**
	 * 여행자의 투어 소요 시간(분 단위)
	 */
	private int usrTrTm;
	/**
	 * 여행자가 투어 요청 게시글을 등록한 일시
	 */
	private String usrTrRstrDt;
	/**
	 * 여행자가 투어 요청 게시글을 수정한 일시
	 */
	private String usrTrMdfyDt;
	/**
	 * 여행자가 투어 요청 게시글을 삭제한 일시
	 */
	private String usrTrDltDt;
	/**
	 * 여행자가 등록한 투어 지역의 도시명. FK
	 */
	private String trCtId;
	/**
	 * 여행자의 가이드 구인 게시글의 세부 요구사항 내용
	 */
	private String usrTrRqDtl;
	/**
	 * 해당 개시글을 작성한 유저
	 */
	private UserVO userVO;
	/**
	 * 게시글 이미지 리스트
	 */
	private List<UserTourImgVO> userTourImgList;
	
	/**DB에 컬럼이 존재하지 않음(쿼리로 값만 구해옴)**/
	/**
	 * 마감일
	 */
	private String deadline;
	
	public String getUsrTrPstId() {
		return usrTrPstId;
	}
	public void setUsrTrPstId(String usrTrPstId) {
		this.usrTrPstId = usrTrPstId;
	}
	public String getAthrId() {
		return athrId;
	}
	public void setAthrId(String athrId) {
		this.athrId = athrId;
	}
	public String getGdId() {
		return gdId;
	}
	public void setGdId(String gdId) {
		this.gdId = gdId;
	}
	public String getUsrTrTtl() {
		return usrTrTtl;
	}
	public void setUsrTrTtl(String usrTrTtl) {
		this.usrTrTtl = usrTrTtl;
	}
	public String getUsrTrDt() {
		return usrTrDt;
	}
	public void setUsrTrDt(String usrTrDt) {
		this.usrTrDt = usrTrDt;
	}
	public String getUsrTrPrps() {
		return usrTrPrps;
	}
	public void setUsrTrPrps(String usrTrPrps) {
		this.usrTrPrps = usrTrPrps;
	}
	public String getUsrTrMp() {
		return usrTrMp;
	}
	public void setUsrTrMp(String usrTrMp) {
		this.usrTrMp = usrTrMp;
	}
	public String getUsrTrGdRq() {
		return usrTrGdRq;
	}
	public void setUsrTrGdRq(String usrTrGdRq) {
		this.usrTrGdRq = usrTrGdRq;
	}
	public double getUsrTrGdHrPrc() {
		return usrTrGdHrPrc;
	}
	public void setUsrTrGdHrPrc(double usrTrGdHrPrc) {
		this.usrTrGdHrPrc = usrTrGdHrPrc;
	}
	public int getUsrTrNp() {
		return usrTrNp;
	}
	public void setUsrTrNp(int usrTrNp) {
		this.usrTrNp = usrTrNp;
	}
	public String getUsrTrIsDlt() {
		return usrTrIsDlt;
	}
	public void setUsrTrIsDlt(String usrTrIsDlt) {
		this.usrTrIsDlt = usrTrIsDlt;
	}
	public int getUsrTrTm() {
		return usrTrTm;
	}
	public void setUsrTrTm(int usrTrTm) {
		this.usrTrTm = usrTrTm;
	}
	public String getUsrTrRstrDt() {
		return usrTrRstrDt;
	}
	public void setUsrTrRstrDt(String usrTrRstrDt) {
		this.usrTrRstrDt = usrTrRstrDt;
	}
	public String getUsrTrMdfyDt() {
		return usrTrMdfyDt;
	}
	public void setUsrTrMdfyDt(String usrTrMdfyDt) {
		this.usrTrMdfyDt = usrTrMdfyDt;
	}
	public String getUsrTrDltDt() {
		return usrTrDltDt;
	}
	public void setUsrTrDltDt(String usrTrDltDt) {
		this.usrTrDltDt = usrTrDltDt;
	}
	public String getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(String trCtId) {
		this.trCtId = trCtId;
	}
	public String getUsrTrRqDtl() {
		return usrTrRqDtl;
	}
	public void setUsrTrRqDtl(String usrTrRqDtl) {
		this.usrTrRqDtl = usrTrRqDtl;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public List<UserTourImgVO> getUserTourImgList() {
		return userTourImgList;
	}
	public void setUserTourImgList(List<UserTourImgVO> userTourImgList) {
		this.userTourImgList = userTourImgList;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

}

