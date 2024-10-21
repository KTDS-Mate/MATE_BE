package com.mate.chat.vo;

import org.springframework.context.annotation.Configuration;

@Configuration

public class ChatVO {
    private String chatId;
    private String chatInfo;
    private String chatSendedTm;
    private boolean isChecked;
    private String chatSenderId;
    private String chatReceiverId;

    public ChatVO(){}

    public ChatVO(String chatId, String chatInfo, String chatSendedTm,
                  boolean isChecked, String chatSenderId, String chatReceiverId) {
        this.chatId = chatId;
        this.chatInfo = chatInfo;
        this.chatSendedTm = chatSendedTm;
        this.isChecked = isChecked;
        this.chatSenderId = chatSenderId;
        this.chatReceiverId = chatReceiverId;
    }

    @Override
    public String toString() {
        return "ChatVO{" +
                "chatId='" + chatId + '\'' +
                ", chatInfo='" + chatInfo + '\'' +
                ", chatSendedTm='" + chatSendedTm + '\'' +
                ", isChecked=" + isChecked +
                ", chatSenderId='" + chatSenderId + '\'' +
                ", chatReceiverId='" + chatReceiverId + '\'' +
                '}';
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getChatInfo() {
        return chatInfo;
    }

    public void setChatInfo(String chatInfo) {
        this.chatInfo = chatInfo;
    }

    public String getChatSendedTm() {
        return chatSendedTm;
    }

    public void setChatSendedTm(String chatSendedTm) {
        this.chatSendedTm = chatSendedTm;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getChatSenderId() {
        return chatSenderId;
    }

    public void setChatSenderId(String chatSenderId) {
        this.chatSenderId = chatSenderId;
    }

    public String getChatReceiverId() {
        return chatReceiverId;
    }

    public void setChatReceiverId(String chatReceiverId) {
        this.chatReceiverId = chatReceiverId;
    }
}
