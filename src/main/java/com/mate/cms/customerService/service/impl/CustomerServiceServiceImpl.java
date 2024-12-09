package com.mate.cms.customerService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.cms.customerService.dao.CustomerServiceDao;
import com.mate.cms.customerService.service.CustomerServiceService;
import com.mate.cms.customerService.vo.CustomerServiceWriteVO;

@Service
public class CustomerServiceServiceImpl implements CustomerServiceService {

	@Autowired
	private CustomerServiceDao customerServiceDao;
	
	@Override
	public boolean createNewCustomerService(CustomerServiceWriteVO customerServiceWriteVO) {
		return false;
	}
	
}
