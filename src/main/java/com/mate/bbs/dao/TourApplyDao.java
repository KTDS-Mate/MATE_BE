package com.mate.bbs.dao;

import com.mate.bbs.vo.TourApplyVO;

public interface TourApplyDao {
	
	public TourApplyVO selectOneTourApply(String gdApplyId);
	
	public boolean isAlreadyAccept(String gdApplyId);
}
