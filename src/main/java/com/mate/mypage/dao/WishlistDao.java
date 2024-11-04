package com.mate.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.common.vo.PaginationVO;
import com.mate.mypage.vo.MyWishVO;
import com.mate.mypage.vo.TrMyWishVO;

public interface WishlistDao {


//  -------------------------------------------------------------------------가이드파트
	
	public String NAMESPACE = "com.mate.mypage.dao.WishlistDao";
	
	public int countWish(String usrLgnId);
	
	public List<MyWishVO> selectAllWish(@Param("loginId") String usrLgnId , @Param("search") PaginationVO paginationVO);
	
	public int deleteWish(String favId);
	
	
	
//  -------------------------------------------------------------------------투어리스트파트
	
	public int countTrWish(String usrLgnId);
	
	public List<TrMyWishVO> selectTrAllWish(@Param("loginId") String usrLgnId , @Param("search") PaginationVO paginationVO);
	
	public int deleteTrWish(String favId);
}
