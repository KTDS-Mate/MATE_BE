package com.mate.user.vo;

import jakarta.validation.constraints.NotBlank;

public class RegistUserVO {

	private String usrId;
	
	@NotBlank(message = "아이디를 입력해주세요.")
	private String usrLgnId;

	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String usrPw;
	
	@NotBlank(message = "비밀번호를 다시 한번 입력해주세요.")
	private String confirmPw;
	
	@NotBlank(message = "이름을 입력해주세요.")
	private String usrLnm;
	
	@NotBlank(message = "성을 입력해주세요.")
	private String usrFnm;
	
	@NotBlank(message = "지역번호를 포함한 휴대폰 번호를 입력해주세요.")
	private String usrPhn;
	
	private String usrGndr;
	
	private String usrBd;
	
	@NotBlank(message = "이메일을 입력해 주세요.")
	private String usrEml;
	
	private String salt;

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

	public String getUsrPw() {
		return usrPw;
	}

	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
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

	public String getConfirmPw() {
		return confirmPw;
	}

	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}
