
package com.mate.access.dao;

import com.mate.access.vo.AccessLogVO;

public interface AccessLogDao {

	public String NAMESPACE = "com.mate.access.dao.AccessLogDao";

	public int insertNewAccessLog(AccessLogVO accessLogVO);

	public int selectLoginFailCount(String ip);

}

