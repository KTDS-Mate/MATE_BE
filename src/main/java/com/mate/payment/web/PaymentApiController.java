package com.mate.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.vo.ApiResponse;
import com.mate.payment.service.PaymentService;
import com.mate.payment.service.PortOneService;
import com.mate.payment.vo.PaymentVO;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@RestController
@RequestMapping("/api/v1")
public class PaymentApiController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PortOneService portOneService;

	@ResponseBody
	@GetMapping("/payment/detail/{payId}")
	public ApiResponse viewOrderInfo(@PathVariable String payId) {
		PaymentVO paymentVO = this.paymentService.getPaymentDetail(payId);
		return new ApiResponse(paymentVO);
	}
	
	// 토큰 발급
	@ResponseBody
	@GetMapping("/getAccessToken")
	public IamportResponse<AccessToken> getAccessToken() {
		return this.portOneService.getAccessToken();
	}
	
	@ResponseBody
	@GetMapping("/verifyPayment")
	public ApiResponse verifyPayment(@RequestParam String payId,
								 @RequestParam double amount)  {
		double payAmount = this.paymentService.getPayAmount(payId);
		return new ApiResponse(amount == payAmount);
	}
	
	@ResponseBody
	@PostMapping("/successPayment")
	public ApiResponse successPayment(@RequestBody PaymentVO paymentVO) {
//		paymentVO.setPayId(payId);
//		paymentVO.setImpUid(impUid);
//		paymentVO.setImpMid(impMid);
//		paymentVO.setPayMthd(payMthd);
		return new ApiResponse(this.paymentService.successPayment(paymentVO));
	}
	
	@ResponseBody
	@PostMapping("/cancelPayment")
	public IamportResponse<Payment> cancelPayment(@RequestParam String impUid, @RequestBody String reason){
		return this.portOneService.cancelPayment(impUid, reason);
	}
	
	
	/**
	 * 환불
	 * @return
	 */
	@ResponseBody
	@PostMapping("/refundPayment")
	public ApiResponse refundPayment(@RequestParam String payId) {
		try {
			this.paymentService.refundPayment(payId);
			
		} catch (Exception e) {
			return new ApiResponse(e.getMessage());
		}
		return new ApiResponse("환불처리 성공");
	}
	
	
}
