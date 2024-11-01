package com.mate.user.service;

import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.user.vo.RegistGuideVO;

public interface GuideService {
	
	public RegistGuideVO getGuideInfo(String usrId);

    public boolean registerGuide(RegistGuideVO registGuideVO);

    public boolean updateGuideProfile(RegistGuideVO registGuideVO);
    
    public List<CitiesVO> getCitiesByCountryId(String countryId);
    
    public List<CountriesVO> getAllCountries();
    
}
