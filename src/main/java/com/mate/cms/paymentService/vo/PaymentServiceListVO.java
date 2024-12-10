package com.mate.cms.paymentService.vo;

import java.util.List;

public class PaymentServiceListVO {

	private int paymentServiceCount;

	private List<PaymentServiceVO> paymentServiceList;

	public int getPaymentServiceCount() {
		return paymentServiceCount;
	}

	public void setPaymentServiceCount(int paymentServiceCount) {
		this.paymentServiceCount = paymentServiceCount;
	}

	public List<PaymentServiceVO> getPaymentServiceList() {
		return paymentServiceList;
	}

	public void setPaymentServiceList(List<PaymentServiceVO> paymentServiceList) {
		this.paymentServiceList = paymentServiceList;
	}

}
