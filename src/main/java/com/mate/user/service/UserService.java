package com.mate.user.service;

import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

public interface UserService {

	public boolean createNewUser(RegistUserVO registUserVO);
	
	public boolean checkAvailableEmail(String email);
	
	public boolean checkAvailableId(String usrId);
	
	public boolean checkAvailablePhn(String usrPhn);
	
	public UserVO readUser(LoginUserVO loginUserVO);
	
	public boolean softDeleteUser(String usrLgnId);
}
