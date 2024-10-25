
package com.mate.access.dao;

public interface AccessLogDao {

	public String NAMESPACE = "com.mate.access.dao.AccessLogDao";
<<<<<<< HEAD
	
	public int insertNewAccessLog(AccessLogDao accessLogDao);
	
=======

	public int insertNewAccessLog(AccessLogVO accessLogVO);

>>>>>>> main
	public int selectLoginFailCount(String ip);

}

