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
	
	private static final String NAMESPACE = "com.mate.user.dao.GuideDao";
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
    public RegistGuideVO selectGuideInfo(String usrLgnId) {
        return getSqlSession().selectOne(NAMESPACE + ".selectGuideInfo", usrLgnId);
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
    public int updateGuideLicenseApi(LicenseVO licenseVO) {
        return getSqlSession().insert(NAMESPACE + ".updateGuideLicenseApi", licenseVO);
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
    @Override
    public int updateGuideLicense(LicenseVO licenseVO) {
    	return getSqlSession().update(NAMESPACE + ".updateGuideLicense", licenseVO);
    }
    
    @Override
    public int deleteLicneseById(String licenseId) {
    	return getSqlSession().delete(NAMESPACE + ".deleteLicneseById", licenseId);
    }
    
    @Override
    public int updateProfileImage(RegistGuideVO registGuideVO) {
    	return getSqlSession().update(NAMESPACE + ".updateProfileImage", registGuideVO);
    }
    
    @Override
    public int updateIdImage(RegistGuideVO registGuideVO) {
    	return getSqlSession().update(NAMESPACE + ".updateIdImage", registGuideVO);
    }
    
    @Override
    public int deleteGuideCitiesByUserId(String usrId) {
    	return getSqlSession().delete(NAMESPACE + ".deleteGuideCitiesByUserId",usrId );
    }
}
