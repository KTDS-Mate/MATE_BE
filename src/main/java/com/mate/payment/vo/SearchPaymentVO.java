package com.mate.payment.vo;

import com.mate.common.vo.PaginationVO;

public class SearchPaymentVO extends PaginationVO {
	
	private String trstId;
	
	private String trstLgnId;

	private String tourType;
	
	private String payState;
	
	private String startDate;
	
	private String endDate;
	
	private String searchType;

	public String getTrstId() {
		return trstId;
	}

	public void setTrstId(String trstId) {
		this.trstId = trstId;
	}

	public String getTrstLgnId() {
		return trstLgnId;
	}
	
	public void setTrstLgnId(String trstLgnId) {
		this.trstLgnId = trstLgnId;
	}
	
	public String getTourType() {
		return tourType;
	}

	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	
	
	
}
