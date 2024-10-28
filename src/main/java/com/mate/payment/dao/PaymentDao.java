package com.mate.payment.dao;

import java.util.List;

import com.mate.payment.vo.PaymentVO;

public interface PaymentDao {
	
	public String NAMESPACE = "com.mate.payment.dao.PaymentDao";
	
	public int selectAllPaymentCount();
	
	public List<PaymentVO> selectAllPayment();
	
	public List<PaymentVO> selectAllMyPayment(String trstId);
	
	public int selectAllMyPaymentCount(String trstId);
	
	public PaymentVO selectOnePayment(String trstId, String trId);
	
	
	
	
	
	
}
