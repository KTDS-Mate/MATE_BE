package com.mate.bbs.service;

import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;

public interface GuideTourService {

    /**
     *  모든 가이드 투어 목록 조회
     * @return
     */
    public GuideTourListVO getAllGuideTour();

    /**
     * 가이드 투어 게시글 한개 조회.
     * @param gdTrPstId
     * @return
     */
    public GuideTourVO getOneGuideTour(String gdTrPstId);
    /**
     * 새로운 가이드 투어 생성
     * @param guideTourWriteVO : 가이드 투어 작성 VO
     * @return
     */
    public boolean createNewGuideTour(GuideTourWriteVO guideTourWriteVO);

    /**
     * 가이드 투어 수정하는 메서드
     * @param guideTourModifyVO : 가이드 투어 수정 VO
     * @return
     */
    public boolean modifyGuideTourModify(GuideTourModifyVO guideTourModifyVO);
    
    /**
     * 가이드 투어 삭제하는 메서드 ( 소프트 딜리트 )
     * @param gdTrPstId : 가이드 투어 게시글 아이디
     * @return
     */
    public boolean softDeleteGuideTour(String gdTrPstId);
}
