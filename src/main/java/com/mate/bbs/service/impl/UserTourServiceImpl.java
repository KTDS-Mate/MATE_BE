package com.mate.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.bbs.dao.UserTourDao;
import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.RequestGuideApplyListVO;
import com.mate.bbs.vo.RequestGuideApplyVO;
import com.mate.bbs.vo.RequestGuideApplyWriteVO;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourImgListVO;
import com.mate.bbs.vo.UserTourImgVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourSchdlVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;
import com.mate.common.beans.FileHandler;
import com.mate.common.vo.StoreResultVO;
import com.mate.payment.dao.PaymentDao;
import com.mate.payment.vo.WritePaymentVO;

@Service
public class UserTourServiceImpl implements UserTourService{

	@Autowired
	private UserTourDao userTourDao;
	
	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private FileHandler fileHandler;
	
	@Transactional
	@Override
	public boolean createNewUserTour(UserTourWriteVO userTourWriteVO) {
		
		// 당일치기 체크박스 값 가져오기(체크되면 true 아니면 null)
		boolean isChecked = userTourWriteVO.getIsChecked();
		
		// 체크가 되어있다면? => 당일치기
		if (isChecked) {
			// jsp에서 받아온 날짜 + 시작 시 + 시작 분을 이어붙이는 쿼리(포멧 맞추기)
			String startDt = this.userTourDao.selectAttachStartHour(userTourWriteVO);
			// jsp에서 받아온 날짜 + 종료 시 + 종료 분을 이어붙이는 쿼리(포멧 맞추기)
			String endDt = this.userTourDao.selectAttachEndHour(userTourWriteVO);
			// 포멧이 완료 된 시간을 USR_TR_ST_DT와 USR_TR_ED_DT에 담아줌
			userTourWriteVO.setUsrTrStDt(startDt);
			userTourWriteVO.setUsrTrEdDt(endDt);
		}
		// 아니면 다중
		else {
			String startDt = this.userTourDao.selectAttachMultyStartHour(userTourWriteVO);
			String endDt = this.userTourDao.selectAttachMultyEndHour(userTourWriteVO);
			userTourWriteVO.setUsrTrStDt(startDt);
			userTourWriteVO.setUsrTrEdDt(endDt);
		}
		
		
		// 리스트 형식으로 form에서 데이터를 받아와 새로운 리스트에 담아줌
		List<UserTourSchdlVO> schdlList = userTourWriteVO.getUserTourSchdlList();
		// PK를 먼저 발급받기 위해 호출
		int createCount = this.userTourDao.insertNewUserTour(userTourWriteVO);
		
		// 투어 희망정보를 작성하지 않으면 nullPointerException이 발생함으로 null 체크
		if (schdlList != null) {
			// 게시글이 작성 된 후 PK를 가져와 forEach문으로 INSERT문 반복
			for (UserTourSchdlVO userTourSchdlVO : schdlList) {
				// datetime-local 반환값 : YYYY-MM-DDTHH:MI
				// 형 변환 필요
				String dateTimeLocal = userTourSchdlVO.getTrTm();
				// T를 " "으로 변환해 형식을 맞춰줌
				String formmatedDate = dateTimeLocal.replace("T", " ");
				// 재 할당
				userTourSchdlVO.setTrTm(formmatedDate);
				// PK를 VO에 할당
				userTourSchdlVO.setUsrTrPstId(userTourWriteVO.getUsrTrPstId());
				// listSize만큼 INSERT문 반복
				this.userTourDao.insertUserTourScheduls(userTourSchdlVO);
			}
		}
		
		List<UserTourImgVO> userTourImgList = userTourWriteVO.getUserTourImgList();

		if (userTourImgList != null && !userTourImgList.isEmpty()) {
			for (UserTourImgVO userTourImgVO : userTourImgList) {
				userTourImgVO.setUsrTrPstId( userTourWriteVO.getUsrTrPstId() );
				StoreResultVO userTourImgResult = this.fileHandler.storeFile(userTourImgVO.getUserTourImgFile());
				
				if (userTourImgResult != null) {
					userTourImgVO.setUsrTrRqOriginFileName( userTourImgResult.getOriginFileName() );
					userTourImgVO.setUsrTrRqImgIdUrl( userTourImgResult.getObfuscatedFileName() );
				}
				
				this.userTourDao.insertNewUserTourImgs(userTourImgVO);
			}
		}
		
		return createCount > 0;
	}

