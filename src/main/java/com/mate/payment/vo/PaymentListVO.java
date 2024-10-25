package com.mate.payment.vo;

import java.util.List;

public class PaymentListVO {
	
	private int PaymentCnt;
	
	private List<PaymentVO> paymentList;

	public int getPaymentCnt() {
		return PaymentCnt;
	}

	public void setPaymentCnt(int paymentCnt) {
		PaymentCnt = paymentCnt;
	}

	public List<PaymentVO> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<PaymentVO> paymentList) {
		this.paymentList = paymentList;
	}

	
	
}
