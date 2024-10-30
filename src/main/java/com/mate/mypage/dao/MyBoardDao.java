package com.mate.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.mypage.vo.MyBoardVO;
import com.mate.mypage.vo.SearchMyBoardVO;

public interface MyBoardDao {

    public String NAMESPACE = "com.mate.mypage.dao.MyBoardDao";

    public int selectBoardCount(@Param("loginId") String usrLgnId , @Param("search") SearchMyBoardVO searchMyBoardVO);
    
    public List<MyBoardVO> selectGDMyAllBoard(@Param("loginId") String usrLgnId);
    public List<MyBoardVO> selectGDMyAllBoard(@Param("loginId") String usrLgnId , @Param("search") SearchMyBoardVO searchMyBoardVO);
    
    public int deleteGDBoard(String gdTrPstId);
}
