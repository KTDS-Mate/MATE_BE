package com.mate.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.bbs.dao.UserTourDao;
import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourSchdlVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;

@Service
public class UserTourServiceImpl implements UserTourService{

	@Autowired
	private UserTourDao userTourDao;

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
		
		// 게시글이 작성 된 후 PK를 가져와 forEach문으로 INSERT문 반복
		for (UserTourSchdlVO userTourSchdlVO : schdlList) {
			// PK를 VO에 할당
			userTourSchdlVO.setUsrTrPstId(userTourWriteVO.getUsrTrPstId());
			// listSize만큼 INSERT문 반복
			this.userTourDao.insertUserTourScheduls(userTourSchdlVO);
		}
		
		return createCount > 0;
	}

	@Override
	public UserTourVO getOneUserTour(String usrTrPstId) {
		UserTourVO userTourVO = this.userTourDao.selectOneUserTour(usrTrPstId);
		return userTourVO;
	}

	@Override
	public UserTourListVO getAllUserTour(SearchUserTourVO searchUserTourVO) {
		int userTourCnt = this.userTourDao.selectAllUserTourCount();
		
		if (userTourCnt == 0) {
			// 등록 된 게시글이 없다면 에러를 발생시키지 않기 위해 새로운 인스턴스를 만들어서 반환
			UserTourListVO userTourListVO = new UserTourListVO();
			userTourListVO.setUserTourCount(0);
			userTourListVO.setUserTourList( new ArrayList<>() );
			return userTourListVO;
		}
		
		List<UserTourVO> UserTourList = this.userTourDao.selectAllUserTour(searchUserTourVO);
		// pagination 을 위해 listSize를 보내줌
		searchUserTourVO.setPageCount(userTourCnt);
		// 한 화면에 보여 줄 게시글 수 지정
		searchUserTourVO.setListSize(9);
		UserTourListVO userTourListVO = new UserTourListVO();
		userTourListVO.setUserTourCount(userTourCnt);
		userTourListVO.setUserTourList(UserTourList);
		
		return userTourListVO;
	}

	@Transactional
	@Override
	public boolean modifyUserTour(UserTourModifyVO userTourModifyVO) {
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
