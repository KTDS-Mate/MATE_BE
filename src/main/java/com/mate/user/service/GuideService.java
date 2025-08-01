package com.mate.user.service;

import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.user.vo.RegistGuideVO;

public interface GuideService {
	
	public RegistGuideVO getGuideInfo(String usrId);

    public boolean registerGuide(RegistGuideVO registGuideVO);

    public boolean updateGuideProfile(RegistGuideVO registGuideVO);
    
    public List<CitiesVO> getCitiesByCountryId(String countryId);
    
    public List<CountriesVO> getAllCountries();
    
    public boolean updateGuideLicense(RegistGuideVO registGuideVO);
    
    public boolean updateGuideLicenseApi(LicenseVO licenseVO);
    
    public boolean deleteLicenseById(String licenseId);
    
//    public boolean updateProfileImage(RegistGuideVO registGuideVO);
    
//    public boolean updateIdImage(RegistGuideVO registGuideVO);
    
    boolean updateGuideLocation(RegistGuideVO registGuideVO);
    
    public String getNextLicenseId();
}
