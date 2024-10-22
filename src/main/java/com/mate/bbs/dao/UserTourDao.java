package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.UserTourInsertVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourVO;

public interface UserTourDao {

	public String NAMESPACE = "com.mate.bbs.dao.UserTourDao";
	
	public int insertNewUserTour(UserTourInsertVO userTourInsertVO);
	
	public UserTourVO selectOneUserTour(String usrTrPstId);
	
	public int selectUserTourCount();
	
	public List<UserTourVO> selectAllUserTour();
	
	public int updateUserTour(UserTourModifyVO userTourModifyVO);
	
	public int updateUserTourIsDlt(String usrTrPstId);
	
}
