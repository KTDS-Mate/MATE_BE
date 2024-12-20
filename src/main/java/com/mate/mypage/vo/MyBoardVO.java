package com.mate.mypage.vo;

public class MyBoardVO {

    private String gdTrPstId;
    private String athrId; // 게시글 작성한 사람의 로그인 아이디 
    private String usrId;
    private String gdTrTtl;
    private String gdTrStDt;
    private String gdTrEdDt;
    private String gdTrPrps;
    private String gdTrMp;
    private int gdTrPrc;
    private String gdTrSmry;
    private String gdTrRstrDt;
    private String gdTrMdfyDt;
    private String gdTrDltDt;
    private char gdTrIsDlt;
    private String trCtId;
    private int gdTrMxNp;
    private String gdTrStts;
    
    private SearchCityAndCountryVO searchCityAndCountryVO;
    
    
    /*
     * GD_TR_PST_ID
		ATHR_ID
		USR_ID
		GD_TR_TTL
		GD_TR_ST_DT
		GD_TR_PRPS
		GD_TR_MP
		GD_TR_PRC
		GD_TR_SMRY
		GD_TR_RSTR_DT
		GD_TR_MDFY_DT
		GD_TR_DLT_DT
		GD_TR_IS_DLT
		TR_CNT_ID
		TR_CT_ID
		GD_TR_ED_DT
		GD_TR_MX_NP
     */
    
    
    
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	
	
	
	
	public SearchCityAndCountryVO getSearchCityAndCountryVO() {
		return searchCityAndCountryVO;
	}




	public void setSearchCityAndCountryVO(SearchCityAndCountryVO searchCityAndCountryVO) {
		this.searchCityAndCountryVO = searchCityAndCountryVO;
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
	public String getGdTrStDt() {
		return gdTrStDt;
	}
	public void setGdTrStDt(String gdTrStDt) {
		this.gdTrStDt = gdTrStDt;
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

	public String getGdTrSmry() {
		return gdTrSmry;
	}
	public void setGdTrSmry(String gdTrSmry) {
		this.gdTrSmry = gdTrSmry;
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

	
	
	public char getGdTrIsDlt() {
		return gdTrIsDlt;
	}
	public void setGdTrIsDlt(char gdTrIsDlt) {
		this.gdTrIsDlt = gdTrIsDlt;
	}

	public String getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(String trCtId) {
		this.trCtId = trCtId;
	}
	public String getGdTrEdDt() {
		return gdTrEdDt;
	}
	public void setGdTrEdDt(String gdTrEdDt) {
		this.gdTrEdDt = gdTrEdDt;
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




	public String getGdTrStts() {
		return gdTrStts;
	}




	public void setGdTrStts(String gdTrStts) {
		this.gdTrStts = gdTrStts;
	}
	


    
}
