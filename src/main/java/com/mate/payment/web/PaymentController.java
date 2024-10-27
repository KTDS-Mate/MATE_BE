package com.mate.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mate.payment.service.PaymentService;
import com.mate.payment.service.PortOneService;

@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PortOneService portOneService;
	
	
	
	
	@GetMapping
	@ResponseBody
	public String getAcessToken() {
		return null;	// TODO 수정
	}
	
	@GetMapping("/payment/detail")
	public String viewPaymentInfo() {
//		PaymentListVO paymentListVO = this.paymentService.getAllMyPayment(id);
//		model.addAttribute("paymentListVO", paymentListVO);
//		return "mypage/Payment/list";
		return "payment/PaymentDetail";
	}
	
//	@GetMapping("get")
//	public String getAccessToken() {
//		
//		
//	}
	
	
}
