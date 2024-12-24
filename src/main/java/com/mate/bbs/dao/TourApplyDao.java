package com.mate.bbs.dao;

import com.mate.bbs.vo.TourApplyVO;
import com.mate.payment.vo.WritePaymentVO;

public interface TourApplyDao {
	
	public String NAMESPACE = "com.mate.bbs.dao.TourApplyDao";
	
	public TourApplyVO selectOneTourApply(String gdApplyId);
	
	public String selectTourAthor(String gdApplyId);
	
	public int updateOtherRefusal(String gdApplyId);
	
	public int updateAcceptTourApply(String gdApplyId);
	
	public int updateRequestTour(String gdApplyId);
	
	public WritePaymentVO selectApplyInfo(String gdApplyId);
	
	public int updateRefusalTourApply(String gdApplyId);
	
}
