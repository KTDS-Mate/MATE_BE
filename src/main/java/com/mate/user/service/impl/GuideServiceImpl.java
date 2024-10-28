package com.mate.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.common.vo.CitiesVO;
import com.mate.user.dao.GuideDao;
import com.mate.user.service.GuideService;
import com.mate.user.vo.GuideCityMappingVO;

@Service
public class GuideServiceImpl implements GuideService {

	@Autowired
	private GuideDao guideDao;

	@Override
	public void registerGuideCities(List<String> cityNames, String usrId) {
		List<GuideCityMappingVO> guideCityMappingList = new ArrayList<>();
		
		for (String CityName : cityNames) {
			Integer cityId = guideDao.selectCityIdByName(CityName);
			
			if (cityId != null) {
				GuideCityMappingVO mapping = new GuideCityMappingVO(); 
				mapping.setCityId(cityId);
				mapping.setUsrId(usrId);
				guideCityMappingList.add(mapping);
			}
		}
		
		if (!guideCityMappingList.isEmpty()) {
			guideDao.insertGuideCities(guideCityMappingList);
		}
	}
}
