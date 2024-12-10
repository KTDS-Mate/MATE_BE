package com.mate.cms.customerService.vo;

import java.util.List;

public class CustomerServiceListVO {

	private int customerServiceCount;

	private List<CustomerServiceVO> customerServiceList;

	public int getCustomerServiceCount() {
		return customerServiceCount;
	}

	public void setCustomerServiceCount(int customerServiceCount) {
		this.customerServiceCount = customerServiceCount;
	}

	public List<CustomerServiceVO> getCustomerServiceList() {
		return customerServiceList;
	}

	public void setCustomerServiceList(List<CustomerServiceVO> customerServiceList) {
		this.customerServiceList = customerServiceList;
	}

}
