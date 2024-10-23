package com.mate.payment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.payment.dao.PaymentDao;
import com.mate.payment.service.PaymentService;
import com.mate.payment.vo.PaymentListVO;
import com.mate.payment.vo.PaymentVO;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	public PaymentListVO getAllPayment() {
		PaymentListVO paymentListVO = new PaymentListVO();
		List<PaymentVO> paymentList = this.paymentDao.selectAllPayment(); 
		int cnt = this.paymentDao.selectAllPaymentCount();
		paymentListVO.setPaymentCnt(cnt);
		paymentListVO.setPaymentList(paymentList);
		return paymentListVO;
	}
	
	
	
	
}
