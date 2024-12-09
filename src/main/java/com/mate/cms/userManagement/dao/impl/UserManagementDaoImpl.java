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
	public int selectUserManagementAllCount(String usrId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectUserManagementAllCount", usrId);
	}

	/**
	 * 모든 회원 목록 조회
	 */
	@Override
	public List<UserManagementVO> selectAllUserManagement(String usrId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllUserManagement", usrId);
	}

	/**
	 * 한 회원 조회
	 */
	@Override
	public UserManagementVO selectOneUserManagement(String usrId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneUserManagement", usrId);
	}

	
	
	
}
