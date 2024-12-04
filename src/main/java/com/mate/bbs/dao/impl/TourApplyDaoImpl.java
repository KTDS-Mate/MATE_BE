package com.mate.bbs.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.TourApplyDao;
import com.mate.bbs.vo.TourApplyVO;

@Repository
public class TourApplyDaoImpl extends SqlSessionDaoSupport implements TourApplyDao {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		// TODO Auto-generated method stub
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	
	@Override
	public TourApplyVO selectOneTourApply(String gdApplyId) {
		return this.getSqlSession().selectOne("selectOneTourApply",gdApplyId);
	}

	@Override
	public boolean isAlreadyAccept(String gdApplyId) {
		int result = this.getSqlSession().selectOne("isAlreadyAccept", gdApplyId);
		return result > 0;
	}
	
}
