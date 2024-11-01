package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.UserTourModifyVO;
import com.mate.bbs.vo.UserTourSchdlVO;
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
	 * @param userTourModifyVO 수정 내용
	 * @return
	 */
	public int updateUserTour(UserTourModifyVO userTourModifyVO);
	
	/**
	 * 게시글 SoftDelete (usrTrIsDlt -> 'Y')
	 * @param usrTrPstId
	 * @return
	 */
	public int updateUserTourIsDtl(String usrTrPstId);
	
	/**
	 * 사용자가 입력한 시작 날짜와 시간을 YYYY-MM-DD HH24:MI로 포멧을 맞춰주는 쿼리 실행
	 * @param userTourWriteVO 게시글 작성에 사용
	 * @return
	 */
	public String selectAttachStartHour(UserTourWriteVO userTourWriteVO);
	
	/**
	 * 사용자가 입력한 시작 날짜와 시간을 YYYY-MM-DD HH24:MI로 포멧을 맞춰주는 쿼리 실행
	 * @param userTourModifyVO 게시글 수정에 사용
	 * @return
	 */
	public String selectAttachStartHour2(UserTourModifyVO userTourModifyVO);
	
	/**
	 * 사용자가 입력한 종료 날짜와 시간을 YYYY-MM-DD HH24:MI로 포멧을 맞춰주는 쿼리 실행
	 * @param userTourWriteVO 게시글 작성에 사용
	 * @return
	 */
	public String selectAttachEndHour(UserTourWriteVO userTourWriteVO);
	
	/**
	 * 사용자가 입력한 종료 날짜와 시간을 YYYY-MM-DD HH24:MI로 포멧을 맞춰주는 쿼리 실행
	 * @param userTourModifyVO 게시글 수정에 사용
	 * @return
	 */
	public String selectAttachEndHour2(UserTourModifyVO userTourModifyVO);
	
	/**
	 * 사용자가 입력한 투어 희망 정보를 저장
	 * @param userTourSchdlVO
	 * @return
	 */
	public int insertUserTourScheduls(UserTourSchdlVO userTourSchdlVO);
	
	/**
	 * 사용자가 입력한 투어 희망 정보를 수정
	 * @param userTourSchdlVO
	 * @return
	 */
	public int updateUserTourScheduls(UserTourSchdlVO userTourSchdlVO);
	
}
