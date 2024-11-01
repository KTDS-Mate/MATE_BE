package com.mate.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.common.vo.PaginationVO;
import com.mate.mypage.vo.MyWishVO;

public interface WishlistDao {


	public String NAMESPACE = "com.mate.mypage.dao.WishlistDao";
	
	public int countWish(String usrLgnId);
	

	public List<MyWishVO> selectAllWish(@Param("loginId") String usrLgnId , @Param("search") PaginationVO paginationVO);
}
