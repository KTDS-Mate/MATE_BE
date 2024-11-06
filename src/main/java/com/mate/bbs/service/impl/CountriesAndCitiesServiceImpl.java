package com.mate.bbs.service.impl;

import java.util.Collections;
import java.util.List;

import com.mate.common.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.CountriesAndCitiesDao;
import com.mate.bbs.service.CountriesAndCitiesService;

@Service
public class CountriesAndCitiesServiceImpl implements CountriesAndCitiesService {

	@Autowired
	private CountriesAndCitiesDao countriesAndCitiesDao;

	@Override
	public RegionsListVO getAllRegions() {
		/**대륙 리스트와 대륙 수를 가져옴**/
		List<RegionsVO> regionList = this.countriesAndCitiesDao.selectAllRegions();
		int regionCount = this.countriesAndCitiesDao.selectRegionsCount();
		RegionsListVO regionsListVO = new RegionsListVO();
		
		regionsListVO.setRegionsCount(regionCount);
		regionsListVO.setRegionsList(regionList);
		
		return regionsListVO;
	}

	@Override
	public CountriesListVO getCountries(int regionId) {
		/**대륙 별 국가 리스트와 수를 가져옴**/
		List<CountriesVO> countriesList = this.countriesAndCitiesDao.selectCountries(regionId);
		int countriesCount = this.countriesAndCitiesDao.selectCountriesCount(regionId);
		CountriesListVO countriesListVO = new CountriesListVO();
		
		countriesListVO.setCountriesCount(countriesCount);
		countriesListVO.setCountriesList(countriesList);
		
		return countriesListVO;
	}

	@Override
	public CitiesListVO getCities(int countryId) {
		/**국가 별 도시 리스트와 수를 가져옴**/
		List<CitiesVO> citiesList = this.countriesAndCitiesDao.selectCities(countryId);
		int citiesCount = this.countriesAndCitiesDao.selectCitiesCount(countryId);
		CitiesListVO citiesListVO = new CitiesListVO();
		
		citiesListVO.setCitiesCount(citiesCount);
		citiesListVO.setCitiesList(citiesList);
		
		return citiesListVO;
	}

	@Override
	public TopDestinationsListVO getTopDestinations() {
		TopDestinationsListVO topDestinationsList = this.countriesAndCitiesDao.selectTopDestinations();



		return topDestinationsList;
	}
	
}
