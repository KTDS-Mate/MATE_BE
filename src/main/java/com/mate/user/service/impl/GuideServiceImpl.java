package com.mate.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.common.beans.FileHandler;
import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.common.vo.StoreResultVO;
import com.mate.user.dao.GuideDao;
import com.mate.user.service.GuideService;
import com.mate.user.vo.RegistGuideVO;

@Service
public class GuideServiceImpl implements GuideService {

	Logger log = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private GuideDao guideDao;

    @Autowired
    private FileHandler filehandler;
    
    @Override
    public RegistGuideVO getGuideInfo(String usrId) { // getGuideInfo 호출해서 User(가이드) 정보 반환
    	// 메서드 호출해서 usrId에 해당하는 정보를 RegistGuidVO 형태로 반환함
        //return guideDao.selectGuideInfo(usrId);
    	RegistGuideVO guideInfo = guideDao.selectGuideInfo(usrId);
        log.debug("Fetched Guide Info: {}", guideInfo);
        log.debug("Guide Cities: {}", guideInfo.getCities());
        log.debug("Guide Country: {}", guideInfo.getCountryName());
        return guideInfo;
    }

    @Transactional
    @Override
    public boolean registerGuide(RegistGuideVO registGuideVO) {

        // 프로필 이미지(gdPrflImg) 처리
        StoreResultVO prflImgResult = filehandler.storeFile(registGuideVO.getGdPrflImgFile());
        // 각 이미지 파일에 대해 storeFile() 메서드를 호출하고 반환값이 Null인지 확인한 후에 null이 아닌 경우에만 파일명을 설정한다.
        if (prflImgResult != null) {
        	registGuideVO.setGdPrflImg(prflImgResult.getObfuscatedFileName());
        }
        
        // 신분증 이미지(gdIdImg) 처리
        StoreResultVO idImgResult = filehandler.storeFile(registGuideVO.getGdIdImgFile());
        if (idImgResult != null) {
        	registGuideVO.setGdIdImg(idImgResult.getObfuscatedFileName());
        }
    	
        // 범죄경력조회서 이미지(gdCbcImg) 처리
    	StoreResultVO cbcImgResult = filehandler.storeFile(registGuideVO.getGdCbcImgFile());
    	if (cbcImgResult != null) {
    		registGuideVO.setGdCbcImg(cbcImgResult.getObfuscatedFileName());
    	}
    	
    	// 가이드 프로필 DB에 삽입
    	int count = this.guideDao.insertGuideProfile(registGuideVO);
    	
    	// 라이센스 처리
    	List<LicenseVO> licenseList = registGuideVO.getLicenses();
    	
    	if (licenseList != null && !licenseList.isEmpty()) {
    		for (LicenseVO licenseVO : licenseList) {
        		licenseVO.setUsrId(registGuideVO.getUsrId());
        		
        		// 시퀀스 값 미리 가져오기
        		String lcnId = guideDao.getNextLicenseId();
        		licenseVO.setLcnId(lcnId);
        		
        		// 라이센스 이미지 
        		StoreResultVO licenseImgResult = filehandler.storeFile(licenseVO.getLcnImgFile());
        		if (licenseImgResult != null) {
        			licenseVO.setLcnImg(licenseImgResult.getObfuscatedFileName());
        		}
        		
        		// 개별 라이센스 삽입
        		guideDao.insertGuideLicense(licenseVO);
    		}
    	}
    	
    	// 도시 정보 리스트
    	List<CitiesVO> citiesList = registGuideVO.getCities();
    	if (citiesList != null && !citiesList.isEmpty()) {
    		for (CitiesVO citiesVO : citiesList) {
    			// usrId 설정
    			citiesVO.setUsrId(registGuideVO.getUsrId());
    			
    			// 시퀀스 값 미리 가져오기
    			String actCtId = guideDao.getNextCityId();
    			citiesVO.setActCtId(actCtId);
    			
    			guideDao.insertGuideCity(citiesVO);
        	}
    	}
    	
    	return count > 0;
    }    	
    
