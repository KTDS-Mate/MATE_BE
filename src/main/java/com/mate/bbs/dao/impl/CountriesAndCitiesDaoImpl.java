package com.mate.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.CountriesAndCitiesDao;
import com.mate.common.vo.CountriesVO;

@Repository
public class CountriesAndCitiesDaoImpl extends SqlSessionDaoSupport implements CountriesAndCitiesDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<CountriesVO> selectAllCountries() {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllCountries");
	}
	
	@Override
	public int selectCountriesCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectCountriesCount");
	}
	
}
