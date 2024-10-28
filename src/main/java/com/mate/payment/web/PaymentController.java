package com.mate.payment.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mate.payment.service.PaymentService;
import com.mate.payment.service.PortOneService;
import com.mate.payment.vo.PaymentVO;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import jakarta.servlet.http.HttpSession;

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
		if(paymentVO.getTrstId().equals(usrId)) {
			model.addAttribute("paymentVO", paymentVO);
			return "payment/PaymentDetail";
		}
		return "mypage/payment/list/" + usrId;
	}
	
	@GetMapping("/getAccessToken")
	@ResponseBody
	public String getAccessToken() {
		String result = this.portOneService.getAccessToken();
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/getImp_uid")
	
	@ResponseBody
	@RequestMapping(value="/verifyiamport/{impUid}", method = RequestMethod.POST)
	public IamportResponse<Payment> patmentByImpUid(Model model, Locale locale, HttpSession session
			, @PathVariable(value=" impUid")String impUid) {	
		return this.portOneService.verifyIamport(impUid);
	}
	
	
	
	
	
	
}
