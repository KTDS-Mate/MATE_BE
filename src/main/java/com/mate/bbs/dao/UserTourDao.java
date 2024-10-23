package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourImgVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.UserTourWriteVO;

public interface UserTourDao {

	public String NAMESPACE = "com.mate.bbs.dao.UserTourDao";
	
	/**
	 * 클라이언트의 새로운 가이드 구인 게시글 작성
	 * @param userTourWriteVO
	 * @return
	 */
	public int insertNewUserTour(UserTourWriteVO userTourWriteVO);
	
	/**
	 * 한 게시글 조회
	 * @param usrTrPstId
	 * @return
	 */
	public UserTourVO selectOneUserTour(String usrTrPstId);
	
	public int selectAllUserTourCount();
	
	/**
	 * 모든 게시글 조회(페이지네이션)
	 * @return
	 */
	public List<UserTourVO> selectAllUserTour(SearchUserTourVO searchUserTourVO);
	
	/**
	 * 게시글 수정
	 * @param userTourModifyVO
	 * @return
	 */
	public int updateUserTour(UserTourModifyVO userTourModifyVO);
	
	/**
	 * 게시글 SoftDelete (usrTrIsDlt -> 'Y')
	 * @param usrTrPstId
	 * @return
	 */
	public int updateUserTourIsDtl(String usrTrPstId);
	
}
