package com.mate.cms.customerService.service;

import com.mate.cms.customerService.vo.CustomerServiceAnswerVO;
import com.mate.cms.customerService.vo.CustomerServiceListVO;
import com.mate.cms.customerService.vo.CustomerServiceWriteVO;
import com.mate.cms.customerService.vo.SearchCustomerServiceVO;

public interface CustomerServiceService {

	public boolean createNewCustomerService(CustomerServiceWriteVO customerServiceWriteVO);
	
	public CustomerServiceListVO getCustomerServiceList(String usrLgnId, SearchCustomerServiceVO searchCustomerServiceVO);
	
	public boolean updateCustomerService(CustomerServiceAnswerVO customerServiceAnswerVO);
	
	public boolean softDeleteCustomerService(String cstmrSrvcCntrId);
	
}
