package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mate.common.vo.PaginationVO;
import com.mate.mypage.service.WishlistService;
import com.mate.mypage.vo.TrWishlistVO;
import com.mate.mypage.vo.WishlistVO;

@Controller
@RequestMapping("/mypage/wishlist")
public class WishlistController {
	
	
	@Autowired
	private WishlistService wishlistService;

//  -------------------------------------------------------------------------투어리스트파트
	@GetMapping("/tr-wishlist/{usrLgnId}")
	public String viewTrWish(@PathVariable String usrLgnId
										  ,PaginationVO paginationVO
										  ,Model model) {
		
		TrWishlistVO trWishlistVO = this.wishlistService.selectTrAllWish(usrLgnId , paginationVO);
		
		model.addAttribute("trWishlistVO" ,trWishlistVO);
		model.addAttribute("paginationVO", paginationVO);
		
		return "mypage/Mypage_Tourist_Wishlist";
	}
	
	@GetMapping("/tr-wishlist/{usrLgnId}/delete-{favId}")
	public String deleteTrWish(@PathVariable String usrLgnId
							  ,@PathVariable String favId
											,Model model) {
		
		int success = this.wishlistService.deleteWish(favId);
    	System.out.println("삭제결과는 " + success);
    	
    	model.addAttribute("success" , success);
		
		return "redirect:/mypage/wishlist/tr-wishlist/"+usrLgnId;
	}
	
	
//  -------------------------------------------------------------------------가이드파트
	
	@GetMapping("/gd-wishlist/{usrLgnId}")
	public String viewGdWish(@PathVariable String usrLgnId
										  ,PaginationVO paginationVO
										  ,Model model) {
		
		WishlistVO wishlistVO = this.wishlistService.selectAllWish(usrLgnId , paginationVO);
		
		model.addAttribute("wishlistVO" ,wishlistVO);
		model.addAttribute("paginationVO", paginationVO);
		
		return "mypage/Mypage_Guide_Wishlist";
	}
	
	@GetMapping("/gd-wishlist/{usrLgnId}/delete-{favId}")
	public String deleteGdWish(@PathVariable String usrLgnId
							  ,@PathVariable String favId
											,Model model) {
		
		System.out.println("로그인 아이디는 " + usrLgnId);
		System.out.println("즐겨찾기 아이디는 " + favId);
		int success = this.wishlistService.deleteWish(favId);
    	System.out.println("삭제결과는 " + success);

		
		
		return "redirect:/mypage/wishlist/gd-wishlist/"+usrLgnId;
	}




}
