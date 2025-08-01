package com.mate.mypage.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.bbs.service.UserTourService;
import com.mate.bbs.vo.RequestGuideApplyListVO;
import com.mate.common.vo.ApiResponse;
import com.mate.mypage.service.MyBoardService;
import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.SearchMyBoardVO;
import com.mate.mypage.vo.TrMyBoardListVO;

@RestController
@RequestMapping("/api/v1/mypage/mytour")
public class MyBoardApiController {

    @Autowired
    private MyBoardService myBoardService;
    
    @Autowired
    private UserTourService userTourService;
    

//  -------------------------------------------------------------------------투어리스트파트

    @GetMapping("/tr-mytour/{usrLgnId}")
    public ApiResponse viewTrMyTour(@PathVariable String usrLgnId,SearchMyBoardVO searchMyBoardVO) {

    	TrMyBoardListVO boardListVO = this.myBoardService.selectTrMyAllBoard(usrLgnId , searchMyBoardVO);

        return new ApiResponse(boardListVO);
    }


    @GetMapping("/tr-mytour/{usrLgnId}/delete-{usrTrPstId}")
    public String deletetrBoard(@PathVariable String usrLgnId , @PathVariable String usrTrPstId 
    						   			   ,Model model) {
    	
    	int success = this.myBoardService.deleteTrBoard(usrTrPstId);
//    	System.out.println("삭제결과는 " + success);
    	model.addAttribute("success" , success);
    	
    	
    	return "redirect:/mypage/mytour/tr-mytour/"+usrLgnId;
    } 
    
	@GetMapping("/tr-mytour/requestApply/{usrTrPstId}")
	public ApiResponse getAllGuideApply(@PathVariable String usrTrPstId) {
		RequestGuideApplyListVO requestGuideApplyListVO = this.userTourService.getAllRequestGuideApply(usrTrPstId);
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(requestGuideApplyListVO);
		
		return apiResponse;
	}
    
//  -------------------------------------------------------------------------가이드파트
    
    
    @GetMapping("/gd-mytour/{usrLgnId}")
    public ApiResponse viewGDMyTour(@PathVariable String usrLgnId, SearchMyBoardVO searchMyBoardVO) {

    	
    	System.out.println("유저아이디는 " + usrLgnId);
    	MyBoardListVO boardListVO = this.myBoardService.selectGDMyAllBoard(usrLgnId , searchMyBoardVO);
    	System.out.println("보드 사이즈는 " + boardListVO.getBoardCnt());
   
        	

        return new ApiResponse(boardListVO);
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
