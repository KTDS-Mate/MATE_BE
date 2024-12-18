package com.mate.bbs.service;

import com.mate.bbs.vo.FavoriteListVO;
import com.mate.bbs.vo.FavoriteWriteVO;

public interface FavoriteService {

	public boolean createNewUserTourFavorite(FavoriteWriteVO favoriteWriteVO);
	
	public boolean createNewGuideTourFavorite(FavoriteWriteVO favoriteWriteVO);
	
	public FavoriteListVO getAllFavoriteList(String pstId);
	
	public FavoriteListVO getAllGuideTourFavoriteList(String gdTrPstId);
	
	public boolean deleteUserTourFavorite(String usrPstId, String usrLgnId);
	
	public boolean deleteGuideTourFavorite(String gdTrPstId, String usrLgnId);
}
