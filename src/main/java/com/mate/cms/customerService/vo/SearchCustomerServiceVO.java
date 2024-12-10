package com.mate.cms.customerService.vo;

import com.mate.common.vo.PaginationVO;

public class SearchCustomerServiceVO extends PaginationVO {

	/** 문의 게시판 검색어 **/
	private String searchKeyword;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

}
