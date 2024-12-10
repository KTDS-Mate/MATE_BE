package com.mate.cms.paymentService.service;

import com.mate.cms.paymentService.vo.PaymentServiceListVO;
import com.mate.cms.paymentService.vo.PaymentServiceUpdateVO;
import com.mate.cms.paymentService.vo.SearchPaymentServiceVO;

public interface PaymentServiceService {

	public PaymentServiceListVO getPaymentServiceList(SearchPaymentServiceVO searchPaymentServiceVO);
	
	public boolean updatePaymentServiceStts(PaymentServiceUpdateVO paymentServiceUpdateVO);
	
}
