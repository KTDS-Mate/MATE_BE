package com.mate.mypage.service.impl;

import com.mate.mypage.dao.MyBoardDao;
import com.mate.mypage.service.MyBoardService;
import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.MyBoardVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBoardServiceImpl implements MyBoardService {

    @Autowired
    private MyBoardDao myBoardDao;

    @Override
    public MyBoardListVO selectGDMyAllBoard(String usrLgnId) {
    	
    	int count = this.myBoardDao.selectBoardCount(usrLgnId);
    	
    	if(count == 0) {
    		MyBoardListVO boardListVO = new MyBoardListVO();
			boardListVO.setBoardCnt(0);
			boardListVO.setBoardList(new ArrayList<>());
			
			return boardListVO;
    	}
    	
    	MyBoardListVO boardListVO = new MyBoardListVO();
    	
    	List<MyBoardVO> myWriteBoard = this.myBoardDao.selectGDMyAllBoard(usrLgnId);
    	
    	boardListVO.setBoardCnt(count);
    	boardListVO.setBoardList(myWriteBoard);

        return boardListVO;
    }

	@Override
	public int deleteGDBoard(String gdTrPstId) {
		int success = this.myBoardDao.deleteGDBoard(gdTrPstId);
		return success;
	}
    
    
}
