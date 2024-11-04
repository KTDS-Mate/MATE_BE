package com.mate.user.dao;

import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.user.vo.RegistGuideVO;

public interface GuideDao {
	
	String NAMESPACE = "com.mate.user.dao.GuideDao";

	public RegistGuideVO selectGuideInfo(String usrId);

	public int insertGuideProfile(RegistGuideVO registGuideVO);

    public int insertGuideCity(CitiesVO citiesVO);

    public int insertGuideLicense(LicenseVO licenseVO);

    public int updateGuideProfile(RegistGuideVO registGuideVO);
    
    public List<CitiesVO> selectCitiesByCountry(String countryId);
    
    public List<CountriesVO> selectAllCountries();
    
    public String getNextLicenseId();
    
    public String getNextCityId();
    
    public int updateGuideLicense(RegistGuideVO registGuideVO);
}
