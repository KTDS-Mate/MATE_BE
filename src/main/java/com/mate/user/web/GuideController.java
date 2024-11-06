package com.mate.user.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.mate.common.vo.CitiesVO;
import com.mate.common.vo.CountriesVO;
import com.mate.common.vo.LicenseVO;
import com.mate.user.service.GuideService;
import com.mate.user.vo.RegistGuideVO;
import com.mate.user.vo.UserVO;

@Controller
@RequestMapping("/user")
public class GuideController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	private static final String NON_GUIDE_REDIRECT_URL = "/mypage/edit-profile/tr-profile/";
    private static final String GUIDE_PROFILE_REDIRECT_URL = "/mypage/edit-profile/gd-profile/";
	
    @Autowired
    private GuideService guideService;

    @GetMapping("/editinfo")
    public String viewGuideEditInfoPage(@SessionAttribute(name = "_LOGIN_USER_", required = false) UserVO userVO, Model model) {
    	if (userVO == null) {
    		return "redirect:/user/login";
    	}
    	
    	// 가이드 정보 + 활동 국가 + 도시정보 조회
    	RegistGuideVO registGuideVO = guideService.getGuideInfo(userVO.getUsrId());
    	model.addAttribute("registGuideVO", registGuideVO);
    	
    	return "mypage/Mypage_Guide_EditInfo";
    }
    
    @GetMapping("/guideregist")
    public String viewGuideRegisterPage(@SessionAttribute(name="_LOGIN_USER_", required=false) UserVO userVO, Model model) {
        // 세션에서 usrId를 가져와 RegistGuideVO에 설정
    	
    	if (userVO == null) {
            return "redirect:/user/login";
        }
    	
    	log.debug("userVO 세션 확인: {}", userVO.getUsrId());
    	
        RegistGuideVO registGuideVO = guideService.getGuideInfo(userVO.getUsrId());
        
        if (registGuideVO.getLicenses() != null) {
        	registGuideVO.setLicenses(new ArrayList<>());
        }
        
        List<LicenseVO> licenses = new ArrayList<>();
        registGuideVO.setLicenses(licenses);
        
        model.addAttribute("registGuideVO", registGuideVO);
        
        List<CountriesVO> countriesList = guideService.getAllCountries();
        model.addAttribute("countriesList", countriesList);
        
        return "user/guideregist";
    }

    @PostMapping("/guideregist")
    public String registerGuide(@ModelAttribute RegistGuideVO registGuideVO, 
    							@SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO, Model model) {
    	
    	if (userVO == null ) {
    		return "redirect:/user/login";
    	}
    	
        // 세션의 usrId를 RegistGuideVO에 설정 후 가이드 등록
        registGuideVO.setUsrLgnId(userVO.getUsrLgnId());
        registGuideVO.setUsrId(userVO.getUsrId());
        
        boolean isRegistered = guideService.registerGuide(registGuideVO);
        
        if (!isRegistered) {
        	log.error("가이드 등록 실패. userVO: {}", userVO);
        	model.addAttribute("errorMessage", "가이드 등록에 실패했습니다. 다시 시도해주세요.");
        	return "user/guideregist";
        }
        
        String isGd = userVO.getUsrIsGd();
        
        /**
         * userVO.setUsrIsGd("Y");
         * DB에서 가이드의 상태변경이 이루어지는데 컨트롤러에서 수행하는 이유.
         * 데이터의 영속성과 세션의 저장된 상태를 일치시키기 위해. -> 세션의 일치성 유지.
         * 사용자가 가이드로 등록되고 데이터베이스에서 usrIsGd값을 변경했지만 세션에 저장된 userVO의 상태가 업데이트 되지 않는다면 
         * 후속 요청 처리에서 상태 불일치가 발생할 수 있다. 
         * ex) 가이드 등록 -> 매출 관리 접근
         * 이 경우 가이드의 상태를 기반으로 뷰를 보여주기 때문.
         */
    	userVO.setUsrIsGd("Y");
        
        if ("Y".equals(isGd)) {
        	return "redirect:" + NON_GUIDE_REDIRECT_URL + userVO.getUsrLgnId();
        }else {
        	return "redirect:" + GUIDE_PROFILE_REDIRECT_URL + userVO.getUsrLgnId();
        }
    }

    @GetMapping("/editlicense")
    public String viewLicenseModifyPage(@SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO, Model model) {
    	if (userVO == null) {
    		return "redirect:/login";
    	}

//    	if (usrId == null) {
//    		usrId = userVO.getUsrId();
//    	}
//    	
    	
    	RegistGuideVO guideInfo = guideService.getGuideInfo(userVO.getUsrId());
    	model.addAttribute("guideInfo", guideInfo);
    	return "user/editlicense";
    }
    
    @PostMapping("/editlicense")
    public String modifyLicense(@ModelAttribute("guideInfo") RegistGuideVO guideInfo,
    							@SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO) {
    	
		if (userVO == null) {
			return "redirect:/login";
		}

    	guideInfo.setUsrId(userVO.getUsrId());
    	boolean isUpdated = guideService.updateGuideLicense(guideInfo);
    	
		return isUpdated ? "redirect:/mypage/edit-profile/gd-profile/" + userVO.getUsrLgnId() : "redirect:/user/editlicense?error=true";
    }
    
    @DeleteMapping("/deleteLicense/{licenseId}")
    @ResponseBody
    public Map<String, Object> deleteLicense(@PathVariable String licenseId) {
    	Map<String, Object> response = new HashMap<>();
    	boolean isDeleted = guideService.deleteLicenseById(licenseId);
    	
    	response.put("success", isDeleted);
    	return response;
    }
    
    @GetMapping("/edit-profile-image")
    public String viewEditProfileImagePage(@SessionAttribute(name = "_LOGIN_USER_", required = false) UserVO userVO, Model model) {
        if (userVO == null) {
            return "redirect:/user/login";
        }
        
        RegistGuideVO guideInfo = guideService.getGuideInfo(userVO.getUsrId());
        model.addAttribute("guideInfo", guideInfo);
        return "user/edit-profile-image";
    }
    
    @GetMapping("/edit-id-image")
    public String viewEditIdImagePage(@SessionAttribute(name="_LOGIN_USER_", required=false) UserVO userVO, Model model) {
    	if (userVO == null) {
    		return "redirect:/user/login";
    	}
    	
    	RegistGuideVO guideInfo = guideService.getGuideInfo(userVO.getUsrId());
    	model.addAttribute("guideInfo", guideInfo);
    	return "user/edit-id-image";
    }
    
    @PostMapping("/update-profile-image")
    public String updateProfileImage(@RequestParam("profileImgFile") MultipartFile profileImgFile,
    								 @SessionAttribute(name = "_LOGIN_USER_", required = false) UserVO userVO, Model model) {
        
        if (userVO == null) {
            return "redirect:/user/login";
        }
        
        RegistGuideVO registGuideVO = new RegistGuideVO();
        registGuideVO.setUsrId(userVO.getUsrId());
        registGuideVO.setGdPrflImgFile(profileImgFile);

        boolean isUpdated = guideService.updateProfileImage(registGuideVO);

        if (!isUpdated) {
            model.addAttribute("errorMessage", "프로필 이미지 업데이트에 실패했습니다. 다시 시도해주세요.");
            return "user/edit-profile-image";
        }
        return "redirect:/mypage/edit-profile/gd-profile/" + userVO.getUsrLgnId();
    }
    
    @PostMapping("/update-id-image")
    public String updateIdImage(@RequestParam("idImageFile") MultipartFile idImageFile, 
    							@SessionAttribute(name="_LOGIN_USER_", required=false) UserVO userVO, Model model) {
		if (userVO == null) {
			return "redirect:/user/login";
		}
		
		RegistGuideVO registGuideVO = new RegistGuideVO();
		registGuideVO.setUsrId(userVO.getUsrId());
		registGuideVO.setGdIdImgFile(idImageFile);
		
		boolean isUpdated = guideService.updateIdImage(registGuideVO);
		
		if (!isUpdated) {
			model.addAttribute("errorMessage", "프로필 이미지 업데이트에 실패했습니다. 다시 시도해주세요.");
			return "user/edit-id-image";
		}
		return "redirect:/mypage/edit-profile/gd-profile/" + userVO.getUsrLgnId();
    }
    
    @GetMapping("/editlocation")
    public String viewEditLocationPage(@SessionAttribute(name = "_LOGIN_USER_", required = false) UserVO userVO, Model model) {
        if (userVO == null) {
            return "redirect:/user/login";
        }

        // RegistGuideVO 객체를 가져옵니다.
        RegistGuideVO registGuideVO = guideService.getGuideInfo(userVO.getUsrId());

        // 모든 국가 목록을 가져와 모델에 추가합니다.
        List<CountriesVO> countriesList = guideService.getAllCountries();
        model.addAttribute("countriesList", countriesList);

        // 현재 선택된 활동 도시 목록을 모델에 추가합니다.
        model.addAttribute("registGuideVO", registGuideVO);

        return "user/editlocation"; // editlocation.jsp 페이지로 이동
    }

    @PostMapping("/editlocation")
    public String updateLocation(@ModelAttribute RegistGuideVO registGuideVO,
                                 @SessionAttribute(name = "_LOGIN_USER_", required = false) UserVO userVO,
                                 Model model) {
        if (userVO == null) {
            return "redirect:/user/login";
        }
        // usrId 설정
        registGuideVO.setUsrId(userVO.getUsrId());
        // 활동 도시 업데이트 로직 (예: 서비스 메서드 호출)
        boolean isUpdated = guideService.updateGuideLocation(registGuideVO);
        if (!isUpdated) {
            model.addAttribute("errorMessage", "활동 지역 업데이트에 실패했습니다. 다시 시도해주세요.");
            return "user/editlocation";
        }
        return "redirect:/mypage/edit-profile/gd-profile/" + userVO.getUsrLgnId();
    }
    
    @GetMapping("/info/{usrId}")
    public String viewGuideInfo(@PathVariable String usrId, Model model) {
        RegistGuideVO guideInfo = guideService.getGuideInfo(usrId);
        model.addAttribute("guideInfo", guideInfo);
        return "guide/info";
    }
    
    // 국가 아이디를 기반으로 도시 목록을 반환한다.
    @GetMapping("/getCities/{countryId}")
    @ResponseBody // JSON 형식으로 데이터 반환. Ajax 요청을 위해서
    public List<CitiesVO> getCitiesByCountry(@PathVariable String countryId) {
    	return guideService.getCitiesByCountryId(countryId);
    }
}