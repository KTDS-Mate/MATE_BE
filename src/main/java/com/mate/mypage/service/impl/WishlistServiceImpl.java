package com.mate.mypage.service.impl;

import com.mate.mypage.dao.WishlistDao;
import com.mate.mypage.service.WishlistService;
import com.mate.mypage.vo.WishVO;
import com.mate.mypage.vo.WishlistVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistDao wishlistDao;

	@Override
	public WishlistVO selectTLAllWish(String usrId) {
		
		int count = this.wishlistDao.countWish(usrId);
		
		if(count == 0) {
			
			WishlistVO wishlistVO = new WishlistVO();
			wishlistVO.setCountWish(0);
			wishlistVO.setWishlist(new ArrayList<>());
			
			return wishlistVO;	
		}
		
		WishlistVO wishlistVO = new WishlistVO();
		
		List<WishVO> wishlist = this.wishlistDao.selectTLAllWish(usrId);
		wishlistVO.setCountWish(count);
		wishlistVO.setWishlist(wishlist);
		
		
		
		return wishlistVO;
	}


}
