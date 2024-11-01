package com.mate.bbs.service;

import com.mate.bbs.vo.FavoriteListVO;
import com.mate.bbs.vo.FavoriteWriteVO;

public interface FavoriteService {

	public boolean createNewUserTourFavorite(FavoriteWriteVO favoriteWriteVO);
	
	public FavoriteListVO getAllFavoriteList(String pstId);
	
}
