package com.mate.payment.web;

import java.util.HashMap;
import java.util.Map;

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
	
	@ResponseBody
	@GetMapping("/getAccessToken")
	public String getAccessToken() {
		String result = this.portOneService.getAccessToken();
		System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@GetMapping("/verifyPayment")
	public Boolean verifyPayment(@RequestParam("payId") String payId,
								 @RequestParam("amount") double amount)  {
		double payAmount = this.paymentService.getPayAmount(payId);
		if (amount == payAmount) {
			return true; 
		}
		return false;
	}
	
	@ResponseBody
	@PostMapping("/successPayment")
	public String successPayment(@RequestParam("payId") String payId, @RequestParam("imp_uid") String impUid,
			 					 @RequestParam("imp_mid") String impMid, @RequestParam("pay_mthd") String payMthd) {
		System.out.println("여기까지는 오나?");
		PaymentVO paymentVO = new PaymentVO();
		paymentVO.setPayId(payId);
		paymentVO.setImpUid(impUid);
		paymentVO.setImpMid(impMid);
		paymentVO.setPayMthd(payMthd);
		if (this.paymentService.successPayment(paymentVO) == true) {
			System.out.println("업데이트 성공");
			return "성공";
		}
		
		return "실패";
		
		
	}
	
	
	@PostMapping("/cancelPayment")
	public Map<String, Object> cancelPayment(@RequestParam("imp_uid") String impUid, @RequestParam("reason") String reason){
		Map<String, Object> response = new HashMap<> ();
		
		try {
			
			
			response.put("success", "true");
			response.put("msg", "결제 취소에 성공하였습니다.");
			
		}catch (Exception e) {
			
		}
		
		
		return null;
		
	}
	
	
	
	
	
	
}
