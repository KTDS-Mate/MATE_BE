package com.mate.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.mypage.vo.MyApplyGuideTourVO;
import com.mate.mypage.vo.MyApplyUserTourVO;
import com.mate.mypage.vo.SearchMyApplyTourVO;

public interface MyApplyTourDao {

	public String NAMESPACE = "com.mate.mypage.dao.MyApplyTourDao";
	
	//    ------------- 여행자 마이페이지 ---------------
	
	/**파라미터로 받은 유저의 모든 신청한 투어를 가져옴**/
	public List<MyApplyUserTourVO> selectAllMyApplyTours(@Param("usrId") String usrId, @Param("search") SearchMyApplyTourVO searchMyApplyTourVO);
	
	public int selectMyTourCount(@Param("athrId") String athrId, @Param("search") SearchMyApplyTourVO searchMyApplyTourVO);
	
	/**파라미터로 받은 가이드의 게시글을 투어 진행중 -> 투어 완료로 변경**/
	public int updateGuideTourStts(String usrTrPstId);
	
	//    ------------- 가이드 마이페이지 ---------------
	
	/**파라미터로 받은 가이드가 신청한 투어를 가져옴**/
	public List<MyApplyGuideTourVO> selectAllMyApplyToursForGuide(@Param("usrId") String usrId, @Param("search") SearchMyApplyTourVO searchMyApplyTourVO);
	
	public int selectMyTourCountForGuide(@Param("athrId") String athrId, @Param("search") SearchMyApplyTourVO searchMyApplyTourVO);
	
	public int updateUserTourStts(String usrTrPstId);
	
}
