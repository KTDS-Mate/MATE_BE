package com.mate.bbs.service;

import com.mate.common.vo.CitiesListVO;
import com.mate.common.vo.CountriesListVO;
import com.mate.common.vo.RegionsListVO;

public interface CountriesAndCitiesService {

	/**
	 * 모든 대륙을 가져옴
	 * @return
	 */
	public RegionsListVO getAllRegions();
	/**
	 * 대륙 별 국가를 가져옴
	 * @param regionId 대륙 아이디
	 * @return
	 */
	public CountriesListVO getCountries(int regionId);
	/**
	 * 국가 별 도시를 가져옴
	 * @param countryId 국가 아이디
	 * @return
	 */
	public CitiesListVO getCities(int countryId);
	
}
