package com.mate.mypage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.mypage.dao.MyApplyTourDao;
import com.mate.mypage.vo.MyApplyGuideTourVO;
import com.mate.mypage.vo.MyApplyUserTourVO;
import com.mate.mypage.vo.SearchMyApplyTourVO;

@Repository
public class MyApplyTourDaoImpl extends SqlSessionDaoSupport implements MyApplyTourDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<MyApplyUserTourVO> selectAllMyApplyTours(String usrId, SearchMyApplyTourVO searchMyApplyTourVO) {
		Map<String, Object> params = new HashMap<>();
		params.put("usrId", usrId);
		params.put("search", searchMyApplyTourVO);
		
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllMyApplyTours", params);
	}
	
	@Override
	public int selectMyTourCount(String athrId, SearchMyApplyTourVO searchMyApplyTourVO) {
		Map<String, Object> params = new HashMap<>();
		params.put("athrId", athrId);
		params.put("search", searchMyApplyTourVO);
		
		return this.getSqlSession().selectOne(NAMESPACE + ".selectMyTourCount", params);
	}

	@Override
	public int updateGuideTourStts(String gdTrPstId) {
		return this.getSqlSession().update(NAMESPACE + ".updateGuideTourStts", gdTrPstId);
	}

	// -----------------------------------------------------------------------------------
	
	@Override
	public List<MyApplyGuideTourVO> selectAllMyApplyToursForGuide(String usrId, SearchMyApplyTourVO searchMyApplyTourVO) {
		Map<String, Object> params = new HashMap<>();
		params.put("usrId", usrId);
		params.put("search", searchMyApplyTourVO);
		
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllMyApplyToursForGuide", params);
	}

	@Override
	public int selectMyTourCountForGuide(String athrId, SearchMyApplyTourVO searchMyApplyTourVO) {
		Map<String, Object> params = new HashMap<>();
		params.put("athrId", athrId);
		params.put("search", searchMyApplyTourVO);
		return this.getSqlSession().selectOne(NAMESPACE + ".selectMyTourCountForGuide", params);
	}

	@Override
	public int updateUserTourStts(String usrTrPstId) {
		return this.getSqlSession().update(NAMESPACE + ".updateUserTourStts", usrTrPstId);
	}
	
}
