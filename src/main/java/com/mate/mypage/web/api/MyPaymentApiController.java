package com.mate.mypage.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.vo.ApiResponse;
import com.mate.payment.service.PaymentService;
import com.mate.payment.vo.PaymentListVO;
import com.mate.payment.vo.SearchPaymentVO;

@RestController
@RequestMapping("/api/v1")
public class MyPaymentApiController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payment/list")
    public ApiResponse viewPaymentList(@ModelAttribute SearchPaymentVO searchPaymentVO) {
		
		PaymentListVO paymentListVO = this.paymentService.getAllMyPayment(searchPaymentVO);
		return new ApiResponse(paymentListVO);
	}
	

}
