package com.mate.common.vo;

import java.util.List;

public class CitiesListVO {

	/**
	 * 국가 별 도시 리스트
	 */
	private List<CitiesVO> cities;

	private List<CitiesVO> citiesList;
	
	private int citiesCount;
	
	public List<CitiesVO> getCities() {
		return cities;
	}

	public void setCities(List<CitiesVO> cities) {
		this.cities = cities;
	}

	public List<CitiesVO> getCitiesList() {
		return citiesList;
	}

	public void setCitiesList(List<CitiesVO> citiesList) {
		this.citiesList = citiesList;
	}

	public int getCitiesCount() {
		return citiesCount;
	}

	public void setCitiesCount(int citiesCount) {
		this.citiesCount = citiesCount;
	}
}
