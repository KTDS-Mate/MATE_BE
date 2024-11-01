package com.mate.bbs.vo;


import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.user.vo.UserVO;

public class GuideTourVO {

	/**
	 * 가이드 투어 게시글 아이디
	 */
	private String gdTrPstId;
	/**
	 * 작성자 아이디
	 */
	private String athrId;
	/**
	 * 예약한 회원 아이디
	 */
	private String usrId;
	/**
	 * 투어 제목
	 */
	private String gdTrTtl;
	/**
	 * 투어 시작 날짜
	 */
	private String gdTrStDt;
	/**
	 * 투어 종료 날짜
	 */
	private String gdTrEdDt;

	/**
	 * 투어 목적
	 */
	private String gdTrPrps;
	/**
	 * 투어 미팅 포인트
	 */
	private String gdTrMp;
	/**
	 * 투어 가격
	 */
	private int gdTrPrc;
	/**
	 * 투어 요약
	 */
	private String gdTrSmry;

	/**
	 * 투어 등록일
	 */
	private String gdTrRstrDt;
	/**
	 * 투어 수정일
	 */
	private String gdTrMdfyDt;
	/**
	 * 투어 삭제일
	 */
	private String gdTrDltDt;
	/**
	 * 투어 삭제 여부
	 */
	private String gdTrIsDlt;
	
	/**
	 * 투어 도시 아이디
	 */
	private String trCtId;
	
	/**
	 * 투어를 진행할 국가 아이디 fk
	 */
	private String trCntId;
	/**
	 * 투어 최대 인원 수
	 */
	private int gdTrMxNp;
	/**
	 * 리뷰 평점 알리아스
	 */
	private double avgRvw;
	/**
	 * 가이드 투어 이미지 리스트 VO 
	 */
	private List<GuideTourImgVO> guideTourImgList;
	/**
	 * 가이드 투어 상세정보 리스트 VO
	 */
	private List<GuideTourDetailInfoVO> guideTourDetailInfoList;
	
	/**
	 * 가이드 투어 제공요소 리스트 VO
	 */
	private List<GuideTourProvidedVO> guideTourProvidedList;
	/**
	 * 가이드 투어 리뷰 리스트 VO
	 */
	private List<GuideTourReviewVO> guideTourReviewList;
	/**
	 * 가이드 추가 정보 리스트 VO
	 */
	private List<GuideTourScheduleInfoVO> guideTourScheduleInfoList;
	
	/**
	 * 가이드 투어 즐겨찾기 리스트 VO
	 */
	// private List<GuideTourFavoriteVO> guideTourFavoriteList;
	
	/**
	 * 가이드 투어 추가정보 리스트 VO
	 */
	// private List<GuideTourAdditionInfoVO> guideTourAdditionInfoList;
	
	/**
	 * 게시글 작성자의 정보를 담은 VO
	 */
	private UserVO userVO;
	/**
	 * 도시 정보를 담은 VO
	 */
	private CitiesVO citiesVO;
	/**
	 * 나라 정보를 담은 VO
	 */
	private CountriesVO countriesVO;
	
