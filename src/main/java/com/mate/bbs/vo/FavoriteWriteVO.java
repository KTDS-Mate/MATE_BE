package com.mate.bbs.vo;

public class FavoriteWriteVO {

	/**즐겨찾기를 등록한 회원의 로그인 아이디**/
	private String usrLgnId;
	/**가이드가 등록한 투어 게시글 ID**/
	private String gdTrPstId;
	/**가이드 구인 게시판 ID**/
	private String usrTrPstId;
	
	public String getUsrLgnId() {
		return usrLgnId;
	}
	public void setUsrLgnId(String usrLgnId) {
		this.usrLgnId = usrLgnId;
	}
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
	public String getUsrTrPstId() {
		return usrTrPstId;
	}
	public void setUsrTrPstId(String usrTrPstId) {
		this.usrTrPstId = usrTrPstId;
	}
	
}
