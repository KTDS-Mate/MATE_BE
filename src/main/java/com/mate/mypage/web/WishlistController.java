package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mate.mypage.service.WishlistService;
import com.mate.mypage.vo.SearchMyWishVO;
import com.mate.mypage.vo.WishlistVO;

@Controller
@RequestMapping("/mypage/wishlist")
public class WishlistController {
	
	
	@Autowired
	private WishlistService wishlistService;


	@GetMapping("/tr-wishlist/{usrLgnId}")
	public String viewTrWish(@PathVariable String usrLgnId
										  ,SearchMyWishVO searchMyWishVO
										  ,Model model) {
		
		WishlistVO wishlistVO = this.wishlistService.selectAllWish(usrLgnId , searchMyWishVO);
		
		model.addAttribute(wishlistVO);
		model.addAttribute("searchBoardVO", searchMyWishVO);
		
		return "mypage/Mypage_Tourist_Wishlist";
	}
	
	@GetMapping("/gd-wishlist/{usrLgnId}")
	public String viewGdWish(@PathVariable String usrLgnId
										  ,SearchMyWishVO searchMyWishVO
										  ,Model model) {
		
		WishlistVO wishlistVO = this.wishlistService.selectAllWish(usrLgnId , searchMyWishVO);
		
		model.addAttribute(wishlistVO);
		model.addAttribute("searchBoardVO", searchMyWishVO);
		
		return "mypage/Mypage_Guide_Wishlist";
	}




}
