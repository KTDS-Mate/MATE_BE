package com.mate.bbs.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.bbs.dao.GuideTourDao;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourDetailInfoVO;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourProvidedVO;
import com.mate.bbs.vo.GuideTourScheduleInfoVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;
import com.mate.bbs.vo.SearchGuideTourVO;

@Service
public class GuideTourServiceImpl implements GuideTourService{

	@Autowired
	private GuideTourDao guideTourDao;
	
	/**
	 * 모든 가이드 투어 전체 수를 조회
	 */
	@Override
	public GuideTourListVO getAllGuideTour(SearchGuideTourVO searchGuideTourVO) {
		int guideTourListCount = this.guideTourDao.selectGuideTourAllCount();
		
		if(guideTourListCount == 0) {
			GuideTourListVO guideTourListVO = new GuideTourListVO();
			guideTourListVO.setGdTrPstCnt(0);
			guideTourListVO.setGuideTourList(new ArrayList<>());
			
			return guideTourListVO;
		}
		List<GuideTourVO> guideTourList = this.guideTourDao.selectAllGuideTour(searchGuideTourVO);
		
		searchGuideTourVO.setListSize(5);
		searchGuideTourVO.setPageCount(guideTourListCount);
		
		GuideTourListVO guideTourListVO = new GuideTourListVO();
		guideTourListVO.setGdTrPstCnt(guideTourListCount);
		guideTourListVO.setGuideTourList(guideTourList);
		
		return guideTourListVO;
	}
	
	@Override
	public GuideTourVO getOneGuideTour(String gdTrPstId) {
		
		GuideTourVO guideTourVO = this.guideTourDao.selectOneGuideTour(gdTrPstId);
		List<GuideTourDetailInfoVO> tourDetailInfoList = this.guideTourDao.selectTourDetailInfoList(gdTrPstId);
		List<GuideTourScheduleInfoVO> tourScheduleInfoList = this.guideTourDao.selectTourScheduleList(gdTrPstId);
		List<GuideTourProvidedVO> tourProvidedInfoList = this.guideTourDao.selectTourProvidedList(gdTrPstId);
		guideTourVO.setGuideTourDetailInfoList(tourDetailInfoList);
		guideTourVO.setGuideTourScheduleInfoList(tourScheduleInfoList);
		guideTourVO.setGuideTourProvidedList(tourProvidedInfoList);
		
		return guideTourVO;
	}
	
	@Transactional
	@Override
	public boolean createNewGuideTour(GuideTourWriteVO guideTourWriteVO) {
		/** jsp에서 받아온 날짜 + 시작 시 + 시작 분 이어붙이는 쿼리 */
		String startHour = this.guideTourDao.selectAttachStartHour(guideTourWriteVO);
		/** jsp에서 받아온 날짜 + 종료 시 + 종료 분 이어붙이는 쿼리 */
		String endHour = this.guideTourDao.selectAttachEndHour(guideTourWriteVO);
		/** 완료된 위 쿼리 시간을 DB의 GD_TR_ST_DT, GD_TR_ED_DT에 담아준다. */
		guideTourWriteVO.setGdTrStDt(startHour);
		guideTourWriteVO.setGdTrEdDt(endHour);
		
		// PK를 먼저 발급받기 위해 호출
		int guideTourInsertCount = this.guideTourDao.insertNewGuideTour(guideTourWriteVO);
		// 리스트 형식으로 form에서 데이터를 받아와 새로운 리스트에 담아준다.
		List<GuideTourDetailInfoVO> detailInfoList = guideTourWriteVO.getGuideTourDetailInfoList();
		
		// 투어 상세정보를 작성하지 않으면 NullPointerException이 발생함으로 null 체크 해준다.
		if(detailInfoList != null) {
			// 게시글이 작성 된 후에 PK를 가져와 forEach문으로 INSERT 반복하는 쿼리.
			for (GuideTourDetailInfoVO guideTourDetailInfoVO : detailInfoList) {
				// PK를 VO에 할당한다.
				guideTourDetailInfoVO.setGdTrPstId(guideTourWriteVO.getGdTrPstId());
				// listSize만큼 INSERT문 반복한다.
				this.guideTourDao.insertNewDetailInfo(guideTourDetailInfoVO);
			}
		}
		
		List<GuideTourScheduleInfoVO> tourScheduleInfoList = guideTourWriteVO.getGuideTourScheduleInfoList();
		
		if(tourScheduleInfoList != null) {
			for (GuideTourScheduleInfoVO guideTourScheduleInfoVO : tourScheduleInfoList) {
				guideTourScheduleInfoVO.setGdTrPstId(guideTourWriteVO.getGdTrPstId());
				this.guideTourDao.insertNewSchdInfo(guideTourScheduleInfoVO);
			}
		}
		
		List<GuideTourProvidedVO> tourProvidedList = guideTourWriteVO.getGuideTourProvidedList();
		
		if (tourProvidedList != null) {
			for (GuideTourProvidedVO guideTourProvidedVO : tourProvidedList) {
				guideTourProvidedVO.setGdTrPstId(guideTourWriteVO.getGdTrPstId());
				this.guideTourDao.insertNewProvidedInfo(guideTourProvidedVO);
			}
		}
		
		return guideTourInsertCount > 0;
	}
	@Transactional
	@Override
	public boolean modifyGuideTour(GuideTourModifyVO guideTourModifyVO) {
		// 가이드가 입력한 날짜를 받아와서 포멧에 맞춤
		String startHour = this.guideTourDao.selectAttachModifyStartHour(guideTourModifyVO);
		String endHour = this.guideTourDao.selectAttachModifyEndHour(guideTourModifyVO);
		// 포멧에 맞춘 시간을 담아준다.
		guideTourModifyVO.setGdTrRstrDt(startHour);
		guideTourModifyVO.setGdTrEdDt(endHour);
		
		int guideTourUpdateCount = this.guideTourDao.updateGuideTour(guideTourModifyVO);
		return guideTourUpdateCount > 0;
	}
	@Transactional
	@Override
	public boolean softDeleteGuideTour(String gdTrPstId) {
		int guideTourDeleteCount = this.guideTourDao.updateGuideTourIsDtl(gdTrPstId);
		return guideTourDeleteCount > 0;
	}
}
