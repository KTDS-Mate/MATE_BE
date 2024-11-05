package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.GuideTourDetailInfoVO;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourProvidedVO;
import com.mate.bbs.vo.GuideTourReviewVO;
import com.mate.bbs.vo.GuideTourScheduleInfoVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;
import com.mate.bbs.vo.SearchGuideTourVO;

public interface GuideTourDao {

	public String NAMESPACE = "com.mate.bbs.dao.GuideTourDao";
	
    /**
     *  가이드 투어 전체 수를 조회
     * @param gdTrPstId : 가이드 투어 게시글 아이디
     * @return
     */
    public int selectGuideTourAllCount();
    
    
    /**
     *  모든 가이드 투어 목록 조회
     * @param athrId : 작성자 아이디
     * @return
     */
    public List<GuideTourVO> selectAllGuideTour(SearchGuideTourVO searchGuideTourVO);
    /**
     * 한 가이드 투어 게시글 조회
     * @param gdTrPstId
     * @return
     */
    public GuideTourVO selectOneGuideTour(String gdTrPstId);
    
    /**
     *  새로운 가이드 투어를 생성
     * @param guideTourWriteVO : 가이드 투어 작성 VO
     * @return
     */
    public int insertNewGuideTour(GuideTourWriteVO guideTourWriteVO);
    
    /**
     * 가이드 투어 수정
     * @param guideTourModifyVO : 가이드 투어 수정 VO
     * @return
     */
    public int updateGuideTour(GuideTourModifyVO guideTourModifyVO);
    
    /**
     * 가이드 투어 삭제 ( 소프트 딜리트 )
     * @param gdTrPstId : 가이드 투어 게시글 아이디
     * @return
     */
    public int updateGuideTourIsDtl(String gdTrPstId);

    /**
     * 투어 등록폼에서 사용할 시작 날짜 이어붙이기.
     * @param guideTourWriteVO
     * @return
     */
    public String selectAttachStartHour(GuideTourWriteVO guideTourWriteVO);
    /**
     * 가이드가 입력한 시작 날짜와 시간을 YYYY-MM-DD HH24:MI로 포멧을 맞춰주는 쿼리 실행
     * @param guideTourModifyVO : 게시글 수정 VO
     * @return
     */
    public String selectAttachModifyStartHour(GuideTourModifyVO guideTourModifyVO);
    /**
     * 투어 등록폼에서 사용할 종료 날짜 이어붙이기.
     * @param guideTourWriteVO
     * @return
     */
    public String selectAttachEndHour(GuideTourWriteVO guideTourWriteVO);
    /**
     * 가이드가 입력한 종료 날짜와 시간을 YYYY-MM-DD HH24:MI로 포멧을 맞춰주는 쿼리 실행
     * @param guideTourModifyVO : 게시글 수정VO
     * @return
     */
    public String selectAttachModifyEndHour(GuideTourModifyVO guideTourModifyVO);
    /**
     * 가이드 투어 등록 폼에서 추가 정보를 담는 메소드.
     * @param guideTourDetailInfoVO
     * @return
     */
    public int insertNewDetailInfo(GuideTourDetailInfoVO guideTourDetailInfoVO);
    /**
     * 가이드 투어 등록 폼에서 세부 일정 정보를 담는 메소드.
     * @param guideTourScheduleInfoVO
     * @return
     */
    public int insertNewSchdInfo(GuideTourScheduleInfoVO guideTourScheduleInfoVO);
    /**
     * 가이드 투어 등록 폼에서 추가 제공 요소를 담는 메소드.
     * @param guideTourScheduleInfoVO
     * @return
     */
    public int insertNewProvidedInfo(GuideTourProvidedVO guideTourProvidedVO);
    
    /**
     * 가상 DOM으로 데이터를 받는 투어 추가 정보를 select 하기 위해 따로 값을 받음.
     * insert에서 한번에 join을 하면 값이 중복되어 나오기 때문. 
     * @param gdTrPstId
     * @return
     */
    public List<GuideTourDetailInfoVO> selectTourDetailInfoList(String gdTrPstId);
    /**
     * 가상 DOM으로 데이터를 받는 투어 제공요소를 select 하기 위해 따로 값을 받음.
     * insert에서 한번에 join을 하면 값이 중복되어 나오기 때문. 
     */
    public List<GuideTourProvidedVO> selectTourProvidedList(String gdTrPstId);
    /**
     * 가상 DOM으로 데이터를 받는 투어 세부일정을 select 하기 위해 따로 값을 받음.
     * insert에서 한번에 join을 하면 값이 중복되어 나오기 때문. 
     * @param gdTrPstId
     * @return
     */
    public List<GuideTourScheduleInfoVO> selectTourScheduleList(String gdTrPstId);
    
}
