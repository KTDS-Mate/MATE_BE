package com.mate.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mate.common.vo.CountriesVO;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

public interface UserDao {
	
	public String NAMESPACE = "com.mate.user.dao.UserDao";
	
	public int insertNewUser(RegistUserVO registUserVO);

	public int getIdCount(String usrId);
	
	public int getEmailCount(String email);
	
	public int getPaypalEmailCount(String payPalEmail);
	
	public int getPhnCount(@Param("usrPhn")String usrPhn, @Param("usrLgnId")String usrLgnId);
	
	public int checkPhoneAvailability(UserVO userVO);
	
	public String selectSalt(String usrId);
	
	public UserVO selectOneMember(LoginUserVO loginUserVO);
	
	public int updateLoginFailState(LoginUserVO loginUserVO);
	
	public int selectLoginRestrictionCount(String usrId);
	
	public int upadateLoginSuccessState(LoginUserVO loginUserVO);
	
	public int softDeleteOneUser(String usrLgnId);
	
	public int updateUserPhoneNumber(UserVO userVO);
	
	public int upadateUserPaypalEmail(UserVO userVO);
	
	public List<CountriesVO> selectAllCountries();
	
	public int updateUserPassword(UserVO userVO);
	
	public String getPasswordByUserId(String usrLgnId);
	
	public String getSalt(String usrLgnId);
	
	public int reissueNewPassword(UserVO userVO);
	
	public UserVO selectOneMemberByIdAndEmail(UserVO userVO);
	
	public UserVO selectUserByLoginId(String username);
	
	public int mergeUser(UserVO oAuthUser);
	
    public String findUserIdByEmail(String usrEml);

}
