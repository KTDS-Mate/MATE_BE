package com.mate.cms.paymentService.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.cms.paymentService.dao.PaymentServiceDao;
import com.mate.cms.paymentService.service.PaymentServiceService;
import com.mate.cms.paymentService.vo.PaymentServiceListVO;
import com.mate.cms.paymentService.vo.PaymentServiceUpdateVO;
import com.mate.cms.paymentService.vo.PaymentServiceVO;
import com.mate.cms.paymentService.vo.SearchPaymentServiceVO;

@Service
public class PaymentServiceServiceImpl implements PaymentServiceService {

	@Autowired
	private PaymentServiceDao paymentServiceDao;
	
	@Override
	public PaymentServiceListVO getPaymentServiceList(SearchPaymentServiceVO searchPaymentServiceVO) {
		int paymentServiceCount = this.paymentServiceDao.selectPaymentServiceCount();
		if (paymentServiceCount == 0) {
			PaymentServiceListVO paymentServiceListVO = new PaymentServiceListVO();
			paymentServiceListVO.setPaymentServiceCount(0);
			paymentServiceListVO.setPaymentServiceList(new ArrayList<>());
			
			return paymentServiceListVO;
		}
		
		List<PaymentServiceVO> paymentServiceList = this.paymentServiceDao.selectAllPaymentService(searchPaymentServiceVO);
		
		PaymentServiceListVO paymentServiceListVO = new PaymentServiceListVO();
		paymentServiceListVO.setPaymentServiceCount(paymentServiceCount);
		paymentServiceListVO.setPaymentServiceList(paymentServiceList);
		
		return paymentServiceListVO;
	}
	
	@Override
	public boolean updatePaymentServiceStts(PaymentServiceUpdateVO paymentServiceUpdateVO) {
		int updateCount = this.paymentServiceDao.updatePayStts(paymentServiceUpdateVO);
		return updateCount > 0;
	}
	
}
