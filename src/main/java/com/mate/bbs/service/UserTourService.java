package com.mate.bbs.service;

import com.mate.bbs.vo.UserTourInsertVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourVO;

public interface UserTourService {

	public boolean createNewUserTour(UserTourInsertVO userTourInsertVO);
	
	public UserTourVO getOneUserTour(String usrTrPstId);

	public UserTourListVO getAllUserTour();
	
	public boolean modifyUserTour(UserTourModifyVO userTourModifyVO);
	
	public boolean softDeleteUserTour(String usrTrPstId);
}
