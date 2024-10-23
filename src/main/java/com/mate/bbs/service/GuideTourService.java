package com.mate.bbs.service;

import com.mate.bbs.vo.GuideTourListVO;
import com.mate.bbs.vo.GuideTourVO;
import com.mate.bbs.vo.WriteGuideTourVO;

public interface GuideTourService {

    // 모든 가이드 투어 목록을 가져오는 메소드
    public GuideTourListVO getAllGuideTour();

//    // 새로운 채팅방을 만드는 메소드
//    public boolean createNewChatRoom(WriteGuideTourVO writeChatRoomVO);
//
//    // id 로 특정 채팅방 하나를 가져오는 메소드
//    public GuideTourVO selectOneChatRoomById(String id);
//
//    // id 로 특정 채팅방 하나를 삭제하는 메소드
//    public boolean deleteOneChatRoom(String id);
}
