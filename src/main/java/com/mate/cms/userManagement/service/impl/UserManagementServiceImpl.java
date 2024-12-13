package com.mate.cms.userManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.cms.userManagement.dao.UserManagementDao;
import com.mate.cms.userManagement.service.UserManagementService;
import com.mate.cms.userManagement.vo.UserManagementListVO;
import com.mate.cms.userManagement.vo.UserManagementVO;

@Service
public class UserManagementServiceImpl implements UserManagementService{

	@Autowired
	private UserManagementDao userManagementDao;
	
	@Override
	public UserManagementListVO getAllUserManagerment() {
		int userManagementCount = this.userManagementDao.selectUserManagementAllCount();
		
		if(userManagementCount == 0) {
			UserManagementListVO userManagementListVO = new UserManagementListVO();
			userManagementListVO.setUsrMngmntCnt(0);
			userManagementListVO.setUserManagementList(new ArrayList<>());
			
			return userManagementListVO;
		}
		
		List<UserManagementVO> UserManagementList = this.userManagementDao.selectAllUserManagement();
		UserManagementListVO userManagementListVO = new UserManagementListVO();
		// Setter 이용하여 count와 List를 ListVO에 넣어줌.
		userManagementListVO.setUsrMngmntCnt(userManagementCount);
		userManagementListVO.setUserManagementList(UserManagementList);
		return userManagementListVO;
	}
	
	@Override
	public UserManagementListVO getWaitingGuideUsers() {
		
		int waitingUsersCount = this.userManagementDao.selectWaitingGuideUsersCount();
		
		if(waitingUsersCount == 0) {
			UserManagementListVO userManagementListVO = new UserManagementListVO();
			userManagementListVO.setUsrMngmntCnt(0);
			userManagementListVO.setUserManagementList(new ArrayList<>());
			return userManagementListVO;
		}
		List<UserManagementVO> waitingGuideList = this.userManagementDao.selectWaitingGuideUsers();
		UserManagementListVO userManagementListVO = new UserManagementListVO();
		userManagementListVO.setUserManagementList(waitingGuideList);
		return userManagementListVO;
	}
	
	
}
