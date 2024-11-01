package com.mate.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.FavoriteDao;
import com.mate.bbs.service.FavoriteService;
import com.mate.bbs.vo.FavoriteListVO;
import com.mate.bbs.vo.FavoriteVO;
import com.mate.bbs.vo.FavoriteWriteVO;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	private FavoriteDao favoriteDao;

	@Override
	public boolean createNewUserTourFavorite(FavoriteWriteVO favoriteWriteVO) {
		return this.favoriteDao.insertNewUserTourFavorite(favoriteWriteVO) > 0;
	}

	@Override
	public FavoriteListVO getAllFavoriteList(String pstId) {
		List<FavoriteVO> favoriteList = this.favoriteDao.selectAllFavoriteList(pstId);
		int selectCount = this.favoriteDao.selectAllFavoriteCount(pstId);
		
		FavoriteListVO favoriteListVO = new FavoriteListVO();
		favoriteListVO.setFavoriteList(favoriteList);
		favoriteListVO.setFavoriteCount(selectCount);
		
		return favoriteListVO;
	}
	
	
	
}
