package com.mate.mypage.web;

import com.mate.mypage.service.MyBoardService;
import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.MyBoardVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mypage/mytour")
public class MyBoardController {

    @Autowired
    private MyBoardService myBoardService;

    //----------------------------------------------------등록 투어

    @GetMapping("/tr-mytour")
    public String viewTRMyTour(@RequestParam String usrId, Model model) {

    	MyBoardListVO myWriteBoard = this.myBoardService.selectGDMyAllBoard(usrId);
    	
        model.addAttribute("myWriteBoard", myWriteBoard);

        return "mypage/Mypage_Tourist_MyTour";
    }

    @GetMapping("/gd-mytour")
    public String viewGDMyTour(@RequestParam String usrId, Model model) {

    	MyBoardListVO boardListVO = this.myBoardService.selectGDMyAllBoard(usrId);
        
        System.out.println(boardListVO);
        model.addAttribute("boardListVO", boardListVO);

        return "mypage/Mypage_Guide_MyTour";
    }
    

    @GetMapping("/gd-mytour/delete-{gdTrPstId}")
    public String deleteBoard(@PathVariable String gdTrPstId 
    						   			   ,Model model) {
    	
    	int success = this.myBoardService.deleteGDBoard(gdTrPstId);
    	System.out.println("삭제결과는 " + success);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/mytour/gd-mytour?usrId=7";
    }
    
    


}
