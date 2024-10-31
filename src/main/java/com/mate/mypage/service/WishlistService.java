package com.mate.mypage.service;

import com.mate.common.vo.PaginationVO;
import com.mate.mypage.vo.WishlistVO;

public interface WishlistService {
	
	public WishlistVO selectAllWish(String usrLgnId , PaginationVO paginationVO);
}
