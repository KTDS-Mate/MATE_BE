package com.mate.mypage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mate.payment.service.PaymentService;
import com.mate.payment.vo.PaymentListVO;
import com.mate.payment.vo.PaymentVO;
import com.mate.payment.vo.SearchPaymentVO;

@Controller
@RequestMapping("/mypage/payment")
public class MyPaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
    @GetMapping("/list/{trstLgnId}")
    public String viewPaymentList(Model model, @PathVariable String trstLgnId, SearchPaymentVO searchPaymentVO) {
		// 회원VO는 세션으로 받아와야 하지만, 일단 PathVariable로 받아옴
		// TODO 세션 추가 되면 그걸 받아와서 유저 정보 끼워서 만들기
    	searchPaymentVO.setTrstId(trstLgnId);
		PaymentListVO paymentListVO = this.paymentService.getAllMyPayment(searchPaymentVO);
		model.addAttribute("paymentListVO", paymentListVO);
        model.addAttribute("searchPaymentVO", searchPaymentVO);
		return "mypage/PaymentList";
	}
	
    // 원래는 ajax로 결제 내역을 가져올 생각이였으나, 페이지네이션으로 인해서 폐기 결정! (보기 좋아졌잖아 한잔해~)
	@ResponseBody
	@GetMapping("/periodSearch")
	public List<PaymentVO> searchPayment(@ModelAttribute SearchPaymentVO searchPaymentVO){
		return this.paymentService.getAllMyPayment(searchPaymentVO).getPaymentList();
//		return this.paymentService.getSearchMyPayment(searchPaymentVO).getPaymentList();
	}
	
	
	
}
