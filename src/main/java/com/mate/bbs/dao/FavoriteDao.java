package com.mate.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.bbs.vo.FavoriteVO;
import com.mate.bbs.vo.FavoriteWriteVO;

public interface FavoriteDao {

	public String NAMESPACE = "com.mate.bbs.dao.FavoriteDao";
	/**가이드 구인 게시글 즐겨찾기 추가 시 작동**/
	public int insertNewUserTourFavorite(FavoriteWriteVO favoriteWriteVO);
	/**가이드가 작성한 게시글 즐겨찾기 추가 시 작동**/
	public int insertNewGuideTourFavorite(FavoriteWriteVO favoriteWriteVO);
	
	/**
	 * 해당 게시물의 모든 즐겨찾기 목록을 가져옴
	 * @param usrPstId 게시물 아이디
	 * @return
	 */
	public List<FavoriteVO> selectAllFavoriteList(String usrPstId);
	
	public int selectAllFavoriteCount(String pstId);
	
	/**
	 * 선택 된 즐겨찾기를 삭제
	 * @return
	 */
	public int deleteFavIsDlt(@Param("usrPstId") String usrPstId
							, @Param("usrLgnId") String usrLgnId);
	
}
