package com.mate.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.UserTourDao;
import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.ModifyUserTourVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.WriteUserTourVO;

@Service
public class UserTourServiceImpl implements UserTourService {

	@Autowired
	private UserTourDao userTourDao;

	@Override
	public boolean createNewUserTour(WriteUserTourVO writeUserTourVO) {
		this.userTourDao.insertNewUserTour(writeUserTourVO);
		return false;
	}

	@Override
	public boolean readOneUserTour(String usrTrPstId) {
		this.userTourDao.selectOneUserTour(usrTrPstId);
		return false;
	}

	@Override
	public UserTourListVO readAllUserTour() {
		UserTourListVO userTourListVO = new UserTourListVO();
		int userTourCount = this.userTourDao.selectUserTourCount();
		List<UserTourVO> userTourList = this.userTourDao.selectAllUserTour();
		
		userTourListVO.setUserTourCount(userTourCount);
		userTourListVO.setUserTourList(userTourList);
		
		return userTourListVO;
	}

	@Override
	public boolean modifyUserTourContent(ModifyUserTourVO modifyUserTourVO) {
		return this.userTourDao.updateUserTourContent(modifyUserTourVO) > 0;
	}

	@Override
	public boolean softDeleteUserTour(String usrTrPstId) {
		return this.userTourDao.updateUserTourIsDlt(usrTrPstId) > 0;
	}
	
	
	
}
