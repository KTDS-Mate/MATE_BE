package com.mate.common.vo;

public class CountriesVO {

	/**
	 * 국가 아이디 PK
	 */
	private int countryId;
	/**
	 * 국가 명
	 */
	private String countryName;
	/**
	 * 대륙 아이디
	 */
	private int regionId;
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
}
