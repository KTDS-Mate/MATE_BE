package com.mate.cms.userManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.cms.userManagement.dao.UserManagementDao;
import com.mate.cms.userManagement.service.UserManagementService;
import com.mate.cms.userManagement.vo.SearchUserManagementVO;
import com.mate.cms.userManagement.vo.UserManagementListVO;
import com.mate.cms.userManagement.vo.UserManagementVO;

@Service
public class UserManagementServiceImpl implements UserManagementService{

	@Autowired
	private UserManagementDao userManagementDao;
	
	@Override
	public UserManagementListVO getAllUserManagerment(String filter) {
		int userManagementCount = this.userManagementDao.selectUserManagementAllCount(filter);
		
		if(userManagementCount == 0) {
			UserManagementListVO userManagementListVO = new UserManagementListVO();
			userManagementListVO.setUsrMngmntCnt(0);
			userManagementListVO.setUserManagementList(new ArrayList<>());
			
			return userManagementListVO;
		}
		
		List<UserManagementVO> UserManagementList = this.userManagementDao.selectAllUserManagement(filter);
		UserManagementListVO userManagementListVO = new UserManagementListVO();
		// Setter 이용하여 count와 List를 ListVO에 넣어줌.
		userManagementListVO.setUsrMngmntCnt(userManagementCount);
		userManagementListVO.setUserManagementList(UserManagementList);
		return userManagementListVO;
	}
	
	@Override
	public UserManagementListVO getWaitingGuideUsers(SearchUserManagementVO searchUserManagementVO) {
		
		int waitingUsersCount = this.userManagementDao.selectWaitingGuideUsersCount();
		
		if(waitingUsersCount == 0) {
			UserManagementListVO userManagementListVO = new UserManagementListVO();
			userManagementListVO.setUsrMngmntCnt(0);
			userManagementListVO.setUserManagementList(new ArrayList<>());
			return userManagementListVO;
		}
		
		searchUserManagementVO.setListSize(5);
		searchUserManagementVO.setPageCount(waitingUsersCount);
		
		List<UserManagementVO> waitingGuideList = this.userManagementDao.selectWaitingGuideUsers(searchUserManagementVO);
		UserManagementListVO userManagementListVO = new UserManagementListVO();
		userManagementListVO.setUserManagementList(waitingGuideList);
		userManagementListVO.setUsrMngmntCnt(waitingUsersCount);
		return userManagementListVO;
	}
	
	
	@Override
	public boolean doAcceptGuideApprove(String usrId) {
		int updateCnt = this.userManagementDao.updateAcceptApprove(usrId);
		return updateCnt > 0;
	}
	
	@Override
	public boolean doRefuseGuideApprove(String usrId) {
		int updateCnt =this.userManagementDao.updateRefuseApprove(usrId);
		return updateCnt > 0;
	}
	
	
	@Override
	public boolean doDeleteUser(String usrId, String usrIsCl) {
		int updateCnt = 0;
		if (usrIsCl.equals("N")) {
			updateCnt = this.userManagementDao.updateDeleteUser(usrId);
		}else {
			updateCnt = this.userManagementDao.updateUndoDeleteUser(usrId);
		}
		return updateCnt > 0;
	}
	
	@Override
	public boolean doBlockUser(String usrId , String usrIsBlck) {
		int updateCnt = 0;
		if (usrIsBlck.equals("N")) {
			updateCnt = this.userManagementDao.updateBlockUser(usrId);
		}else {
			updateCnt = this.userManagementDao.updateUndoBlockUser(usrId);
		}
		
		return updateCnt > 0;
	}
	
}
