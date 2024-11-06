package com.mate.mypage.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.mypage.dao.CalendarDao;
import com.mate.mypage.vo.CalendarVO;

@Repository
public class CalendarDaoImpl extends SqlSessionDaoSupport implements CalendarDao{

	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		// TODO Auto-generated method stub
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<CalendarVO> calenList(String usrLgnId) {
		
		return this.getSqlSession().selectList(NAMESPACE + ".calenList" , usrLgnId);
	}
}
