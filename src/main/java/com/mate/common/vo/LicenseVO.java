package com.mate.common.vo;

public class LicenseVO {

	/**
	 * 가이드 라이센스 아이디
	 */
	private String lcnId;
	
	/**
	 * 가이드 아이디
	 */
	private String usrId;
	
	/**
	 * 라이센스 이름 
	 */
	private String lcnNm;
	
	/**
	 * 라이센스 이미지
	 */
	private String lcnImg;

	public String getLcnId() {
		return lcnId;
	}

	public void setLcnId(String lcnId) {
		this.lcnId = lcnId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getLcnNm() {
		return lcnNm;
	}

	public void setLcnNm(String lcnNm) {
		this.lcnNm = lcnNm;
	}

	public String getLcnImg() {
		return lcnImg;
	}

	public void setLcnImg(String lcnImg) {
		this.lcnImg = lcnImg;
	}
}
