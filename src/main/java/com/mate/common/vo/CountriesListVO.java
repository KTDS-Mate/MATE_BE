package com.mate.common.vo;

import java.util.List;

public class CountriesListVO {

	/**
	 * 대륙 별 국가 수
	 */
	private int countriesCount;
	/**
	 * 대륙 별 국가 리스트
	 */
	private List<CountriesVO> countriesList;

	public int getCountriesCount() {
		return countriesCount;
	}

	public void setCountriesCount(int countriesCount) {
		this.countriesCount = countriesCount;
	}

	public List<CountriesVO> getCountriesList() {
		return countriesList;
	}

	public void setCountriesList(List<CountriesVO> countriesList) {
		this.countriesList = countriesList;
	}
	
}
