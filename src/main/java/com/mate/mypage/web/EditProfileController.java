package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mate.mypage.service.EditProfileService;
import com.mate.user.service.GuideService;
import com.mate.user.vo.RegistGuideVO;
import com.mate.user.vo.UserVO;

@Controller
@RequestMapping("/mypage/edit-profile")
public class EditProfileController {

	@Autowired
	private EditProfileService editProfileService;
	
	@Autowired
	private GuideService guideService;
	
	@GetMapping("/choice") // 마이페이지 선택시 usrIsGd 값에 따라 투어리스트와 가이드에 페이지 이동이 갈린다
    public String viewFirstMypageEdit(@RequestParam String usrLgnId
    								 ,@RequestParam String usrIsGd
    								 ,Model model) {
		//System.out.println("유저아이디 : " + usrLgnId);
		//System.out.println("가이드여부 : " + usrIsGd);
    	if(usrIsGd.equals("N")) {
            return "redirect:/mypage/edit-profile/tr-profile/"+usrLgnId;
    	} else if(usrIsGd.equals("Y")) {
    		return "redirect:/mypage/edit-profile/gd-profile/"+usrLgnId;
    	}
    	return "";
    }
	
	//----------------------------------------------------Tourlist

    @GetMapping("/tr-profile/{usrLgnId}")
    public String viewTRMypage(@PathVariable String usrLgnId, Model model) {
    	int count = this.editProfileService.countUsers();
        UserVO userVO = this.editProfileService.selectOneUser(usrLgnId);

//        System.out.println(count);
        model.addAttribute("userVO", userVO);
    	return "mypage/Mypage_Tourist_EditInfo";
    }
    
    @GetMapping("/tr-profile/update/{usrLgnId}")
    public String viewUpdateOneUserForm(@PathVariable String usrLgnId , Model model) {
    	
    	return "";
    }
    
    @PostMapping("/tr-profile/update/{usrLgnId}")
    public String updateOneUser(@PathVariable String usrLgnId , Model model) {
    	
    	return "";
    }

    //----------------------------------------------------Guide
    
    
    @GetMapping("/gd-profile/{usrLgnId}")
    public String viewGDMypage(@PathVariable String usrLgnId, Model model) {
    	/*int count = this.editProfileService.countUsers();
        UserVO userVO = this.editProfileService.selectOneUser(usrLgnId);
        System.out.println(count);

        model.addAttribute("userVO", userVO);
        return "mypage/Mypage_Guide_EditInfo";*/
    	
    	int count = this.editProfileService.countUsers();
        UserVO userVO = this.editProfileService.selectOneUser(usrLgnId);
//        System.out.println(count);

        RegistGuideVO registGuideVO = guideService.getGuideInfo(userVO.getUsrId());
        if (registGuideVO == null) {
            model.addAttribute("errorMessage", "가이드 정보를 찾을 수 없습니다.");
            return "errorPage";  // Replace with your error page
        }

        model.addAttribute("userVO", userVO);
        model.addAttribute("registGuideVO", registGuideVO);

        return "mypage/Mypage_Guide_EditInfo";
    }
}
