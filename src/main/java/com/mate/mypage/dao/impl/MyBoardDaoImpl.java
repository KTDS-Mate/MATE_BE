package com.mate.mypage.dao.impl;

import com.mate.mypage.dao.MyBoardDao;
import com.mate.mypage.vo.MyBoardVO;
import com.mate.mypage.vo.SearchMyBoardVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBoardDaoImpl extends SqlSessionDaoSupport implements MyBoardDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public int selectBoardCount(String usrLgnId , SearchMyBoardVO searchMyBoardVO) {

    	Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", searchMyBoardVO);
    	
    	return this.getSqlSession().selectOne(NAMESPACE + ".selectBoardCount" ,params);
    }
    
    @Override
    public List<MyBoardVO> selectGDMyAllBoard(String usrLgnId, SearchMyBoardVO searchMyBoardVO) {
    	Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", searchMyBoardVO);
    	
        return this.getSqlSession().selectList(NAMESPACE + ".selectGDMyAllBoard", params);
    }
    
    @Override
    public List<MyBoardVO> selectGDMyAllBoard(String usrLgnId) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("loginId", usrLgnId);

    	
    	return this.getSqlSession().selectList(NAMESPACE + ".selectGDMyAllBoard", params);
    }

	@Override
	public int deleteGDBoard(String gdTrPstId) {
		
		return this.getSqlSession().delete(NAMESPACE + ".deleteGDBoard" , gdTrPstId);
	}

}
