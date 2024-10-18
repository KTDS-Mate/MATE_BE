package com.mate.review.vo;

import java.util.List;

import com.mate.chat.vo.ChatVO;

public class WriteChatRoomVO {

    private String chatRoomId;
    private String senderId;
    private String receiverId;
    private List<ChatVO> chatVOList;

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getSenderId() {
        return senderId;
        
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public List<ChatVO> getChatVOList() {
        return chatVOList;
    }

    public void setChatVOList(List<ChatVO> chatVOList) {
        this.chatVOList = chatVOList;
    }
}
