package com.mate.user.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

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

    @GetMapping("/editlicense/{usrid}")
    public String viewLicenseModifyPage(@RequestParam(required=false) String usrId,
    								    @SessionAttribute(name = "_LOGIN_USER_", required=false) UserVO userVO, Model model) {
    	if (userVO == null) {
    		return "redirect:/login";
    	}

    	if (usrId == null) {
    		usrId = userVO.getUsrId();
    	}
    	
    	log.debug("usrId: {}", usrId);
    	
    	RegistGuideVO guideInfo = guideService.getGuideInfo(usrId);
    	
    	if (guideInfo == null ) {
    		log.error("guideInfo null. usrId를 찾지 못한 경우: {}", guideInfo, usrId);
    		model.addAttribute("errorMessage", "가이드 정보를 찾을 수 없음.");
    		return "redirect:/";
    		
    	}
    	
    	if (!"Y".equals(guideInfo.getUsrIsGd())) {
    		return "redirect:" + NON_GUIDE_REDIRECT_URL + guideInfo.getUsrId();
    	}
    	
    	model.addAttribute("guideInfo", guideInfo);
    	return "user/editlicense";
    }
    
    @PostMapping("/user/editlicense")
    public String modifyLicense(@ModelAttribute("guideInfo") RegistGuideVO registGuideVO,
    							@SessionAttribute UserVO userVO) {
    	
    	if (!"Y".equals(registGuideVO.getUsrIsGd())) {
    		return "redirect:" + NON_GUIDE_REDIRECT_URL + registGuideVO.getUsrId(); 
    	}
    	
    	boolean isUpdated = guideService.updateGuideLicense(registGuideVO);
    	
    	if (isUpdated) {
    		return GUIDE_PROFILE_REDIRECT_URL + userVO.getUsrId();
    	} else {
    		return "redirect:/user/editlicense?usrId=" + registGuideVO.getUsrId() + "&error=true";
    	}
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