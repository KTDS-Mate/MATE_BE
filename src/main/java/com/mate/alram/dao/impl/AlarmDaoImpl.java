package com.mate.alram.dao.impl;

import com.mate.alram.dao.AlarmDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class AlarmDaoImpl extends SqlSessionDaoSupport implements AlarmDao {
}
