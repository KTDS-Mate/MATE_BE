package com.mate.mypage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.mypage.dao.WishlistDao;
import com.mate.mypage.vo.SearchMyWishVO;
import com.mate.mypage.vo.WishVO;

@Repository
public class WishlistDaoImpl extends SqlSessionDaoSupport implements WishlistDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int countWish(String usrLgnId , SearchMyWishVO searchMyWishVO) {
		
		Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", searchMyWishVO);
		
		return this.getSqlSession().selectOne(null);
	}

	@Override
	public List<WishVO> selectAllWish(String usrLgnId, SearchMyWishVO searchMyWishVO) {
		
		Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", searchMyWishVO);
		
		return this.getSqlSession().selectList(NAMESPACE + ".selectTLAllWish" , params);
	}
	
	@Override
	public List<WishVO> selectAllWish(String usrLgnId) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", usrLgnId);

		
		return this.getSqlSession().selectList(NAMESPACE + ".selectTLAllWish" , params);
	}






}
