package com.mate.bbs.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		GuideTourListVO guideTourListVO = new GuideTourListVO();
		List<GuideTourVO> guideTourList = new ArrayList<>();
		
		int guideTourListCount = this.guideTourDao.selectGuideTourAllCount();
		guideTourListVO.setGdTrPstCnt(guideTourListCount);
		guideTourList = this.guideTourDao.selectAllGuideTour();
		guideTourListVO.setGuideTourList(guideTourList);
		
		return guideTourListVO;
	}
	@Override
	public boolean createNewGuideTour(GuideTourWriteVO guideTourWriteVO) {
		int guideTourInsertCount = this.guideTourDao.insertNewGuideTour(guideTourWriteVO);
		return guideTourInsertCount > 0;
	}
	@Override
	public boolean updateGuideTourModify(GuideTourModifyVO guideTourModifyVO) {
		int guideTourUpdateCount = this.guideTourDao.updateGuideTour(guideTourModifyVO);
		return guideTourUpdateCount > 0;
	}
	@Override
	public boolean updateGuideTourDelete(String gdTrPstId) {
		int guideTourDeleteCount = this.guideTourDao.updateGuideTourIsDtl(gdTrPstId);
		return guideTourDeleteCount > 0;
	}
}
