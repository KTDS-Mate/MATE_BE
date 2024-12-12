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
		int cnt = this.paymentDao.selectAllMyPaymentCount(searchPaymentVO);
		paymentListVO.setPaymentCnt(cnt);
		if (cnt == 0) {
			paymentListVO.setPaymentList(new ArrayList<>());
			return paymentListVO;
		}
		// 조회된 항목의 페이지 수 설정
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
	public boolean refundPayment(String payId) throws Exception {
		if (this.paymentDao.updateRefundPayment(payId) != 1) {
			throw new Exception("결제 내역 업데이트 실패");
		}
		PaymentVO paymentVO = this.paymentDao.selectOnePayment(payId);
		System.out.println(paymentVO);
		if (paymentVO.getPayTrTp().equals("TOURIST")) {
			// 투어리스트 투어인경우 (해주세요나 계획있는 여행)
			if (this.paymentDao.updateCancelTrstTour(paymentVO) != 1) {
				System.out.println("여기서 오류가 발생1");
				throw new Exception("유저 투어정보 업데이트 실패");
			}
			// 해주세요 테이블에 지원 기록이 있는 경우.(해당 프로젝트로 진행중임.)
			if (this.paymentDao.selectApplyCnt(paymentVO) == 1) {
				if (this.paymentDao.updateCancelApply(paymentVO) != 1) {
					System.out.println("여기서 오류가 발생2");
					throw new Exception("가이드 지원목록 업데이트 실패");
				}
			}
		} else if (paymentVO.getPayTrTp().equals("GUIDE")) {
			//가이드 여행인 경우
			if (this.paymentDao.updateCancelGdTour(paymentVO) != 1) {
				throw new Exception("가이드 투어정보 업데이트 실패");
			}
			
		}
		
		return true;
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
