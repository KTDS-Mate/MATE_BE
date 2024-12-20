package com.mate.user.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.vo.ApiResponse;
import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.user.service.GuideService;
import com.mate.user.vo.RegistGuideVO;
import com.mate.user.vo.UserVO;

@RestController
@RequestMapping("/api/user")
public class GuideApiController {
	
    private static final Logger log = LoggerFactory.getLogger(GuideApiController.class);
    
    private final GuideService guideService;

    @Autowired
    public GuideApiController(GuideService guideService) {
        this.guideService = guideService;
    }

    /**
     * 가이드 등록 (이미지 업로드 포함)
     */
    @PostMapping("/guideregist")
    public ApiResponse registerGuide(@RequestBody RegistGuideVO registGuideVO, Authentication authentication) {
        
    	try {
            // 인증된 사용자 정보 확인
            UserVO authenticatedUser = extractUserVO(authentication);
            
            if (authenticatedUser == null) {
                ApiResponse response = new ApiResponse();
                response.setStatus(HttpStatus.UNAUTHORIZED);
                response.setStatusMessage("사용자가 로그인되어 있지 않습니다.");
                return response;
            }

            registGuideVO.setUsrId(authenticatedUser.getUsrId());
            registGuideVO.setGdApplStt("WAITING");
            
            boolean isRegistered = guideService.registerGuide(registGuideVO);

            if (!isRegistered) {
                ApiResponse response = new ApiResponse();
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                response.setStatusMessage("가이드 등록에 실패했습니다. 다시 시도해주세요.");
                return response;
            }

            // 응답 바디에 필요한 데이터 포함
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("gdPrflImg", registGuideVO.getGdPrflImg());
            responseBody.put("gdIdImg", registGuideVO.getGdIdImg());
            responseBody.put("gdCbcImg", registGuideVO.getGdCbcImg());

            // 라이센스 이미지 URL 포함
            List<String> licenseImages = new ArrayList<>();
            if (registGuideVO.getLicenses() != null) {
                for (LicenseVO license : registGuideVO.getLicenses()) {
                    licenseImages.add(license.getLcnImg());
                }
            }
            responseBody.put("licenseImages", licenseImages);

            ApiResponse response = new ApiResponse();
            response.setStatus(HttpStatus.OK);
            response.setStatusMessage("가이드 등록에 성공했습니다.");
            response.setBody(responseBody);
            return response;

    	} catch (Exception e) {
            ApiResponse response = new ApiResponse();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setStatusMessage("가이드 등록 중 오류가 발생했습니다.");
            return response;
        }
    }
    // 가이드 이미지 URL 업데이트
    @PostMapping("/updateGuideImage")
    public ApiResponse updateGuideImage(@RequestBody Map<String, String> requestBody, 
                                        Authentication authentication) {
    	try {
            String usrId = requestBody.get("usrId");
            String imageUrl = requestBody.get("imageUrl");
            String imageType = requestBody.get("imageType");

            UserVO authenticatedUser = extractUserVO(authentication);
            if (authenticatedUser == null || !authenticatedUser.getUsrId().equals(usrId)) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "권한이 없습니다.");
            }

            RegistGuideVO registGuideVO = new RegistGuideVO();
            registGuideVO.setUsrId(usrId);

            switch (imageType) {
                case "gdPrflImg":
                    registGuideVO.setGdPrflImg(imageUrl);
                    break;
                case "gdIdImg":
                    registGuideVO.setGdIdImg(imageUrl);
                    break;
                case "gdCbcImg":
                    registGuideVO.setGdCbcImg(imageUrl);
                    break;
                default:
                    if (imageType.startsWith("license-")) {
                        return handleLicenseImage(usrId, imageUrl);
                    }
            }

            boolean updated = guideService.updateGuideProfile(registGuideVO);
            
