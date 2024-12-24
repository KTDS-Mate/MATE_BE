package com.mate.cms.userManagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.cms.customerService.vo.SearchCustomerServiceVO;
import com.mate.cms.userManagement.dao.UserManagementDao;
import com.mate.cms.userManagement.vo.SearchUserManagementVO;
import com.mate.cms.userManagement.vo.UserManagementVO;

@Repository
public class UserManagementDaoImpl extends SqlSessionDaoSupport implements UserManagementDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	/**
	 * 회원 전체 수 조회
	 */
	@Override
	public int selectUserManagementAllCount(String filter) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectUserManagementAllCount", filter);
	}

	/**
	 * 모든 회원 목록 조회
	 */
	@Override
	public List<UserManagementVO> selectAllUserManagement(String filter) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllUserManagement", filter);
	}
	
	@Override
	public List<UserManagementVO> selectWaitingGuideUsers(SearchUserManagementVO searchUserManagementVO) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectWaitingGuideUsers", searchUserManagementVO);
	}
	
	@Override
	public int selectWaitingGuideUsersCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectWaitingGuideUsersCount");
	}
	
	@Override
	public int updateAcceptApprove(String usrId) {
		return this.getSqlSession().update(NAMESPACE + ".updateGuideApprove", usrId);
	}
	
	
	@Override
	public int updateRefuseApprove(String usrId) {
		return this.getSqlSession().update(NAMESPACE + ".updateRefuseApprove", usrId);
	}
	
	@Override
	public int updateDeleteUser(String usrId) {
		return this.getSqlSession().update(NAMESPACE + ".updateDeleteUser", usrId);
	}
	
	@Override
	public int updateBlockUser(String usrId) {
		return this.getSqlSession().update(NAMESPACE + ".updateBlockUser", usrId);
	}
	
	@Override
	public int updateUndoDeleteUser(String usrId) {
		return this.getSqlSession().update(NAMESPACE + ".updateUndoDeleteUser", usrId);
	}
	
	@Override
	public int updateUndoBlockUser(String usrId) {
		return this.getSqlSession().update(NAMESPACE + ".updateUndoBlockUser", usrId);
	}
	
	
	
}
