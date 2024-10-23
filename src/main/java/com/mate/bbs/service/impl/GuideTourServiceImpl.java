package com.mate.bbs.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.bbs.dao.GuideTourDao;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;

@Service
public class GuideTourServiceImpl implements GuideTourService{

	@Autowired
	private GuideTourDao guideTourDao;
	
	@Override
	public GuideTourListVO getAllGuideTour() {
		int guideTourListCount = this.guideTourDao.selectGuideTourAllCount();
		
		if(guideTourListCount == 0) {
			GuideTourListVO guideTourListVO = new GuideTourListVO();
			guideTourListVO.setGdTrPstCnt(0);
			guideTourListVO.setGuideTourList(new ArrayList<>());
			
			return guideTourListVO;
		}
		List<GuideTourVO> guideTourList = this.guideTourDao.selectAllGuideTour();
		
		GuideTourListVO guideTourListVO = new GuideTourListVO();
		guideTourListVO.setGdTrPstCnt(guideTourListCount);
		guideTourListVO.setGuideTourList(guideTourList);
		
		return guideTourListVO;
	}
	
	@Override
	public GuideTourVO getOneGuideTour(String gdTrPstId) {
		GuideTourVO guideTourVO = this.guideTourDao.selectOneGuideTour(gdTrPstId);
		return guideTourVO;
	}
	
	@Transactional
	@Override
	public boolean createNewGuideTour(GuideTourWriteVO guideTourWriteVO) {
		int guideTourInsertCount = this.guideTourDao.insertNewGuideTour(guideTourWriteVO);
		return guideTourInsertCount > 0;
	}
	@Transactional
	@Override
	public boolean modifyGuideTourModify(GuideTourModifyVO guideTourModifyVO) {
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
