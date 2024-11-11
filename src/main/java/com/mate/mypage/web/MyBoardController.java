package com.mate.mypage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mate.mypage.service.MyBoardService;
import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.SearchMyBoardVO;
import com.mate.mypage.vo.TrMyBoardListVO;
import com.mate.mypage.vo.TrMyBoardVO;

@Controller
@RequestMapping("/mypage/mytour")
public class MyBoardController {

    @Autowired
    private MyBoardService myBoardService;
    
    
    

//  -------------------------------------------------------------------------투어리스트파트

    @GetMapping("/tr-mytour/{usrLgnId}")
    public String viewTrMyTour(@PathVariable String usrLgnId,SearchMyBoardVO searchMyBoardVO, Model model) {

    	TrMyBoardListVO boardListVO = this.myBoardService.selectTrMyAllBoard(usrLgnId , searchMyBoardVO);
    	
    	int myBoardListVO = boardListVO.getBoardCnt();
    	List<TrMyBoardVO> myBoardListVO2 = boardListVO.getBoardList();
    	
//    	System.out.println("갯수는 " + myBoardListVO);
//    	System.out.println("리스트는 " + myBoardListVO2);
    	
    	
//    	System.out.println("타입은 " + searchMyBoardVO.getSearchType());
//    	System.out.println("검색어는 " + searchMyBoardVO.getSearchKeyword());
    	
        model.addAttribute("boardListVO", boardListVO);
        model.addAttribute("searchBoardVO", searchMyBoardVO);


        return "mypage/Mypage_Tourist_MyTour";
    }


    @GetMapping("/tr-mytour/{usrLgnId}/delete-{usrTrPstId}")
    public String deletetrBoard(@PathVariable String usrLgnId , @PathVariable String usrTrPstId 
    						   			   ,Model model) {
    	
    	int success = this.myBoardService.deleteTrBoard(usrTrPstId);
//    	System.out.println("삭제결과는 " + success);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/mytour/tr-mytour/"+usrLgnId;
    } 
    
//  -------------------------------------------------------------------------가이드파트
    
    
    @GetMapping("/gd-mytour/{usrLgnId}")
    public String viewGDMyTour(@PathVariable String usrLgnId, SearchMyBoardVO searchMyBoardVO, Model model) {

    	MyBoardListVO boardListVO = this.myBoardService.selectGDMyAllBoard(usrLgnId , searchMyBoardVO);
    	
   
  
    	
    	
        model.addAttribute("boardListVO", boardListVO);
        model.addAttribute("searchBoardVO", searchMyBoardVO);
        	

        return "mypage/Mypage_Guide_MyTour";
    }
    

    
    
    @GetMapping("/gd-mytour/{usrLgnId}/delete-{gdTrPstId}")
    public String deleteGDBoard(@PathVariable String usrLgnId , @PathVariable String gdTrPstId 
    						   			   ,Model model) {
    	
    	int success = this.myBoardService.deleteGDBoard(gdTrPstId);
    	System.out.println("삭제결과는 " + success);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/mytour/gd-mytour/"+usrLgnId;
    }
    
    


}
