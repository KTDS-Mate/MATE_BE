package com.mate.bbs.vo;

import java.util.List;

import com.mate.user.vo.UserVO;

public class GuideTourReviewVO {

	/**
	 * 가이드 투어 리뷰의  PK
	 */
	private String gdTrRvwId;
	/**
	 * 리뷰작성자의 PK
	 */
	private String athrId;
	/**
	 * 가이드가 등록한 투어 게시글 아이디
	 */
	private String gdTrPstId;
	/**
	 * 리뷰의 제목
	 */
	private String gdTrRvwTtl;
	/**
	 * 리뷰의 내용
	 */
	private String gdTrRvwCntnt;
	/**
	 * 리뷰 작성 일자
	 */
	private String gdTrRvwCrtdat;
	/**
	 * 리뷰 삭제 일자
	 */
	private String gdTrRvwDltAt;
	/**
	 * 리뷰 삭제 여부
	 */
	private String gdTrRvwIsDlt;
	/**
	 * 투어에 대한 평점
	 */
	private int gdTrRvwRtng;
	/**
	 * 투어 리뷰 수정 날짜
	 */
	private String gdTrRvwMdfyDt;
	
	/**
	 * 상위 리뷰 아이디(대댓글)
	 */
	private String prGdTrRvwId;
	/**
	 * 별점의 개수.
	 */
	private int reviewCount;
	
	/**
	 * 가이드 투어 리뷰 이미지 리스트 VO
	 */
	private List<GuideTourReviewImgVO> guideTourReviewImgList;
	
	private UserVO userVO;
	
	private GuideTourVO guideTourVO;
	
	/**별점 평균 컬럼 없음**/
	private int reviewAvg;
	
	/**별점 개수 컬럼 없음**/
	private int fiveCount;
	private int fourCount;
	private int threeCount;
	private int twoCount;
	private int oneCount;
	
	
	public String getGdTrRvwId() {
		return gdTrRvwId;
	}
	public void setGdTrRvwId(String gdTrRvwId) {
		this.gdTrRvwId = gdTrRvwId;
	}
	public String getAthrId() {
		return athrId;
	}
	public void setAthrId(String athrId) {
		this.athrId = athrId;
	}
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
	public String getGdTrRvwTtl() {
		return gdTrRvwTtl;
	}
	public void setGdTrRvwTtl(String gdTrRvwTtl) {
		this.gdTrRvwTtl = gdTrRvwTtl;
	}
	public String getGdTrRvwCntnt() {
		return gdTrRvwCntnt;
	}
	public void setGdTrRvwCntnt(String gdTrRvwCntnt) {
		this.gdTrRvwCntnt = gdTrRvwCntnt;
	}
	public String getGdTrRvwCrtdat() {
		return gdTrRvwCrtdat;
	}
	public void setGdTrRvwCrtdat(String gdTrRvwCrtdat) {
		this.gdTrRvwCrtdat = gdTrRvwCrtdat;
	}
	public String getGdTrRvwDltAt() {
		return gdTrRvwDltAt;
	}
	public void setGdTrRvwDltAt(String gdTrRvwDltAt) {
		this.gdTrRvwDltAt = gdTrRvwDltAt;
	}
	public String getGdTrRvwIsDlt() {
		return gdTrRvwIsDlt;
	}
	public void setGdTrRvwIsDlt(String gdTrRvwIsDlt) {
		this.gdTrRvwIsDlt = gdTrRvwIsDlt;
	}
	public int getGdTrRvwRtng() {
		return gdTrRvwRtng;
	}
	public void setGdTrRvwRtng(int gdTrRvwRtng) {
		this.gdTrRvwRtng = gdTrRvwRtng;
	}
	public String getGdTrRvwMdfyDt() {
		return gdTrRvwMdfyDt;
	}
	public void setGdTrRvwMdfyDt(String gdTrRvwMdfyDt) {
		this.gdTrRvwMdfyDt = gdTrRvwMdfyDt;
	}
	public String getPrGdTrRvwId() {
		return prGdTrRvwId;
	}
	public void setPrGdTrRvwId(String prGdTrRvwId) {
		this.prGdTrRvwId = prGdTrRvwId;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public List<GuideTourReviewImgVO> getGuideTourReviewImgList() {
		return guideTourReviewImgList;
	}
	public void setGuideTourReviewImgList(List<GuideTourReviewImgVO> guideTourReviewImgList) {
		this.guideTourReviewImgList = guideTourReviewImgList;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public GuideTourVO getGuideTourVO() {
		return guideTourVO;
	}
	public void setGuideTourVO(GuideTourVO guideTourVO) {
		this.guideTourVO = guideTourVO;
	}
	public int getReviewAvg() {
		return reviewAvg;
	}
	public void setReviewAvg(int reviewAvg) {
		this.reviewAvg = reviewAvg;
	}
	public int getFiveCount() {
		return fiveCount;
	}
	public void setFiveCount(int fiveCount) {
		this.fiveCount = fiveCount;
	}
	public int getFourCount() {
		return fourCount;
	}
	public void setFourCount(int fourCount) {
		this.fourCount = fourCount;
	}
	public int getThreeCount() {
		return threeCount;
	}
	public void setThreeCount(int threeCount) {
		this.threeCount = threeCount;
	}
	public int getTwoCount() {
		return twoCount;
	}
	public void setTwoCount(int twoCount) {
		this.twoCount = twoCount;
	}
	public int getOneCount() {
		return oneCount;
	}
	public void setOneCount(int oneCount) {
		this.oneCount = oneCount;
	}
	
}
