package com.mate.bbs.vo;

import com.mate.common.vo.PaginationVO;

public class SearchGuideTourVO extends PaginationVO{

	/** 클라이언트가 검색한 국가 검색 창 */
	private String searchType;
	
	private String searchKeyword;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}
