package com.mate.common.vo;

import java.util.List;

public class CitiesListVO {

	/**
	 * 국가 별 도시 수
	 */
	private int citiesCount;
	
	/**
	 * 국가 별 도시 리스트
	 */
	private List<CitiesVO> citiesList;

	public int getCitiesCount() {
		return citiesCount;
	}

	public void setCitiesCount(int citiesCount) {
		this.citiesCount = citiesCount;
	}

	public List<CitiesVO> getCitiesList() {
		return citiesList;
	}

	public void setCitiesList(List<CitiesVO> citiesList) {
		this.citiesList = citiesList;
	}
	
}
