package com.mate.mypage.vo;

public class GuideReviewVO {

	/**
	GD_RVW_ID
	ATHR_ID
	GD_ID
	GD_RVW_TTL
	GD_RVW_CNTNT
	GD_RVW_CRTDAT
	GD_RVW_DLT_AT
	GD_RVW_IS_DLT
	GD_RVW_RTNG
	 */
	
	private String gdRvwId;
	private String athrId;
	private String gdId;
	private String gdRvwTtl;
	private String gdRvwCntnt;
	private String gdRvwCrtdat;
	private String gdRvwIsDlt;
	private double gdRvwRtng;
	private int trCtId;
	private String gdRvwStDt;
	private String gdRvwEdDt;
	
	
	private GuideInfoVO guideInfoVO;
	
	private SearchCityAndCountryVO searchCityAndCountryVO;
	
	
	
	
	
	
	
	
	
	public String getGdRvwStDt() {
		return gdRvwStDt;
	}
	public void setGdRvwStDt(String gdRvwStDt) {
		this.gdRvwStDt = gdRvwStDt;
	}
	public String getGdRvwEdDt() {
		return gdRvwEdDt;
	}
	public void setGdRvwEdDt(String gdRvwEdDt) {
		this.gdRvwEdDt = gdRvwEdDt;
	}
	public int getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(int trCtId) {
		this.trCtId = trCtId;
	}
	public GuideInfoVO getGuideInfoVO() {
		return guideInfoVO;
	}
	public void setGuideInfoVO(GuideInfoVO guideInfoVO) {
		this.guideInfoVO = guideInfoVO;
	}
	public SearchCityAndCountryVO getSearchCityAndCountryVO() {
		return searchCityAndCountryVO;
	}
	public void setSearchCityAndCountryVO(SearchCityAndCountryVO searchCityAndCountryVO) {
		this.searchCityAndCountryVO = searchCityAndCountryVO;
	}
	public String getGdRvwId() {
		return gdRvwId;
	}
	public void setGdRvwId(String gdRvwId) {
		this.gdRvwId = gdRvwId;
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
	public String getGdRvwTtl() {
		return gdRvwTtl;
	}
	public void setGdRvwTtl(String gdRvwTtl) {
		this.gdRvwTtl = gdRvwTtl;
	}
	public String getGdRvwCntnt() {
		return gdRvwCntnt;
	}
	public void setGdRvwCntnt(String gdRvwCntnt) {
		this.gdRvwCntnt = gdRvwCntnt;
	}
	public String getGdRvwCrtdat() {
		return gdRvwCrtdat;
	}
	public void setGdRvwCrtdat(String gdRvwCrtdat) {
		this.gdRvwCrtdat = gdRvwCrtdat;
	}
	public String getGdRvwIsDlt() {
		return gdRvwIsDlt;
	}
	public void setGdRvwIsDlt(String gdRvwIsDlt) {
		this.gdRvwIsDlt = gdRvwIsDlt;
	}
	public double getGdRvwRtng() {
		return gdRvwRtng;
	}
	public void setGdRvwRtng(double gdRvwRtng) {
		this.gdRvwRtng = gdRvwRtng;
	}
	
}