package com.mate.cms.userManagement.vo;

import com.mate.common.vo.PaginationVO;

public class SearchUserManagementVO extends PaginationVO{

	/** 가이드 유무 필터링 **/
	private String guideCheckedType;
	
	private String searchKeyword;

	public String getGuideCheckedType() {
		return guideCheckedType;
	}

	public void setGuideCheckedType(String guideCheckedType) {
		this.guideCheckedType = guideCheckedType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	 
	
}
