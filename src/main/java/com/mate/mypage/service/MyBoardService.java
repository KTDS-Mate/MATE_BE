package com.mate.mypage.service;

import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.SearchMyBoardVO;
import com.mate.mypage.vo.TrMyBoardListVO;

public interface MyBoardService {
	
	
//  -------------------------------------------------------------------------투어리스트파트
	
	public TrMyBoardListVO selectTrMyAllBoard(String usrLgnId , SearchMyBoardVO searchMyBoardVO);
	
	public int deleteTrBoard(String usrTrPstId);
	
//  -------------------------------------------------------------------------가이드파트

    public MyBoardListVO selectGDMyAllBoard(String usrLgnId , SearchMyBoardVO searchMyBoardVO);
    
    public int deleteGDBoard(String gdTrPstId);
    
}
