package com.mate.mypage.dao.impl;

import com.mate.mypage.dao.MyBoardDao;
import com.mate.mypage.vo.MyBoardVO;

import java.util.List;

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
    public int selectBoardCount(String usrLgnId) {

    	return this.getSqlSession().selectOne(NAMESPACE + ".selectBoardCount" ,usrLgnId);
    }
    
    @Override
    public List<MyBoardVO> selectGDMyAllBoard(String usrLgnId) {
        return this.getSqlSession().selectList(NAMESPACE + ".selectGDMyAllBoard", usrLgnId);
    }

	@Override
	public int deleteGDBoard(String gdTrPstId) {
		
		return this.getSqlSession().delete(NAMESPACE + ".deleteGDBoard" , gdTrPstId);
	}

}
