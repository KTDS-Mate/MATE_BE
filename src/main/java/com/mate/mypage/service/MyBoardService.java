package com.mate.mypage.service;

import java.util.List;

import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.MyBoardVO;
import com.mate.mypage.vo.SearchMyBoardVO;

public interface MyBoardService {

    public MyBoardListVO selectGDMyAllBoard(String usrLgnId , SearchMyBoardVO searchMyBoardVO);
    
    public int deleteGDBoard(String gdTrPstId);
}
