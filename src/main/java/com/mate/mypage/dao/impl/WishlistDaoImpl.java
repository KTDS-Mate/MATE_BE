package com.mate.mypage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.common.vo.PaginationVO;
import com.mate.mypage.dao.WishlistDao;
import com.mate.mypage.vo.MyWishVO;
import com.mate.mypage.vo.TrMyWishVO;

@Repository
public class WishlistDaoImpl extends SqlSessionDaoSupport implements WishlistDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
    
    
//  -------------------------------------------------------------------------가이드파트

	@Override
	public int countWish(String usrLgnId) {
		

		
		return this.getSqlSession().selectOne(NAMESPACE + ".countWish" , usrLgnId);
	}

	@Override
	public List<MyWishVO> selectAllWish(String usrLgnId, PaginationVO paginationVO) {
		
		Map<String, Object> params = new HashMap<>();
        params.put("loginId", usrLgnId);
        params.put("search", paginationVO);
		
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllWish" , params);
	}

	@Override
	public int deleteWish(String favId) {
		
		//System.out.println("Dao 전" + favId);
		return this.getSqlSession().delete(NAMESPACE + ".deleteWish" , favId);
	}
	
//  -------------------------------------------------------------------------투어리스트파트
	
	
	
	
	
	
	@Override
	public int countTrWish(String usrLgnId) {
		
		
		
		return this.getSqlSession().selectOne(NAMESPACE + ".countTrWish" , usrLgnId);
	}
	
	
	
	@Override
	public List<TrMyWishVO> selectTrAllWish(String usrLgnId, PaginationVO paginationVO) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", usrLgnId);
		params.put("search", paginationVO);
		
		return this.getSqlSession().selectList(NAMESPACE + ".selectTrAllWish" , params);
	}
	
	@Override
	public int deleteTrWish(String favId) {
		
		//System.out.println("Dao 전" + favId);
		return this.getSqlSession().delete(NAMESPACE + ".deleteTrWish" , favId);
	}
	






}
