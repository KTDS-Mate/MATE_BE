package com.mate.bbs.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mate.bbs.service.FavoriteService;
import com.mate.bbs.vo.FavoriteListVO;
import com.mate.bbs.vo.FavoriteWriteVO;
import com.mate.user.vo.UserVO;

@RestController
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/favorite/{pstId}")
	public Map<String, Object> getAllFavorite(@PathVariable String pstId) {
		FavoriteListVO favoriteListVO = this.favoriteService.getAllFavoriteList(pstId);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("favoriteList", favoriteListVO.getFavoriteList());
		resultMap.put("favoriteCount", favoriteListVO.getFavoriteCount());
		
		return resultMap;
	}
	
	@PostMapping("/favorite/{pstId}")
	public Map<String, Object> doCreateNewUserTourFavorite(@PathVariable String pstId
														 , @SessionAttribute(value = "_LOGIN_USER_", required = false) UserVO loginUserVO) {
		FavoriteWriteVO favoriteWriteVO = new FavoriteWriteVO();
		favoriteWriteVO.setUsrTrPstId(pstId);
		favoriteWriteVO.setUsrLgnId(loginUserVO.getUsrLgnId());
		
		boolean isCreated = this.favoriteService.createNewUserTourFavorite(favoriteWriteVO);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", isCreated);
		
		return resultMap;
	}
	
	
	@GetMapping("/favorite/delete/{usrPstId}/{usrLgnId}")
	public Map<String, Object> doDeleteUserTourFavorite(@PathVariable String usrPstId
													  , @PathVariable String usrLgnId) {
		boolean isDeleted = this.favoriteService.deleteUserTourFavorite(usrPstId, usrLgnId);
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", isDeleted);
		
		return resultMap;
	}
	
	
}
