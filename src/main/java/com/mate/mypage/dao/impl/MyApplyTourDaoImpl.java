package com.mate.mypage.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.vo.UserTourVO;
import com.mate.mypage.dao.MyApplyTourDao;

@Repository
public class MyApplyTourDaoImpl extends SqlSessionDaoSupport implements MyApplyTourDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<UserTourVO> selectAllMyTours(String athrId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllMyTours", athrId);
	}
	
	@Override
	public int selectMyTourCount(String athrId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectMyTourCount", athrId);
	}

	@Override
	public int updateUserTourStts(String usrTrPstId) {
		return this.getSqlSession().update(NAMESPACE + ".updateUserTourStts", usrTrPstId);
	}

}
