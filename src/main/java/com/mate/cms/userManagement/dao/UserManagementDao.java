package com.mate.cms.userManagement.dao;

import java.util.List;

import com.mate.cms.userManagement.vo.UserManagementVO;

public interface UserManagementDao {

	public String NAMESPACE = "com.mate.cms.userManagement.dao.UserManagementDao";
	
	/**
	 * 회원 전체 수 조회
	 * @param usrId
	 * @return
	 */
	public int selectUserManagementAllCount(String usrId);
	
	/**
	 * 모든 회원 목록 조회
	 */
	public List<UserManagementVO> selectAllUserManagement(String usrId);
	
	/**
	 * 한 회원 조회
	 */
	public UserManagementVO selectOneUserManagement(String usrId);
	
}
