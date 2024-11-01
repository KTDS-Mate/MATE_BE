package com.mate.mypage.vo;

import com.mate.common.vo.CountriesVO;

public class SearchCityAndCountryVO {

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
	
	private CountriesVO countriesVO;

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

	public CountriesVO getCountriesVO() {
		return countriesVO;
	}

	public void setCountriesVO(CountriesVO countriesVO) {
		this.countriesVO = countriesVO;
	}
	
	
	
}
