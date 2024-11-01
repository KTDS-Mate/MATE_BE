package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mate.mypage.service.EditProfileService;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    public EditProfileService mypageService;


//------------------------------------------------------캘린더

    @GetMapping("/calendar/tr-calendar")
    public String viewTRCalendar() {

        return "mypage/Mypage_Tourist_Calendar";
    }

    @GetMapping("/calendar/gd-calendar")
    public String viewGDCalendar() {

        return "mypage/Mypage_Guide_Calendar";
    }


//-----------------------------------------------즐겨찾기

    @GetMapping("/tr-wishlist")
    public String viewTRWishlist() {

        return "mypage/Mypage_Tourist_Wishlist";
    }


    @GetMapping("/gd-wishlist")
    public String viewGDWishlist() {

        return "mypage/Mypage_Guide_Wishlist";
    }


//--------------------------------------------------고객 등록 리뷰

    @GetMapping("/tr-review")
    public String viewTRReview() {

        return "mypage/Mypage_Tourist_MyReview";
    }


//-------------------------------------------------가이드 정산내역


    @GetMapping("/gd-sales")
    public String viewGDSales() {

        return "mypage/MyPage_SalesManagement";
    }


//    ---------------------------------고객 결제내역

    @GetMapping("/tr-payment")
    public String viewTRPayment() {

        return "mypage/MyPage_PaymentDetails";
    }


    

    //    --------------------------------------------- 메세지
    @GetMapping("/tr-message")
    public String viewTRMessage() {

        return "mypage/Mypage_Tourist_Wishlist";
    }

    @GetMapping("/gd-message")
    public String viewGDMessage() {

        return "mypage/Mypage_Guide_Calendar";
    }

    @GetMapping("/gd-insert")
    public String viewGDInsertPage() {


        return "guide/Guide_TourInsert";
    }

    
}
