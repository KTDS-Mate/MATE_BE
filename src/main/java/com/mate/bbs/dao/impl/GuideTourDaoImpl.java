package com.mate.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.GuideTourDao;
import com.mate.bbs.vo.GuideTourDetailInfoVO;
import com.mate.bbs.vo.GuideTourImgVO;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourProvidedVO;
import com.mate.bbs.vo.GuideTourReserveVO;
import com.mate.bbs.vo.GuideTourReviewVO;
import com.mate.bbs.vo.GuideTourScheduleInfoVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;
import com.mate.bbs.vo.SearchGuideTourVO;

@Repository
public class GuideTourDaoImpl extends SqlSessionDaoSupport implements GuideTourDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	/**
	 * 가이드 투어 전체 수를 조회
	 */
	@Override
	public int selectGuideTourAllCount(SearchGuideTourVO searchGuideTourVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectGuideTourAllCount", searchGuideTourVO);
	}
	
	/**
	 * 모든 가이드 투어 목록 조회 (검색)
	 */
	@Override
	public List<GuideTourVO> selectAllGuideTour(SearchGuideTourVO searchGuideTourVO) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllGuideTour", searchGuideTourVO);
	}
	/**
	 * 한 가이드 투어 게시글 조회
	 */
	@Override
	public GuideTourVO selectOneGuideTour(String gdTrPstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneGuideTour", gdTrPstId);
	}
	/**
	 * 새로운 가이드 투어를 생성
	 */
	@Override
	public int insertNewGuideTour(GuideTourWriteVO guideTourWriteVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewGuideTour", guideTourWriteVO);
	}
	/**
	 * 가이드 투어 수정
	 */
	@Override
	public int updateGuideTour(GuideTourModifyVO guideTourModifyVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateGuideTour", guideTourModifyVO);
	}
	/**
	 * 가이드 투어 삭제 ( 소프트 딜리트 )
	 */
	@Override
	public int updateGuideTourIsDtl(String gdTrPstId) {
		return this.getSqlSession().update(NAMESPACE + ".updateGuideTourIsDtl", gdTrPstId);
	}
	@Override
	public String selectAttachStartHour(GuideTourWriteVO guideTourWriteVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachStartHour", guideTourWriteVO);
	}
	@Override
	public String selectAttachModifyStartHour(GuideTourModifyVO guideTourModifyVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachModifyStartHour", guideTourModifyVO);
	}
	@Override
	public String selectAttachEndHour(GuideTourWriteVO guideTourWriteVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachEndHour", guideTourWriteVO);
	}
	@Override
	public String selectAttachModifyEndHour(GuideTourModifyVO guideTourModifyVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachModifyEndHour", guideTourModifyVO);
	}
	@Override
	public String selectAttachMultyStartHour(GuideTourWriteVO guideTourWriteVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachMultyStartHour", guideTourWriteVO);
	}
	@Override
	public String selectAttachMultyEndHour(GuideTourWriteVO guideTourWriteVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachMultyEndHour", guideTourWriteVO);
	}
	@Override
	public int insertNewDetailInfo(GuideTourDetailInfoVO guideTourDetailInfoVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewDetailInfo", guideTourDetailInfoVO);
	}
	@Override
	public int insertNewSchdInfo(GuideTourScheduleInfoVO guideTourScheduleInfoVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewSchdInfo", guideTourScheduleInfoVO);
	}
	@Override
	public int insertNewProvidedInfo(GuideTourProvidedVO guideTourProvidedVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewProvidedInfo", guideTourProvidedVO);
	}
	
	@Override
	public List<GuideTourDetailInfoVO> selectTourDetailInfoList(String gdTrPstId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectTourDetailInfoList", gdTrPstId);
	}
	@Override
	public List<GuideTourProvidedVO> selectTourProvidedList(String gdTrPstId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectTourProvidedList", gdTrPstId);
	}
	@Override
	public List<GuideTourScheduleInfoVO> selectTourScheduleList(String gdTrPstId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectTourScheduleList", gdTrPstId);
	}

	@Override
	public List<GuideTourVO> getRandomGuideTours() {
		return this.getSqlSession().selectList(NAMESPACE + ".getRandomGuideTours");
	}
	
	@Override
	public int deleteGuideTourSchdls(String gdTrPstId) {
		return this.getSqlSession().delete(NAMESPACE + ".deleteGuideTourSchdls", gdTrPstId);
	}
	@Override
	public int deleteGuideTourDetails(String gdTrPstId) {
		return this.getSqlSession().delete(NAMESPACE + ".deleteGuideTourDetails", gdTrPstId);
	}
	@Override
	public int deleteGuideTourProvided(String gdTrPstId) {
		return this.getSqlSession().delete(NAMESPACE + ".deleteGuideTourProvided", gdTrPstId);
	}

	@Override
	public int selectImgCount(String gdTrPstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectImgCount", gdTrPstId);
	}
	
	@Override
	public List<GuideTourImgVO> selectGuideTourImgList(String gdTrPstId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectGuideTourImgList", gdTrPstId);
	}
	
	@Override
	public GuideTourVO selectLateGuideTour() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectLateGuideTour");
	}
	
	@Override
	public String selectAttachMultyStartHour2(GuideTourModifyVO guideTourModifyVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachMultyStartHour2", guideTourModifyVO);
	}
	@Override
	public String selectAttachMultyEndHour2(GuideTourModifyVO guideTourModifyVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAttachMultyEndHour2", guideTourModifyVO);
	}
	@Override
	public int updateGuideTourReserve(GuideTourReserveVO guideTourReserveVO) {
		return this.getSqlSession().update(NAMESPACE+ ".updateGuideTourReserve", guideTourReserveVO);
	}
	
}
