package com.mate.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.UserTourDao;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourSchdlVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;

@Repository
public class UserTourDaoImpl extends SqlSessionDaoSupport implements UserTourDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNewUserTour(UserTourWriteVO userTourWriteVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewUserTour", userTourWriteVO);
	}

	@Override
	public UserTourVO selectOneUserTour(String usrTrPstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneUserTour", usrTrPstId);
	}

	@Override
	public int selectAllUserTourCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAllUserTourCount");
	}
	
	@Override
	public List<UserTourVO> selectAllUserTour(SearchUserTourVO searchUserTourVO) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllUserTour", searchUserTourVO);
	}
	
	@Override
	public int updateUserTour(UserTourModifyVO userTourModifyVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateUserTour", userTourModifyVO);
	}

	@Override
	public int updateUserTourIsDtl(String usrTrPstId) {
		return this.getSqlSession().update(NAMESPACE + ".updateUserTourIsDtl", usrTrPstId);
	}

	@Override
	public String selectAttachStartHour(UserTourWriteVO userTourWriteVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachStartHour", userTourWriteVO);
	}
	
	@Override
	public String selectAttachEndHour(UserTourWriteVO userTourWriteVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachEndHour", userTourWriteVO);
	}
	
	@Override
	public int insertUserTourScheduls(UserTourSchdlVO userTourSchdlVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertUserTourScheduls", userTourSchdlVO);
	}
	
}
