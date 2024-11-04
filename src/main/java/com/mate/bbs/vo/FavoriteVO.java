package com.mate.bbs.vo;

import com.mate.user.vo.UserVO;

public class FavoriteVO {

	/**게시판에서 공통으로 사용 할 즐겨찾기VO**/
	/**즐겨찾기 항목의 아이디 PK**/
	private String favId;
	/**즐겨찾기 추가 일자**/
	private String favCrAt;
	/**즐겨찾기 삭제 여부**/
	private String favIsDlt;
	/**즐겨찾기 삭제 일자**/
	private String favDltAt;
	/**즐겨찾기를 등록한 회원의 로그인 아이디**/
	private String usrLgnId;
	/**가이드가 등록한 투어 게시글 ID**/
	private String gdTrPstId;
	/**가이드 구인 게시판 ID**/
	private String usrTrPstId;
	
	/**해당 즐겨찾기를 추가 한 유저**/
	private UserVO userVO;
	
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
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
}
