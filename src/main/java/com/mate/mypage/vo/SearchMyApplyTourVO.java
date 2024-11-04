package com.mate.mypage.vo;

import com.mate.common.vo.PaginationVO;

public class SearchMyApplyTourVO extends PaginationVO {

	// 검색에 사용
	private String searchKeyword;
	
	// 정렬에 사용
	private String orderby;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	
}
