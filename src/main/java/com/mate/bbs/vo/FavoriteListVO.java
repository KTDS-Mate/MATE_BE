package com.mate.bbs.vo;

import java.util.List;

public class FavoriteListVO {

	/**검색 된 즐겨찾기의 개수**/
	private int favoriteCount;
	/**검색 된 즐겨찾기들**/
	private List<FavoriteVO> favoriteList;

	public int getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public List<FavoriteVO> getFavoriteList() {
		return favoriteList;
	}
	public void setFavoriteList(List<FavoriteVO> favoriteList) {
		this.favoriteList = favoriteList;
	}
	
}
