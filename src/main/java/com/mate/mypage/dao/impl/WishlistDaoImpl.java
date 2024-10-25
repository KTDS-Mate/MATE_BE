package com.mate.mypage.dao.impl;

import com.mate.mypage.dao.WishlistDao;
import com.mate.mypage.vo.WishVO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WishlistDaoImpl extends SqlSessionDaoSupport implements WishlistDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int countWish(String usrId) {
		
		return this.getSqlSession().selectOne(null);
	}

	@Override
	public List<WishVO> selectTLAllWish(String usrId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectTLAllWish" , usrId);
	}






}
