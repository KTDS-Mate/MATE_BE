package com.mate.cms.userManagement.vo;

public class UserManagementVO {

	/** 유저 PK */
	private String usrId;
	
	/** 유저 로그인 아이디 */
	private String usrLgnId;
	
	/** 가이드 등록일 */
	private String gdRgstDt;

	/** 유저 성 */
	private String usrFnm;

	/** 유저 이름 */
	private String usrLnm;

	/** 유저 성별 */
	private String usrGndr;

	/** 유저 생일 */
	private String usrBd;

	/** 유저 이메일 */
	private String usrEml;

	/** 유저 가이드 여부 */
	private String usrIsGd;

	/** 가이드 신청 여부 */
	private String gdApplStt;
	
	/** 회원 탈퇴 여부 */
	private String usrIsCl;

	/** 회원 정지 여부 */
	private String usrIsBlck;
	
	/** 회원(가이드) 자기소개 */
    private String usrSlfIntdctn;
    
    /** 가이드 프로필 사진 */
    private String gdPrflImg;
	
    /** 가이드 신분증 사진 */
    private String gdIdImg;
    
    /** 가이드 범죄경력 조회서 사진 */
    private String gdCbcImg;
    
    
    /** 가이드 경력 */
	private int usrGdExp;
	
	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrLgnId() {
		return usrLgnId;
	}

	public void setUsrLgnId(String usrLgnId) {
		this.usrLgnId = usrLgnId;
	}

	public String getGdRgstDt() {
		return gdRgstDt;
	}

	public void setGdRgstDt(String gdRgstDt) {
		this.gdRgstDt = gdRgstDt;
	}

	public String getUsrFnm() {
		return usrFnm;
	}

	public void setUsrFnm(String usrFnm) {
		this.usrFnm = usrFnm;
	}

	public String getUsrLnm() {
		return usrLnm;
	}

	public void setUsrLnm(String usrLnm) {
		this.usrLnm = usrLnm;
	}

	public String getUsrGndr() {
		return usrGndr;
	}

	public void setUsrGndr(String usrGndr) {
		this.usrGndr = usrGndr;
	}

	public String getUsrBd() {
		return usrBd;
	}

	public void setUsrBd(String usrBd) {
		this.usrBd = usrBd;
	}

	public String getUsrEml() {
		return usrEml;
	}

	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}

	public String getUsrIsGd() {
		return usrIsGd;
	}

	public void setUsrIsGd(String usrIsGd) {
		this.usrIsGd = usrIsGd;
	}

	public String getGdApplStt() {
		return gdApplStt;
	}

	public void setGdApplStt(String gdApplStt) {
		this.gdApplStt = gdApplStt;
	}

	public String getUsrIsCl() {
		return usrIsCl;
	}

	public void setUsrIsCl(String usrIsCl) {
		this.usrIsCl = usrIsCl;
	}

	public String getUsrIsBlck() {
		return usrIsBlck;
	}

	public void setUsrIsBlck(String usrIsBlck) {
		this.usrIsBlck = usrIsBlck;
	}

	public String getUsrSlfIntdctn() {
		return usrSlfIntdctn;
	}

	public void setUsrSlfIntdctn(String usrSlfIntdctn) {
		this.usrSlfIntdctn = usrSlfIntdctn;
	}

	public String getGdPrflImg() {
		return gdPrflImg;
	}

	public void setGdPrflImg(String gdPrflImg) {
		this.gdPrflImg = gdPrflImg;
	}

	public String getGdIdImg() {
		return gdIdImg;
	}

	public void setGdIdImg(String gdIdImg) {
		this.gdIdImg = gdIdImg;
	}

	public String getGdCbcImg() {
		return gdCbcImg;
	}

	public void setGdCbcImg(String gdCbcImg) {
		this.gdCbcImg = gdCbcImg;
	}

	public int getUsrGdExp() {
		return usrGdExp;
	}

	public void setUsrGdExp(int usrGdExp) {
		this.usrGdExp = usrGdExp;
	}
	
	

}
