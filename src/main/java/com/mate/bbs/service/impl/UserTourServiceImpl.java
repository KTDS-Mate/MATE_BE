package com.mate.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.bbs.dao.UserTourDao;
import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourImgVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourSchdlVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;
import com.mate.common.beans.FileHandler;
import com.mate.common.vo.StoreResultVO;

@Service
public class UserTourServiceImpl implements UserTourService{

	@Autowired
	private UserTourDao userTourDao;

	@Autowired
	private FileHandler fileHandler;
	
	@Transactional
	@Override
	public boolean createNewUserTour(UserTourWriteVO userTourWriteVO) {
		// jsp에서 받아온 날짜 + 시작 시 + 시작 분을 이어붙이는 쿼리(포멧 맞추기)
		String startDt = this.userTourDao.selectAttachStartHour(userTourWriteVO);
		// jsp에서 받아온 날짜 + 종료 시 + 종료 분을 이어붙이는 쿼리(포멧 맞추기)
		String endDt = this.userTourDao.selectAttachEndHour(userTourWriteVO);
		// 포멧이 완료 된 시간을 USR_TR_ST_DT와 USR_TR_ED_DT에 담아줌
		userTourWriteVO.setUsrTrStDt(startDt);
		userTourWriteVO.setUsrTrEdDt(endDt);
		
		// 리스트 형식으로 form에서 데이터를 받아와 새로운 리스트에 담아줌
		List<UserTourSchdlVO> schdlList = userTourWriteVO.getUserTourSchdlList();
		// PK를 먼저 발급받기 위해 호출
		int createCount = this.userTourDao.insertNewUserTour(userTourWriteVO);
		
		// 투어 희망정보를 작성하지 않으면 nullPointerException이 발생함으로 null 체크
		if (schdlList != null) {
			// 게시글이 작성 된 후 PK를 가져와 forEach문으로 INSERT문 반복
			for (UserTourSchdlVO userTourSchdlVO : schdlList) {
				// PK를 VO에 할당
				userTourSchdlVO.setUsrTrPstId(userTourWriteVO.getUsrTrPstId());
				// listSize만큼 INSERT문 반복
				this.userTourDao.insertUserTourScheduls(userTourSchdlVO);
			}
		}
		
		// 이미지가 계속 null로 들어가여
//		List<UserTourImgVO> imgList = userTourWriteVO.getUserTourImgList();
//		
//		if (imgList != null && !imgList.isEmpty()) {
//			for (UserTourImgVO userTourImgVO : imgList) {
//				String usrTrPstId = userTourWriteVO.getUsrTrPstId();
//				userTourImgVO.setUsrTrPstId(usrTrPstId);
//				
//				StoreResultVO imgResult= fileHandler.storeFile(userTourWriteVO.getUsrTourImgFile());
//				if (imgResult != null) {
//					userTourWriteVO.setImgFileName(imgResult.getObfuscatedFileName());
//				}
//				this.userTourDao.insertNewUserTourImgs(userTourImgVO);
//			}
//		}
		
		return createCount > 0;
	}

	@Override
	public UserTourVO getOneUserTour(String usrTrPstId) {
		UserTourVO userTourVO = this.userTourDao.selectOneUserTour(usrTrPstId);
		List<UserTourSchdlVO> scdls = this.userTourDao.selectUserTourSchdls(usrTrPstId);
		
		userTourVO.setUserTourSchdlList(scdls);
		
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
		// 한 화면에 보여 줄 게시글 수 지정
		searchUserTourVO.setListSize(9);
		// pagination 을 위해 listSize를 보내줌
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
	
}
