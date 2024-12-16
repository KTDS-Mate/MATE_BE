package com.mate.cms.customerService.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.cms.customerService.service.CustomerServiceService;
import com.mate.cms.customerService.vo.CustomerServiceAnswerVO;
import com.mate.cms.customerService.vo.CustomerServiceListVO;
import com.mate.cms.customerService.vo.CustomerServiceWriteVO;
import com.mate.cms.customerService.vo.SearchCustomerServiceVO;
import com.mate.common.vo.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CustomerServiceApiController {

	@Autowired
	private CustomerServiceService customerServiceService;

	// 1대1 문의 작성
	@PostMapping("/cutomerservice/insert")
	public ApiResponse doCreateNewCustomerService(@RequestBody @Valid CustomerServiceWriteVO customerServiceWriteVO,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> fieldErrors = bindingResult.getFieldErrors().stream()
					.map(fieldError -> fieldError.getDefaultMessage()).toList();
			ApiResponse errorResponse = new ApiResponse(HttpStatus.BAD_REQUEST);
			errorResponse.setErrors(fieldErrors);

		}
		boolean isCreate = this.customerServiceService.createNewCustomerService(customerServiceWriteVO);
		
		return new ApiResponse(isCreate);
	}
	
	@GetMapping("/customerservice/list/{usrLgnId}")
	public ApiResponse doGetCustomerService(@PathVariable String usrLgnId, SearchCustomerServiceVO searchCustomerServiceVO) {
		CustomerServiceListVO customerServiceListVO = customerServiceService.getCustomerServiceList(usrLgnId, searchCustomerServiceVO);
		
		ApiResponse apiResponse = new ApiResponse();
		
		apiResponse.setBody(customerServiceListVO);
		
		return apiResponse;
	}

	@PostMapping("/customerservice/update/{cstmrSrvcCntrId}")
	public ApiResponse doAnswerCustomerService(@PathVariable String cstmrSrvcCntrId,
											   @RequestBody CustomerServiceAnswerVO customerServiceAnswerVO) {
		customerServiceAnswerVO.setCstmrSrvcCntrId(cstmrSrvcCntrId);
		boolean isUpdated = this.customerServiceService.updateCustomerService(customerServiceAnswerVO);
		return new ApiResponse(isUpdated);
	}
	
	@GetMapping("/customerservice/delete/{cstmrSrvcCntrId}")
	public ApiResponse doSoftDeleteCustomerService(@PathVariable String cstmrSrvcCntrId) {
		boolean isDeleted = this.customerServiceService.softDeleteCustomerService(cstmrSrvcCntrId);
		return new ApiResponse(isDeleted);
	}
	
}
