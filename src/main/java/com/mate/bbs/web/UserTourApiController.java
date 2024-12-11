package com.mate.bbs.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourImgListVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;
import com.mate.common.vo.ApiResponse;
import com.mate.user.vo.UserVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserTourApiController {

	@Autowired
	private UserTourService userTourService;
	
	/** 클라이언트가 등록한 가이드 구인 게시글 목록 조회 페이지 **/
	@GetMapping("/usertour/list")
	public ApiResponse viewAllUserTourPage(SearchUserTourVO searchUserTourVO) {
		UserTourListVO userTourListVO = this.userTourService.getAllUserTour(searchUserTourVO);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(userTourListVO.getUserTourList());

		return apiResponse;
	}
	
	/** 클라이언트가 등록한 가이드 구인 게시글 상세 조회 페이지 **/
	@GetMapping("/usertour/view/{usrTrPstId}")
	public ApiResponse viewOneUserTourPage(@PathVariable String usrTrPstId) {
		UserTourVO userTourVO = this.userTourService.getOneUserTour(usrTrPstId);
		
		return new ApiResponse(userTourVO);
	}
	
	/** 클라이언트가 작성 가이드 구인 게시글을 받아와서 DB에 저장하는 페이지 **/
	@PostMapping("/usertour/insert")
	public ApiResponse doCreateNewUserTour(@RequestBody @Valid UserTourWriteVO userTourWriteVO,
			                               BindingResult bindingResult, 
			                               @SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		if (bindingResult.hasErrors()) {
			List<String> fieldErrors = bindingResult.getFieldErrors()
													.stream()
													.map( fieldError -> fieldError.getDefaultMessage() )
													.toList();
			ApiResponse errorResponse = new ApiResponse(HttpStatus.BAD_REQUEST);
			errorResponse.setErrors(fieldErrors);
			
			return errorResponse;
		}
//		userTourWriteVO.setAthrId(loginUserVO.getUsrLgnId());

		boolean isCreate = this.userTourService.createNewUserTour(userTourWriteVO);

		return new ApiResponse(isCreate);
	}

	@GetMapping("/usertour/imgs/{usrTrPstId}")
	public ApiResponse getUserTourImgs(@PathVariable String usrTrPstId) {
		UserTourImgListVO userTourImgs = this.userTourService.getUserTourImgs(usrTrPstId);
		
		return new ApiResponse(userTourImgs);
	}
	
}
