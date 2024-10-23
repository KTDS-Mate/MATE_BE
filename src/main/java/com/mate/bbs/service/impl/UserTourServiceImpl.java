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
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;

@Service
public class UserTourServiceImpl implements UserTourService{

	@Autowired
	private UserTourDao userTourDao;

	@Transactional
	@Override
	public boolean createNewUserTour(UserTourWriteVO userTourWriteVO) {
		int createCount = this.userTourDao.insertNewUserTour(userTourWriteVO);
		
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
