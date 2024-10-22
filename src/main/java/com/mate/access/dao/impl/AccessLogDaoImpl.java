<<<<<<< HEAD
//package com.mate.access.dao.impl;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.mate.access.dao.AccessLogDao;
//import com.mate.access.vo.AccessLogVO;
//
//@Repository
//public class AccessLogDaoImpl extends SqlSessionDaoSupport implements AccessLogDao {
//
//	@Autowired
//	@Override
//	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
//		super.setSqlSessionTemplate(sqlSessionTemplate);
//	}
//
//	@Override
//	public int insertNewAccessLog(AccessLogVO accessLogVO) {
//		return this.getSqlSession().insert(NAMESPACE + ".insertNewAccessLog", accessLogVO);
//	}
//
//	@Override
//	public int selectLoginFailCount(String ip) {
//		return this.getSqlSession().selectOne(NAMESPACE + ".selectLoginFailCount", ip);
//	}
//
//
//
//}
=======
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
>>>>>>> 8662bed88921a494095ede571cdadad7c5d5bb0f
