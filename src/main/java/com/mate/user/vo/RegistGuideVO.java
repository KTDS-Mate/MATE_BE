package com.mate.user.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;

public class RegistGuideVO {
	/**
	 * 회원의 아이디(PK)
	 */
	private String usrId;
	/**
	 * 회원의 로그인 아이디
	 */
	private String usrLgnId;
	/**
	 * 가이드 여부
	 */
	private String usrIsGd;
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
     * 성별
     */
    private String usrGndr;
    /**
     * 가이드 프로필 이미지 
     */
    private String gdPrflImg;
    /**
     * 가이드의 신분증 사진
     */
    private String gdIdImg;
    
    /**
     * 가이드의 범죄경력 조회서 사진
     */
    private String gdCbcImg;
    /**
     * 가이드 자기소개
     */
    private String usrSlfIntdctn;
    /**
     * 가이드 활동 도시 : CITIES 테이블, GD_ACT_CT는 완충 테이블
     */
    private List<CitiesVO> cities;
    
    /**
     * 가이드 활동 국가 리스트: COUNTRIES 테이블.
     */
    private List<CountriesVO> countries;
    /**
     * 가이드가 활동하는 도시의 PK
     */
    private String cityId;
    /**
     * 가이드가 활동하는 도시
     */
    private String cityName;
    /**
     * 국가 아이디 PK
     */
	private String gdRpCntId;
    /**
     * 라이센스 이름, 이미지 : GD_LCN 테이블
     */

	private List<LicenseVO> licenses;
	
	/**
     * 가이드 라이센스명
     */
    private String gdLcnNm;
    /**
     * 가이드 라이센스 이미지
     */
    private String gdLcnImg;
    /**
     * 페이팔 이메일(정산계좌)
     */
    private String usrPypEml;
    
    /**
     * 가이드 경력
     */
    private String usrGdExp;
    /**
     * 가이드가 활동하는 국가
     */
    private String countryName;
    /**
     * 가이드 등록일
     */
    private String gdRgstDt;
    /**
     * FE에서 선택된 도시들 DB에 저장하기 위한 변수
     */
    private List<String> selectedCities;
    
    private String gdApplStt;
    
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

	public String getUsrIsGd() {
		return usrIsGd;
	}

	public void setUsrIsGd(String usrIsGd) {
		this.usrIsGd = usrIsGd;
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

	public String getGdRpCntId() {
		return gdRpCntId;
	}

	public void setGdRpCntId(String gdRpCntId) {
		this.gdRpCntId = gdRpCntId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getGdLcnNm() {
		return gdLcnNm;
	}

	public void setGdLcnNm(String gdLcnNm) {
		this.gdLcnNm = gdLcnNm;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getGdRgstDt() {
		return gdRgstDt;
	}

	public void setGdRgstDt(String gdRgstDt) {
		this.gdRgstDt = gdRgstDt;
	}
	
	public List<CountriesVO> getCountries() {
		return countries;
	}

	public void setCountries(List<CountriesVO> countries) {
		this.countries = countries;
	}

	public List<String> getSelectedCities() {
		return selectedCities;
	}

	public void setSelectedCities(List<String> selectedCities) {
		this.selectedCities = selectedCities;
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

	public String getGdLcnImg() {
		return gdLcnImg;
	}

	public void setGdLcnImg(String gdLcnImg) {
		this.gdLcnImg = gdLcnImg;
	}

	public String getGdApplStt() {
		return gdApplStt;
	}

	public void setGdApplStt(String gdApplStt) {
		this.gdApplStt = gdApplStt;
	}
	
}
