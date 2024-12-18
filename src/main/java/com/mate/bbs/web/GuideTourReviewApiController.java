package com.mate.bbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.GuideTourReviewService;
import com.mate.bbs.vo.GuideTourReviewListVO;
import com.mate.bbs.vo.GuideTourReviewWriteVO;
import com.mate.common.vo.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class GuideTourReviewApiController {

	@Autowired
	private GuideTourReviewService guideTourReviewService;
	
	@GetMapping("/guidetour/review/list")
	public ApiResponse viewAllGuideTourReview (String gdTrPstId) {
		
		GuideTourReviewListVO guideTourReviewListVO = this.guideTourReviewService.getAllGuideTourReview(gdTrPstId);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(guideTourReviewListVO.getGuideTourReviewList());
		
		return apiResponse;
	}
	
	@GetMapping("/guidetour/review/count")
	public ApiResponse getAllGuideTourReviewCount (String gdTrPstId) {
		
		GuideTourReviewListVO guideTourReviewListVO = this.guideTourReviewService.getAllGuideTourReview(gdTrPstId);
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(guideTourReviewListVO.getReviewCnt());
		
		return apiResponse;
	}
	
	@PostMapping("/guidetour/review/insert")
	public ApiResponse doCreateNewGuideTourReview(@RequestBody @Valid GuideTourReviewWriteVO guideTourReviewWriteVO
												, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			List<String> fieldErrors = bindingResult.getFieldErrors()
													.stream()
													.map(fieldError -> fieldError.getDefaultMessage())
													.toList();
			ApiResponse errorResponse = new ApiResponse(HttpStatus.BAD_REQUEST);
			errorResponse.setErrors(fieldErrors);
			
			return errorResponse;
		}
		
		boolean isCreate = this.guideTourReviewService.createNewGuideTourReview(guideTourReviewWriteVO);
		
		return new ApiResponse(isCreate);
	}
	
	@GetMapping("/guidetour/review/delete")
	public ApiResponse doDeleteGuideTourReview() {
		return null;
	}
	
}
