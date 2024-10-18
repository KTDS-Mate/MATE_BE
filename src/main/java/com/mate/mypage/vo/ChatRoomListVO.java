package com.mate.mypage.vo;

import java.util.List;

public class ChatRoomListVO {
    private int chatCnt;
    private List<ChatRoomVO> chatRoomVOList;

    public int getChatCnt() {
        return chatCnt;
    }

    public void setChatCnt(int chatCnt) {
        this.chatCnt = chatCnt;
    }

    public List<ChatRoomVO> getChatRoomVOList() {
        return chatRoomVOList;
    }

    public void setChatRoomVOList(List<ChatRoomVO> chatRoomVOList) {
        this.chatRoomVOList = chatRoomVOList;
    }
}
