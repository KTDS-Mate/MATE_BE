<<<<<<< HEAD
//package com.mate.access.dao;
//
//import com.mate.access.vo.AccessLogVO;
//
//public interface AccessLogDao {
//
//	public String NAMESPACE = "com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao";
//
//	public int insertNewAccessLog(AccessLogVO accessLogVO);
//
//	public int selectLoginFailCount(String ip);
//
//}
=======
package com.mate.access.dao;

public interface AccessLogDao {

	public String NAMESPACE = "com.mate.access.dao.AccessLogDao";
	
	public int insertNewAccessLog(AccessLogDao accessLogDao);
	
	public int selectLoginFailCount(String ip);
}
>>>>>>> 8662bed88921a494095ede571cdadad7c5d5bb0f
