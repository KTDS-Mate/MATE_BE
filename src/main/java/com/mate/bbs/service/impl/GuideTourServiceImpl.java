package com.mate.bbs.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.bbs.dao.GuideTourDao;
import com.mate.bbs.dao.GuideTourReviewDao;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourDetailInfoVO;
import com.mate.bbs.vo.GuideTourImgListVO;
import com.mate.bbs.vo.GuideTourImgVO;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourProvidedVO;
import com.mate.bbs.vo.GuideTourReserveVO;
import com.mate.bbs.vo.GuideTourReviewVO;
import com.mate.bbs.vo.GuideTourScheduleInfoVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;
import com.mate.bbs.vo.SearchGuideTourVO;
import com.mate.payment.dao.PaymentDao;

@Service
public class GuideTourServiceImpl implements GuideTourService{

	@Autowired
	private GuideTourDao guideTourDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private GuideTourReviewDao guideTourReviewDao;
	
	/**
	 * 모든 가이드 투어 전체 수를 조회
	 */
	@Override
	public GuideTourListVO getAllGuideTour(SearchGuideTourVO searchGuideTourVO) {
		int guideTourListCount = this.guideTourDao.selectGuideTourAllCount(searchGuideTourVO);
		
		if(guideTourListCount == 0) {
			GuideTourListVO guideTourListVO = new GuideTourListVO();
			guideTourListVO.setGdTrPstCnt(0);
			guideTourListVO.setGuideTourList(new ArrayList<>());
			
			return guideTourListVO;
		}
		
		searchGuideTourVO.setListSize(5);
		searchGuideTourVO.setPageCount(guideTourListCount);
		
		List<GuideTourVO> guideTourList = this.guideTourDao.selectAllGuideTour(searchGuideTourVO);
		GuideTourListVO guideTourListVO = new GuideTourListVO();
		
		guideTourListVO.setGdTrPstCnt(guideTourListCount);
		guideTourListVO.setGuideTourList(guideTourList);
		// TODO 여기에 사진
		System.out.println("todo" + guideTourListCount);
		return guideTourListVO;
	}
	
	@Override
	public GuideTourVO getOneGuideTour(String gdTrPstId) {
		
		GuideTourVO guideTourVO = this.guideTourDao.selectOneGuideTour(gdTrPstId);
		List<GuideTourDetailInfoVO> tourDetailInfoList = this.guideTourDao.selectTourDetailInfoList(gdTrPstId);
		List<GuideTourScheduleInfoVO> tourScheduleInfoList = this.guideTourDao.selectTourScheduleList(gdTrPstId);
		List<GuideTourProvidedVO> tourProvidedInfoList = this.guideTourDao.selectTourProvidedList(gdTrPstId);
		List<GuideTourImgVO> guideTourImgList = this.guideTourDao.selectGuideTourImgList(gdTrPstId);
		List<GuideTourReviewVO> guideTourReviewList = this.guideTourReviewDao.selectGuideTourAllReview(gdTrPstId);
		int imgCnt = this.guideTourDao.selectImgCount(gdTrPstId);
		guideTourVO.setGuideTourDetailInfoList(tourDetailInfoList);
		guideTourVO.setGuideTourScheduleInfoList(tourScheduleInfoList);
		guideTourVO.setGuideTourProvidedList(tourProvidedInfoList);
		guideTourVO.setGuideTourImgList(guideTourImgList);
		guideTourVO.setGuideImgCount(imgCnt);
		guideTourVO.setGuideTourReviewList(guideTourReviewList);
		
		return guideTourVO;
	}
	
