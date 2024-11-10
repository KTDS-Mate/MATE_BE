package com.mate.user.service;

import java.util.List;

import com.mate.common.vo.CountriesVO;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

public interface UserService {

	public boolean createNewUser(RegistUserVO registUserVO);
	
	public boolean checkAvailableEmail(String email);
	
	public boolean checkAvailablePaypalEmail(String paypalEmail);
	
	public boolean checkAvailableId(String usrId);
	
	public boolean checkAvailablePhn(String usrPhn, String usrLgnId);
	
	public UserVO readUser(LoginUserVO loginUserVO);
	
	public boolean softDeleteUser(String usrLgnId);
	
	public boolean updateUserPhoneNumber(String usrLgnId, String newPhn);
	
	public boolean updateUserPaypalEmail(String usrLgnId, String usrEml);
	
	public List<CountriesVO> getAllCountries();
	
	public boolean checkCurrentPassword(String usrLgnId, String currentPassword);
	
	public boolean updateUserPassword(UserVO userVO, String newPassword);
	
	public boolean reissueUserPassword(UserVO userVO);
}
