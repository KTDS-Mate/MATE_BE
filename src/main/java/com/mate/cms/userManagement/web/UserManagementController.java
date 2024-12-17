package com.mate.cms.userManagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mate.cms.customerService.vo.SearchCustomerServiceVO;
import com.mate.cms.userManagement.service.UserManagementService;
import com.mate.cms.userManagement.vo.UserManagementListVO;
import com.mate.common.vo.ApiResponse;


@RestController
@RequestMapping("/api/v1")
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;
	
	@GetMapping("/usermanagement/list")
	public ApiResponse doGetAllUsers() {
		
		UserManagementListVO userManagementListVO = this.userManagementService.getAllUserManagerment();
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(userManagementListVO.getUserManagementList());
		
		return apiResponse;
	}
	
	@GetMapping("/usermanagement/waiting/list")
	public ApiResponse doGetWaitingGuideUsers(SearchCustomerServiceVO searchCustomerServiceVO) {
		UserManagementListVO userManagementListVO = this.userManagementService.getWaitingGuideUsers(searchCustomerServiceVO);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(userManagementListVO.getUserManagementList());
		
		return apiResponse;
	}
	
	@ResponseBody
	@PostMapping("/usermanagement/aceptguide/{usrId}")
	public ApiResponse doAceptGuideApprove(@PathVariable String usrId) {
		try {
//			this.userManagementService.as
			System.out.println("asdf");
		} catch(Exception e) {
			return new ApiResponse(e.getMessage());
		}
		
		return new ApiResponse("수락하였습니다.");
	}
	
}
