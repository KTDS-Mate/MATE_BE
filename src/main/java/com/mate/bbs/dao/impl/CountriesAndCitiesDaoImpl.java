package com.mate.bbs.dao.impl;

import java.util.List;

import com.mate.common.vo.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.CountriesAndCitiesDao;

@Repository
public class CountriesAndCitiesDaoImpl extends SqlSessionDaoSupport implements CountriesAndCitiesDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<RegionsVO> selectAllRegions() {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllRegions");
	}

	@Override
	public int selectRegionsCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectRegionsCount");
	}

	@Override
	public List<CountriesVO> selectCountries(int regionId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectCountries", regionId);
	}

	@Override
	public int selectCountriesCount(int regionId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectCountriesCount", regionId);
	}

	@Override
	public List<CitiesVO> selectCities(int countryId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectCities", countryId);
	}

	@Override
	public int selectCitiesCount(int countryId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectCitiesCount", countryId);
	}

	@Override
	public TopDestinationsListVO selectTopDestinations() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectTopDestinations");
	}
}
