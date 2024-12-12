package com.mate.cms.paymentService.dao;

import java.util.List;

import com.mate.cms.paymentService.vo.PaymentServiceUpdateVO;
import com.mate.cms.paymentService.vo.PaymentServiceVO;
import com.mate.cms.paymentService.vo.SearchPaymentServiceVO;

public interface PaymentServiceDao {

	public String NAMESPACE = "com.mate.cms.paymentService.dao.PaymentServiceDao";
	
	public List<PaymentServiceVO> selectAllPaymentService(SearchPaymentServiceVO searchPaymentServiceVO);
	
	public int selectPaymentServiceCount();
	
	public int updatePayStts(PaymentServiceUpdateVO paymentServiceUpdateVO);
	
}
