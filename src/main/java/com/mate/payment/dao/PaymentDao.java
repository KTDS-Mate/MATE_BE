package com.mate.payment.dao;

import java.util.List;

import com.mate.payment.vo.PaymentVO;

public interface PaymentDao {
	
	public String NAMESPACE = "com.mate.payment.dao.PaymentDao";
	
	public int selectAllPaymentCount();
	
	public List<PaymentVO> selectAllPayment();
	
	
}
