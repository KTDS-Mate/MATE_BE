package com.mate.chat.vo;

import java.util.List;

public class ChatListVO {
    private int chatCnt;
    private List<ChatVO> chatVOList;

    public int getChatCnt() {
        return chatCnt;
    }

    public void setChatCnt(int chatCnt) {
        this.chatCnt = chatCnt;
    }

    public List<ChatVO> getChatVOList() {
        return chatVOList;
    }

    public void setChatVOList(List<ChatVO> chatVOList) {
        this.chatVOList = chatVOList;
    }
}
