package com.mate.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.TourApplyDao;
import com.mate.bbs.service.TourApplyService;
import com.mate.bbs.vo.TourApplyVO;

@Service
public class TourApplyServiceImpl  implements TourApplyService{
	
	@Autowired
	private TourApplyDao tourApplyDao;
	
	@Override
	public TourApplyVO getOneTourApply(String gdApplyId) {
		return this.tourApplyDao.selectOneTourApply(gdApplyId);
	}
}
