package com.mate.bbs.vo;

public class GuideTourFavoriteVO {

	/**
	 * 즐겨찾기 항목의 아이디 PK
	 */
	private String favId;
	/**
	 * 즐겨찾기 추가 일자
	 */
	private String favCrAt;
	/**
	 * 즐겨찾기 삭제 여부
	 */
	private String favIsDlt;
	/**
	 * 즐겨찾기 삭제 일자
	 */
	private String favDltAt;
	/**
	 * 회원의 PK
	 */
	private String usrId;
	/**
	 * 가이드가 등록한 투어 게시글 아이디
	 */
	private String gdTrPstId;
	
	public String getFavId() {
		return favId;
	}
	public void setFavId(String favId) {
		this.favId = favId;
	}
	public String getFavCrAt() {
		return favCrAt;
	}
	public void setFavCrAt(String favCrAt) {
		this.favCrAt = favCrAt;
	}
	public String getFavIsDlt() {
		return favIsDlt;
	}
	public void setFavIsDlt(String favIsDlt) {
		this.favIsDlt = favIsDlt;
	}
	public String getFavDltAt() {
		return favDltAt;
	}
	public void setFavDltAt(String favDltAt) {
		this.favDltAt = favDltAt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
}
