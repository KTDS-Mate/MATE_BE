package com.mate.bbs.dao;

import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;

public interface CountriesAndCitiesDao {

	public String NAMESPACE = "com.mate.bbs.dao.CountriesAndCitiesDao";
	
	public List<CountriesVO> selectAllCountries(); 
	
	public int selectCountriesCount();
	
	public List<CitiesVO> selectCities(int countryId);
	
}
