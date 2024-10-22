package com.mate.bbs.service;

import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourModifyVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.GuideTourWriteVO;

public interface GuideTourService {

    /**
     *  모든 가이드 투어 목록을 가져오는 메소드
     * @return
     */
    public GuideTourListVO getAllGuideTour();

    /**
     * 새로운 가이드 투어 생성하는 메서드
     * @param guideTourWriteVO : 가이드 투어 작성 VO
     * @return
     */
    public boolean createNewGuideTour(GuideTourWriteVO guideTourWriteVO);

    /**
     * 가이드 투어 수정하는 메서드
     * @param guideTourModifyVO : 가이드 투어 수정 VO
     * @return
     */
    public boolean updateGuideTourModify(GuideTourModifyVO guideTourModifyVO);
    
    /**
     * 가이드 투어 삭제하는 메서드 ( 소프트 딜리트 )
     * @param gdTrPstId : 가이드 투어 게시글 아이디
     * @return
     */
    public boolean updateGuideTourDelete(String gdTrPstId);
}
