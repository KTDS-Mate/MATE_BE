package com.mate.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mate.common.beans.FileHandler;
import com.mate.common.s3.S3Service;
import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.common.vo.StoreResultVO;
import com.mate.user.dao.GuideDao;
import com.mate.user.dao.UserDao;
import com.mate.user.service.GuideService;
import com.mate.user.vo.RegistGuideVO;

@Service
public class GuideServiceImpl implements GuideService {

	Logger log = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private GuideDao guideDao;
    
    @Autowired
    private UserDao userDao;

    @Autowired
    private FileHandler filehandler;
    
    @Autowired
    private S3Service s3Service;
    
    @Override
    public RegistGuideVO getGuideInfo(String usrId) { // getGuideInfo 호출해서 User(가이드) 정보 반환
    	// 메서드 호출해서 usrId에 해당하는 정보를 RegistGuidVO 형태로 반환함
    	RegistGuideVO guideInfo = guideDao.selectGuideInfo(usrId);
        if (guideInfo == null) {
            log.warn("가이드 정보가 존재하지 않습니다. 유저 아이디: {}", usrId);
        }
        return guideInfo;
    }

    @Transactional
    @Override
    public boolean registerGuide(RegistGuideVO registGuideVO) {
        try {
            // 2. selectedCities를 CitiesVO 리스트로 변환
            if (registGuideVO.getSelectedCities() != null && !registGuideVO.getSelectedCities().isEmpty()) {
                List<CitiesVO> citiesList = new ArrayList<>();
                for (String cityId : registGuideVO.getSelectedCities()) {
                    try {
                        CitiesVO city = new CitiesVO();
                        city.setCityId(Integer.parseInt(cityId));
                        city.setUsrId(registGuideVO.getUsrId());
                        citiesList.add(city);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("유효하지 않은 cityId 포맷", e);
                    }
                }
                registGuideVO.setCities(citiesList);
            }

            // 3. 기본값 설정
            registGuideVO.setUsrSlfIntdctn(registGuideVO.getUsrSlfIntdctn() != null ? 
                registGuideVO.getUsrSlfIntdctn() : "");
            registGuideVO.setUsrPypEml(registGuideVO.getUsrPypEml() != null ? 
                registGuideVO.getUsrPypEml() : "");
            registGuideVO.setUsrGdExp(registGuideVO.getUsrGdExp() != null ? 
                registGuideVO.getUsrGdExp() : "0");
            registGuideVO.setGdApplStt("WAITING");
            registGuideVO.setUsrIsGd("N");

            // 4. 메인 프로필 정보 업데이트
            int count = this.guideDao.insertGuideProfile(registGuideVO);
            
            if (count <= 0) {
                return false;
            }

            // 5. 라이센스 처리
            if (registGuideVO.getLicenses() != null && !registGuideVO.getLicenses().isEmpty()) {
                for (LicenseVO licenseVO : registGuideVO.getLicenses()) {
                    licenseVO.setUsrId(registGuideVO.getUsrId());
                    String lcnId = guideDao.getNextLicenseId();
                    licenseVO.setLcnId(lcnId);
                    guideDao.updateGuideLicenseApi(licenseVO);
                }
            }

            // 6. 도시 정보 처리
            List<CitiesVO> citiesList = registGuideVO.getCities();
            if (citiesList != null && !citiesList.isEmpty()) {
                for (CitiesVO citiesVO : citiesList) {
                    String actCtId = guideDao.getNextCityId();
                    citiesVO.setActCtId(actCtId);
                    guideDao.insertGuideCity(citiesVO);
                }
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException("가이드 등록 실패", e);
        }
    }
    
    @Transactional
    @Override
    public boolean updateGuideLicense(RegistGuideVO registGuideVO) {
        List<LicenseVO> licenseList = registGuideVO.getLicenses();

        if (licenseList == null || licenseList.isEmpty()) {
            return false;
        }

        for (LicenseVO licenseVO : licenseList) {
            try {
                if (licenseVO.getLcnId() == null || licenseVO.getLcnId().isEmpty()) {
                    // 신규 라이센스인 경우 삽입
                    String newLcnId = guideDao.getNextLicenseId();
                    licenseVO.setLcnId(newLcnId);
                    licenseVO.setUsrId(registGuideVO.getUsrId());

                    // 신규 라이센스 이미지 저장
                    StoreResultVO licenseImgResult = filehandler.storeFile(licenseVO.getLcnImgFile());
                    if (licenseImgResult != null) {
                        licenseVO.setLcnImg(licenseImgResult.getObfuscatedFileName());
                    } else {
                        throw new RuntimeException("라이센스 이미지 저장 실패"); 
                    }
                    guideDao.updateGuideLicenseApi(licenseVO);
                } else {
                    // 기존 라이센스 업데이트
                    StoreResultVO licenseImgResult = filehandler.storeFile(licenseVO.getLcnImgFile());
                    if (licenseImgResult != null) {
                        licenseVO.setLcnImg(licenseImgResult.getObfuscatedFileName());
                    } else {
                        throw new RuntimeException("라이센스 이미지 저장 실패"); 
                    }
                    guideDao.updateGuideLicense(licenseVO);
                }
            } catch (Exception e) {
                // 예외 처리 방식 결정 (예: 예외 재발생, 오류 메시지 반환 등)
                throw new RuntimeException("라이센스 업데이트 중 오류 발생", e); 
            }
        }
        return true;
    }
    
    @Override
    public boolean updateGuideLicenseApi(LicenseVO licenseVO) {
    	int updateCount = guideDao.updateGuideLicenseApi(licenseVO);
        return updateCount > 0;
    }
    
//    @Override
//    public boolean updateProfileImage(RegistGuideVO registGuideVO) {
//		if (registGuideVO.getGdPrflImgFile() != null && !registGuideVO.getGdPrflImgFile().isEmpty()) {
//			StoreResultVO prflImgResult = filehandler.storeFile(registGuideVO.getGdPrflImgFile());
//			if (prflImgResult != null) {
//				registGuideVO.setGdPrflImg(prflImgResult.getObfuscatedFileName());
//			}
//		}
//		int updateResult = guideDao.updateProfileImage(registGuideVO);
//    	return updateResult > 0;
//    }    
//    
//    @Override
//    public boolean updateIdImage(RegistGuideVO registGuideVO) {
//    	if (registGuideVO.getGdIdImgFile() != null && !registGuideVO.getGdIdImgFile().isEmpty()) {
//    		StoreResultVO idImgResult = filehandler.storeFile(registGuideVO.getGdIdImgFile());
//    		if (idImgResult != null) {
//    			registGuideVO.setGdIdImg(idImgResult.getObfuscatedFileName());
//    		}
//    	}
//    	int updateResult = guideDao.updateIdImage(registGuideVO);
//    	return updateResult > 0;
//    }
    
    @Transactional
    @Override
    public boolean updateGuideLocation(RegistGuideVO registGuideVO) {
        // 예시: 기존 활동 도시 삭제
        guideDao.deleteGuideCitiesByUserId(registGuideVO.getUsrId());

        // 새로운 활동 도시 삽입
        List<CitiesVO> citiesList = registGuideVO.getCities();
        if (citiesList != null && !citiesList.isEmpty()) {
            for (CitiesVO city : citiesList) {
                city.setUsrLngId(registGuideVO.getUsrId());;
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
    	return userDao.selectAllCountries();
    }
    
    @Override
    public String getNextLicenseId() {
        return guideDao.getNextLicenseId();
    }
}