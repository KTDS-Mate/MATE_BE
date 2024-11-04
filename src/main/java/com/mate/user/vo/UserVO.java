package com.mate.user.vo;

import java.util.List;

import com.mate.common.vo.CitiesVO;

public class UserVO {

    /**
     * 회원 아이디
     */
    private String usrId;
    /**
     * 회원 로그인 아이디
     */
    private String usrLgnId;
    /**
     * 비밀번호
     */
    private String usrPwd;
    /**
     * 회원의 성
     */
    private String usrLnm;
    
    /**
     * 회원의 이름
     */
    private String usrFnm;
    
    /**
     * 회원의 성별
     */
    private String usrGndr;
    
    /**
     * 회원의 이메일
     */
    private String usrEml;
    
    /**
     * 회원의 전화번호
     */
    private String usrPhn;
    
    /**
     * 회원의 생년월일
     */
    private String usrBd;
    
    /**
     * 가이드 여부 확인
     */
    private String usrIsGd;
    /**
     * 회원(가이드) 자기소개
     */
    private String usrSlfIntdctn;
    /**
     * 회원의 페이팔 이메일
     */
    private String usrPypEml;
    /**
     * 평균 별점
     */
    private double usrAvgRtng;
    /**
     * 회원의 가입일자
     */
    private String usrJnDt;
    /**
     * 회원의 탈퇴일자
     */
    private String usrClDt;
    /**
     * 회원의 탈퇴 여부
     */
    private String usrIsCl;
    /**
     * 수정일자
     */
    private String usrMdfyDt;
    /**
     * 가이드 프로필 사진
     */
    private String gdPrflImg;
    /**
     * 가이드 신분증 사진
     */
    private String gdIdImg;
    /**
     * 가이드 범죄경력 조회서 사진
     */
    private String gdCbcImg;
    /**
     * 가이드 대표 국적 아이디(fk)
     */
    private String gdRpCntId;
    /**
     * 가이드 활동 도시 (여러개 선택 가능)
     */
    private List<CitiesVO> citiesVO;
    /**
     * 가이드 활동 국가
     */
    private String countryName;
    /**
     * 국가 번호 코드
     */
	private String usrCntCode;

	private String salt;
	
	private String confirmPwd;
	
	/**
	 * 가이드 경력
	 */
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

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

    public String getUsrLnm() {
        return usrLnm;
    }

    public void setUsrLnm(String usrLnm) {
        this.usrLnm = usrLnm;
    }

    public String getUsrFnm() {
        return usrFnm;
    }

    public void setUsrFnm(String usrFnm) {
        this.usrFnm = usrFnm;
    }

    public String getUsrGndr() {
        return usrGndr;
    }

    public void setUsrGndr(String usrGndr) {
        this.usrGndr = usrGndr;
    }

    public String getUsrEml() {
        return usrEml;
    }

    public void setUsrEml(String usrEml) {
        this.usrEml = usrEml;
    }

    public String getUsrPhn() {
        return usrPhn;
    }

    public void setUsrPhn(String usrPhn) {
        this.usrPhn = usrPhn;
    }

    public String getUsrBd() {
        return usrBd;
    }

    public void setUsrBd(String usrBd) {
        this.usrBd = usrBd;
    }

    public String getUsrIsGd() {
        return usrIsGd;
    }

    public void setUsrIsGd(String usrIsGd) {
        this.usrIsGd = usrIsGd;
    }

    public String getUsrSlfIntdctn() {
        return usrSlfIntdctn;
    }

    public void setUsrSlfIntdctn(String usrSlfIntdctn) {
        this.usrSlfIntdctn = usrSlfIntdctn;
    }

    public String getUsrPypEml() {
        return usrPypEml;
    }

    public void setUsrPypEml(String usrPypEml) {
        this.usrPypEml = usrPypEml;
    }

    public double getUsrAvgRtng() {
        return usrAvgRtng;
    }

    public void setUsrAvgRtng(double usrAvgRtng) {
        this.usrAvgRtng = usrAvgRtng;
    }

    public String getUsrJnDt() {
        return usrJnDt;
    }

    public void setUsrJnDt(String usrJnDt) {
        this.usrJnDt = usrJnDt;
    }

    public String getUsrClDt() {
        return usrClDt;
    }

    public void setUsrClDt(String usrClDt) {
        this.usrClDt = usrClDt;
    }

    public String getUsrIsCl() {
        return usrIsCl;
    }

    public void setUsrIsCl(String usrIsCl) {
        this.usrIsCl = usrIsCl;
    }

    public String getUsrMdfyDt() {
        return usrMdfyDt;
    }

    public void setUsrMdfyDt(String usrMdfyDt) {
        this.usrMdfyDt = usrMdfyDt;
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

    public String getGdRpCntId() {
        return gdRpCntId;
    }

    public void setGdRpCntId(String gdRpCntId) {
        this.gdRpCntId = gdRpCntId;
    }

	public String getUsrCntCode() {
		return usrCntCode;
	}

	public void setUsrCntCode(String usrCntCode) {
		this.usrCntCode = usrCntCode;
	}

	public List<CitiesVO> getCitiesVO() {
		return citiesVO;
	}

	public void setCitiesVO(List<CitiesVO> citiesVO) {
		this.citiesVO = citiesVO;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public int getUsrGdExp() {
		return usrGdExp;
	}

	public void setUsrGdExp(int usrGdExp) {
		this.usrGdExp = usrGdExp;
	}
	
}
