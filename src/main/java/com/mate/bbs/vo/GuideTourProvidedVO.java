package com.mate.bbs.vo;

import com.mate.common.vo.GuideCityVO;
import com.mate.common.vo.CountryVO;

/**
 * 가이드 투어 제공항목 VO
 */
public class GuideTourProvidedVO {

	/**
	 * 투어 제공 요소 ID
	 */
	private String trIncldId;
	/**
	 * 투어 제공 요소 정보
	 */
	private String trIncld;
	/**
	 * 가이드가 등록한 투어 게시글 아이디
	 */
	private String gdTrPstId;
	
	

	
	public String getTrIncldId() {
		return trIncldId;
	}
	public void setTrIncldId(String trIncldId) {
		this.trIncldId = trIncldId;
	}
	public String getTrIncld() {
		return trIncld;
	}
	public void setTrIncld(String trIncld) {
		this.trIncld = trIncld;
	}
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
}
