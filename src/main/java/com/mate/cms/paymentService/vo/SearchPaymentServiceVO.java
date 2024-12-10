package com.mate.cms.paymentService.vo;

import com.mate.common.vo.PaginationVO;

public class SearchPaymentServiceVO extends PaginationVO {

	private String searchKeyword;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

}
