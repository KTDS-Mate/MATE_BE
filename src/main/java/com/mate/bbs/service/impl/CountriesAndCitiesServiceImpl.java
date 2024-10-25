package com.mate.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.CountriesAndCitiesDao;
import com.mate.bbs.service.CountriesAndCitiesService;
import com.mate.common.vo.CountriesListVO;
import com.mate.common.vo.CountriesVO;

@Service
public class CountriesAndCitiesServiceImpl implements CountriesAndCitiesService {

	@Autowired
	private CountriesAndCitiesDao countriesAndCitiesDao;
	
	@Override
	public CountriesListVO getAllCountries() {
		List<CountriesVO> countriesList = this.countriesAndCitiesDao.selectAllCountries();
		int countriesCount = this.countriesAndCitiesDao.selectCountriesCount();
		CountriesListVO countriesListVO = new CountriesListVO();
		countriesListVO.setCountriesList(countriesList);
		countriesListVO.setCountriesCount(countriesCount);
		
		return countriesListVO;
	}
	
}
