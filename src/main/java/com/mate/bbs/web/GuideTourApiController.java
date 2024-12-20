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

import com.mate.bbs.service.FavoriteService;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.FavoriteListVO;
import com.mate.bbs.vo.FavoriteWriteVO;
import com.mate.bbs.vo.GuideTourImgListVO;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;
import com.mate.bbs.vo.SearchGuideTourVO;
import com.mate.common.vo.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class GuideTourApiController {

	@Autowired
	private GuideTourService guideTourService;
	
	@Autowired
	private FavoriteService favoriteService;
	
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
		System.out.println("toto" + guideTourListVO.getGdTrPstCnt());
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
	public ApiResponse doCreateNewGuideTour(@RequestBody @Valid GuideTourWriteVO guideTourWriteVO
											,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			List<String> fieldErrors = bindingResult.getFieldErrors()
													.stream()
													.map(fieldError -> fieldError.getDefaultMessage())
													.toList();
			fieldErrors.stream().forEach( a -> 
				System.out.println("!" + a)
			);
			ApiResponse errorResponse = new ApiResponse(HttpStatus.BAD_REQUEST);
			errorResponse.setErrors(fieldErrors);
			
			return errorResponse;
		}
		System.out.println("불러온 값" + guideTourWriteVO.getAthrId());
		System.out.println("!!!");
		boolean isCreate = this.guideTourService.createNewGuideTour(guideTourWriteVO);
		
		return new ApiResponse(isCreate);
	}
	
	@GetMapping("/guidetour/imgs/{gdTrPstId}")
	public ApiResponse getGuideTourImgs(@PathVariable String gdTrPstId) {
		GuideTourImgListVO guideTourImgs = this.guideTourService.getGuideTourImgs(gdTrPstId);
		return new ApiResponse(guideTourImgs);
	}
	
	@GetMapping("/guidetour/random")
	public ApiResponse getRandomGuideTours() {
	    ApiResponse apiResponse = new ApiResponse();
	    try {
	        List<GuideTourVO> randomTours = guideTourService.getRandomGuideTours();
	        apiResponse.setBody(randomTours);
	    } catch (Exception e) {
	        apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	        apiResponse.setErrors(List.of(e.getMessage())); // 오류 메시지를 리스트에 추가
	    }
	    return apiResponse;
	}

    
    @GetMapping("/guidetour/favorite/{gdTrPstId}")
    public ApiResponse getAllGuideTourFavorite(@PathVariable String gdTrPstId) {
    	FavoriteListVO favoriteListVO = this.favoriteService.getAllGuideTourFavoriteList(gdTrPstId);
    	ApiResponse apiResponse = new ApiResponse();
    	apiResponse.setBody(favoriteListVO.getFavoriteList());
    	
    	return apiResponse;
    }
    
    @PostMapping("/guidetour/favorite/create")
    public ApiResponse doCreateNewGuideTourFavorite(@RequestBody FavoriteWriteVO favoriteWriteVO) {
    	boolean isCreated = this.favoriteService.createNewGuideTourFavorite(favoriteWriteVO);
    	
    	return new ApiResponse(isCreated);
    }
    
    @GetMapping("/guidetour/favorite/delete/{gdTrPstId}/{usrLgnId}")
    public ApiResponse doDeleteGuideTourFavorite(@PathVariable String gdTrPstId, 
    											 @PathVariable String usrLgnId) {
    	boolean isDeleted = this.favoriteService.deleteGuideTourFavorite(gdTrPstId, usrLgnId);
    	
    	return new ApiResponse(isDeleted);
    	
    }
    
    @GetMapping("/guidetour/getLateGuideTour")
    public ApiResponse doGetLateGuideTour() {
    	GuideTourVO guideTourVO = this.guideTourService.getLateGuideTour();
    	
    	ApiResponse apiResponse = new ApiResponse();
    	apiResponse.setBody(guideTourVO);
    	
    	return apiResponse;
    }
}
