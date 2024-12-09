package com.mate.bbs.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mate.common.vo.RegionsListVO;
import com.mate.common.vo.CountriesListVO;
import com.mate.common.vo.CitiesListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.CountriesAndCitiesService;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.GuideTourImgListVO;
import com.mate.bbs.vo.UserTourImgListVO;


@RestController
public class CountriesAndCitiesController {

	@Autowired
	private CountriesAndCitiesService countriesAndCitiesService;
	
	@Autowired
	private UserTourService userTourService;
	
	@Autowired
	private GuideTourService guideTourService;
	
	@GetMapping("/tour/regions")
	public Map<String, Object> getAllRegions() {
		RegionsListVO regions = this.countriesAndCitiesService.getAllRegions();
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("regions", regions.getRegionsList());
		resultMap.put("regionsCount", regions.getRegionsCount());
		
		return resultMap;
	}
	
	@GetMapping("/tour/countries/{regionId}")
	public Map<String, Object> getCountries(@PathVariable int regionId) {
		CountriesListVO countries = this.countriesAndCitiesService.getCountries(regionId);
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("countries", countries.getCountriesList());
		resultMap.put("countriesCount", countries.getCountriesCount());
		
		return resultMap;
	}
	
	@GetMapping("/tour/cities/{countryId}")
	public Map<String, Object> getCities(@PathVariable int countryId) {
		CitiesListVO cities = this.countriesAndCitiesService.getCities(countryId);
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("cities", cities.getCitiesList());
		resultMap.put("citiesCount", cities.getCitiesCount());
		
		return resultMap;
	}

	@GetMapping("/tour/search")
	public ResponseEntity<?> search(@RequestParam("type") String type, @RequestParam("query") String query) {
		List<?> results = countriesAndCitiesService.searchByType(type, query);
		return ResponseEntity.ok(Map.of("results", results));
	}

	@GetMapping("/usertour/imgs/{usrTrPstId}")
	public Map<String, Object> getUserTourImgs(@PathVariable String usrTrPstId) {
		UserTourImgListVO userTourImgs = this.userTourService.getUserTourImgs(usrTrPstId);
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("imgCnt", userTourImgs.getImgCount());
		resultMap.put("imgUrls", userTourImgs.getUserTourImgList());
		
		return resultMap;
	}
	
	@GetMapping("/guidetour/imgs/{gdTrPstId}")
	public Map<String, Object> getGuideTourImgs(@PathVariable String gdTrPstId) {
		GuideTourImgListVO guideTourImgs = this.guideTourService.getGuideTourImgs(gdTrPstId);
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("imgCnt", guideTourImgs.getGuideTourImgCount());
		resultMap.put("imgUrls", guideTourImgs.getGuideTourImgList());
		
		return resultMap;
	}
	
}
