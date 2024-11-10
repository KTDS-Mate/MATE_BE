package com.mate.bbs.dao;

import java.util.List;

import com.mate.common.vo.*;

public interface CountriesAndCitiesDao {

	public String NAMESPACE = "com.mate.bbs.dao.CountriesAndCitiesDao";
	/**
	 * 모든 대륙을 가져옴
	 * @return
	 */
	public List<RegionsVO> selectAllRegions();
	
	/**
	 * 모든 대륙의 수
	 * @return
	 */
	public int selectRegionsCount();
	
	/**
	 * 대륙 별 국가를 가져옴
	 * @param regionId 대륙 아이디
	 * @return
	 */
	public List<CountriesVO> selectCountries(int regionId); 
	
	/**
	 * 대륙 별 국가 수
	 * @param regionId 대륙 아이디
	 * @return
	 */
	public int selectCountriesCount(int regionId);
	
	/**
	 * 국가 별 도시를 가져옴
	 * @param countryId 국가 아이디
	 * @return
	 */
	public List<CitiesVO> selectCities(int countryId);
	
	/**
	 * 국가 별 도시 수
	 * @param countryId 국가 아이디
	 * @return
	 */
	public int selectCitiesCount(int countryId);

	List<CountriesVO> searchCountriesByName(String query);

	List<CitiesVO> searchCitiesByName(String query);

//	List<CitiesVO> selectRandomCities();

//	public TopDestinationsListVO selectTopDestinations();
}
