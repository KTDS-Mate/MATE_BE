package com.mate.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.mypage.vo.MyBoardVO;
import com.mate.mypage.vo.SearchMyBoardVO;
import com.mate.mypage.vo.TrMyBoardVO;

public interface MyBoardDao {

    public String NAMESPACE = "com.mate.mypage.dao.MyBoardDao";
    
    
//  -------------------------------------------------------------------------투어리스트파트
    
    
    public int selectTrBoardCount(@Param("loginId") String usrLgnId , @Param("search") SearchMyBoardVO searchMyBoardVO);
    
    public List<TrMyBoardVO> selectTrMyAllBoard(@Param("loginId") String usrLgnId);
    public List<TrMyBoardVO> selectTrMyAllBoard(@Param("loginId") String usrLgnId , @Param("search") SearchMyBoardVO searchMyBoardVO);
    
    public int deleteTrBoard(String usrTrPstId);
    
    
    
    
//    -------------------------------------------------------------------------가이드파트

    public int selectBoardCount(@Param("loginId") String usrLgnId , @Param("search") SearchMyBoardVO searchMyBoardVO);
    
    public List<MyBoardVO> selectGDMyAllBoard(@Param("loginId") String usrLgnId);
    public List<MyBoardVO> selectGDMyAllBoard(@Param("loginId") String usrLgnId , @Param("search") SearchMyBoardVO searchMyBoardVO);
    
    public int deleteGDBoard(String gdTrPstId);
    


}
