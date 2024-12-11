package com.mate.bbs.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.RequestGuideApplyListVO;

@RestController
public class RequestGuideApplyController {

	@Autowired
	private UserTourService userTourService;
	
	@GetMapping("/requestApply/{usrTrPstId}")
	public Map<String, Object> getAllRegions(@PathVariable String usrTrPstId) {
		RequestGuideApplyListVO requestGuideApplys = this.userTourService.getAllRequestGuideApply(usrTrPstId);
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("requestGuideApplys", requestGuideApplys.getRequestGuideApplyList());
		resultMap.put("requestGuideApplyCount", requestGuideApplys.getRequestGuideApplyCount());
		
		return resultMap;
	}
	
	
	
}