    @Transactional
    @Override
    public boolean updateGuideLicense(RegistGuideVO registGuideVO) {
    	List<LicenseVO> licenseList = registGuideVO.getLicenses();
    	//String usrId = registGuideVO.getUsrId();
    	
    	if (licenseList == null || licenseList.isEmpty()) {
    		return false;
    	}
    	
    	for (LicenseVO licenseVO : licenseList) {
			if (licenseVO.getLcnId() == null || licenseVO.getLcnId().isEmpty()) {
				licenseVO.setLcnImg("default_image.jpg");
				
				// 신규 라이센스인 경우 삽입
				String newLcnId = guideDao.getNextLicenseId();
				licenseVO.setLcnId(newLcnId);
				licenseVO.setUsrId(registGuideVO.getUsrId());
				
				// 신규 라이센스 이미지 저장
				StoreResultVO licenseImgResult = filehandler.storeFile(licenseVO.getLcnImgFile());
				if (licenseImgResult != null) {
				    licenseVO.setLcnImg(licenseImgResult.getObfuscatedFileName());
				}
				guideDao.insertGuideLicense(licenseVO);
			} else {
				// 기존 라이센스 업데이트
				StoreResultVO licenseImgResult = filehandler.storeFile(licenseVO.getLcnImgFile());
				if (licenseImgResult != null) {
				    licenseVO.setLcnImg(licenseImgResult.getObfuscatedFileName());
				}
				guideDao.updateGuideLicense(licenseVO);
            }
    	}
    	return true;
    }
    
    @Override
    public boolean updateProfileImage(RegistGuideVO registGuideVO) {
		if (registGuideVO.getGdPrflImgFile() != null && !registGuideVO.getGdPrflImgFile().isEmpty()) {
			StoreResultVO prflImgResult = filehandler.storeFile(registGuideVO.getGdPrflImgFile());
			if (prflImgResult != null) {
				registGuideVO.setGdPrflImg(prflImgResult.getObfuscatedFileName());
			}
		}
		int updateResult = guideDao.updateProfileImage(registGuideVO);
    	return updateResult > 0;
    }    
    
    @Override
    public boolean updateIdImage(RegistGuideVO registGuideVO) {
    	if (registGuideVO.getGdIdImgFile() != null && !registGuideVO.getGdIdImgFile().isEmpty()) {
    		StoreResultVO idImgResult = filehandler.storeFile(registGuideVO.getGdIdImgFile());
    		if (idImgResult != null) {
    			registGuideVO.setGdIdImg(idImgResult.getObfuscatedFileName());
    		}
    	}
    	int updateResult = guideDao.updateIdImage(registGuideVO);
    	return updateResult > 0;
    }
    
    @Transactional
    @Override
    public boolean updateGuideLocation(RegistGuideVO registGuideVO) {
        // 예시: 기존 활동 도시 삭제
        guideDao.deleteGuideCitiesByUserId(registGuideVO.getUsrId());

        // 새로운 활동 도시 삽입
        List<CitiesVO> citiesList = registGuideVO.getCities();
        if (citiesList != null && !citiesList.isEmpty()) {
            for (CitiesVO city : citiesList) {
                city.setUsrId(registGuideVO.getUsrId());
                String actCtId = guideDao.getNextCityId();
                city.setActCtId(actCtId);
                guideDao.insertGuideCity(city);
            }
        }
        return true;
    }
    
    @Override
    public boolean deleteLicenseById(String licenseId) {
    	int deleteCount = guideDao.deleteLicneseById(licenseId);
    	return deleteCount > 0;
    }
    
    @Transactional
    @Override
    public boolean updateGuideProfile(RegistGuideVO registGuideVO) {
    	
    	int updateResult = guideDao.updateGuideProfile(registGuideVO);
    	return updateResult > 0;
    }

    
    @Override
    public List<CitiesVO> getCitiesByCountryId(String countryId) {
    	return guideDao.selectCitiesByCountry(countryId);
    }
    
    @Override
    public List<CountriesVO> getAllCountries() {
    	return guideDao.selectAllCountries();
    }
}
