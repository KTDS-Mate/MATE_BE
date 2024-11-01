package com.mate.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mate.common.vo.PaginationVO;
import com.mate.mypage.service.WishlistService;
import com.mate.mypage.vo.WishlistVO;

@Controller
@RequestMapping("/mypage/wishlist")
public class WishlistController {
	
	
	@Autowired
	private WishlistService wishlistService;


	@GetMapping("/tr-wishlist/{usrLgnId}")
	public String viewTrWish(@PathVariable String usrLgnId
										  ,PaginationVO paginationVO
										  ,Model model) {
		
		WishlistVO wishlistVO = this.wishlistService.selectAllWish(usrLgnId , paginationVO);
		
		model.addAttribute("wishlistVO" ,wishlistVO);
		model.addAttribute("paginationVO", paginationVO);
		
		return "mypage/Mypage_Tourist_Wishlist";
	}
	
	@GetMapping("/gd-wishlist/{usrLgnId}")
	public String viewGdWish(@PathVariable String usrLgnId
										  ,PaginationVO paginationVO
										  ,Model model) {
		
		WishlistVO wishlistVO = this.wishlistService.selectAllWish(usrLgnId , paginationVO);
		
		model.addAttribute("wishlistVO" ,wishlistVO);
		model.addAttribute("paginationVO", paginationVO);
		
		return "mypage/Mypage_Guide_Wishlist";
	}




}
