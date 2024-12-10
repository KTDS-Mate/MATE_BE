package com.mate.bbs.vo;

import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.RegionsVO;
import com.mate.user.vo.UserVO;

public class UserTourVO {

	/** 게시글의 아이디. Pk **/
	private String usrTrPstId;
	/** 해당 투어를 작성한 여행자 FK **/
	private String athrId;
	/** 투어를 예약한 가이드 FK **/
	private String gdId;
	/** 여행자가 등록한 투어 게시글의 제목 **/
	private String usrTrTtl;
	/** 여행자가 입력한 투어 일시 **/
	private String usrTrStDt;
	/** 여행자가 입력한 투어의 목적 **/
	private String usrTrPrps;
	/** 여행자가 등록한 가이드와 만날 지점에 대한 정보 **/
	private String usrTrMp;
	/** 여행자가 가이드에게 제시하는 고용 금액 **/
	private double usrTrGdHrPrc;
	/** 여행자의 총 투어 인원 **/
	private int usrTrNp;
	/** 논리적 삭제를 위한 게시글 삭제 여부 (기본 값 : N) **/
	private String usrTrIsDlt;
	/** 여행자가 투어 요청 게시글을 등록한 일시 **/
	private String usrTrRstrDt;
	/** 여행자가 투어 요청 게시글을 수정한 일시 **/
	private String usrTrMdfyDt;
	/** 여행자가 투어 요청 게시글을 삭제한 일시 **/
	private String usrTrDltDt;
	/** 여행자가 등록한 투어 지역의 도시명. FK **/
	private int trCtId;
	/** 여행자의 가이드 구인 게시글의 세부 요구사항 내용 **/
	private String usrTrRqDtl;
	/** 원하는 가이드의 성별 **/
	private String gdGndr;
	/** 원하는 가이드의 나이 **/
	private String gdAge;
	/** 원하는 가이드의 경력 **/
	private String gdCrr;
	/** 가이드에게 원하는 사항 **/
	private String gdWntRq;
	/** 가이드 구인 게시글 투어 상태 (RCRTNG : 모집 중, RSRVT : 예약 중, PRG : 투어 진행중, CMPLT: 투어 완료) **/
	private String usrTrStts;
	/** 여행자가 입력한 투어 종료일시 **/
	private String usrTrEdDt;
	
	private UserVO userVO;
	
	/**
	 * 게시글 이미지 파일 정보 리스트
	 */
	private List<UserTourImgVO> userTourImgList;
	
	/**
	 * 투어 일정 리스트
	 */
	private List<UserTourSchdlVO> userTourSchdlList;
	/**
	 * 사용자가 즐겨찾기 한 즐겨찾기
	 */
	private FavoriteVO favoriteVO;
	
	/**대륙 별 검색에 사용**/
	
	private CitiesVO citiesVO;
	
	private CountriesVO countriesVO;
	
	private RegionsVO regionsVO;
	
	/**게시글 수정 시 보여줘야 하는 것**/
	/**
	 * 여행자가 입력한 input[date]의 값 받아오기
	 */
	private String inputYear;
	/**
	 * 여행자가 입력한 시작 시 input[time] 값 받아오기
	 */
	private String inputStartHour;
	/**
	 * 여행자가 입력한 종료 시 input[time] 값 받아오기
	 */
	private String inputEndHour;
	
	/**컬럼은 존재하지 않음 -> view 화면에서 보여주기 위해 알리아스명을 적어줌**/
	/**마감일**/
	private int deadline;
	/**투어 총 소요 시간**/
	private String usrTrTm;
	/** 투어 구분 **/
	private String usrTrDivide;
	
	private int userTourImgCount;
	
