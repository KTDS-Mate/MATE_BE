package com.mate.bbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mate.bbs.service.CountriesAndCitiesService;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourImgListVO;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;
import com.mate.bbs.vo.SearchGuideTourVO;
import com.mate.common.vo.ApiResponse;
import com.mate.user.vo.UserVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class GuideTourApiController {

	@Autowired
	private GuideTourService guideTourService;
	
	
	
	/** 가이드가 등록한 투어 게시글 목록 조회 페이지 **/
	@GetMapping("/guidetour/list")
	public ApiResponse viewAllGuideTourPage(SearchGuideTourVO searchGuideTourVO ) {
		
		GuideTourListVO guideTourListVO = this.guideTourService.getAllGuideTour(searchGuideTourVO);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(guideTourListVO.getGuideTourList());
		
		return apiResponse;
	}
	
	@GetMapping("/guidetour/count")
	public ApiResponse getAllGuideTourCount(SearchGuideTourVO searchGuideTourVO) {
		GuideTourListVO guideTourListVO = this.guideTourService.getAllGuideTour(searchGuideTourVO);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(guideTourListVO.getGdTrPstCnt());
		
		return apiResponse;
	}
	
	/** 가이드가 등록한 게시글 상세 조회 페이지 **/
	@GetMapping("/guidetour/info/{gdTrPstId}")
	public ApiResponse viewOneGuideTourPage (@PathVariable String gdTrPstId) {
		
		GuideTourVO guideTourVO = this.guideTourService.getOneGuideTour(gdTrPstId);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(guideTourVO);
		
		return apiResponse;
	}
	
	/**가이드가 작성한 투어 게시글을 받아와서 DB에 저장하는 페이지 **/
	@PostMapping("/guidetour/insert")
	public ApiResponse doCreateNewGuideTour(@RequestBody @Valid GuideTourWriteVO guideTourWriteVO,
											BindingResult bindingResult,
											@SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		
		if(bindingResult.hasErrors()) {
			List<String> fieldErrors = bindingResult.getFieldErrors()
													.stream()
													.map(fieldError -> fieldError.getDefaultMessage())
													.toList();
			ApiResponse errorResponse = new ApiResponse(HttpStatus.BAD_REQUEST);
			errorResponse.setErrors(fieldErrors);
			
			return errorResponse;
		}
		
		boolean isCreate = this.guideTourService.createNewGuideTour(guideTourWriteVO);
		
		return new ApiResponse(isCreate);
	}
	
	@GetMapping("/guidetour/imgs/{gdTrPstId}")
	public ApiResponse getGuideTourImgs(@PathVariable String gdTrPstId) {
		GuideTourImgListVO guideTourImgs = this.guideTourService.getGuideTourImgs(gdTrPstId);
		return new ApiResponse(guideTourImgs);
	}
	
    @GetMapping("/guidetour/random")
    public ResponseEntity<?> getRandomGuideTours() {
        try {
            List<GuideTourVO> randomTours = guideTourService.getRandomGuideTours();
            return ResponseEntity.ok(randomTours); // JSON 형식으로 반환
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Server Error\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }
    
    
    
    @GetMapping("/guidetour/getLateGuideTour")
    public ApiResponse doGetLateGuideTour() {
    	GuideTourVO guideTourVO = this.guideTourService.getLateGuideTour();
    	
    	ApiResponse apiResponse = new ApiResponse();
    	apiResponse.setBody(guideTourVO);
    	
    	return apiResponse;
    }
}
