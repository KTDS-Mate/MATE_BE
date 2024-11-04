package com.mate.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mate.payment.service.PaymentService;
import com.mate.payment.service.PortOneService;
import com.mate.payment.vo.PaymentVO;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

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
		
		if(paymentVO != null && paymentVO.getTrstId().equals(usrId)) {
			model.addAttribute("paymentVO", paymentVO);
			return "payment/PaymentDetail";
		}
		return "mypage/payment/list/" + usrId;
	}
	
	// 토큰 발급
	@ResponseBody
	@PostMapping("/getAccessToken")
	public IamportResponse<AccessToken> getAccessToken() {
		return this.portOneService.getAccessToken();
	}
	
	@ResponseBody
	@GetMapping("/verifyPayment")
	public Boolean verifyPayment(@RequestParam String payId,
								 @RequestParam double amount)  {
		double payAmount = this.paymentService.getPayAmount(payId);
		if (amount == payAmount) {
			return true; 
		}
		return false;
	}
	
	@ResponseBody
	@PostMapping("/successPayment")
	public boolean successPayment(@RequestParam String payId, @RequestParam String impUid,
			 					 @RequestParam String impMid, @RequestParam String payMthd) {
		PaymentVO paymentVO = new PaymentVO();
		paymentVO.setPayId(payId);
		paymentVO.setImpUid(impUid);
		paymentVO.setImpMid(impMid);
		paymentVO.setPayMthd(payMthd);
		
		return this.paymentService.successPayment(paymentVO);
	}
	
	@ResponseBody
	@PostMapping("/cancelPayment")
	public IamportResponse<Payment> cancelPayment(@RequestParam String impUid, @RequestParam String reason){
		return this.portOneService.cancelPayment(impUid, reason);
	}
	
	
	/**
	 * 환불
	 * @return
	 */
	@ResponseBody
	@PostMapping("/refundPayment")
	public boolean refundPayment(@RequestParam String payId) {
		return this.paymentService.refundPayment(payId);
	}
	
	
	
	
	
	
}