            if (updated) {
                return new ApiResponse(HttpStatus.OK, "이미지 URL 업데이트 성공");
            }
            return new ApiResponse(HttpStatus.BAD_REQUEST, "이미지 URL 업데이트 실패");
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "이미지 URL 업데이트 중 오류 발생");
        }
    }
    
    private ApiResponse handleLicenseImage(String usrId, String imageUrl) {
        LicenseVO licenseVO = new LicenseVO();
        licenseVO.setUsrId(usrId);
        licenseVO.setLcnImg(imageUrl);
        boolean updated = guideService.updateGuideLicenseApi(licenseVO);
        
        if (updated) {
            return new ApiResponse(HttpStatus.OK, "라이센스 이미지 업데이트 성공");
        }
        return new ApiResponse(HttpStatus.BAD_REQUEST, "라이센스 이미지 업데이트 실패");
    }
    	
    /**
     * 가이드 등록 정보 조회
     */
    @GetMapping("/guideregist")
    public ApiResponse getGuideRegistrationInfo(Authentication authentication) {
        try {
            UserVO userVO = extractUserVO(authentication);
            if (userVO == null) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
            }

            RegistGuideVO registGuideVO = guideService.getGuideInfo(userVO.getUsrId());

            if (registGuideVO.getLicenses() != null) {
                registGuideVO.setLicenses(null); // 기존 라이센스 비우기
            }

            registGuideVO.setLicenses(null); // 라이센스를 null로 초기화

            List<CountriesVO> countriesList = guideService.getAllCountries();

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("registGuideVO", registGuideVO);
            responseBody.put("countriesList", countriesList);

            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "가이드 등록 정보 조회 중 오류가 발생했습니다.");
        }
    }
    /**
     * 사용자 ID로 가이드 정보 조회
     */
    @GetMapping("/info/{usrId}")
    public ApiResponse getGuideInfo(@PathVariable String usrId) {
        try {
            RegistGuideVO guideInfo = guideService.getGuideInfo(usrId);
            if (guideInfo == null) {
                return new ApiResponse(HttpStatus.NOT_FOUND, "가이드를 찾을 수 없습니다.");
            }

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("guideInfo", guideInfo);

            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "가이드 정보 조회 중 오류가 발생했습니다.");
        }
    }
    /**
     * 국가 ID로 도시 목록 조회
     */
    @GetMapping("/getCities/{countryId}")
    public ApiResponse getCitiesByCountry(@PathVariable String countryId) {
        try {
            List<CitiesVO> cities = guideService.getCitiesByCountryId(countryId);
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("cities", cities);
            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "도시 정보 조회 중 오류가 발생했습니다.");
        }
    }
    
    @GetMapping("/getAllCountries")
    public ApiResponse getAllCountries() {
        try {
            List<CountriesVO> countries = guideService.getAllCountries();
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("countries", countries);
            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "국가 목록 조회 중 오류가 발생했습니다.");
        }
    }
    
    /**
     * Authentication에서 UserVO 추출
     */
    private UserVO extractUserVO(Authentication authentication) {
        if (authentication == null || authentication.getPrincipal() == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserVO user) {
            return user;
        }
        return null;
    }
    
    
    /**
     * 가이드 정보 수정
     */
    @GetMapping("/editinfo")
    public ApiResponse getGuideEditInfo(Authentication authentication) {
        try {
            UserVO userVO = extractUserVO(authentication);
            if (userVO == null) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
            }

            RegistGuideVO registGuideVO = guideService.getGuideInfo(userVO.getUsrLgnId());
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("registGuideVO", registGuideVO);

            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "가이드 정보 조회 중 오류가 발생했습니다.");
        }
    }
    
    /**
     * 라이센스 수정 정보 조회
     */
    @GetMapping("/editlicense")
    public ApiResponse getLicenseModifyInfo(Authentication authentication) {
        try {
            UserVO userVO = extractUserVO(authentication);
            if (userVO == null) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
            }

            RegistGuideVO guideInfo = guideService.getGuideInfo(userVO.getUsrLgnId());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("guideInfo", guideInfo);

            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "라이센스 수정 정보 조회 중 오류가 발생했습니다.");
        }
    }
    
    /**
     * 라이센스 수정
     */
    @PostMapping("/editlicense")
    public ApiResponse modifyLicense(@ModelAttribute RegistGuideVO guideInfo, Authentication authentication) {
        try {
            UserVO userVO = extractUserVO(authentication);
            if (userVO == null) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
            }

            guideInfo.setUsrId(userVO.getUsrId());
            boolean isUpdated = guideService.updateGuideLicense(guideInfo);

            if (isUpdated) {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("message", "라이센스가 성공적으로 수정되었습니다.");
                return new ApiResponse(HttpStatus.OK, responseBody);
            } else {
                return new ApiResponse(HttpStatus.BAD_REQUEST, "라이센스 수정에 실패했습니다.");
            }
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "라이센스 수정 중 오류가 발생했습니다.");
        }
    }

    /**
     * 라이센스 삭제
     */
    @DeleteMapping("/deleteLicense/{licenseId}")
    public ApiResponse deleteLicense(@PathVariable String licenseId) {
        try {
            boolean isDeleted = guideService.deleteLicenseById(licenseId);
            if (isDeleted) {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("message", "라이센스가 성공적으로 삭제되었습니다.");
                return new ApiResponse(HttpStatus.OK, responseBody);
            } else {
                return new ApiResponse(HttpStatus.BAD_REQUEST, "라이센스 삭제에 실패했습니다.");
            }
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "라이센스 삭제 중 오류가 발생했습니다.");
        }
    }
    
    /**
     * 프로필 이미지 수정 정보 조회
     */
    @GetMapping("/edit-profile-image")
    public ApiResponse getEditProfileImageInfo(Authentication authentication) {
        try {
            UserVO userVO = extractUserVO(authentication);
            if (userVO == null) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
            }

            RegistGuideVO guideInfo = guideService.getGuideInfo(userVO.getUsrId());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("guideInfo", guideInfo);

            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "프로필 이미지 수정 정보 조회 중 오류가 발생했습니다.");
        }
    }
    
    /**
     * 신분증 이미지 수정 정보 조회
     */
    @GetMapping("/edit-id-image")
    public ApiResponse getEditIdImageInfo(Authentication authentication) {
        try {
            UserVO userVO = extractUserVO(authentication);
            if (userVO == null) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
            }

            RegistGuideVO guideInfo = guideService.getGuideInfo(userVO.getUsrId());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("guideInfo", guideInfo);

            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "신분증 이미지 수정 정보 조회 중 오류가 발생했습니다.");
        }
    }
    
    /**
     * 프로필 이미지 업데이트
     */
