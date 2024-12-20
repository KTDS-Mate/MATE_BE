package com.mate.common.vo;

public class CitiesVO {

	private String usrId;
	
	private String usrLngId;
	
	/**
	 * 도시 아이디
	 */
	private int cityId;
	/**
	 * 도시 명
	 */
	private String cityName;
	/**
	 * 국가 아이디
	 */
	private int countryId;
	

	private CountriesVO country;
	
	private String actCtId;
	
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrLngId() {
		return usrLngId;
	}
	public void setUsrLngId(String usrLngId) {
		this.usrLngId = usrLngId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public CountriesVO getCountry() {
		return country;
	}
	public void setCountry(CountriesVO country) {
		this.country = country;
	}
	public String getActCtId() {
		return actCtId;
	}
	public void setActCtId(String actCtId) {
		this.actCtId = actCtId;
	}
}
