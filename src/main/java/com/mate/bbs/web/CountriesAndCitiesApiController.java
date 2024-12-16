package com.mate.bbs.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.CountriesAndCitiesService;

@RestController
@RequestMapping("/api/v1")
public class CountriesAndCitiesApiController {

	@Autowired
	private CountriesAndCitiesService countriesAndCitiesService;
	
	@GetMapping("/tour/search")
	public ResponseEntity<?> search(@RequestParam String type, @RequestParam String query) {
	    List<?> results = countriesAndCitiesService.searchByType(type, query);
	    return ResponseEntity.ok(Map.of("results", results));
	}

}
