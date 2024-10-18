package com.mate.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.UserTourDao;
import com.mate.bbs.vo.ModifyUserTourVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.WriteUserTourVO;

@Repository
public class UserTourDaoImpl extends SqlSessionDaoSupport implements UserTourDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNewUserTour(WriteUserTourVO writeUserTourVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewUserTour", writeUserTourVO);
	}

	@Override
	public UserTourVO selectOneUserTour(String usrTrPstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneUserTour", usrTrPstId);
	}
	
	@Override
	public int selectUserTourCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectUserTourCount");
	}

	@Override
	public List<UserTourVO> selectAllUserTour() {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllUserTour");
	}

	@Override
	public int updateUserTourContent(ModifyUserTourVO modifyUserTourVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateUserTourContent", modifyUserTourVO);
	}

	@Override
	public int updateUserTourIsDlt(String usrTrPstId) {
		return this.getSqlSession().update(NAMESPACE + ".updateUserTourIsDlt", usrTrPstId);
	}

}
