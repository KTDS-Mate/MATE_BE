package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.GuideTourDetailInfoVO;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourProvidedVO;
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
     * 투어 등록폼에서 사용할 종료 날짜 이어붙이기.
     * @param guideTourWriteVO
     * @return
     */
    public String selectAttachEndHour(GuideTourWriteVO guideTourWriteVO);
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
    
    public List<GuideTourDetailInfoVO> selectTourDetailInfoList(String gdTrPstId);
    
    // 나머지 두개도 만듬
    
}
