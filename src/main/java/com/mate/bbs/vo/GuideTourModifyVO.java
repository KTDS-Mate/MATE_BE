package com.mate.bbs.vo;

import java.util.List;

public class GuideTourModifyVO {

	
	/**
	 * 투어 제목
	 */
	private String gdTrTtl;
	/**
	 * 투어 일시
	 */
	private String gdTrDt;
	/**
	 * 투어 목적
	 */
	private String gdTrPrps;
	/**
	 * 투어 미팅 포인트
	 */
	private String gdTrMp;
	/**
	 * 투어 가격
	 */
	private int gdTrPrc;
	/**
	 * 투어 요약
	 */
	private String gdTrSmry;
	/**
	 * 투어 소요 시간
	 */
	private int gdTrTm;
	/**
	 * 투어 사진 리스트
	 */
	private List<GuideTourImgVO> guideTourImgList;
	/**
	 *  투어제공항목 리스트
	 */
	private List<GuideTourProvidedVO> guideTourProvidedList;
	/**
	 * 가이드 투어 상세 정보 VO
	 */
	private List<GuideTourDetailInfoVO> guideTourDetailInfoList;
	
	public String getGdTrTtl() {
		return gdTrTtl;
	}
	public void setGdTrTtl(String gdTrTtl) {
		this.gdTrTtl = gdTrTtl;
	}
	public String getGdTrDt() {
		return gdTrDt;
	}
	public void setGdTrDt(String gdTrDt) {
		this.gdTrDt = gdTrDt;
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
	public String getGdTrSmry() {
		return gdTrSmry;
	}
	public void setGdTrSmry(String gdTrSmry) {
		this.gdTrSmry = gdTrSmry;
	}
	public int getGdTrTm() {
		return gdTrTm;
	}
	public void setGdTrTm(int gdTrTm) {
		this.gdTrTm = gdTrTm;
	}
	public List<GuideTourImgVO> getGuideTourImgList() {
		return guideTourImgList;
	}
	public void setGuideTourImgList(List<GuideTourImgVO> guideTourImgList) {
		this.guideTourImgList = guideTourImgList;
	}
	public List<GuideTourProvidedVO> getGuideTourProvidedList() {
		return guideTourProvidedList;
	}
	public void setGuideTourProvidedList(List<GuideTourProvidedVO> guideTourProvidedList) {
		this.guideTourProvidedList = guideTourProvidedList;
	}
	public List<GuideTourDetailInfoVO> getGuideTourDetailInfoList() {
		return guideTourDetailInfoList;
	}
	public void setGuideTourDetailInfoList(List<GuideTourDetailInfoVO> guideTourDetailInfoList) {
		this.guideTourDetailInfoList = guideTourDetailInfoList;
	}
}
