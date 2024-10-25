package com.mate.payment.service;

import com.mate.payment.vo.PaymentListVO;

public interface PaymentService {
	
	public PaymentListVO getAllPayment();
	
	public PaymentListVO getAllMyPayment(String trstId);
	
	
}
