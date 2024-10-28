package com.mate.user.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.user.dao.GuideDao;
import com.mate.user.vo.RegistGuideVO;

@Repository
public class GuideDaoImpl extends SqlSessionDaoSupport implements GuideDao{
	
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int updateGuideInfo(RegistGuideVO registGuideVO) {
		return getSqlSession().update(NAMESPACE + ".updateGuideInfo", registGuideVO);
	}

	@Override
	public int insertGuideCities(List<CitiesVO> CitiesVOList) {
		return getSqlSession().insert(NAMESPACE + ".insertGuideCities", CitiesVOList);
	}

	@Override
	public Integer selectCityIdByName(String cityName) {
		return getSqlSession().selectOne(NAMESPACE + ".insertGuideCities", cityName);
	}
	
	@Override
	public int insertGuideCountry(CountriesVO countriesVO) {
		return getSqlSession().insert(NAMESPACE + ".insertGuideCountry", countriesVO);
	}

	@Override
	public int insertGuideLicense(List<LicenseVO> licenseVOList) {
		return getSqlSession().insert(NAMESPACE + ".insertGuideLicense", licenseVOList);
	}
}
