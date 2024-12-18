package com.mate.cms.customerService.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.cms.customerService.dao.CustomerServiceDao;
import com.mate.cms.customerService.service.CustomerServiceService;
import com.mate.cms.customerService.vo.CustomerServiceAnswerVO;
import com.mate.cms.customerService.vo.CustomerServiceListVO;
import com.mate.cms.customerService.vo.CustomerServiceVO;
import com.mate.cms.customerService.vo.CustomerServiceWriteVO;
import com.mate.cms.customerService.vo.SearchCustomerServiceVO;

@Service
public class CustomerServiceServiceImpl implements CustomerServiceService {

	@Autowired
	private CustomerServiceDao customerServiceDao;
	
	@Transactional
	@Override
	public boolean createNewCustomerService(CustomerServiceWriteVO customerServiceWriteVO) {
		int createCount = this.customerServiceDao.insertNewCustomerService(customerServiceWriteVO);
		return createCount > 0;
	}
	
	@Override
	public CustomerServiceListVO getCustomerServiceList(String usrLgnId, SearchCustomerServiceVO searchCustomerServiceVO) {
		int customerServiceCnt = this.customerServiceDao.selectCustomerServiceCount(usrLgnId, searchCustomerServiceVO);
		if (customerServiceCnt == 0) {
			CustomerServiceListVO customerServiceListVO = new CustomerServiceListVO();
			customerServiceListVO.setCustomerServiceCount(0);
			customerServiceListVO.setCustomerServiceList( new ArrayList<>() );
			return customerServiceListVO;
		}
		
		searchCustomerServiceVO.setListSize(5);
		searchCustomerServiceVO.setPageCount(customerServiceCnt);
		
		List<CustomerServiceVO> customerServiceList = this.customerServiceDao.selectCustomerServiceList(usrLgnId, searchCustomerServiceVO);
		CustomerServiceListVO customerServiceListVO = new CustomerServiceListVO();
		
		customerServiceListVO.setCustomerServiceCount(customerServiceCnt);
		customerServiceListVO.setCustomerServiceList(customerServiceList);
		
		return customerServiceListVO;
	}
	
	@Transactional
	@Override
	public boolean updateCustomerService(CustomerServiceAnswerVO customerServiceAnswerVO) {
		int updateCount = this.customerServiceDao.updateCustomerService(customerServiceAnswerVO);
		return updateCount > 0;
	}
	
	@Transactional
	@Override
	public boolean softDeleteCustomerService(String cstmrSrvcCntrId) {
		int deleteCount = this.customerServiceDao.deleteCustomerService(cstmrSrvcCntrId);
		return deleteCount > 0;
	}
	
	@Override
	public CustomerServiceListVO getCustomerServiceListForCms(SearchCustomerServiceVO searchCustomerServiceVO) {
		int customerServiceCnt = this.customerServiceDao.selectCustomerServiceCountForCms(searchCustomerServiceVO);
		
		if (customerServiceCnt == 0) {
			CustomerServiceListVO customerServiceListVO = new CustomerServiceListVO();
			customerServiceListVO.setCustomerServiceCount(0);
			customerServiceListVO.setCustomerServiceList( new ArrayList<>() );
			return customerServiceListVO;
		}
		
		searchCustomerServiceVO.setListSize(5);
		searchCustomerServiceVO.setPageCount(customerServiceCnt);
		
		List<CustomerServiceVO> customerServiceList = this.customerServiceDao.selectCustomerServiceListForCms(searchCustomerServiceVO);
		CustomerServiceListVO customerServiceListVO = new CustomerServiceListVO();
		
		customerServiceListVO.setCustomerServiceCount(customerServiceCnt);
		customerServiceListVO.setCustomerServiceList(customerServiceList);
		
		return customerServiceListVO;
	}
	
}
