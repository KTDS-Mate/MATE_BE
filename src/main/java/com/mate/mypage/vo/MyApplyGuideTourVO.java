package com.mate.mypage.vo;

import com.mate.payment.vo.PaymentVO;
import com.mate.user.vo.UserVO;

public class MyApplyGuideTourVO {

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
	private int usrTrIsDlt;
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

	private PaymentVO paymentVO;
	
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

	public int getUsrTrIsDlt() {
		return usrTrIsDlt;
	}

	public void setUsrTrIsDlt(int usrTrIsDlt) {
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

	public PaymentVO getPaymentVO() {
		return paymentVO;
	}

	public void setPaymentVO(PaymentVO paymentVO) {
		this.paymentVO = paymentVO;
	}
	
}
