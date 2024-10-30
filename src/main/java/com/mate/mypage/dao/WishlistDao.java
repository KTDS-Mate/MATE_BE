package com.mate.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.mypage.vo.SearchMyWishVO;
import com.mate.mypage.vo.WishVO;

public interface WishlistDao {


	public String NAMESPACE = "com.mate.mypage.dao.WishlistDao";
	
	public int countWish(@Param("loginId") String usrLgnId , @Param("search") SearchMyWishVO searchMyWishVO);
	
	public List<WishVO> selectAllWish(@Param("loginId") String usrLgnId);
	public List<WishVO> selectAllWish(@Param("loginId") String usrLgnId , @Param("search") SearchMyWishVO searchMyWishVO);
}
