package com.mate.bbs.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.GuideTourReviewService;

@RestController
public class GuideTourReviewController {
	
	@Autowired
	private GuideTourReviewService guideTourReviewService;
	
	// ------ 리뷰 가져오는 것은 일반 GuideTourController에서 작업함
	
	private Map<String, Object> doCreateNewGuideTourReview() {
		this.guideTourReviewService.createNewGuideTourReview(null);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		return null;
	}
	
}
