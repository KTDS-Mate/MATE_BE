package com.mate.cms.userManagement.service;

import com.mate.cms.userManagement.vo.UserManagementListVO;

public interface UserManagementService {

	/**
	 * 모든 회원 조회
	 * @param usrId
	 * @return
	 */
	public UserManagementListVO getAllUserManagerment();
	
	/**
	 * 가이드 신청 회원 조회
	 * @return
	 */
	public UserManagementListVO getWaitingGuideUsers();
}