	/**
	 * 해당 프로퍼티는 DB컬럼에 존재하지 않음
	 */
	private String guideAge;
	
	
	
	
	public String getGdTrPstId() {
		return gdTrPstId;
	}
	public void setGdTrPstId(String gdTrPstId) {
		this.gdTrPstId = gdTrPstId;
	}
	public String getAthrId() {
		return athrId;
	}
	public void setAthrId(String athrId) {
		this.athrId = athrId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getGdTrTtl() {
		return gdTrTtl;
	}
	public void setGdTrTtl(String gdTrTtl) {
		this.gdTrTtl = gdTrTtl;
	}
	public String getGdTrStDt() {
		return gdTrStDt;
	}
	public void setGdTrStDt(String gdTrStDt) {
		this.gdTrStDt = gdTrStDt;
	}
	public String getGdTrEdDt() {
		return gdTrEdDt;
	}
	public void setGdTrEdDt(String gdTrEdDt) {
		this.gdTrEdDt = gdTrEdDt;
	}
	public String getGdTrPrps() {
		return gdTrPrps;
	}
	public void setGdTrPrps(String gdTrPrps) {
		this.gdTrPrps = gdTrPrps;
	}
	public String getGdTrMp() {
		return gdTrMp;
	}
	public void setGdTrMp(String gdTrMp) {
		this.gdTrMp = gdTrMp;
	}
	public int getGdTrPrc() {
		return gdTrPrc;
	}
	public void setGdTrPrc(int gdTrPrc) {
		this.gdTrPrc = gdTrPrc;
	}
	public String getGdTrSmry() {
		return gdTrSmry;
	}
	public void setGdTrSmry(String gdTrSmry) {
		this.gdTrSmry = gdTrSmry;
	}
	public String getGdTrRstrDt() {
		return gdTrRstrDt;
	}
	public void setGdTrRstrDt(String gdTrRstrDt) {
		this.gdTrRstrDt = gdTrRstrDt;
	}
	public String getGdTrMdfyDt() {
		return gdTrMdfyDt;
	}
	public void setGdTrMdfyDt(String gdTrMdfyDt) {
		this.gdTrMdfyDt = gdTrMdfyDt;
	}
	public String getGdTrDltDt() {
		return gdTrDltDt;
	}
	public void setGdTrDltDt(String gdTrDltDt) {
		this.gdTrDltDt = gdTrDltDt;
	}
	public String getGdTrIsDlt() {
		return gdTrIsDlt;
	}
	public void setGdTrIsDlt(String gdTrIsDlt) {
		this.gdTrIsDlt = gdTrIsDlt;
	}
	public String getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(String trCtId) {
		this.trCtId = trCtId;
	}
	public String getTrCntId() {
		return trCntId;
	}
	public void setTrCntId(String trCntId) {
		this.trCntId = trCntId;
	}
	public int getGdTrMxNp() {
		return gdTrMxNp;
	}
	public void setGdTrMxNp(int gdTrMxNp) {
		this.gdTrMxNp = gdTrMxNp;
	}
	public double getAvgRvw() {
		return avgRvw;
	}
	public void setAvgRvw(double avgRvw) {
		this.avgRvw = avgRvw;
	}
	public List<GuideTourImgVO> getGuideTourImgList() {
		return guideTourImgList;
	}
	public void setGuideTourImgList(List<GuideTourImgVO> guideTourImgList) {
		this.guideTourImgList = guideTourImgList;
	}
	public List<GuideTourDetailInfoVO> getGuideTourDetailInfoList() {
		return guideTourDetailInfoList;
	}
	public void setGuideTourDetailInfoList(List<GuideTourDetailInfoVO> guideTourDetailInfoList) {
		this.guideTourDetailInfoList = guideTourDetailInfoList;
	}
	public List<GuideTourProvidedVO> getGuideTourProvidedList() {
		return guideTourProvidedList;
	}
	public void setGuideTourProvidedList(List<GuideTourProvidedVO> guideTourProvidedList) {
		this.guideTourProvidedList = guideTourProvidedList;
	}
	public List<GuideTourReviewVO> getGuideTourReviewList() {
		return guideTourReviewList;
	}
	public void setGuideTourReviewList(List<GuideTourReviewVO> guideTourReviewList) {
		this.guideTourReviewList = guideTourReviewList;
	}
	public List<GuideTourScheduleInfoVO> getGuideTourScheduleInfoList() {
		return guideTourScheduleInfoList;
	}
	public void setGuideTourScheduleInfoList(List<GuideTourScheduleInfoVO> guideTourScheduleInfoList) {
		this.guideTourScheduleInfoList = guideTourScheduleInfoList;
	}
	//	public List<GuideTourFavoriteVO> getGuideTourFavoriteList() {
//		return guideTourFavoriteList;
//	}
//	public void setGuideTourFavoriteList(List<GuideTourFavoriteVO> guideTourFavoriteList) {
//		this.guideTourFavoriteList = guideTourFavoriteList;
//	}
//	public List<GuideTourAdditionInfoVO> getGuideTourAdditionInfoList() {
//		return guideTourAdditionInfoList;
//	}
//	public void setGuideTourAdditionInfoList(List<GuideTourAdditionInfoVO> guideTourAdditionInfoList) {
//		this.guideTourAdditionInfoList = guideTourAdditionInfoList;
//	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public CitiesVO getCitiesVO() {
		return citiesVO;
	}
	public void setCitiesVO(CitiesVO citiesVO) {
		this.citiesVO = citiesVO;
	}
	public CountriesVO getCountriesVO() {
		return countriesVO;
	}
	public void setCountriesVO(CountriesVO countriesVO) {
		this.countriesVO = countriesVO;
	}
	public String getGuideAge() {
		return guideAge;
	}
	public void setGuideAge(String guideAge) {
		this.guideAge = guideAge;
	}
}
