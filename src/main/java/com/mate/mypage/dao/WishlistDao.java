package com.mate.mypage.dao;

import java.util.List;

import com.mate.mypage.vo.WishVO;

public interface WishlistDao {


	public String NAMESPACE = "com.mate.mypage.dao.WishlistDao";
	
	public int countWish(String usrId);
	
	public List<WishVO> selectTLAllWish(String usrId);
}
