package com.mate.common.vo;

import java.util.List;

public class CountriesListVO {

	private int countriesCount;
	
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
