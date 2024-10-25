package com.mate.bbs.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.CountriesAndCitiesService;
import com.mate.common.vo.CountriesListVO;


@RestController
public class CountriesAndCitiesController {

	@Autowired
	private CountriesAndCitiesService countriesAndCitiesService;
	
	@GetMapping("/tour/countreis")
	public Map<String, Object> getAllCounties() {
		CountriesListVO countriesVO = this.countriesAndCitiesService.getAllCountries();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("countries", countriesVO.getCountriesList());
		resultMap.put("countriesCnt", countriesVO.getCountriesCount());
		
		return resultMap;
	}
	
}
