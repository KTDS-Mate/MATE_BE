package com.mate.mypage.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.common.vo.ApiResponse;
import com.mate.common.vo.PaginationVO;
import com.mate.mypage.service.WishlistService;
import com.mate.mypage.vo.TrWishlistVO;
import com.mate.mypage.vo.WishlistVO;

@RestController
@RequestMapping("api/v1/mypage/wishlist")
public class WishlistApiController {
	
	
	@Autowired
	private WishlistService wishlistService;

//  -------------------------------------------------------------------------투어리스트파트
	@GetMapping("/tr-wishlist/{usrLgnId}")
	public ApiResponse viewTrWish(@PathVariable String usrLgnId
										  ,PaginationVO paginationVO
										  ) {
		
		System.out.println("유저아이디는 " + usrLgnId);
		TrWishlistVO trWishlistVO = this.wishlistService.selectTrAllWish(usrLgnId , paginationVO);
		System.out.println("즐겨찾기갯수는 " + trWishlistVO.getCountWish());
		
		return new ApiResponse(trWishlistVO);
	}
	
	@GetMapping("/tr-wishlist/{usrLgnId}/delete-{favId}")
	public ApiResponse deleteTrWish(@PathVariable String usrLgnId
							  ,@PathVariable String favId) {
		
		System.out.println("즐겨찾기한 게시글아이디는 " + favId);
		int success = this.wishlistService.deleteWish(favId);
//    	System.out.println("삭제결과는 " + success);
		System.out.println(success);
    	

		
		return new ApiResponse(success);
	}
	
	
//  -------------------------------------------------------------------------가이드파트
	
	@GetMapping("/gd-wishlist/{usrLgnId}")
	public ApiResponse viewGdWish(@PathVariable String usrLgnId
										  ,PaginationVO paginationVO) {
		
		System.out.println("유저아이디는 " + usrLgnId);
		WishlistVO wishlistVO = this.wishlistService.selectAllWish(usrLgnId , paginationVO);
		System.out.println("즐겨찾기갯수는 " + wishlistVO.getCountWish());

		
		return new ApiResponse(wishlistVO);
	}
	
	@GetMapping("/gd-wishlist/{usrLgnId}/delete-{favId}")
	public ApiResponse deleteGdWish(@PathVariable String usrLgnId
							  ,@PathVariable String favId) {
		

		int success = this.wishlistService.deleteWish(favId);


		
		
		return new ApiResponse(success);
	}




}
