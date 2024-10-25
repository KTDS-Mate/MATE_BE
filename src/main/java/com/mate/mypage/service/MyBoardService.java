package com.mate.mypage.service;

import java.util.List;

import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.MyBoardVO;

public interface MyBoardService {

    public MyBoardListVO selectGDMyAllBoard(String usrLgnId);
    
    public int deleteGDBoard(String gdTrPstId);
}
