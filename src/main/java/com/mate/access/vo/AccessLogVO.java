package com.mate.access.vo;

public class AccessLogVO {

	// PK
	private String accessLogId;
	
	// 접근 유형
	private String accessType;
	
	// 유저의 아이디(usrLgnId)
	private String accessId;
	
	// 접근 시간
	private String accessTime;
	
	// 접근 URL
	private String accessUrl;
	
	// 접근 HTTP method
	private String accessMethod;
	
	// 접근 IP
	private String accessIp;
	
	// login 성공/실패 여부
	private String loginSuccessYn;
	
	
	private String usrIsGd;
	
	
	public String getAccessLogId() {
		return accessLogId;
	}

	public void setAccessLogId(String accessLogId) {
		this.accessLogId = accessLogId;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}

	public String getAccessUrl() {
		return accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	public String getAccessMethod() {
		return accessMethod;
	}

	public void setAccessMethod(String accessMethod) {
		this.accessMethod = accessMethod;
	}

	public String getAccessIp() {
		return accessIp;
	}

	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
	}

	public String getLoginSuccessYn() {
		return loginSuccessYn;
	}

	public void setLoginSuccessYn(String loginSuccessYn) {
		this.loginSuccessYn = loginSuccessYn;
	}

	public String getUsrIsGd() {
		return usrIsGd;
	}

	public void setUsrIsGd(String usrIsGd) {
		this.usrIsGd = usrIsGd;
	}
}
