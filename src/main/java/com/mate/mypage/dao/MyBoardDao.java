package com.mate.mypage.dao;

import java.util.List;

import com.mate.mypage.vo.MyBoardVO;

public interface MyBoardDao {

    public String NAMESPACE = "com.mate.mypage.dao.MyBoardDao";

    public int selectBoardCount(String usrId);
    
    public List<MyBoardVO> selectGDMyAllBoard(String usrId);
    
    public int deleteGDBoard(String gdTrPstId);
}
