package com.mate.bbs.vo;

import com.mate.common.vo.PaginationVO;

public class SearchUserTourVO extends PaginationVO {

	/**
	 * 대륙 별 검색에 사용
	 */
	private String regionName;
	/**
	 * ~ 순 정렬에 사용
	 */
	private String orderby;
	
	/****클라이언트가 등록한 가이드 구인 게시글 목록 검색창****/
	private String searchKeyword;

	private String searchType;
	
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
}