//    @PostMapping("/update-profile-image")
//    public ApiResponse updateProfileImage(@RequestParam("profileImgFile") MultipartFile profileImgFile,
//                                         Authentication authentication) {
//        try {
//            UserVO userVO = extractUserVO(authentication);
//            if (userVO == null) {
//                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
//            }
//
//            RegistGuideVO registGuideVO = new RegistGuideVO();
//            registGuideVO.setUsrLgnId(userVO.getUsrLgnId());
//            registGuideVO.setGdPrflImgFile(profileImgFile);
//
//            boolean isUpdated = guideService.updateProfileImage(registGuideVO);
//
//            if (isUpdated) {
//                Map<String, Object> responseBody = new HashMap<>();
//                responseBody.put("message", "프로필 이미지가 성공적으로 업데이트되었습니다.");
//                return new ApiResponse(HttpStatus.OK, responseBody);
//            } else {
//                return new ApiResponse(HttpStatus.BAD_REQUEST, "프로필 이미지 업데이트에 실패했습니다.");
//            }
//        } catch (Exception e) {
//            log.error("프로필 이미지 업데이트 중 오류 발생", e);
//            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "프로필 이미지 업데이트 중 오류가 발생했습니다.");
//        }
//    }
    
//    /**
//     * 신분증 이미지 업데이트
//     */
//    @PostMapping("/update-id-image")
//    public ApiResponse updateIdImage(@RequestParam("idImageFile") MultipartFile idImageFile, 
//                                     Authentication authentication) {
//        try {
//            UserVO userVO = extractUserVO(authentication);
//            if (userVO == null) {
//                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
//            }
//
//            RegistGuideVO registGuideVO = new RegistGuideVO();
//            registGuideVO.setUsrLgnId(userVO.getUsrLgnId());
//            registGuideVO.setGdIdImgFile(idImageFile);
//
//            boolean isUpdated = guideService.updateIdImage(registGuideVO);
//
//            if (isUpdated) {
//                Map<String, Object> responseBody = new HashMap<>();
//                responseBody.put("message", "신분증 이미지가 성공적으로 업데이트되었습니다.");
//                return new ApiResponse(HttpStatus.OK, responseBody);
//            } else {
//                return new ApiResponse(HttpStatus.BAD_REQUEST, "신분증 이미지 업데이트에 실패했습니다.");
//            }
//        } catch (Exception e) {
//            log.error("신분증 이미지 업데이트 중 오류 발생", e);
//            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "신분증 이미지 업데이트 중 오류가 발생했습니다.");
//        }
//    }
    
    /**
     * 활동 지역 수정 정보 조회
     */
    @GetMapping("/editlocation")
    public ApiResponse getEditLocationInfo(Authentication authentication) {
        try {
            UserVO userVO = extractUserVO(authentication);
            if (userVO == null) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
            }

            RegistGuideVO registGuideVO = guideService.getGuideInfo(userVO.getUsrId());
            List<CountriesVO> countriesList = guideService.getAllCountries();

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("registGuideVO", registGuideVO);
            responseBody.put("countriesList", countriesList);

            return new ApiResponse(HttpStatus.OK, responseBody);
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "활동 지역 수정 정보 조회 중 오류가 발생했습니다.");
        }
    }

    /**
     * 활동 지역 업데이트
     */
    @PostMapping("/editlocation")
    public ApiResponse updateLocation(@ModelAttribute RegistGuideVO registGuideVO,
                                     Authentication authentication) {
        try {
            UserVO userVO = extractUserVO(authentication);
            if (userVO == null) {
                return new ApiResponse(HttpStatus.UNAUTHORIZED, "사용자가 로그인되어 있지 않습니다.");
            }

            registGuideVO.setUsrId(userVO.getUsrId());
            boolean isUpdated = guideService.updateGuideLocation(registGuideVO);

            if (isUpdated) {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("message", "활동 지역이 성공적으로 업데이트되었습니다.");
                return new ApiResponse(HttpStatus.OK, responseBody);
            } else {
                return new ApiResponse(HttpStatus.BAD_REQUEST, "활동 지역 업데이트에 실패했습니다.");
            }
        } catch (Exception e) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "활동 지역 업데이트 중 오류가 발생했습니다.");
        }
    }


}