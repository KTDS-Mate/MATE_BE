package com.mate.payment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.payment.dao.PaymentDao;
import com.mate.payment.service.PaymentService;
import com.mate.payment.vo.PaymentListVO;
import com.mate.payment.vo.PaymentVO;
import com.mate.payment.vo.SearchPaymentVO;

@Service
public class PaymentServiceImpl implements PaymentService {

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
	public PaymentListVO getAllMyPayment(SearchPaymentVO searchPaymentVO) {
		PaymentListVO paymentListVO = new PaymentListVO();
    	String lgnId = searchPaymentVO.getTrstLgnId();
    	String usrId = this.paymentDao.selectUserId(lgnId);
    	searchPaymentVO.setTrstId(usrId);
		int cnt = this.paymentDao.selectAllMyPaymentCount(searchPaymentVO);
		paymentListVO.setPaymentCnt(cnt);
		if (cnt == 0) {
			paymentListVO.setPaymentList(new ArrayList<>());
			return paymentListVO;
		}
		// 조회된 항목의 갯수 설정
		searchPaymentVO.setPageCount(cnt);
		
		List<PaymentVO> paymentList = this.paymentDao.selectAllMyPayment(searchPaymentVO);
		paymentListVO.setPaymentList(paymentList);
		
		return paymentListVO;
	}
	
	@Override
	public PaymentVO getPaymentDetail(String payId) {
		return this.paymentDao.selectOnePayment(payId);
	}
	
	@Override
	public String getUsrId(String trstLgnId) {
		return this.paymentDao.selectUserId(trstLgnId);
	}
	
	@Override
	public double getPayAmount(String payId) {
		return this.paymentDao.selectOnePaymentAmount(payId);
	}
	
	@Transactional
	@Override
	public boolean successPayment(PaymentVO paymentVO) {
		int updateCnt = this.paymentDao.updateSuccessPayment(paymentVO);
		return updateCnt > 0;
	}
	
	@Transactional
	@Override
	public boolean refundPayment(String payId) {
		int updateCnt = this.paymentDao.updateRefundPayment(payId);
		return updateCnt > 0;
	}
	
	@Override
	public PaymentListVO getSearchMyPayment(SearchPaymentVO searchPaymentVO) {
		PaymentListVO paymentListVO = new PaymentListVO();
		int cnt = this.paymentDao.selectSearchMyPaymentCount(searchPaymentVO);
		paymentListVO.setPaymentCnt(cnt);
		if (cnt == 0 ) {
			return paymentListVO;
		}
		List<PaymentVO> paymentList = this.paymentDao.selectSearchMyPayment(searchPaymentVO);
		paymentListVO.setPaymentList(paymentList);
		return paymentListVO;
	}
	
	
	
	
}
