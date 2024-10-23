package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;

public interface GuideTourDao {

	public String NAMESPACE = "com.mate.bbs.dao.GuideTourDao";
	
    /**
     *  가이드 투어 수를 조회
     * @param gdTrPstId : 가이드 투어 게시글 아이디
     * @return
     */
    public int selectGuideTourAllCount();
    /**
     *  모든 가이드 투어 목록 조회
     * @param athrId : 작성자 아이디
     * @return
     */
    public List<GuideTourVO> selectAllGuideTour();
    /**
     * 한 가이드 투어 게시글 조회
     * @param gdTrPstId
     * @return
     */
    public GuideTourVO selectOneGuideTour(String gdTrPstId);
    
    /**
     *  새로운 가이드 투어를 생성하는 메서드
     * @param guideTourWriteVO : 가이드 투어 작성 VO
     * @return
     */
    public int insertNewGuideTour(GuideTourWriteVO guideTourWriteVO);
    
    /**
     * 가이드 투어 수정 메서드
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

}
