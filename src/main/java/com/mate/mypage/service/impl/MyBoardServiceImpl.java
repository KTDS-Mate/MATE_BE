package com.mate.mypage.service.impl;

import com.mate.mypage.dao.MyBoardDao;
import com.mate.mypage.service.MyBoardService;
import com.mate.mypage.vo.MyBoardListVO;
import com.mate.mypage.vo.MyBoardVO;
import com.mate.mypage.vo.SearchMyBoardVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBoardServiceImpl implements MyBoardService {

    @Autowired
    private MyBoardDao myBoardDao;

    @Override
    public MyBoardListVO selectGDMyAllBoard(String usrLgnId ,SearchMyBoardVO searchMyBoardVO) {
    	
    	int count = this.myBoardDao.selectBoardCount(usrLgnId , searchMyBoardVO);
    	
    	if(count == 0) {
    		MyBoardListVO boardListVO = new MyBoardListVO();
			boardListVO.setBoardCnt(0);
			boardListVO.setBoardList(new ArrayList<>());
			
			return boardListVO;
    	}
    	
    	
    	
    	List<MyBoardVO> MyboardList = null;
    	if(searchMyBoardVO == null) { 
    				// 페이지 처리를 하지 않을경우 
    		MyboardList = this.myBoardDao.selectGDMyAllBoard(usrLgnId);
    		}
    		else {
    		// 페이지네이션을 위한 게시글 조회
    			MyboardList = this.myBoardDao.selectGDMyAllBoard(usrLgnId ,searchMyBoardVO);
    			//총 페이지 개수를 구한다
    			searchMyBoardVO.setPageCount(count);
    			}
    	
    	MyBoardListVO boardListVO = new MyBoardListVO();

    	boardListVO.setBoardCnt(count);
    	boardListVO.setBoardList(MyboardList);

        return boardListVO;
    }

    
	@Override
	public int deleteGDBoard(String gdTrPstId) {
		int success = this.myBoardDao.deleteGDBoard(gdTrPstId);
		return success;
	}
    
    
}
