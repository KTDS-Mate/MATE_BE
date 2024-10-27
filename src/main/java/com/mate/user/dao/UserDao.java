package com.mate.user.dao;

import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

public interface UserDao {
	
	public String NAMESPACE = "com.mate.user.dao.UserDao";
	
	public int insertNewUser(RegistUserVO registUserVO);

	public int getIdCount(String usrId);
	
	public int getEmailCount(String email);
	
	public int getPhnCount(String usrPhn);
	
	public String selectSalt(String usrId);
	
	UserVO selectOneMember(LoginUserVO loginUserVO);
	
	public int updateLoginFailState(LoginUserVO loginUserVO);
	
	public int selectLoginRestrictionCount(String usrId);
	
	public int upadateLoginSuccessState(LoginUserVO loginUserVO);
	
	public int softDeleteOneUser(String usrLgnId);
}
