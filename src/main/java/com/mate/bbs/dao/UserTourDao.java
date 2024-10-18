package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.ModifyUserTourVO;
import com.mate.bbs.vo.UserTourVO;
import com.mate.bbs.vo.WriteUserTourVO;

public interface UserTourDao {

	public String NAMESPACE = "com.mate.bbs.dao.UserTourDao";
	
	public int insertNewUserTour(WriteUserTourVO writeUserTourVO);
	
	/**
	 * 하나의 게시글을 선택했을 때 보여줄 내용
	 * @return
	 */
	public UserTourVO selectOneUserTour(String usrTrPstId);
	
	public int selectUserTourCount();
	
	public List<UserTourVO> selectAllUserTour();
	
	/**
	 * 유저가 등록한 게시글의 내용 수정
	 * 수정 사항 : 제목, 일시, 목적, 미팅포인트, 가이드 요청사항, 가이드 고용 금액, 투어 인원, 투어 지역 도시, 투어 사진 수정(논리적삭제 OR 사진 추가), 세부 요구사항
	 * @return
	 */
	public int updateUserTourContent(ModifyUserTourVO modifyUserTourVO);
	
	/**
	 * 유저가 등록한 게시글의 논리적 삭제를 위한 쿼리
	 * @return
	 */
	public int updateUserTourIsDlt(String usrTrPstId);
	
}
