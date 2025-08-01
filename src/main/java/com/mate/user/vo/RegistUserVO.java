package com.mate.user.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistUserVO {

	private String usrId;
	
	@NotBlank(message = "아이디를 입력해주세요.")
	@Size(min=4, max=20)
	private String usrLgnId;

	@NotBlank(message = "영문, 숫자, 특수 문자를 포함해서 8자 이상 16자 이하로 입력해주세요.")
	@Size(min=8, max=16)
	private String usrPwd;
	
	@NotBlank(message = "비밀번호를 다시 한번 입력해주세요.")
	private String confirmPwd;
	
	@NotBlank(message = "성을 입력해주세요.")
	private String usrLnm;
	
	@NotBlank(message = "이름을 입력해주세요.")
	private String usrFnm;
	
	@NotBlank(message = "지역번호를 포함한 휴대폰 번호를 입력해주세요.")
	private String usrPhn;
	
	private String usrGndr;
	
	private String usrBd;
	
	@NotBlank(message = "이메일을 입력해 주세요.")
	@Email(message = "이메일 형식에 맞게 입력해주세요.")
	private String usrEml;
	
	private String salt;
	
	
	private String authVerified;
	
	// 국가 번호 코드
	private String usrCntCode;

	@NotBlank(message ="국적을 입력하세요.")
	private String gdRpCntId;
	
	public String getAuthVerified() {
		return authVerified;
	}

	public void setAuthVerified(String authVerified) {
		this.authVerified = authVerified;
	}

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

	public String getUsrPhn() {
		return usrPhn;
	}

	public void setUsrPhn(String usrPhn) {
		this.usrPhn = usrPhn;
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

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPw(String confirmPw) {
		this.confirmPwd = confirmPw;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUsrCntCode() {
		return usrCntCode;
	}

	public void setUsrCntCode(String usrCntCode) {
		this.usrCntCode = usrCntCode;
	}

	public String getGdRpCntId() {
		return gdRpCntId;
	}

	public void setGdRpCntId(String gdRpCntId) {
		this.gdRpCntId = gdRpCntId;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
}
