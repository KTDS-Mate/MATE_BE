package com.mate.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.GuideTourReviewDao;
import com.mate.bbs.vo.GuideTourReviewVO;
import com.mate.bbs.vo.GuideTourReviewWriteVO;

@Repository
public class GuideTourReviewDaoImpl extends SqlSessionDaoSupport implements GuideTourReviewDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	/**
	 * 가이드 투어 리뷰 한개 조회
	 * @param gdTrRvwId
	 * @return
	 */
	@Override
	public GuideTourReviewVO selectOneGuideTourReview(String gdTrRvwId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneGuideTourReview" , gdTrRvwId);
	}
	/**
	 * 가이드 투어 리뷰 전체 조회
	 * @param gdTrPstId
	 * @return
	 */
	@Override
	public List<GuideTourReviewVO> selectGuideTourAllReview(String gdTrPstId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectGuideTourAllReview", gdTrPstId);
	}
	
	@Override
	public int selectGuideTourReviewCount(String gdTrPstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectGuideTourReviewCount", gdTrPstId);
	}
	
	/**
	 * 가이드 투어 리뷰 추가
	 * @param guideTourReviewVO
	 * @return
	 */
	@Override
	public int insertNewGuideTourReview(GuideTourReviewWriteVO guideTourReviewWriteVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewGuideTourReview", guideTourReviewWriteVO);
	}
	/**
	 * 가이드 투어 리뷰 수정
	 * @param guideTourReviewVO
	 * @return
	 */
	@Override
	public int updateGuideTourReview(GuideTourReviewVO guideTourReviewVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateGuideTourReview",guideTourReviewVO);
	}
	/**
	 * 가이드 투어 리뷰 삭제 ( 소프트 딜리트 )
	 * @param gdTrRvwId
	 * @return
	 */
	@Override
	public int deleteGuideTourReview(String gdTrRvwId) {
		return this.getSqlSession().update(NAMESPACE + ".deleteGuideTourReview", gdTrRvwId);
	}
	@Override
	public GuideTourReviewVO selectLateGuideTourReview() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectLateGuideTourReview");
	}
}
