package com.mate.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mate.payment.service.PaymentService;
import com.mate.payment.service.PortOneService;
import com.mate.payment.vo.PaymentVO;

@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PortOneService portOneService;
	
	@GetMapping("/payment/detail")
	public String viewOrderInfo(@RequestParam String usrId
							  , @RequestParam String payId, Model model) {
		PaymentVO paymentVO = this.paymentService.getPaymentDetail(payId);
		if(paymentVO.getTrstId().equals(usrId)) {	// 결제 내역 소유자 확인
			model.addAttribute("paymentVO", paymentVO);
			return "payment/PaymentDetail";
		}
		return "mypage/payment/list/" + usrId;
	}
	
	@ResponseBody
	@GetMapping("/getAccessToken")
	public String getAccessToken() {
		String result = this.portOneService.getAccessToken();
		System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@GetMapping("/verifyPayment")
	public Boolean verifyPayment(@RequestParam("payId") String payId, @RequestParam("amount") double amount)  {
		double payAmount = this.paymentService.getPayAmount(payId);
		if (amount == payAmount) {
			return true; 
		}
		return false;
	}
	
	@PostMapping("/prepare")
	public void preparePayment(@RequestBody PrePaymentEntity request) {
		int sum = 5;
	}
	
	
	
	
	
	
}
