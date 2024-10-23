package com.mate.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.GuideTourDao;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;

@Repository
public class GuideTourDaoImpl extends SqlSessionDaoSupport implements GuideTourDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectGuideTourAllCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectGuideTourAllCount");
	}
	@Override
	public List<GuideTourVO> selectAllGuideTour() {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllGuideTour");
	}
	@Override
	public GuideTourVO selectOneGuideTour(String gdTrPstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneGuideTour", gdTrPstId);
	}
	
	@Override
	public int insertNewGuideTour(GuideTourWriteVO guideTourWriteVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewGuideTour", guideTourWriteVO);
	}
	@Override
	public int updateGuideTour(GuideTourModifyVO guideTourModifyVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateGuideTour", guideTourModifyVO);
	}
	@Override
	public int updateGuideTourIsDtl(String gdTrPstId) {
		return this.getSqlSession().update(NAMESPACE + ".updateGuideTourIsDtl", gdTrPstId);
	}
}
