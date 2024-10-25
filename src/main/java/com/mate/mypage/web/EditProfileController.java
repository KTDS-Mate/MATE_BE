package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mate.mypage.service.EditProfileService;
import com.mate.user.vo.UserVO;

@Controller
@RequestMapping("/mypage/edit-profile")
public class EditProfileController {

	@Autowired
	private EditProfileService editProfileService;
	
	//----------------------------------------------------Tourlist


    @GetMapping("/tr-profile")
    public String viewTRMypage(@PathVariable String usrId, Model model) {
        int count = this.editProfileService.countUsers();
        UserVO userVO = this.editProfileService.selectOneUser(usrId);

        System.out.println(count);
        model.addAttribute("usrVO", userVO);

        return "mypage/Mypage_Tourist_EditInfo";

    }

    //----------------------------------------------------Guide
    
    
    @GetMapping("/gd-profile")
    public String viewGDMypage(@RequestParam String usrId, Model model) {
        int count = this.editProfileService.countUsers();
        UserVO userVO = this.editProfileService.selectOneUser(usrId);
        System.out.println(count);

        model.addAttribute("usrVO", userVO);

        return "mypage/Mypage_Guide_EditInfo";

    }
}
