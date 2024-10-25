package com.mate.mail.vo;

public class EmailVO {

	/**
	 * 사용자가 입력한 이메일
	 */
	private String email;

	/**
	 * 발급된 인증 코드
	 */
	private String authCode;
	
	/**
	 * 인증코드 발급시간
	 */
	private String issueTime;

	/**
	 * 인증 여부
	 */
	private String authVerified;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(String issueTime) {
		this.issueTime = issueTime;
	}

	public String getAuthVerified() {
		return authVerified;
	}

	public void setAuthVerified(String authVerified) {
		this.authVerified = authVerified;
	}
}
