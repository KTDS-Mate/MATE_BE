package com.mate.cms.userManagement.vo;

import java.util.List;

public class UserManagementListVO {

	/**
	 * 회원 전체 수
	 */
	private int usrMngmntCnt;
	
	/**
	 * 조회된 회원 목록
	 */
	private List<UserManagementVO> userManagementList;

	public int getUsrMngmntCnt() {
		return usrMngmntCnt;
	}

	public void setUsrMngmntCnt(int usrMngmntCnt) {
		this.usrMngmntCnt = usrMngmntCnt;
	}

	public List<UserManagementVO> getUserManagementList() {
		return userManagementList;
	}

	public void setUserManagementList(List<UserManagementVO> userManagementList) {
		this.userManagementList = userManagementList;
	}
	
}
