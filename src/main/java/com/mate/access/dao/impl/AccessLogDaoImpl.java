package com.mate.access.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.access.dao.AccessLogDao;

@Repository
public class AccessLogDaoImpl extends SqlSessionDaoSupport implements AccessLogDao {

	@Override
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNewAccessLog(AccessLogDao accessLogDao) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewAccessLog", accessLogDao);
	}

	@Override
	public int selectLoginFailCount(String ip) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectLoginFailCount", ip);
	}
}
