package com.mate.mypage.service;

import com.mate.mypage.vo.SearchMyWishVO;
import com.mate.mypage.vo.WishlistVO;

public interface WishlistService {
	
	public WishlistVO selectAllWish(String usrLgnId , SearchMyWishVO searchMyWishVO);
}
