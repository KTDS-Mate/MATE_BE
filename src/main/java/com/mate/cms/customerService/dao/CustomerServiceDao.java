package com.mate.cms.customerService.dao;

import com.mate.cms.customerService.vo.CustomerServiceWriteVO;

public interface CustomerServiceDao {

	public String NAMESPACE = "com.mate.cms.customerService.dao.CustomerServiceDao";
	
	public int insertNewCustomerService(CustomerServiceWriteVO customerServiceWriteVO);
	
}
