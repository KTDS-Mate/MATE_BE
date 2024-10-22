package com.mate.bbs.vo;

import java.util.List;

import com.mate.user.vo.UserVO;

public class GuideTourImgVO {

	/**
	 * 가이드 투어 게시글 이미지 아이디
	 */
	private String gdTrImgId;
	/**
	 * 가이드가 등록한 투어 게시글 아이디
	 */
	private String gdTrPStId;
	/**
	 * 가이드 등록 투어 게시글의 사진
	 */
	private String gdTrImgUrl;
	/**
	 * 사진 업로드한 일자
	 */
	private String usrTrRStrDt;
	/**
	 * 사진을 삭제한 일자
	 */
	private String usrTrDltDt;
	/**
	 * 사진 삭제 여부
	 */
	private String gdTrImgIsDlt;
	
	private UserVO userVO;
	
	
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	public String getGdTrImgId() {
		return gdTrImgId;
	}
	public void setGdTrImgId(String gdTrImgId) {
		this.gdTrImgId = gdTrImgId;
	}
	public String getGdTrPStId() {
		return gdTrPStId;
	}
	public void setGdTrPStId(String gdTrPStId) {
		this.gdTrPStId = gdTrPStId;
	}
	public String getGdTrImgUrl() {
		return gdTrImgUrl;
	}
	public void setGdTrImgUrl(String gdTrImgUrl) {
		this.gdTrImgUrl = gdTrImgUrl;
	}
	public String getUsrTrRStrDt() {
		return usrTrRStrDt;
	}
	public void setUsrTrRStrDt(String usrTrRStrDt) {
		this.usrTrRStrDt = usrTrRStrDt;
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
}
