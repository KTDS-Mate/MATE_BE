package com.mate.cms.userManagement.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.cms.userManagement.dao.UserManagementDao;
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
	public int selectUserManagementAllCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectUserManagementAllCount");
	}

	/**
	 * 모든 회원 목록 조회
	 */
	@Override
	public List<UserManagementVO> selectAllUserManagement() {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllUserManagement");
	}
	
	@Override
	public List<UserManagementVO> selectWaitingGuideUsers() {
		return this.getSqlSession().selectList(NAMESPACE + ".selectWaitingGuideUsers");
	}
	
	@Override
	public int selectWaitingGuideUsersCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectWaitingGuideUsersCount");
	}
	
}
