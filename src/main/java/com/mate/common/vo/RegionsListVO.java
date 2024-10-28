package com.mate.common.vo;

import java.util.List;

public class RegionsListVO {

	/**
	 * 대륙 수
	 */
	private int regionsCount;
	/**
	 * 대륙 리스트
	 */
	private List<RegionsVO> regionsList;
	public int getRegionsCount() {
		return regionsCount;
	}
	public void setRegionsCount(int regionsCount) {
		this.regionsCount = regionsCount;
	}
	public List<RegionsVO> getRegionsList() {
		return regionsList;
	}
	public void setRegionsList(List<RegionsVO> regionsList) {
		this.regionsList = regionsList;
	}
	
}
