package com.mate.bbs.vo;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class GuideTourWriteVO {
	
	/**
	 * 가이드가 등록한 투어 제목
	 */
	@NotBlank(message = "제목을 작성해주세요!")
	private String gdTrTtl;
	/**
	 * 가이드가 입력한 input[date]의 값 받아오기
	 */
	private String inputYear;
	/**
	 * 가이드가 입력한 시작 시
	 */
	private String inputStartHour;
	/**
	 * 가이드가 입력한 시작 분
	 */
	private String inputStartMinute;
	/**
	 * 투어 시작 일자
	 */
	private String gdTrStDt;
	/**
	 * 투어 종료 일자
	 */
	private String gdTrEdDt;
	/**
	 * 가이드가 입력한 종료 시
	 */
	private String inputEndHour;
	/**
	 * 가이드가 입력한 종료 분
	 */
	private String inputEndMinute;
	/**
	 * 투어 상세정보(목적)
	 */
	@NotBlank(message = "투어 목적을 작성해주세요!")
	private String gdTrPrps;
	/**
	 * 투어 미팅 포인트(만날 장소)
	 */
	private String gdTrMp;
	/**
	 * 투어 비용(가격)
	 */
	@Min(value=1 , message="1 이상의 값을 입력해주세요!")
	@PositiveOrZero(message ="음수를 넣으실 수 없습니다!")
	private int gdTrPrc;
	/**
	 * 투어 최대 인원수
	 */
	private int gdTrMxNp;
	/**
	 * 투어를 진행할 도시 아이디 fk
	 */
	private int trCtId;
	/**
	 * 투어 날짜
	 */
	private String gdTrDt;
	/**
	 * 투어 요약(요구사항)
	 */
	private String gdTrSmry;
	/**
	 *  투어제공항목 리스트
	 */
	private List<GuideTourProvidedVO> guideTourProvidedList;
	/**
	 * 투어 사진 리스트
	 */
	private List<GuideTourImgVO> guideTourImgList;
	/**
	 * 가이드 투어 상세정보 리스트 VO
	 */
	private List<GuideTourDetailInfoVO> guideTourDetailInfoList;
	
	public String getGdTrStDt() {
		return gdTrStDt;
	}
	public void setGdTrStDt(String gdTrStDt) {
		this.gdTrStDt = gdTrStDt;
	}
	public String getGdTrEdDt() {
		return gdTrEdDt;
	}
	public void setGdTrEdDt(String gdTrEdDt) {
		this.gdTrEdDt = gdTrEdDt;
	}
	public String getGdTrTtl() {
		return gdTrTtl;
	}
	public void setGdTrTtl(String gdTrTtl) {
		this.gdTrTtl = gdTrTtl;
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
	public String getInputStartMinute() {
		return inputStartMinute;
	}
	public void setInputStartMinute(String inputStartMinute) {
		this.inputStartMinute = inputStartMinute;
	}
	public String getInputEndHour() {
		return inputEndHour;
	}
	public void setInputEndHour(String inputEndHour) {
		this.inputEndHour = inputEndHour;
	}
	public String getInputEndMinute() {
		return inputEndMinute;
	}
	public void setInputEndMinute(String inputEndMinute) {
		this.inputEndMinute = inputEndMinute;
	}
	public String getGdTrPrps() {
		return gdTrPrps;
	}
	public void setGdTrPrps(String gdTrPrps) {
		this.gdTrPrps = gdTrPrps;
	}
	public String getGdTrMp() {
		return gdTrMp;
	}
	public void setGdTrMp(String gdTrMp) {
		this.gdTrMp = gdTrMp;
	}
	public int getGdTrPrc() {
		return gdTrPrc;
	}
	public void setGdTrPrc(int gdTrPrc) {
		this.gdTrPrc = gdTrPrc;
	}
	public int getGdTrMxNp() {
		return gdTrMxNp;
	}
	public void setGdTrMxNp(int gdTrMxNp) {
		this.gdTrMxNp = gdTrMxNp;
	}
	public int getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(int trCtId) {
		this.trCtId = trCtId;
	}
	public String getGdTrDt() {
		return gdTrDt;
	}
	public void setGdTrDt(String gdTrDt) {
		this.gdTrDt = gdTrDt;
	}
	public String getGdTrSmry() {
		return gdTrSmry;
	}
	public void setGdTrSmry(String gdTrSmry) {
		this.gdTrSmry = gdTrSmry;
	}
	public List<GuideTourProvidedVO> getGuideTourProvidedList() {
		return guideTourProvidedList;
	}
	public void setGuideTourProvidedList(List<GuideTourProvidedVO> guideTourProvidedList) {
		this.guideTourProvidedList = guideTourProvidedList;
	}
	public List<GuideTourImgVO> getGuideTourImgList() {
		return guideTourImgList;
	}
	public void setGuideTourImgList(List<GuideTourImgVO> guideTourImgList) {
		this.guideTourImgList = guideTourImgList;
	}
	public List<GuideTourDetailInfoVO> getGuideTourDetailInfoList() {
		return guideTourDetailInfoList;
	}
	public void setGuideTourDetailInfoList(List<GuideTourDetailInfoVO> guideTourDetailInfoList) {
		this.guideTourDetailInfoList = guideTourDetailInfoList;
	}
	
	
}
