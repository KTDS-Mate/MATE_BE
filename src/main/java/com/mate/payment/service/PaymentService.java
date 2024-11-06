package com.mate.payment.service;

import com.mate.payment.vo.PaymentListVO;
import com.mate.payment.vo.PaymentVO;
import com.mate.payment.vo.SearchPaymentVO;

public interface PaymentService {
	
	public PaymentListVO getAllPayment();
	
	public PaymentListVO getAllMyPayment(SearchPaymentVO searchPaymentVO);
	
	public PaymentVO getPaymentDetail(String payId);
	
	public double getPayAmount(String payId);
	
	public boolean successPayment(PaymentVO paymentVO);
	
	public boolean refundPayment(String payId);
	
	public PaymentListVO getSearchMyPayment(SearchPaymentVO searchPaymentVO);
	
	public String getUsrId(String trstLgnId);
}
