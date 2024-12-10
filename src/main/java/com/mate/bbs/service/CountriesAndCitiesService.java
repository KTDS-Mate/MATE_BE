package com.mate.bbs.service;

import com.mate.common.vo.*;

import java.util.List;

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

	/**
	 * 검색 타입과 검색어를 받아서 적절한 결과를 반환
	 *
	 * @param type  검색 타입 (예: country, city 등)
	 * @param query 검색어
	 * @return 검색 결과 리스트
	 */
	List<?> searchByType(String type, String query);

}
