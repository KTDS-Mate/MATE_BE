package com.mate.common.vo;

public class CityVO {
	/**
	 * 도시 테이블의 PK
	 */
	private String ctId;
	/**
	 * 국가 테이블의 PK
	 */
	private String cntId;
	/**
	 * 도시명
	 */
	private String ctNm;
	
	public String getCtId() {
		return ctId;
	}
	public void setCtId(String ctId) {
		this.ctId = ctId;
	}
	public String getCntId() {
		return cntId;
	}
	public void setCntId(String cntId) {
		this.cntId = cntId;
	}
	public String getCtNm() {
		return ctNm;
	}
	public void setCtNm(String ctNm) {
		this.ctNm = ctNm;
	}
}
