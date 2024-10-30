package com.mate.bbs.vo;

import java.util.List;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class UserTourWriteVO {

	/**
	 * 게시글의 아이디. Pk
	 */
	private String usrTrPstId;
	/**
	 * 게시글 작성자
	 */
	private String athrId;
	/**
	 * 여행자가 등록한 투어 게시글의 제목
	 */
	@NotBlank(message ="제목을 작성해주세요!")
	private String usrTrTtl;
	/**
	 * 여행자가 입력한 input[date]의 값 받아오기
	 */
	private String inputYear;
	/**
	 * 여행자가 입력한 시작 시간
	 */
	private String inputStartHour;
	/**
	 * 여행자가 입력한 투어 시작 일시(YYYY-MM-DD HH24:MI)
	 */
	private String usrTrStDt;
	/**
	 * 여행자가 입력한 투어의 목적
	 */
	@NotBlank(message ="투어 목적을 작성해주세요!")
	private String usrTrPrps;
	/**
	 * 여행자가 등록한 가이드와 만날 지점에 대한 정보
	 */
//	@NotBlank(message = "집결 장소를 선택해주세요!")
	private String usrTrMp;
	/**
	 * 여행자가 가이드에게 제시하는 고용 금액
	 */
	@Min(value = 1 , message = "1 이상의 값을 입력해주세요!")
	@PositiveOrZero(message = "음수를 넣으실 수 없습니다!")
	private double usrTrGdHrPrc;
	/**
	 * 여행자의 총 투어 인원
	 */
	@Min(value = 1 , message = "1 이상의 값을 입력해주세요!")
	@PositiveOrZero(message = "음수를 넣으실 수 없습니다!")
	private int usrTrNp;
	/**
	 * 여행자가 등록한 투어 지역의 도시명. FK
	 */
	private int trCtId;
	/**
	 * 여행자의 가이드 구인 게시글의 세부 요구사항 내용
	 */
	@NotBlank(message ="세부 요구사항을 작성해주세요!")
	private String usrTrRqDtl;
	/**
	 * 원하는 가이드의 성별
	 */
	private String gdGndr;
	/**
	 * 원하는 가이드의 나이
	 */
	private int gdAge;
	/**
	 * 원하는 가이드의 경력
	 */
	private int gdCrr;
	/**
	 * 가이드에게 원하는 사항
	 */
	private String gdWntRq;
	/**
	 * 여행자가 입력한 투어 종료 일시
	 */
	private String usrTrEdDt;
	/**
	 * 여행자가 입력한 종료 시간
	 */
	private String inputEndHour;
	/**
	 * 게시글 이미지 파일 정보 리스트
	 */
	private List<UserTourImgVO> userTourImgList;
	/**
	 * 투어 일정 리스트
	 */
	private List<UserTourSchdlVO> userTourSchdlList;
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
	public String getUsrTrTtl() {
		return usrTrTtl;
	}
	public void setUsrTrTtl(String usrTrTtl) {
		this.usrTrTtl = usrTrTtl;
	}
	public String getInputYear() {
		return inputYear;
	}
	public void setInputYear(String inputYear) {
		this.inputYear = inputYear;
	}
	public String getInputStartHour() {
		return inputStartHour;
	}
	public void setInputStartHour(String inputStartHour) {
		this.inputStartHour = inputStartHour;
	}
	public String getUsrTrStDt() {
		return usrTrStDt;
	}
	public void setUsrTrStDt(String usrTrStDt) {
		this.usrTrStDt = usrTrStDt;
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
	public int getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(int trCtId) {
		this.trCtId = trCtId;
	}
	public String getUsrTrRqDtl() {
		return usrTrRqDtl;
	}
	public void setUsrTrRqDtl(String usrTrRqDtl) {
		this.usrTrRqDtl = usrTrRqDtl;
	}
	public String getGdGndr() {
		return gdGndr;
	}
	public void setGdGndr(String gdGndr) {
		this.gdGndr = gdGndr;
	}
	public int getGdAge() {
		return gdAge;
	}
	public void setGdAge(int gdAge) {
		this.gdAge = gdAge;
	}
	public int getGdCrr() {
		return gdCrr;
	}
	public void setGdCrr(int gdCrr) {
		this.gdCrr = gdCrr;
	}
	public String getGdWntRq() {
		return gdWntRq;
	}
	public void setGdWntRq(String gdWntRq) {
		this.gdWntRq = gdWntRq;
	}
	public String getUsrTrEdDt() {
		return usrTrEdDt;
	}
	public void setUsrTrEdDt(String usrTrEdDt) {
		this.usrTrEdDt = usrTrEdDt;
	}
	public String getInputEndHour() {
		return inputEndHour;
	}
	public void setInputEndHour(String inputEndHour) {
		this.inputEndHour = inputEndHour;
	}
	public List<UserTourImgVO> getUserTourImgList() {
		return userTourImgList;
	}
	public void setUserTourImgList(List<UserTourImgVO> userTourImgList) {
		this.userTourImgList = userTourImgList;
	}
	public List<UserTourSchdlVO> getUserTourSchdlList() {
		return userTourSchdlList;
	}
	public void setUserTourSchdlList(List<UserTourSchdlVO> userTourSchdlList) {
		this.userTourSchdlList = userTourSchdlList;
	}
	
}
