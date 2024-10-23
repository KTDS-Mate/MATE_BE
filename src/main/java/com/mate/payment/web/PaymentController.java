package com.mate.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mate.payment.service.PaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/mypage/payment")
	public String viewPaymentInfo() {
		
		
		return "mypage/MyPageLayout_PaymentDetails";
	}
	
	
}
