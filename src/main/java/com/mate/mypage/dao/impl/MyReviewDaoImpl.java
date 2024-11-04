package com.mate.mypage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.mypage.dao.MyReviewDao;
import com.mate.mypage.vo.GuideReviewVO;
import com.mate.mypage.vo.GuideTourReviewVO;
import com.mate.mypage.vo.SearchGuideReviewVO;
import com.mate.mypage.vo.SearchGuideTourReviewVO;

@Repository
public class MyReviewDaoImpl extends SqlSessionDaoSupport implements MyReviewDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	
//  -------------------------------------------------------------------------투어리스트파트


	@Override
	public int countGuideReview(String usrLgnId, SearchGuideReviewVO searchGuideReviewVO) {
		Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", searchGuideReviewVO);
		return this.getSqlSession().selectOne(NAMESPACE + ".countGuideReview", params);
	}
	@Override
	public List<GuideReviewVO> selectAllGuideReview(String usrLgnId) {
		Map<String, Object> params = new HashMap<>();
    	params.put("loginId", usrLgnId);
    	
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllGuideReview", params);
	}
	@Override
	public List<GuideReviewVO> selectAllGuideReview(String usrLgnId, SearchGuideReviewVO searchGuideReviewVO) {
		Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", searchGuideReviewVO);
        
        return this.getSqlSession().selectList(NAMESPACE + ".selectAllGuideReview", params);
	}
	@Override
	public int deleteGuideReview(String gdRvwId) {

		return this.getSqlSession().update(NAMESPACE +".deleteGuideReview", gdRvwId);
	}
	
//  -------------------------------------------------------------------------가이드파트

	
	@Override
	public int countGuideTourReview(String usrLgnId, SearchGuideTourReviewVO searchGuideTourReviewVO) {
		Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", searchGuideTourReviewVO);
        
        
		return this.getSqlSession().selectOne(NAMESPACE + ".countGuideTourReview" , params);
	}
	@Override
	public List<GuideTourReviewVO> selectAllGuideTourReview(String usrLgnId) {
		Map<String, Object> params = new HashMap<>();
    	params.put("loginId", usrLgnId);
    	
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllGuideTourReview", params);
	}
	@Override
	public List<GuideTourReviewVO> selectAllGuideTourReview(String usrLgnId, SearchGuideTourReviewVO SearchGuideTourReviewVO) {
		Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", SearchGuideTourReviewVO);
        
        
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllGuideTourReview", params);
	}
	@Override
	public int deleteGuideTourReview(String gdTrRvwId) {
		
		return this.getSqlSession().update(NAMESPACE + ".deleteGuideTourReview", gdTrRvwId);
	}
	
}
