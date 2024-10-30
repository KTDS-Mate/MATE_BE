package com.mate.mypage.web;

import com.mate.mypage.service.MyBoardService;
import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.MyBoardVO;
import com.mate.mypage.vo.SearchMyBoardVO;

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

    @GetMapping("/tr-mytour/{usrLgnId}")
    public String viewTRMyTour(@PathVariable String usrLgnId,SearchMyBoardVO searchMyBoardVO, Model model) {

    	MyBoardListVO boardListVO = this.myBoardService.selectGDMyAllBoard(usrLgnId , searchMyBoardVO);
    	

    	System.out.println("타입은 " + searchMyBoardVO.getSearchType());
    	System.out.println("검색어는 " + searchMyBoardVO.getSearchKeyword());
    	
        model.addAttribute("boardListVO", boardListVO);
        model.addAttribute("searchBoardVO", searchMyBoardVO);


        return "mypage/Mypage_Tourist_MyTour";
    }

    @GetMapping("/gd-mytour/{usrLgnId}")
    public String viewGDMyTour(@PathVariable String usrLgnId, SearchMyBoardVO searchMyBoardVO, Model model) {

    	MyBoardListVO boardListVO = this.myBoardService.selectGDMyAllBoard(usrLgnId , searchMyBoardVO);
    	
   
  
    	
    	
        model.addAttribute("boardListVO", boardListVO);
        model.addAttribute("searchBoardVO", searchMyBoardVO);
        	

        return "mypage/Mypage_Guide_MyTour";
    }
    

    @GetMapping("/gd-mytour/{usrLgnId}/delete-{gdTrPstId}")
    public String deleteBoard(@PathVariable String usrLgnId , @PathVariable String gdTrPstId 
    						   			   ,Model model) {
    	
    	int success = this.myBoardService.deleteGDBoard(gdTrPstId);
    	System.out.println("삭제결과는 " + success);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/mytour/gd-mytour/"+usrLgnId;
    }
    
    


}
