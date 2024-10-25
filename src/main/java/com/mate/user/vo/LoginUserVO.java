package com.mate.user.vo;

<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotBlank;

>>>>>>> main
public class LoginUserVO {
	
	private String usrId;
	
	private String usrLgnId;
	
	private String email;
	
	private String usrPwd;

	private String nextUrl;
	
	private String ip;
	
	private String usrIsGd;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsrPwd() {
		return usrPwd;
	}

	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsrIsGd() {
		return usrIsGd;
	}

	public void setUsrIsGd(String usrIsGd) {
		this.usrIsGd = usrIsGd;
	}
}
