package com.mate.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.GuideTourDao;
import com.mate.bbs.service.GuideTourService;
import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourVO;

@Service
public class GuideTourServiceImpl implements GuideTourService{

	@Autowired
	private GuideTourDao guideTourDao;
	
	@Override
	public GuideTourListVO getAllGuideTour() {
		
		int guideTourCount = this.guideTourDao.selectGuideTourAllCount();
		
		List<GuideTourVO> guideTourList = this.guideTourDao.selectAllGuideTour();
		
		GuideTourListVO guideTourListVO = new GuideTourListVO();
		guideTourListVO.setGdTrPstCnt(guideTourCount);
//		guideTourListVO.setGuideTourList(guideTourList);
			
		return guideTourListVO;
	}
}
