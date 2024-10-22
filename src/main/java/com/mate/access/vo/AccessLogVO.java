package com.mate.access.vo;

public class AccessLogVO {

	private String accessLogId;
	
	private String accessType;
	
	private String accessEmail;
	
	private String accessTime;
	
	private String accessUrl;
	
	private String accessMethod;
	
	private String accessIp;
	
	private String loginSuccessStatus;

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

	public String getAccessEmail() {
		return accessEmail;
	}

	public void setAccessEmail(String accessEmail) {
		this.accessEmail = accessEmail;
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

	public String getLoginSuccessStatus() {
		return loginSuccessStatus;
	}

	public void setLoginSuccessStatus(String loginSuccessStatus) {
		this.loginSuccessStatus = loginSuccessStatus;
	}
}
