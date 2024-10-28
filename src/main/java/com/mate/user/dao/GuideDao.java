package com.mate.user.dao;

import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.user.vo.RegistGuideVO;

public interface GuideDao {

	public String NAMESPACE = "com.mate.user.dao.GuideDao";
	
	public int updateGuideInfo(RegistGuideVO registGuideVO);
	
	public int insertGuideCity(List<CitiesVO> citiesVOList);
	
	public int insertGuideCountry(CountriesVO countriesVO);
	
	public int insertGuideLicense(List<LicenseVO> licenseVOList);
	
}
