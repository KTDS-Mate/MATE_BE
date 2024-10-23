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


    
//------------------------------------------------------캘린더

    @GetMapping("/tr-calendar")
    public String viewTRCalendar(){

        return "mypage/Mypage_Tourist_Calendar";
    }

    @GetMapping("/gd-calendar")
    public String viewGDCalendar(){

        return "mypage/Mypage_Guide_Calendar";
    }



//-----------------------------------------------즐겨찾기

    @GetMapping("/tr-wishlist")
    public String viewTRWishlist(){

        return "mypage/Mypage_Tourist_Wishlist";
    }


    @GetMapping("/gd-wishlist")
    public String viewGDWishlist(){

        return "mypage/Mypage_Guide_Wishlist";
    }


//----------------------------------------------------등록 투어

    @GetMapping("/tr-mytour")
    public String viewTRMyTour() {

        return "mypage/Mypage_Tourist_MyTour";
    }
    @GetMapping("/gd-mytour")
    public String viewGDMyTour() {

        return "mypage/Mypage_Guide_MyTour";
    }




//--------------------------------------------------고객 등록 리뷰

    @GetMapping("/tr-review")
    public String viewTRReview(){

        return "mypage/Mypage_Tourist_MyReview";
    }



//-------------------------------------------------가이드 정산내역


    @GetMapping("/gd-sales")
    public String viewGDSales(){

        return "mypage/MyPage_SalesManagement";
    }


//    ---------------------------------고객 결제내역

    @GetMapping("/tr-payment")
    public String viewTRPayment(){

        return "mypage/MyPage_PaymentDetails";
    }



    //-----------------------------------------------------내 정보 수정


    @GetMapping("/tr-profile")
    public String viewTRMypage(@RequestParam int usrId, Model model){
        int count = this.mypageService.countUsers();
        UserVO userVO = this.mypageService.selectOneUser(usrId);

        System.out.println(count);
        model.addAttribute("usrVO" , userVO);

        return "mypage/Mypage_Tourist_EditInfo";

    }


    @GetMapping("/gd-profile")
    public String viewGDMypage(@RequestParam int usrId, Model model){
        int count = this.mypageService.countUsers();
        UserVO userVO = this.mypageService.selectOneUser(usrId);
        System.out.println(count);

        model.addAttribute("usrVO" , userVO);

        return "mypage/Mypage_Guide_EditInfo";

    }

//    --------------------------------------------- 메세지
    @GetMapping("/tr-message")
    public String viewTRMessage(){

        return "mypage/Mypage_Tourist_Wishlist";
    }

    @GetMapping("/gd-message")
    public String viewGDMessage(){

        return "mypage/Mypage_Guide_Calendar";
    }

    @GetMapping("/gd-insert")
    public String viewGDInsertPage(){



        return "guide/Guide_TourInsert";
    }


}
