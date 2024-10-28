package com.mate.user.vo;

import java.util.List;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.LicenseVO;

public class RegistGuideVO {
	
	/**
	 * 가이드의 성
	 */
    private String usrLnm;
    
    /**
     * 가이드의 이름
     */
    private String usrFnm;
    
    /**
     * 가이드의 생년월일
     */
    private String usrBd;
    
    /**
     * 휴대전화번호
     */
    private String usrPhn;

    /**
     * 이메일
     */
    private String usrEml;

    /**
     * 가이드 프로필 이미지 
     */
    private String gdPrflImg;

    /**
     * 가이드 자기소개
     */
    private String usrSlfIntdctn;

    /**
     * 가이드의 대표 국적 : COUNTRIES 테이블
     */
    private String countryName;;

    /**
     * 가이드 활동 도시 : CITIES 테이블, GD_ACT_CT는 완충 테이블
     */
    private List<CitiesVO> cities;
    /**
     * 가이드의 신분증 사진
     */
    private String gdIdImg;
    
    /**
     * 가이드의 범죄경력 조회서 사진
     */
    private String gdCbcImg;

    /**
     * 라이센스 이름, 이미지 : GD_LCN 테이블
     */
    private List<LicenseVO> licenses;
    
    /**
     * 페이팔 이메일(정산계좌)
     */
    private String usrPypEml;
    
    /**
     * 가이드 경력
     */
    private String usrGdExp;
    
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

	public String getUsrBd() {
		return usrBd;
	}

	public void setUsrBd(String usrBd) {
		this.usrBd = usrBd;
	}

	public String getUsrPhn() {
		return usrPhn;
	}

	public void setUsrPhn(String usrPhn) {
		this.usrPhn = usrPhn;
	}

	public String getUsrEml() {
		return usrEml;
	}

	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}

	public String getGdPrflImg() {
		return gdPrflImg;
	}

	public void setGdPrflImg(String gdPrflImg) {
		this.gdPrflImg = gdPrflImg;
	}

	public String getUsrSlfIntdctn() {
		return usrSlfIntdctn;
	}

	public void setUsrSlfIntdctn(String usrSlfIntdctn) {
		this.usrSlfIntdctn = usrSlfIntdctn;
	}
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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

	public String getUsrPypEml() {
		return usrPypEml;
	}

	public void setUsrPypEml(String usrPypEml) {
		this.usrPypEml = usrPypEml;
	}

	public String getUsrGdExp() {
		return usrGdExp;
	}

	public void setUsrGdExp(String usrGdExp) {
		this.usrGdExp = usrGdExp;
	}

	public List<CitiesVO> getCities() {
		return cities;
	}

	public void setCities(List<CitiesVO> cities) {
		this.cities = cities;
	}

	public List<LicenseVO> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<LicenseVO> licenses) {
		this.licenses = licenses;
	}
}
