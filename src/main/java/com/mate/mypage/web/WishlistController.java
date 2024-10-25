package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mate.mypage.service.WishlistService;
import com.mate.mypage.vo.WishlistVO;

@Controller
@RequestMapping("/mypage/wishlist")
public class WishlistController {
	
	
	@Autowired
	private WishlistService wishlistService;


	@GetMapping("/tr-wishlist")
	public String viewTrWish(@RequestParam String usrId
										  ,Model model) {
		
		WishlistVO wishlistVO = this.wishlistService.selectTLAllWish(usrId);
		
		model.addAttribute(wishlistVO);
		
		return "mypage/Mypage_Tourist_MyReview";
	}
	
	@GetMapping("/gd-wishlist")
	public String viewGdWish(@RequestParam String usrId
			,Model model) {
		
		WishlistVO wishlistVO = this.wishlistService.selectTLAllWish(usrId);
		
		model.addAttribute(wishlistVO);
		
		return "mypage/Mypage_Guide_Wishlist";
	}




}
