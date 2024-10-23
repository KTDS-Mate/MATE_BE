package com.mate.bbs.vo;

import com.mate.common.vo.CityVO;
import com.mate.common.vo.CountryVO;

public class GuideTourVO {

	
	/**
	 * 가이드 투어 게시글 아이디
	 */
	private String gdTrPstId;
	/**
	 * 작성자 아이디
	 */
	private String athrId;
	/**
	 * 예약한 회원 아이디
	 */
	private String usrId;
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
	 * 투어 등록일
	 */
	private String gdTrRstrDt;
	/**
	 * 투어 수정일
	 */
	private String gdTrMdfyDt;
	/**
	 * 투어 삭제일
	 */
	private String gdTrDltDt;
	/**
	 * 투어 삭제 여부
	 */
	private String gdTrIsDlt;
	/**
	 * 투어 국가 아이디
	 */
	private String trCntId;
	/**
	 * 투어 도시 아이디
	 */
	private String trCtId;
	
	//private UsrInfoVO usrInfo;
	
	
	private CountryVO countryVO;
	
	
	private CityVO cityVO;
	
	public CountryVO getCountryVO() {
		return countryVO;
	}
	public void setCountryVO(CountryVO countryVO) {
		this.countryVO = countryVO;
	}
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
	public String getAthrId() {
		return athrId;
	}
	public void setAthrId(String athrId) {
		this.athrId = athrId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
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
	public String getGdTrRstrDt() {
		return gdTrRstrDt;
	}
	public void setGdTrRstrDt(String gdTrRstrDt) {
		this.gdTrRstrDt = gdTrRstrDt;
	}
	public String getGdTrMdfyDt() {
		return gdTrMdfyDt;
	}
	public void setGdTrMdfyDt(String gdTrMdfyDt) {
		this.gdTrMdfyDt = gdTrMdfyDt;
	}
	public String getGdTrDltDt() {
		return gdTrDltDt;
	}
	public void setGdTrDltDt(String gdTrDltDt) {
		this.gdTrDltDt = gdTrDltDt;
	}
	public String getGdTrIsDlt() {
		return gdTrIsDlt;
	}
	public void setGdTrIsDlt(String gdTrIsDlt) {
		this.gdTrIsDlt = gdTrIsDlt;
	}
	public String getTrCntId() {
		return trCntId;
	}
	public void setTrCntId(String trCntId) {
		this.trCntId = trCntId;
	}
	public String getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(String trCtId) {
		this.trCtId = trCtId;
	}
	
}
