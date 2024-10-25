package com.mate.user.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.user.dao.UserDao;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int getIdCount(String userId) {
		return getSqlSession().selectOne(NAMESPACE + ".getIdCount", userId);
	}
	
	@Override
	public int insertNewUser(RegistUserVO registUserVO) {
		return getSqlSession().insert(NAMESPACE + ".insertNewUser", registUserVO);
	}
	
	@Override
	public int softDeleteOneUser(String usrLgnId) {
		return getSqlSession().update(NAMESPACE + ".softDeleteOneUser", usrLgnId);
	}
	
	@Override
	public int getEmailCount(String email) {
		return this.getSqlSession().selectOne(NAMESPACE + ".getEmailCount",email);
	}
	
	@Override
	public String selectSalt(String usrId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectSalt", usrId);
	}
	
	@Override
	public UserVO selectOneMember(LoginUserVO loginUserVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneMember", loginUserVO);
	}
	
	@Override
	public int updateLoginFailState(LoginUserVO loginUserVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateLoginFailState", loginUserVO);
	}
	
	@Override
	public int upadateLoginSuccessState(LoginUserVO loginUserVO) {
		return this.getSqlSession().update(NAMESPACE + ".upadateLoginSuccessState", loginUserVO);
	}
	
	@Override
	public int selectLoginRestrictionCount(String usrId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectLoginRestrictionCount", usrId);
	}
}
