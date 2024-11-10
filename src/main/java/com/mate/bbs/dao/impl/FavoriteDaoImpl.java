package com.mate.bbs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.FavoriteDao;
import com.mate.bbs.vo.FavoriteVO;
import com.mate.bbs.vo.FavoriteWriteVO;

@Repository
public class FavoriteDaoImpl extends SqlSessionDaoSupport implements FavoriteDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNewUserTourFavorite(FavoriteWriteVO favoriteWriteVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewUserTourFavorite", favoriteWriteVO);
	}

	@Override
	public int insertNewGuideTourFavorite(FavoriteWriteVO favoriteWriteVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewGuideTourFavorite", favoriteWriteVO);
	}
	
	@Override
	public List<FavoriteVO> selectAllFavoriteList(String pstId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllFavoriteList", pstId);
	}

	@Override
	public int selectAllFavoriteCount(String usrPstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAllFavoriteCount", usrPstId);
	}
	
	@Override
	public int deleteFavIsDlt(String usrPstId, String usrLgnId) {
		Map<String, Object> param = new HashMap<>();
		param.put("usrPstId", usrPstId);
		param.put("usrLgnId", usrLgnId);
		
		return this.getSqlSession().update(NAMESPACE + ".deleteFavIsDlt", param);
	}

}
