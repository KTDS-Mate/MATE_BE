package com.mate.bbs.vo;

import org.springframework.web.multipart.MultipartFile;

public class UserTourImgVO {

	/**
	 * 여행자 등록 투어 게시글의 사진 PK
	 */
	private String usrTrRqImgId;
	/**
	 * 게시글의 아이디. Pk
	 */
	private String usrTrPstId;
	/**
	 * 여행자 등록 투어 게시글의 사진 URL
	 */
	private String usrTrRqImgIdUrl;
	/**
	 * 사진을 업로드한 일자
	 */
	private String usrTrRstrDt;
	/**
	 * 사진을 삭제한 일자
	 */
	private String usrTrDltDt;
	/**
	 * 사진의 삭제 여부 (기본 값 : N)
	 */
	private String gdTrImgIsDlt;
	
	private String usrTrRqOriginFileName;
	
	/** Tourist_TourInsert에서 받아 올 파일**/
	private MultipartFile userTourImgFile;
	
	public String getUsrTrRqImgId() {
		return usrTrRqImgId;
	}
	public void setUsrTrRqImgId(String usrTrRqImgId) {
		this.usrTrRqImgId = usrTrRqImgId;
	}
	public String getUsrTrPstId() {
		return usrTrPstId;
	}
	public void setUsrTrPstId(String usrTrPstId) {
		this.usrTrPstId = usrTrPstId;
	}
	public String getUsrTrRqImgIdUrl() {
		return usrTrRqImgIdUrl;
	}
	public void setUsrTrRqImgIdUrl(String usrTrRqImgIdUrl) {
		this.usrTrRqImgIdUrl = usrTrRqImgIdUrl;
	}
	public String getUsrTrRstrDt() {
		return usrTrRstrDt;
	}
	public void setUsrTrRstrDt(String usrTrRstrDt) {
		this.usrTrRstrDt = usrTrRstrDt;
	}
	public String getUsrTrDltDt() {
		return usrTrDltDt;
	}
	public void setUsrTrDltDt(String usrTrDltDt) {
		this.usrTrDltDt = usrTrDltDt;
	}
	public String getGdTrImgIsDlt() {
		return gdTrImgIsDlt;
	}
	public void setGdTrImgIsDlt(String gdTrImgIsDlt) {
		this.gdTrImgIsDlt = gdTrImgIsDlt;
	}
	public MultipartFile getUserTourImgFile() {
		return userTourImgFile;
	}
	public void setUserTourImgFile(MultipartFile userTourImgFile) {
		this.userTourImgFile = userTourImgFile;
	}
	public String getUsrTrRqOriginFileName() {
		return usrTrRqOriginFileName;
	}
	public void setUsrTrRqOriginFileName(String usrTrRqOriginFileName) {
		this.usrTrRqOriginFileName = usrTrRqOriginFileName;
	}
	
}
