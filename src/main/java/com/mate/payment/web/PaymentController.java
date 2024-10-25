package com.mate.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mate.payment.service.PaymentService;
import com.mate.payment.vo.PaymentListVO;

@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/mypage/payment/{id}")
	public String viewPaymentInfo(Model model, @PathVariable String id) {
		// 회원VO는 세션으로 받아와야 하지만, 일단 PathVariable로 받아옴
		// TODO 세션 추가 되면 그걸 받아와서 유저 정보 끼워서 만들기
		PaymentListVO paymentListVO = this.paymentService.getAllMyPayment(id);
		model.addAttribute("paymentListVO", paymentListVO);
		return "mypage/MyPageLayout_PaymentDetails";
	}
	
	
}
