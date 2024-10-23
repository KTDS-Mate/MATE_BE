package com.mate.mypage.web;

import com.mate.mypage.service.MypageService;
import com.mate.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MypageController {

    @Autowired
    public MypageService mypageService;

    @GetMapping("/mypage-tourlist")
    public String viewTourlistMypage(@RequestParam int usrId, Model model){
        int count = this.mypageService.countUsers();
        UserVO userVO = this.mypageService.selectOneUser(usrId);

        System.out.println(count);
        model.addAttribute("usrVO" , userVO);

        return "mypage/Mypage_Tourist_EditInfo";

    }




    @GetMapping("/mypage-guide")
    public String viewGuideMypage(@RequestParam int usrId, Model model){
        int count = this.mypageService.countUsers();
        UserVO userVO = this.mypageService.selectOneUser(usrId);
        System.out.println(count);

        model.addAttribute("usrVO" , userVO);

        return "mypage/Mypage_Guide_EditInfo";

    }

    @GetMapping("/wishlist")
    public String viewWishlist(){

        return "mypage/Mypage_Guide_Wishlist";
    }





}
