package com.mate.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.common.vo.CountriesVO;
import com.mate.user.dao.UserDao;
import com.mate.user.vo.LoginUserVO;
import com.mate.user.vo.RegistUserVO;
import com.mate.user.vo.UserVO;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int getIdCount(String userId) {
		return getSqlSession().selectOne(NAMESPACE + ".getIdCount", userId);
	}
	
	@Override
	public int insertNewUser(RegistUserVO registUserVO) {
		return getSqlSession().insert(NAMESPACE + ".insertNewUser", registUserVO);
	}
	
	@Override
	public int softDeleteOneUser(String usrLgnId) {
		return getSqlSession().update(NAMESPACE + ".softDeleteOneUser", usrLgnId);
	}
	
	@Override
	public int getEmailCount(String email) {
		return this.getSqlSession().selectOne(NAMESPACE + ".getEmailCount",email);
	}
	
	@Override
	public int getPaypalEmailCount(String payPalEmail) {		
		return this.getSqlSession().selectOne(NAMESPACE + ".getPaypalEmailCount", payPalEmail);
	}
	
	@Override
	public String selectSalt(String usrId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectSalt", usrId);
	}
	
	@Override
	public int getPhnCount(@Param("usrPhn")String usrPhn, @Param("usrLgnId")String usrLgnId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".getPhnCount", usrPhn);
	}
	
	@Override
    public int checkPhoneAvailability(UserVO userVO) {
        return this.getSqlSession().selectOne(NAMESPACE + ".checkPhoneAvailability", userVO);
    }
	
	@Override
	public UserVO selectOneMember(LoginUserVO loginUserVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneMember", loginUserVO);
	}
	
	@Override
	public int updateLoginFailState(LoginUserVO loginUserVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateLoginFailState", loginUserVO);
	}
	
	@Override
	public int upadateLoginSuccessState(LoginUserVO loginUserVO) {
		return this.getSqlSession().update(NAMESPACE + ".upadateLoginSuccessState", loginUserVO);
	}
	
	@Override
	public int selectLoginRestrictionCount(String usrId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectLoginRestrictionCount", usrId);
	}
	
	@Override
	public int updateUserPhoneNumber(UserVO userVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateUserPhoneNumber", userVO);
	}
	
	@Override
	public int upadateUserPaypalEmail(UserVO userVO) {
		return this.getSqlSession().update(NAMESPACE + ".upadateUserPaypalEmail", userVO);
	}
	
	@Override
	public int updateUserPassword(UserVO userVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateUserPassword", userVO);
	}
	
	@Override
	public List<CountriesVO> selectAllCountries() {
		return getSqlSession().selectList(NAMESPACE + ".selectAllCountries");
	}
	
	@Override
	public String getPasswordByUserId(String usrLgnId) {
		return getSqlSession().selectOne(NAMESPACE + ".getPasswordByUserId", usrLgnId);
	}
	
	@Override
	public String getSalt(String usrLgnId) {
		return getSqlSession().selectOne(NAMESPACE + ".getSalt", usrLgnId);
	}
	
	@Override
	public int reissueNewPassword(UserVO userVO) {
		return getSqlSession().insert(NAMESPACE + ".reissueNewPassword", userVO);
	}
	
	@Override
	public UserVO selectOneMemberByIdAndEmail(UserVO userVO) {
		return getSqlSession().selectOne(NAMESPACE + ".selectOneMemberByIdAndEmail", userVO);
	}
	
	@Override
	public int mergeUser(UserVO oAuthUser) {
		return this.getSqlSession().update(NAMESPACE + ".mergeUser", oAuthUser);
	}
	
	@Override
	public UserVO selectUserByLoginId(String username) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectUserByLoginId", username);
	}
	
	@Override
	public String findUserIdByEmail(String usrEml) {
		return this.getSqlSession().selectOne(NAMESPACE + ".findUserIdByEmail", usrEml);
	}
}
