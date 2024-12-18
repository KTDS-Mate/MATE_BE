package com.mate.bbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.CountriesAndCitiesService;
import com.mate.bbs.service.FavoriteService;
import com.mate.bbs.service.TourApplyService;
import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.FavoriteListVO;
import com.mate.bbs.vo.FavoriteWriteVO;
import com.mate.bbs.vo.RequestGuideApplyWriteVO;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.TourApplyVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;
import com.mate.common.vo.ApiResponse;
import com.mate.common.vo.CitiesListVO;
import com.mate.common.vo.CountriesListVO;
import com.mate.common.vo.RegionsListVO;
import com.mate.user.vo.UserVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserTourApiController {

	@Autowired
	private UserTourService userTourService;

	@Autowired
	private CountriesAndCitiesService countriesAndCitiesService;

	@Autowired
	private FavoriteService favoriteService;

	@Autowired
	private TourApplyService tourApplyService;

	/** 클라이언트가 등록한 가이드 구인 게시글 목록 조회 페이지 **/
	@GetMapping("/usertour/list")
	public ApiResponse getAllUserTours(SearchUserTourVO searchUserTourVO) {
		UserTourListVO userTourListVO = this.userTourService.getAllUserTour(searchUserTourVO);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(userTourListVO.getUserTourList());

		return apiResponse;
	}

	@GetMapping("/usertour/count")
	public ApiResponse getAllUserTourCount(SearchUserTourVO searchUserTourVO) {
		UserTourListVO userTourListVO = this.userTourService.getAllUserTour(searchUserTourVO);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(userTourListVO.getUserTourCount());

		return apiResponse;
	}

	/** 클라이언트가 등록한 가이드 구인 게시글 상세 조회 페이지 **/
	@GetMapping("/usertour/view/{usrTrPstId}")
	public ApiResponse getOneUserTour(@PathVariable String usrTrPstId) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);

		return new ApiResponse(userTourVO);
	}

	/** 클라이언트가 작성 가이드 구인 게시글을 받아와서 DB에 저장하는 페이지 **/
	@PostMapping("/usertour/insert")
	public ApiResponse doCreateNewUserTour(@RequestBody @Valid UserTourWriteVO userTourWriteVO,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> fieldErrors = bindingResult.getFieldErrors().stream()
					.map(fieldError -> fieldError.getDefaultMessage()).toList();
			ApiResponse errorResponse = new ApiResponse(HttpStatus.BAD_REQUEST);
			errorResponse.setErrors(fieldErrors);

			return errorResponse;
		}
		boolean isCreate = this.userTourService.createNewUserTour(userTourWriteVO);

		return new ApiResponse(isCreate);
	}

	@PostMapping("/usertour/modify")
	public ApiResponse doUserTourModify(@RequestBody @Valid UserTourModifyVO userTourModifyVO, BindingResult bindingResult) {
		
		boolean isModified = this.userTourService.modifyUserTour(userTourModifyVO);

		return new ApiResponse(isModified);
	}
	
	@GetMapping("/usertour/delete/{usrTrPstId}")
	public ApiResponse doDeleteUserTour(@PathVariable String usrTrPstId, Authentication authentication) {
		
		UserVO userVO = extractUserVO(authentication);
		
		if (userVO == null) {
			return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
		}
		
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);
		
		if (!userTourVO.getAthrId().equals(userVO.getUsrLgnId())) {
			return new ApiResponse(HttpStatus.BAD_REQUEST, "권한이 부족합니다.");
		}
		
		boolean isDeleted = this.userTourService.softDeleteUserTour(usrTrPstId);
		
		return new ApiResponse(isDeleted);
	}
	
	@PostMapping("/request/insert")
	public ApiResponse doCreateNewRequstTour(@RequestBody @Valid UserTourWriteVO userTourWriteVO,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> fieldErrors = bindingResult.getFieldErrors().stream()
					.map(fieldError -> fieldError.getDefaultMessage()).toList();
			ApiResponse errorResponse = new ApiResponse(HttpStatus.BAD_REQUEST);
			errorResponse.setErrors(fieldErrors);

			return errorResponse;
		}
		boolean isCreate = this.userTourService.createNewRequestTour(userTourWriteVO);
		return new ApiResponse(isCreate);
	}

	@PostMapping("/request/apply/insert")
	public ApiResponse doCreateNewTourGuideApply(@RequestBody @Valid RequestGuideApplyWriteVO requestGuideApplyWriteVO,
			BindingResult result) {
		if (result.hasErrors()) {
			List<String> fieldErrors = result.getFieldErrors().stream()
					.map(fieldError -> fieldError.getDefaultMessage()).toList();
			ApiResponse errorResponse = new ApiResponse(HttpStatus.BAD_REQUEST);
			errorResponse.setErrors(fieldErrors);
			return errorResponse;
		}
		boolean isCreate = this.userTourService.createNewRequestGuideApply(requestGuideApplyWriteVO);

		return new ApiResponse(isCreate);
	}

	@GetMapping("/tour/regions")
	public ApiResponse getAllRegions() {
		RegionsListVO regions = this.countriesAndCitiesService.getAllRegions();

		return new ApiResponse(regions);
	}

	@GetMapping("/tour/countries/{regionId}")
	public ApiResponse getCountries(@PathVariable int regionId) {
		CountriesListVO countries = this.countriesAndCitiesService.getCountries(regionId);

		return new ApiResponse(countries);
	}

	@GetMapping("/tour/cities/{countryId}")
	public ApiResponse getCities(@PathVariable int countryId) {
		CitiesListVO cities = this.countriesAndCitiesService.getCities(countryId);

		return new ApiResponse(cities);
	}

	@GetMapping("/favorite/{pstId}")
	public ApiResponse getAllFavorite(@PathVariable String pstId) {
		FavoriteListVO favoriteListVO = this.favoriteService.getAllFavoriteList(pstId);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(favoriteListVO.getFavoriteList());

		return apiResponse;
	}

	@PostMapping("/favorite/create")
	public ApiResponse doCreateNewUserTourFavorite(@RequestBody FavoriteWriteVO favoriteWriteVO) {
		boolean isCreated = this.favoriteService.createNewUserTourFavorite(favoriteWriteVO);

		return new ApiResponse(isCreated);
	}

	@GetMapping("/favorite/delete/{usrPstId}/{usrLgnId}")
	public ApiResponse doDeleteUserTourFavorite(@PathVariable String usrPstId, @PathVariable String usrLgnId) {
		boolean isDeleted = this.favoriteService.deleteUserTourFavorite(usrPstId, usrLgnId);

		return new ApiResponse(isDeleted);
	}

	@GetMapping("/usertour/getLateUserTour")
	public ApiResponse doGetLateUserTour() {
		UserTourVO userTourVO = this.userTourService.getLateUserTour();

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(userTourVO);

		return apiResponse;
	}

	@GetMapping("/tourApply/detail/{gdApplyId}")
	public ApiResponse viewTourApply(@PathVariable String gdApplyId, Authentication authentication) {
		UserVO userVO = extractUserVO(authentication);
		if (userVO == null) {
			return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
		}
		
		TourApplyVO tourApplyVO = this.tourApplyService.getOneTourApply(gdApplyId);

		String athrUserId = tourApplyVO.getUserTourVO().getAthrId();
		String gdId = tourApplyVO.getGdId();
		// 만약 로그인 한 유저가 해당 게시글의 작성자가 아니고 게시글 계획을 작성한 가이드가 아닌 경우
		if (!athrUserId.equals(userVO.getUsrLgnId()) && !gdId.equals(userVO.getUsrLgnId())) {
			return new ApiResponse(HttpStatus.BAD_REQUEST, "해당 게시글의 작성자가 아닙니다!");
		}

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(tourApplyVO);

		return apiResponse;
	}

	private UserVO extractUserVO(Authentication authentication) {
		if (authentication == null || authentication.getPrincipal() == null) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserVO user) {
			return user;
		}
		return null;
	}

}
