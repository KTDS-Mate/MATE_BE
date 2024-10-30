package com.mate.mypage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.mypage.dao.WishlistDao;
import com.mate.mypage.service.WishlistService;
import com.mate.mypage.vo.SearchMyWishVO;
import com.mate.mypage.vo.WishVO;
import com.mate.mypage.vo.WishlistVO;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistDao wishlistDao;

	@Override
	public WishlistVO selectAllWish(String usrLgnId , SearchMyWishVO searchMyWishVO) {
		
		int count = this.wishlistDao.countWish(usrLgnId , searchMyWishVO);
		
		if(count == 0) {
			
			WishlistVO wishlistVO = new WishlistVO();
			wishlistVO.setCountWish(0);
			wishlistVO.setWishlist(new ArrayList<>());
			
			return wishlistVO;	
		}
		
		List<WishVO> MyWishList = null;
    	if(searchMyWishVO == null) { 
    				// 페이지 처리를 하지 않을경우 
    		MyWishList = this.wishlistDao.selectAllWish(usrLgnId);
    		}
    		else {
    		// 페이지네이션을 위한 게시글 조회
    			MyWishList = this.wishlistDao.selectAllWish(usrLgnId ,searchMyWishVO);
    			//총 페이지 개수를 구한다
    			searchMyWishVO.setPageCount(count);
    			}
		
		WishlistVO wishlistVO = new WishlistVO();
		
		List<WishVO> wishlist = this.wishlistDao.selectAllWish(usrLgnId);
		wishlistVO.setCountWish(count);
		wishlistVO.setWishlist(wishlist);
		
		
		
		return wishlistVO;
	}


}
