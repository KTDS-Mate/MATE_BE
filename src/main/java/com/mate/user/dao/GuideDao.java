package com.mate.user.dao;

import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.user.vo.RegistGuideVO;

public interface GuideDao {

	public String NAMESPACE = "com.mate.user.dao.GuideDao";
	
	public int updateGuideInfo(RegistGuideVO registGuideVO);
	
	// 도시명으로 CITY_ID 조회
	public Integer selectCityIdByName(String cityName);
	
	// GD_ACT_CT에 데이터 삽입
	public int insertGuideCities(List<CitiesVO> CitiesVOList);
	
	public int insertGuideCountry(CountriesVO countriesVO);
	
	public int insertGuideLicense(List<LicenseVO> licenseVOList);
	
}
