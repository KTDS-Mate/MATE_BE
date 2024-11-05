package com.mate.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.UserTourDao;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourImgVO;
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
	public int selectAllUserTourCount(SearchUserTourVO searchUserTourVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAllUserTourCount", searchUserTourVO);
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
	public String selectAttachStartHour2(UserTourModifyVO userTourModifyVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachStartHour2", userTourModifyVO);
	}
	
	@Override
	public String selectAttachEndHour(UserTourWriteVO userTourWriteVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachEndHour", userTourWriteVO);
	}
	
	@Override
	public String selectAttachEndHour2(UserTourModifyVO userTourModifyVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachEndHour2", userTourModifyVO);
	}
	
	@Override
	public int insertUserTourScheduls(UserTourSchdlVO userTourSchdlVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertUserTourScheduls", userTourSchdlVO);
	}
	
	@Override
	public List<UserTourSchdlVO> selectUserTourSchdls(String usrTrPstId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectUserTourSchdls", usrTrPstId);
	}
	
	@Override
	public int insertNewUserTourImgs(UserTourImgVO userTourImgVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewUserTourImgs", userTourImgVO);
	}
	
	@Override
	public int deleteUserTourSchdls(String usrTrPstId) {
		return this.getSqlSession().delete(NAMESPACE + ".deleteUserTourSchdls", usrTrPstId);
	}
}
