package com.mate.bbs.service;

import com.mate.common.vo.CitiesListVO;
import com.mate.common.vo.CountriesListVO;

public interface CountriesAndCitiesService {

	public CountriesListVO getAllCountries();
	
	public CitiesListVO getAllCities(int countryId);
	
}
