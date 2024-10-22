package com.mate.bbs.dao;

import java.util.List;

import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.WriteGuideTourVO;

public interface GuideTourDao {

	public String NAMESPACE = "com.mate.bbs.dao.GuideTourDao";
	
    // 가이드 투어 수를 반환하는 메서드 정의
    public int selectGuideTourAllCount();

    // 모든 가이드 투어 목록을 반환하는 메서드 정의
    public List<GuideTourVO> selectAllGuideTour();

    // 새로운 가이드 투어를 생성하는 메서드 정의
    public int createNewGuideTour(WriteGuideTourVO writeGuideTourVO);
//
//    // 특정 ID 를 가진 채팅방의 정보를 반환하는 메서드 정의
//    public GuideTourVO selectChatRoomById(String id);
//
//    // 특정 ID 를 가진 채팅방을 삭제(soft delete)하는 메서드 정의
//    public int deleteChatRoomById(String id, boolean isDeleted);

}
