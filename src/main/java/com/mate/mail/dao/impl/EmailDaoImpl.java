package com.mate.mail.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.mail.dao.EmailDao;
import com.mate.mail.vo.EmailVO;

@Repository
public class EmailDaoImpl extends SqlSessionDaoSupport implements EmailDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	// email 인증 코드를 DB에 저장.
	@Override
	public void insertNewAuthCode(EmailVO emailVO) {
		getSqlSession().insert(NAMESPACE + ".insertNewAuthCode", emailVO);
	}
	
	// 이메일에 해당하는 인증 코드 조회
	@Override
	public EmailVO getAuthCodeByEmail(String email) {
		return getSqlSession().selectOne(NAMESPACE + ".getAuthCodeByEmail", email);
	}

	// email 인증 코드 재발급 시 이전에 발급했던 코드 무효화
	public int invalidatePrevAuthCode(String email) {
		return getSqlSession().update(NAMESPACE + ".invalidatePrevAuthCode", email);
	}
	
	@Override
	public int updateTempPassword(EmailVO emailVO) {
		return getSqlSession().update(NAMESPACE + ".updateTempPassword", emailVO);
	}
}
