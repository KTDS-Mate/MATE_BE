package com.mate.cms.userManagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mate.cms.userManagement.service.UserManagementService;
import com.mate.cms.userManagement.vo.SearchUserManagementVO;
import com.mate.cms.userManagement.vo.UserManagementListVO;
import com.mate.common.vo.ApiResponse;


@RestController
@RequestMapping("/api/v1")
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;
	
	@GetMapping("/usermanagement/list/{filter}")
	public ApiResponse doGetAllUsers(@PathVariable String filter) {
		UserManagementListVO userManagementListVO = this.userManagementService.getAllUserManagerment(filter);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(userManagementListVO.getUserManagementList());
		
		return apiResponse;
	}
	
	@GetMapping("/usermanagement/waiting/list")
	public ApiResponse doGetWaitingGuideUsers(SearchUserManagementVO searchUserManagementVO) {
		UserManagementListVO userManagementListVO = this.userManagementService.getWaitingGuideUsers(searchUserManagementVO);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(userManagementListVO);
		
		return apiResponse;
	}
	
	@ResponseBody
	@PostMapping("/usermanagement/acceptguide/{usrId}")
	public ApiResponse doAceptGuideApprove(@PathVariable String usrId) {
		try {
			this.userManagementService.doAcceptGuideApprove(usrId);
		} catch(Exception e) {
			return new ApiResponse(e.getMessage());
		}
		
		return new ApiResponse(true);
	}
	
	@ResponseBody
	@PostMapping("/usermanagement/refuseguide/{usrId}")
	public ApiResponse doRefuseGuideApprove(@PathVariable String usrId) {
		try {
			this.userManagementService.doRefuseGuideApprove(usrId);
		} catch(Exception e) {
			return new ApiResponse(e.getMessage());
		}
		return new ApiResponse(true);
	}
	
	@ResponseBody
	@PostMapping("/usermanagement/deleteUser/{usrId}/{usrIsCl}")
	public ApiResponse doDeleteUser(@PathVariable String usrId, @PathVariable String usrIsCl) {
		try {
			this.userManagementService.doDeleteUser(usrId, usrIsCl);
		} catch(Exception e) {
			return new ApiResponse(e.getMessage());
		}
		return new ApiResponse(true);
	}
	
	@ResponseBody
	@PostMapping("/usermanagement/blockUser/{usrId}/{usrIsBlck}")
	public ApiResponse doBlockeUser(@PathVariable String usrId, @PathVariable String usrIsBlck) {
		try {
			this.userManagementService.doBlockUser(usrId, usrIsBlck);
		} catch(Exception e) {
			return new ApiResponse(e.getMessage());
		}
		return new ApiResponse(true);
	}
	
	
	
	
}