	@Transactional
	@Override
	public boolean createNewGuideTour(GuideTourWriteVO guideTourWriteVO) {
		// 당일치기 체크박스 값 가져오기(체크되면 true 아니면 null)
		boolean isChecked = guideTourWriteVO.getIsChecked();
		
		// 체크가 되어있다면? => 당일치기
		if(isChecked) {
			/** jsp에서 받아온 날짜 + 시작 시 + 시작 분 이어붙이는 쿼리 */
			String startHour = this.guideTourDao.selectAttachStartHour(guideTourWriteVO);
			/** jsp에서 받아온 날짜 + 종료 시 + 종료 분 이어붙이는 쿼리 */
			String endHour = this.guideTourDao.selectAttachEndHour(guideTourWriteVO);
			
			/** 완료된 위 쿼리 시간을 DB의 GD_TR_ST_DT, GD_TR_ED_DT에 담아준다. */
			guideTourWriteVO.setGdTrStDt(startHour);
			guideTourWriteVO.setGdTrEdDt(endHour);
		} else {
			String startDt = this.guideTourDao.selectAttachMultyStartHour(guideTourWriteVO);
			String endDt = this.guideTourDao.selectAttachMultyEndHour(guideTourWriteVO);
			guideTourWriteVO.setGdTrStDt(startDt);
			guideTourWriteVO.setGdTrEdDt(endDt);
		}
		
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
		boolean isChecked = guideTourModifyVO.getIsChecked();
		if (isChecked) {
			// 가이드가 입력한 날짜를 받아와서 포멧에 맞춤
			String startHour = this.guideTourDao.selectAttachModifyStartHour(guideTourModifyVO);
			String endHour = this.guideTourDao.selectAttachModifyEndHour(guideTourModifyVO);
			// 포멧에 맞춘 시간을 담아준다.
			guideTourModifyVO.setGdTrStDt(startHour);
			guideTourModifyVO.setGdTrEdDt(endHour);
		}
		else {
			String startDt = this.guideTourDao.selectAttachMultyStartHour2(guideTourModifyVO);
			String endDt = this.guideTourDao.selectAttachMultyEndHour2(guideTourModifyVO);
			guideTourModifyVO.setGdTrStDt(startDt);
			guideTourModifyVO.setGdTrEdDt(endDt);
			
		}
		
		// 기존의 스케쥴을 모두 삭제
		this.guideTourDao.deleteGuideTourSchdls(guideTourModifyVO.getGdTrPstId());
		// 기존의 추가 정보를 모두 삭제
		this.guideTourDao.deleteGuideTourDetails(guideTourModifyVO.getGdTrPstId());
		// 기존의 제공 요소를 모두 삭제
		this.guideTourDao.deleteGuideTourProvided(guideTourModifyVO.getGdTrPstId());
		
		// 새로 작성 한 리스트들을 다시 입력
		List<GuideTourScheduleInfoVO> guideTourSchdlList = guideTourModifyVO.getGuideTourScheduleInfoList();
		List<GuideTourDetailInfoVO> guideTourDetailList = guideTourModifyVO.getGuideTourDetailInfoList();
		List<GuideTourProvidedVO> guideTourProvidedList = guideTourModifyVO.getGuideTourProvidedList();
		
		if(guideTourSchdlList != null && !guideTourSchdlList.isEmpty()) {
			for (GuideTourScheduleInfoVO guideTourScheduleInfoVO : guideTourSchdlList) {
				guideTourScheduleInfoVO.setGdTrPstId(guideTourModifyVO.getGdTrPstId());
				
				this.guideTourDao.insertNewSchdInfo(guideTourScheduleInfoVO);
			}
		}
		if(guideTourDetailList != null && !guideTourDetailList.isEmpty()) {
			for (GuideTourDetailInfoVO guideTourDetailInfoVO : guideTourDetailList) {
				guideTourDetailInfoVO.setGdTrPstId(guideTourModifyVO.getGdTrPstId());
				
				this.guideTourDao.insertNewDetailInfo(guideTourDetailInfoVO);
			}
		}
		if(guideTourProvidedList != null && !guideTourProvidedList.isEmpty()) {
			for(GuideTourProvidedVO guideTourProvidedVO : guideTourProvidedList) {
				guideTourProvidedVO.setGdTrPstId(guideTourModifyVO.getGdTrPstId());
				
				this.guideTourDao.insertNewProvidedInfo(guideTourProvidedVO);
			}
		}
		
		int guideTourUpdateCount = this.guideTourDao.updateGuideTour(guideTourModifyVO);
		
		return guideTourUpdateCount > 0;
	}
	
	@Transactional
	@Override
	public boolean softDeleteGuideTour(String gdTrPstId) {
		int guideTourDeleteCount = this.guideTourDao.updateGuideTourIsDtl(gdTrPstId);
		return guideTourDeleteCount > 0;
	}

	@Override
	public List<GuideTourVO> getRandomGuideTours() {
		return guideTourDao.getRandomGuideTours();
	}

	@Override
	public GuideTourImgListVO getGuideTourImgs(String gdTrPstId) {
		int guideTourImgCount = this.guideTourDao.selectImgCount(gdTrPstId);
		List<GuideTourImgVO> guideTourImgList = this.guideTourDao.selectGuideTourImgList(gdTrPstId);
		
		GuideTourImgListVO guideTourImgListVO = new GuideTourImgListVO();
		guideTourImgListVO.setGuideTourImgCount(guideTourImgCount);
		guideTourImgListVO.setGuideTourImgList(guideTourImgList);
		
		return guideTourImgListVO;
	}
	
	@Override
	public GuideTourVO getLateGuideTour() {
		GuideTourVO guideTourVO = this.guideTourDao.selectLateGuideTour();
		return guideTourVO;
	}
	@Transactional
	@Override
	public boolean updateGuideTourStts(GuideTourReserveVO guideTourReserveVO) {
		return this.guideTourDao.updateGuideTourReserve(guideTourReserveVO) > 0;
	}
	
}
