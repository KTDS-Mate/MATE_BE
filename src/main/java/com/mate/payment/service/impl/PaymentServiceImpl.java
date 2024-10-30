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
	
	@Override
	public PaymentListVO getAllMyPayment(String trstId) {
		PaymentListVO paymentListVO = new PaymentListVO();
		List<PaymentVO> paymentList = this.paymentDao.selectAllMyPayment(trstId);
		int cnt = this.paymentDao.selectAllMyPaymentCount(trstId);
		paymentListVO.setPaymentCnt(cnt);
		paymentListVO.setPaymentList(paymentList);
		return paymentListVO;
	}
	
	@Override
	public PaymentVO getPaymentDetail(String payId) {
		return this.paymentDao.selectOnePayment(payId);
	}
	
	@Override
	public double getPayAmount(String payId) {
		return this.paymentDao.selectOnePaymentAmount(payId);
	}
	
	@Override
	public boolean successPayment(PaymentVO paymentVO) {
		int updateCnt = this.paymentDao.updateSuccessPayment(paymentVO);
		return updateCnt > 0;
	}
	
	
	
	
	
}
