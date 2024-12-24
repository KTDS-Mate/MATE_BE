package com.mate.cms.userManagement.dao;

import java.util.List;

import com.mate.cms.customerService.vo.SearchCustomerServiceVO;
import com.mate.cms.userManagement.vo.SearchUserManagementVO;
import com.mate.cms.userManagement.vo.UserManagementVO;

public interface UserManagementDao {

	public String NAMESPACE = "com.mate.cms.userManagement.dao.UserManagementDao";
	
	/**
	 * 회원 전체 수 조회
	 * @param usrId
	 * @return
	 */
	public int selectUserManagementAllCount(String filter);
	
	/**
	 * 모든 회원 목록 조회
	 */
	public List<UserManagementVO> selectAllUserManagement(String filter);
	
	/**
	 * 가이드 신청 인원 조회
	 * @return
	 */
	public List<UserManagementVO> selectWaitingGuideUsers(SearchUserManagementVO searchUserManagementVO);
	
	/**
	 * 가이드 신청 인원 수 조회
	 * @return
	 */
	public int selectWaitingGuideUsersCount();
	
	public int updateAcceptApprove(String usrId);
	
	public int updateRefuseApprove(String usrId);
	
	
	public int updateDeleteUser(String usrId);
	
	public int updateBlockUser(String usrId);
	
	public int updateUndoDeleteUser(String usrId);
	
	public int updateUndoBlockUser(String usrId);
	
}
