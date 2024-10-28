package com.mate.bbs.vo;

import java.util.List;

public class GuideTourWriteVO {

	
	/**
	 * 가이드 유저 성
	 */
	private String usrLnm;
	/**
	 * 가이드 유저 이름
	 */
	private String usrFnm;
	/**
	 * 투어 제목
	 */
	private String gdTrTtl;
	/**
	 * 투어 시작 일자
	 */
	private String gdTrStDt;
	/**
	 * 투어 종료 일자
	 */
	private String gdTrEdDt;
	/**
	 * 투어 최대 인원수
	 */
	private int gdTrMxNp;
	/**
	 * 투어 장소 (국가 도시)
	 */
	private String ctNm;
	/**
	 * 투어 날짜
	 */
	private String gdTrDt;
	/**
	 * 투어 게시글 등록 날자
	 */
	private String gdTrRstrDt;
	/**
	 * 끝날짜
	 */
	private String gdTrTm;
	/**
	 * 투어를 진행할 도시 아이디 fk
	 */
	private String trCtId;
	/**
	 * 투어 요약
	 */
	private String gdTrSmry;
	/**
	 * 투어 상세정보(목적)
	 */
	private String gdTrPrps;
	
	/**
	 * 투어 비용
	 */
	private int gdTrPrc;
	
	/**
	 * 투어 미팅 포인트
	 */
	private String gdTrMp;
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
	public String getUsrLnm() {
		return usrLnm;
	}
	public void setUsrLnm(String usrLnm) {
		this.usrLnm = usrLnm;
	}
	public String getUsrFnm() {
		return usrFnm;
	}
	public void setUsrFnm(String usrFnm) {
		this.usrFnm = usrFnm;
	}
	public String getGdTrTtl() {
		return gdTrTtl;
	}
	public void setGdTrTtl(String gdTrTtl) {
		this.gdTrTtl = gdTrTtl;
	}
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
	public int getGdTrMxNp() {
		return gdTrMxNp;
	}
	public void setGdTrMxNp(int gdTrMxNp) {
		this.gdTrMxNp = gdTrMxNp;
	}
	public String getCtNm() {
		return ctNm;
	}
	public void setCtNm(String ctNm) {
		this.ctNm = ctNm;
	}
	public String getGdTrDt() {
		return gdTrDt;
	}
	public void setGdTrDt(String gdTrDt) {
		this.gdTrDt = gdTrDt;
	}
	public String getGdTrRstrDt() {
		return gdTrRstrDt;
	}
	public void setGdTrRstrDt(String gdTrRstrDt) {
		this.gdTrRstrDt = gdTrRstrDt;
	}
	public String getGdTrTm() {
		return gdTrTm;
	}
	public void setGdTrTm(String gdTrTm) {
		this.gdTrTm = gdTrTm;
	}
	public String getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(String trCtId) {
		this.trCtId = trCtId;
	}
	public String getGdTrSmry() {
		return gdTrSmry;
	}
	public void setGdTrSmry(String gdTrSmry) {
		this.gdTrSmry = gdTrSmry;
	}
	public String getGdTrPrps() {
		return gdTrPrps;
	}
	public void setGdTrPrps(String gdTrPrps) {
		this.gdTrPrps = gdTrPrps;
	}
	public int getGdTrPrc() {
		return gdTrPrc;
	}
	public void setGdTrPrc(int gdTrPrc) {
		this.gdTrPrc = gdTrPrc;
	}
	public String getGdTrMp() {
		return gdTrMp;
	}
	public void setGdTrMp(String gdTrMp) {
		this.gdTrMp = gdTrMp;
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
