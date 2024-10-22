package com.mate.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.UserTourDao;
import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.UserTourInsertVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourVO;

@Service
public class UserTourServiceImpl implements UserTourService {

	@Autowired
	private UserTourDao userTourDao;
	
	@Override
	public boolean createNewUserTour(UserTourInsertVO userTourInsertVO) {
		return this.userTourDao.insertNewUserTour(userTourInsertVO) > 0;
	}

	@Override
	public UserTourVO getOneUserTour(String usrTrPstId) {
		return this.userTourDao.selectOneUserTour(usrTrPstId);
	}

	@Override
	public UserTourListVO getAllUserTour() {
		UserTourListVO userTourListVO = new UserTourListVO();
		int userTourCount = this.userTourDao.selectUserTourCount();
		List<UserTourVO> userTourList = this.userTourDao.selectAllUserTour();
		userTourListVO.setUserTourCount(userTourCount);
		userTourListVO.setUserTourList(userTourList);
		
		return userTourListVO;
	}

	@Override
	public boolean modifyUserTour(UserTourModifyVO userTourModifyVO) {
		return this.userTourDao.updateUserTour(userTourModifyVO) > 0;
	}

	@Override
	public boolean softDeleteUserTour(String usrTrPstId) {
		return this.userTourDao.updateUserTourIsDlt(usrTrPstId) > 0;
	}

	
	
}
