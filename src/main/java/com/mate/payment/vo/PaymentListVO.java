package com.mate.payment.vo;

import java.util.List;

public class PaymentListVO {
	
	private int PaymentCnt;
	
	private SearchPaymentVO searchVO;
	
	
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

	public SearchPaymentVO getSearchVO() {
		return searchVO;
	}

	public void setSearchVO(SearchPaymentVO searchVO) {
		this.searchVO = searchVO;
	}

}
