package com.mate.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.bbs.vo.RequestGuideApplyVO;
import com.mate.bbs.vo.RequestGuideApplyWriteVO;
import com.mate.bbs.vo.SearchUserTourVO;
import com.mate.bbs.vo.TourGuideApplyWriteVO;
import com.mate.bbs.vo.UserTourImgVO;
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
	 * 해주세요 게시글 작성
	 * @return
	 */
	public int insertNewRequestTour(UserTourWriteVO userTourWriteVO);
	
	/**
	 * 한 게시글 조회
	 * @param usrTrPstId
	 * @return
	 */
	public UserTourVO selectOneUserTour(String usrTrPstId);
	
	public int selectAllUserTourCount(SearchUserTourVO searchUserTourVO);
	
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
	 * 예약 버튼을 클릭했을 때 해당 게시글의 예약 상태와 가이드 아이디를 변경
	 * @param usrTrPstId 게시글 아이디
	 * @param usrLgnId 가이드 아이디
	 * @return
	 */
	public int updateGdId(@Param("usrTrPstId") String usrTrPstId, @Param("usrLgnId") String usrLgnId);	
			
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
	
	public String selectAttachMultyStartHour(UserTourWriteVO userTourWriteVO);
	public String selectAttachMultyEndHour(UserTourWriteVO userTourWriteVO);
	
	
	/**
	 * 사용자가 입력한 투어 희망 정보를 저장
	 * @param userTourSchdlVO
	 * @return
	 */
	public int insertUserTourScheduls(UserTourSchdlVO userTourSchdlVO);
	
	public List<UserTourSchdlVO> selectUserTourSchdls(String usrTrPstId);
	
	public int insertNewUserTourImgs(UserTourImgVO userTourImgVO);
	
	/**게시글 수정 시 일정 리스트들을 추가 & 삭제 하게 될 경우가 있어서 삭제 후 다시 insert**/
	public int deleteUserTourSchdls(String usrTrPstId);

	public int insertNewTourGuideApply(TourGuideApplyWriteVO tourGuideApplyWriteVO);
	
	public int insertNewRequestGuideApply(RequestGuideApplyWriteVO requestGuideApplyWriteVO);
	
	public List<RequestGuideApplyVO> selectAllRequestGuideApplyList(String usrTrPstId);
	
	public int selectRequestGuideApplyListCount(String usrTrPstId);
	
	public int selectUserTourImgCount(String usrTrPstId);
	
	public List<UserTourImgVO> selectUserTourImgs(String usrTrPstId);
	
	public UserTourVO selectLateUserTour();
	
}
