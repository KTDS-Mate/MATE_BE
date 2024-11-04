package com.mate.bbs.vo;

import com.mate.common.vo.PaginationVO;

public class SearchGuideTourVO extends PaginationVO{

	/** 검색 종류 */
	private String searchType;
	/** 가이드가 등록한 투어 게시글 목록 검색창 */
	private String searchKeyword;

	/** 정렬에 사용 */
	private String orderBy;
	/** 대륙 별 검색 */
	private String regionName;
	
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

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
}
