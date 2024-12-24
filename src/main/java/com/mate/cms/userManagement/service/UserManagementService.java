package com.mate.cms.userManagement.service;

import com.mate.cms.userManagement.vo.SearchUserManagementVO;
import com.mate.cms.userManagement.vo.UserManagementListVO;

public interface UserManagementService {

	/**
	 * 모든 회원 조회
	 * @param usrId
	 * @return
	 */
	public UserManagementListVO getAllUserManagerment(String filter);
	
	/**
	 * 가이드 신청 회원 조회
	 * @return
	 */
	public UserManagementListVO getWaitingGuideUsers(SearchUserManagementVO searchUserManagementVO);

	
	public boolean doAcceptGuideApprove(String usrId);
	
	public boolean doRefuseGuideApprove(String usrId);
	
	public boolean doDeleteUser(String usrId, String usrIsCl);
	
	public boolean doBlockUser(String usrId, String usrIsBlck);
	
}
