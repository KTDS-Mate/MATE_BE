package com.mate.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mate.payment.service.PaymentService;
import com.mate.payment.service.PortOneService;

@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PortOneService portOneService;
	
	@GetMapping("/payment/detail")
	public String viewPaymentInfo() {
//		PaymentListVO paymentListVO = this.paymentService.getAllMyPayment(id);
//		model.addAttribute("paymentListVO", paymentListVO);
//		return "mypage/Payment/list";
		return "payment/PaymentDetail";
	}
	
	@GetMapping("/getAccessToken")
	@ResponseBody
	public String getAccessToken() {
		String result = this.portOneService.getAccessToken();
		System.out.println(result);
		return result;
	}
	
}
