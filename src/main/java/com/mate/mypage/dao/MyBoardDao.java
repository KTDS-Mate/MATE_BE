package com.mate.mypage.dao;

import java.util.List;

import com.mate.mypage.vo.MyBoardVO;

public interface MyBoardDao {

    public String NAMESPACE = "com.mate.mypage.dao.MyBoardDao";

    public int selectBoardCount(String usrLgnId);
    
    public List<MyBoardVO> selectGDMyAllBoard(String usrLgnId);
    
    public int deleteGDBoard(String gdTrPstId);
}
