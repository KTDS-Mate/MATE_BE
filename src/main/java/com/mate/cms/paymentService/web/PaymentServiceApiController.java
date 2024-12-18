package com.mate.cms.paymentService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.cms.paymentService.service.PaymentServiceService;
import com.mate.cms.paymentService.vo.PaymentServiceListVO;
import com.mate.cms.paymentService.vo.PaymentServiceUpdateVO;
import com.mate.cms.paymentService.vo.SearchPaymentServiceVO;
import com.mate.common.vo.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class PaymentServiceApiController {

	@Autowired
	private PaymentServiceService paymentServiceService;

	@GetMapping("/paymentservice/list")
	public ApiResponse doGetAllPaymentService(SearchPaymentServiceVO searchPaymentServiceVO) {
		PaymentServiceListVO paymentServiceListVO = this.paymentServiceService.getPaymentServiceList(searchPaymentServiceVO);
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(paymentServiceListVO.getPaymentServiceList());
		
		return apiResponse;
	}

	@PostMapping("/paymentservice/update")
	public ApiResponse doUpdatePaymentStts(@RequestBody PaymentServiceUpdateVO paymentServiceUpdateVO) {
		boolean isUpdated = this.paymentServiceService.updatePaymentServiceStts(paymentServiceUpdateVO);
		
		return new ApiResponse(isUpdated);
	}
	
}