	public String getUsrTrDivide() {
		return usrTrDivide;
	}
	public void setUsrTrDivide(String usrTrDivide) {
		this.usrTrDivide = usrTrDivide;
	}
	public String getUsrTrPstId() {
		return usrTrPstId;
	}
	public void setUsrTrPstId(String usrTrPstId) {
		this.usrTrPstId = usrTrPstId;
	}
	public String getAthrId() {
		return athrId;
	}
	public void setAthrId(String athrId) {
		this.athrId = athrId;
	}
	public String getGdId() {
		return gdId;
	}
	public void setGdId(String gdId) {
		this.gdId = gdId;
	}
	public String getUsrTrTtl() {
		return usrTrTtl;
	}
	public void setUsrTrTtl(String usrTrTtl) {
		this.usrTrTtl = usrTrTtl;
	}
	public String getUsrTrStDt() {
		return usrTrStDt;
	}
	public void setUsrTrStDt(String usrTrStDt) {
		this.usrTrStDt = usrTrStDt;
	}
	public String getUsrTrPrps() {
		return usrTrPrps;
	}
	public void setUsrTrPrps(String usrTrPrps) {
		this.usrTrPrps = usrTrPrps;
	}
	public String getUsrTrMp() {
		return usrTrMp;
	}
	public void setUsrTrMp(String usrTrMp) {
		this.usrTrMp = usrTrMp;
	}
	public double getUsrTrGdHrPrc() {
		return usrTrGdHrPrc;
	}
	public void setUsrTrGdHrPrc(double usrTrGdHrPrc) {
		this.usrTrGdHrPrc = usrTrGdHrPrc;
	}
	public int getUsrTrNp() {
		return usrTrNp;
	}
	public void setUsrTrNp(int usrTrNp) {
		this.usrTrNp = usrTrNp;
	}
	public String getUsrTrIsDlt() {
		return usrTrIsDlt;
	}
	public void setUsrTrIsDlt(String usrTrIsDlt) {
		this.usrTrIsDlt = usrTrIsDlt;
	}
	public String getUsrTrRstrDt() {
		return usrTrRstrDt;
	}
	public void setUsrTrRstrDt(String usrTrRstrDt) {
		this.usrTrRstrDt = usrTrRstrDt;
	}
	public String getUsrTrMdfyDt() {
		return usrTrMdfyDt;
	}
	public void setUsrTrMdfyDt(String usrTrMdfyDt) {
		this.usrTrMdfyDt = usrTrMdfyDt;
	}
	public String getUsrTrDltDt() {
		return usrTrDltDt;
	}
	public void setUsrTrDltDt(String usrTrDltDt) {
		this.usrTrDltDt = usrTrDltDt;
	}
	public int getTrCtId() {
		return trCtId;
	}
	public void setTrCtId(int trCtId) {
		this.trCtId = trCtId;
	}
	public String getUsrTrRqDtl() {
		return usrTrRqDtl;
	}
	public void setUsrTrRqDtl(String usrTrRqDtl) {
		this.usrTrRqDtl = usrTrRqDtl;
	}
	public String getGdGndr() {
		return gdGndr;
	}
	public void setGdGndr(String gdGndr) {
		this.gdGndr = gdGndr;
	}
	public String getGdAge() {
		return gdAge;
	}
	public void setGdAge(String gdAge) {
		this.gdAge = gdAge;
	}
	public String getGdCrr() {
		return gdCrr;
	}
	public void setGdCrr(String gdCrr) {
		this.gdCrr = gdCrr;
	}
	public String getGdWntRq() {
		return gdWntRq;
	}
	public void setGdWntRq(String gdWntRq) {
		this.gdWntRq = gdWntRq;
	}
	public String getUsrTrStts() {
		return usrTrStts;
	}
	public void setUsrTrStts(String usrTrStts) {
		this.usrTrStts = usrTrStts;
	}
	public String getUsrTrEdDt() {
		return usrTrEdDt;
	}
	public void setUsrTrEdDt(String usrTrEdDt) {
		this.usrTrEdDt = usrTrEdDt;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public List<UserTourImgVO> getUserTourImgList() {
		return userTourImgList;
	}
	public void setUserTourImgList(List<UserTourImgVO> userTourImgList) {
		this.userTourImgList = userTourImgList;
	}
	public List<UserTourSchdlVO> getUserTourSchdlList() {
		return userTourSchdlList;
	}
	public void setUserTourSchdlList(List<UserTourSchdlVO> userTourSchdlList) {
		this.userTourSchdlList = userTourSchdlList;
	}
	public FavoriteVO getFavoriteVO() {
		return favoriteVO;
	}
	public void setFavoriteVO(FavoriteVO favoriteVO) {
		this.favoriteVO = favoriteVO;
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
	public RegionsVO getRegionsVO() {
		return regionsVO;
	}
	public void setRegionsVO(RegionsVO regionsVO) {
		this.regionsVO = regionsVO;
	}
	public String getInputYear() {
		return inputYear;
	}
	public void setInputYear(String inputYear) {
		this.inputYear = inputYear;
	}
	public String getInputStartHour() {
		return inputStartHour;
	}
	public void setInputStartHour(String inputStartHour) {
		this.inputStartHour = inputStartHour;
	}
	public String getInputEndHour() {
		return inputEndHour;
	}
	public void setInputEndHour(String inputEndHour) {
		this.inputEndHour = inputEndHour;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public String getUsrTrTm() {
		return usrTrTm;
	}
	public void setUsrTrTm(String usrTrTm) {
		this.usrTrTm = usrTrTm;
	}
	public int getUserTourImgCount() {
		return userTourImgCount;
	}
	public void setUserTourImgCount(int userTourImgCount) {
		this.userTourImgCount = userTourImgCount;
	}
	
}