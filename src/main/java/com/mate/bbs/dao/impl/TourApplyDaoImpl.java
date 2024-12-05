package com.mate.bbs.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.TourApplyDao;
import com.mate.bbs.vo.TourApplyVO;
import com.mate.payment.vo.WritePaymentVO;

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
	public String selectTourAthor(String gdApplyId) {
		String athorId = this.getSqlSession().selectOne("selectTourAthor", gdApplyId);
		return athorId;
	}
	
	@Override
	public int updateAcceptTourApply(String gdApplyId) {
		return this.getSqlSession().update("updateAcceptTourApply", gdApplyId);
	}
	
	@Override
	public int updateRequestTour(String gdApplyId) {
		return this.getSqlSession().update("updateRequestTour", gdApplyId);
	}
	
	@Override
	public WritePaymentVO selectApplyInfo(String gdApplyId) {
		return this.getSqlSession().selectOne("selectApplyInfo", gdApplyId);
	}
	
	@Override
	public int updateRefusalTourApply(String gdApplyId) {
		return this.getSqlSession().update("updateRefusalTourApply" ,gdApplyId);
	}
	
	
}
