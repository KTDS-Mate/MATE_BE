package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ResponseBody
	@GetMapping("/mypage/payment/list")
    public ApiResponse viewPaymentList(@RequestBody SearchPaymentVO searchPaymentVO) {
		// 회원VO는 세션으로 받아와야 하지만, 일단 PathVariable로 받아옴
		// TODO 세션 추가 되면 그걸 받아와서 유저 정보 끼워서 만들기
		PaymentListVO paymentListVO = this.paymentService.getAllMyPayment(searchPaymentVO);
		return new ApiResponse(paymentListVO);
	}
	

}
