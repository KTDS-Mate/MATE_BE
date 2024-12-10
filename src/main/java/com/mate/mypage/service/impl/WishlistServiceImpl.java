package com.mate.mypage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.common.vo.PaginationVO;
import com.mate.mypage.dao.WishlistDao;
import com.mate.mypage.service.WishlistService;
import com.mate.mypage.vo.MyWishVO;
import com.mate.mypage.vo.TrMyWishVO;
import com.mate.mypage.vo.TrWishlistVO;
import com.mate.mypage.vo.WishlistVO;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistDao wishlistDao;

    
//  -------------------------------------------------------------------------가이드파트
	@Override
	public WishlistVO selectAllWish(String usrLgnId , PaginationVO paginationVO) {
		
		int count = this.wishlistDao.countWish(usrLgnId);
		
		if(count == 0) {
			
			WishlistVO wishlistVO = new WishlistVO();
			wishlistVO.setCountWish(0);
			wishlistVO.setWishlist(new ArrayList<>());
			
			return wishlistVO;	
		}

    	
		 List<MyWishVO>	MyWishList = this.wishlistDao.selectAllWish(usrLgnId ,paginationVO);
    			//총 페이지 개수를 구한다
    	paginationVO.setPageCount(count);

		WishlistVO wishlistVO = new WishlistVO();
		wishlistVO.setCountWish(count);
		wishlistVO.setWishlist(MyWishList);
		
		
		
		return wishlistVO;
	}

	@Override
	public int deleteWish(String favId) {
		
		//System.out.println("서비스 임플전" + favId);
		int success = this.wishlistDao.deleteWish(favId);
		//System.out.println("서비스 임플후" + success);
		
		return success;
	}
	
//  -------------------------------------------------------------------------투어리스트파트

	
	
	@Override
	public TrWishlistVO selectTrAllWish(String usrLgnId , PaginationVO paginationVO) {
		
		int count = this.wishlistDao.countTrWish(usrLgnId);
		
		if(count == 0) {
			
			TrWishlistVO wishlistVO = new TrWishlistVO();
			wishlistVO.setCountWish(0);
			wishlistVO.setWishlist(new ArrayList<>());
			
			return wishlistVO;	
		}
		
		
		List<TrMyWishVO> MyWishList = this.wishlistDao.selectTrAllWish(usrLgnId ,paginationVO);
		//총 페이지 개수를 구한다
		paginationVO.setPageCount(count);
		
		TrWishlistVO wishlistVO = new TrWishlistVO();
		wishlistVO.setCountWish(count);
		wishlistVO.setWishlist(MyWishList);
		
		
		
		return wishlistVO;
	}
	
	@Override
	public int deleteTrWish(String favId) {
		
		//System.out.println("서비스 임플전" + favId);
		int success = this.wishlistDao.deleteWish(favId);
		//System.out.println("서비스 임플후" + success);
		
		return success;
	}


}
