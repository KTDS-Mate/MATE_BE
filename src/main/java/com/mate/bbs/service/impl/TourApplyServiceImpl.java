package com.mate.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.bbs.dao.TourApplyDao;
import com.mate.bbs.service.TourApplyService;
import com.mate.bbs.vo.TourApplyVO;
import com.mate.payment.dao.PaymentDao;
import com.mate.payment.vo.WritePaymentVO;
import com.mate.user.vo.UserVO;

@Service
public class TourApplyServiceImpl  implements TourApplyService{
	
	@Autowired
	private TourApplyDao tourApplyDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	public TourApplyVO getOneTourApply(String gdApplyId) {
		return this.tourApplyDao.selectOneTourApply(gdApplyId);
	}
	
	@Transactional
	@Override
	public boolean acceptTourApply(String gdApplyId, UserVO loginUserVO) throws Exception {
		String athorId = this.tourApplyDao.selectTourAthor(gdApplyId);
		if (!(athorId == null || athorId.equals(loginUserVO.getUsrLgnId()))) {
			throw new Exception("글의 소유자가 아닙니다.");
		}
		if (this.tourApplyDao.updateOtherRefusal(gdApplyId) < 1) {
			throw new Exception("나머지 게시글 거절 처리에 실패했습니다.");
		}
		if (this.tourApplyDao.updateAcceptTourApply(gdApplyId) != 1) {
			throw new Exception("수락 처리에 실패했습니다.");
		}
		if (this.tourApplyDao.updateRequestTour(gdApplyId) != 1) {
			throw new Exception("투어 게시글 업데이트에 실패했습니다.");
		}
		
		WritePaymentVO writePaymentVO = this.tourApplyDao.selectApplyInfo(gdApplyId);
		if (writePaymentVO == null) {
			throw new Exception("에러가 발생했습니다.");
		}
		writePaymentVO.setTrstId(loginUserVO.getUsrLgnId());
		if (this.paymentDao.selectTrstTrPaymentCnt(gdApplyId) == 1) {
			return true;
		}
		if (this.paymentDao.insertTrstTrPayment(writePaymentVO) != 1) {
			throw new Exception("예약에 실패하였습니다.");
		}
		return true;
	}
	
	@Transactional
	@Override
	public boolean refusalTourApply(String gdApplyId, UserVO loginUserVO) throws Exception {
		String athorId = this.tourApplyDao.selectTourAthor(gdApplyId);
		if (!(athorId == null || athorId.equals(loginUserVO.getUsrLgnId()))) {
			throw new Exception("글의 소유자가 아닙니다.");
		}
		if (this.tourApplyDao.updateRefusalTourApply(gdApplyId) != 1) {
			throw new Exception("거절 처리에 실패했습니다.");
		}
		return true;
	}
	
	
	
	
}