	@Override
	public boolean createNewRequestTour(UserTourWriteVO userTourWriteVO) {
		
		boolean isChecked = userTourWriteVO.getIsChecked();
		
		if (isChecked) {
			// jsp에서 받아온 날짜 + 시작 시 + 시작 분을 이어붙이는 쿼리(포멧 맞추기)
			String startDt = this.userTourDao.selectAttachStartHour(userTourWriteVO);
			// jsp에서 받아온 날짜 + 종료 시 + 종료 분을 이어붙이는 쿼리(포멧 맞추기)
			String endDt = this.userTourDao.selectAttachEndHour(userTourWriteVO);
			// 포멧이 완료 된 시간을 USR_TR_ST_DT와 USR_TR_ED_DT에 담아줌
			userTourWriteVO.setUsrTrStDt(startDt);
			userTourWriteVO.setUsrTrEdDt(endDt);
		}
		else {
			String startDt = this.userTourDao.selectAttachMultyStartHour(userTourWriteVO);
			String endDt = this.userTourDao.selectAttachMultyEndHour(userTourWriteVO);
			userTourWriteVO.setUsrTrStDt(startDt);
			userTourWriteVO.setUsrTrEdDt(endDt);
		}
		
		int createCount = this.userTourDao.insertNewRequestTour(userTourWriteVO);
		
		return createCount > 0;
	}
	
	@Override
	public UserTourVO getOneUserTour(String usrTrPstId) {
		UserTourVO userTourVO = this.userTourDao.selectOneUserTour(usrTrPstId);
		List<UserTourSchdlVO> scdls = this.userTourDao.selectUserTourSchdls(usrTrPstId);
		int imgCnt = this.userTourDao.selectUserTourImgCount(usrTrPstId);
		
		userTourVO.setUserTourSchdlList(scdls);
		userTourVO.setUserTourImgCount(imgCnt);
		
		return userTourVO;
	}

	@Override
	public UserTourListVO getAllUserTour(SearchUserTourVO searchUserTourVO) {
		int userTourCnt = this.userTourDao.selectAllUserTourCount(searchUserTourVO);
		
		if (userTourCnt == 0) {
			// 등록 된 게시글이 없다면 에러를 발생시키지 않기 위해 새로운 인스턴스를 만들어서 반환
			UserTourListVO userTourListVO = new UserTourListVO();
			userTourListVO.setUserTourCount(0);
			userTourListVO.setUserTourList( new ArrayList<>() );
			return userTourListVO;
		}
		// pagination 을 위해 listSize를 보내줌
		searchUserTourVO.setListSize(5);
		searchUserTourVO.setPageCount(userTourCnt);
		
		List<UserTourVO> UserTourList = this.userTourDao.selectAllUserTour(searchUserTourVO);
		UserTourListVO userTourListVO = new UserTourListVO();
		
		userTourListVO.setUserTourCount(userTourCnt);
		userTourListVO.setUserTourList(UserTourList);
		
		return userTourListVO;
	}

