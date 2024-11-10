package com.mate.bbs.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.GuideListDao;

@Repository
public class GuideListDaoImpl extends SqlSessionDaoSupport implements GuideListDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {

		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	
	
	
}
