package com.mate.bbs.service;

import com.mate.bbs.vo.RequestGuideApplyListVO;
import com.mate.bbs.vo.RequestGuideApplyWriteVO;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.TourGuideApplyWriteVO;
import com.mate.bbs.vo.UserTourImgListVO;
import com.mate.bbs.vo.UserTourListVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;

public interface UserTourService {

	/**
	 * 클라이언트의 새로운 가이드 구인 게시글 작성
	 * @param userTourWriteVO
	 * @return
	 */
	public boolean createNewUserTour(UserTourWriteVO userTourWriteVO);
	
	/**
	 * 해주세요 게시글 작성
	 * @param userTourWriteVO
	 * @return
	 */
	public boolean createNewRequestTour(UserTourWriteVO userTourWriteVO);
	
	/**
	 * 한 게시글 조회
	 * @param usrTrPstId
	 * @return
	 */
	public UserTourVO getOneUserTour(String usrTrPstId);
	
	/**
	 * 모든 게시글 조회
	 * @return
	 */
	public UserTourListVO getAllUserTour(SearchUserTourVO searchUserTourVO);
	
	/**
	 * 게시글 수정
	 * @param userTourModifyVO
	 * @return
	 */
	public boolean modifyUserTour(UserTourModifyVO userTourModifyVO);
	
	/**
	 * 게시글 SoftDelete (usrTrIsDlt -> 'Y')
	 * @param usrTrPstId
	 * @return
	 */
	public boolean softDeleteUserTour(String usrTrPstId);
	
	public boolean reserveUserTour(String usrTrPstId, String usrLgnId);
	
	public boolean createNewTourGuideApply(TourGuideApplyWriteVO tourGuideApplyWriteVO);
	
	public boolean createNewRequestGuideApply(RequestGuideApplyWriteVO requestGuideApplyWriteVO);
	
	public RequestGuideApplyListVO getAllRequestGuideApply(String usrTrPstId);
	
	public UserTourImgListVO getUserTourImgs(String usrTrPstId);
	
	public UserTourVO getLateUserTour();
	
}
