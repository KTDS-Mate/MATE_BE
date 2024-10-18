package com.mate.bbs.service;

import com.mate.bbs.vo.ModifyUserTourVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.WriteUserTourVO;

public interface UserTourService {

	public boolean createNewUserTour(WriteUserTourVO writeUserTourVO);
	
	public boolean readOneUserTour(String usrTrPstId);
	
	public UserTourListVO readAllUserTour();
	
	public boolean modifyUserTourContent(ModifyUserTourVO modifyUserTourVO);
	
	public boolean softDeleteUserTour(String usrTrPstId);
	
}
