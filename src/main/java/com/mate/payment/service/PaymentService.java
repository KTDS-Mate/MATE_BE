package com.mate.payment.service;

import com.mate.payment.vo.PaymentListVO;
import com.mate.payment.vo.PaymentVO;

public interface PaymentService {
	
	public PaymentListVO getAllPayment();
	
	public PaymentListVO getAllMyPayment(String trstId);
	
	public PaymentVO getPaymentDetail(String payId);
	
	public double getPayAmount(String payId);
	
	public boolean successPayment(PaymentVO paymentVO);
	
	public boolean refundPayment(String payId);
	
}
