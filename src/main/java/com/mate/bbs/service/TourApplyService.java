package com.mate.bbs.service;

import com.mate.bbs.vo.TourApplyVO;
import com.mate.user.vo.UserVO;


public interface TourApplyService {
	
	public TourApplyVO getOneTourApply(String gdApplyId);
	
	public boolean acceptTourApply(String gdApplyId, UserVO loginUserVO) throws Exception;
	
	public boolean refusalTourApply(String gdApplyId, UserVO loginUserVO) throws Exception;
	
}
