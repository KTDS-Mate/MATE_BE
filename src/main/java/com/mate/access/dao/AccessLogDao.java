package com.mate.access.dao;

public interface AccessLogDao {

	public String NAMESPACE = "com.mate.access.dao.AccessLogDao";
	
	public int insertNewAccessLog(AccessLogDao accessLogDao);
	
	public int selectLoginFailCount(String ip);
}
