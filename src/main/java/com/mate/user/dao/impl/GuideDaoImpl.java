package com.mate.user.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.user.dao.GuideDao;
import com.mate.user.vo.RegistGuideVO;

@Repository
public class GuideDaoImpl extends SqlSessionDaoSupport implements GuideDao{
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
    public RegistGuideVO selectGuideInfo(String usrId) {
        return getSqlSession().selectOne(NAMESPACE + ".selectGuideInfo", usrId);
    }

    @Override
    public int insertGuideProfile(RegistGuideVO registGuideVO) {
        return getSqlSession().insert(NAMESPACE + ".insertGuideProfile", registGuideVO);
    }

    @Override
    public int insertGuideCity(CitiesVO citiesVO) {
        return getSqlSession().insert(NAMESPACE + ".insertGuideCity", citiesVO);
    }

    @Override
    public int insertGuideLicense(LicenseVO licenseVO) {
        return getSqlSession().insert(NAMESPACE + ".insertGuideLicense", licenseVO);
    }

    @Override
    public int updateGuideProfile(RegistGuideVO registGuideVO) {
        return getSqlSession().update(NAMESPACE + ".updateGuideProfile", registGuideVO);
    }
    
    @Override
    public List<CitiesVO> selectCitiesByCountry(String countryId) {
    	return getSqlSession().selectList(NAMESPACE + ".selectCitiesByCountry", countryId);
    }
    
    @Override
    public List<CountriesVO> selectAllCountries() {
    	return getSqlSession().selectList(NAMESPACE + ".selectAllCountries");
    }
    
    @Override
    public String getNextLicenseId() {
    	return getSqlSession().selectOne(NAMESPACE + ".getNextLicenseId");
    }
    
    @Override
    public String getNextCityId() {
    	return getSqlSession().selectOne(NAMESPACE + ".getNextCityId");
    }
}