	@Transactional
	@Override
	public boolean modifyUserTour(UserTourModifyVO userTourModifyVO) {
		// 사용자가 입력한 날짜를 받아와서 포멧에 맞춤
		String startDt = this.userTourDao.selectAttachStartHour2(userTourModifyVO);
		String endDt = this.userTourDao.selectAttachEndHour2(userTourModifyVO);
		// 포멧에 맞춘 시간을 담아줌
		userTourModifyVO.setUsrTrStDt(startDt);
		userTourModifyVO.setUsrTrEdDt(endDt);
		
		// 기존의 스케줄을 모두 삭제
		this.userTourDao.deleteUserTourSchdls(userTourModifyVO.getUsrTrPstId());
		
		// 새로 작성 한 리스트들을 다시 입력
		List<UserTourSchdlVO> tourschdlList = userTourModifyVO.getUserTourSchdlList();
		
		if (tourschdlList != null && !tourschdlList.isEmpty()) {
			for (UserTourSchdlVO userTourSchdlVO : tourschdlList) {
				userTourSchdlVO.setUsrTrPstId(userTourModifyVO.getUsrTrPstId());
				
				this.userTourDao.insertUserTourScheduls(userTourSchdlVO);
			}
		}
		
		int updateCount = this.userTourDao.updateUserTour(userTourModifyVO);
		
		return updateCount > 0;
	}

	@Transactional
	@Override
	public boolean softDeleteUserTour(String usrTrPstId) {
		int updateCount = this.userTourDao.updateUserTourIsDtl(usrTrPstId);
		return updateCount > 0;
	}

	@Transactional
	@Override
	public boolean reserveUserTour(String usrTrPstId, String usrLgnId) {
		if (this.userTourDao.updateGdId(usrTrPstId, usrLgnId) > 0) {
			WritePaymentVO writePaymentVO = this.paymentDao.selectUsrTrPayInf(usrTrPstId);
			if (writePaymentVO != null) {
				return this.paymentDao.insertTrstTrPayment(writePaymentVO) > 0 ;
			}
		}
		return false;
	}
	
	@Transactional
	@Override
	public boolean createNewRequestGuideApply(RequestGuideApplyWriteVO requestGuideApplyWriteVO) {
		
		int createCount = this.userTourDao.insertNewRequestGuideApply(requestGuideApplyWriteVO);
		
		List<UserTourSchdlVO> tourSchdlList = requestGuideApplyWriteVO.getUserTourSchdlList();
		if (tourSchdlList != null && !tourSchdlList.isEmpty()) {
			for (UserTourSchdlVO userTourSchdlVO : tourSchdlList) {
				// datetime-local 반환값 : YYYY-MM-DDTHH:MI
				// 형 변환 필요
				String dateTimeLocal = userTourSchdlVO.getTrTm();
				// T를 " "으로 변환해 형식을 맞춰줌
				String formmatedDate = dateTimeLocal.replace("T", " ");
				// 재 할당
				userTourSchdlVO.setTrTm(formmatedDate);
				userTourSchdlVO.setUsrTrPstId(requestGuideApplyWriteVO.getGdApplyId());
				
				this.userTourDao.insertUserTourScheduls(userTourSchdlVO);
			}
		}
		
		return createCount > 0;
	}

	@Override
	public RequestGuideApplyListVO getAllRequestGuideApply(String usrTrPstId) {
		int applyCount = this.userTourDao.selectRequestGuideApplyListCount(usrTrPstId);
		if (applyCount == 0) {
			RequestGuideApplyListVO requestGuideApplyListVO = new RequestGuideApplyListVO();
			requestGuideApplyListVO.setRequestGuideApplyCount(0);
			return requestGuideApplyListVO;
		}
		List<RequestGuideApplyVO> requestGuideApplyList = this.userTourDao.selectAllRequestGuideApplyList(usrTrPstId);
		RequestGuideApplyListVO requestGuideApplyListVO = new RequestGuideApplyListVO();
		requestGuideApplyListVO.setRequestGuideApplyCount(applyCount);
		requestGuideApplyListVO.setRequestGuideApplyList(requestGuideApplyList);
		
		return requestGuideApplyListVO;
	}
	
	@Override
	public UserTourImgListVO getUserTourImgs(String usrTrPstId) {
		int imgCount = this.userTourDao.selectUserTourImgCount(usrTrPstId);
		List<UserTourImgVO> userTourImgList = this.userTourDao.selectUserTourImgs(usrTrPstId);
		UserTourImgListVO userTourImgListVO = new UserTourImgListVO();
		userTourImgListVO.setImgCount(imgCount);
		userTourImgListVO.setUserTourImgList(userTourImgList);
		return userTourImgListVO;
	}
	
}
