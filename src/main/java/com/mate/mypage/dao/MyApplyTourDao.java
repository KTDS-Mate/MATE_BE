package com.mate.mypage.dao;

import java.util.List;

import com.mate.bbs.vo.UserTourVO;

public interface MyApplyTourDao {

	public String NAMESPACE = "com.mate.mypage.dao.MyApplyTourDao";
	
	/**파라미터로 받은 유저의 모든 작성한 투어를 가져옴**/
	public List<UserTourVO> selectAllMyTours(String athrId);
	
	public int selectMyTourCount(String athrId);
	
	/**파라미터로 받은 게시글을 투어 진행중 -> 투어 완료로 변경**/
	public int updateUserTourStts(String usrTrPstId);
	
}
