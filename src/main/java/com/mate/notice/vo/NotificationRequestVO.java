package com.mate.notice.vo;

public class NotificationRequestVO {
    private String token;   // 유저의 알림 토큰
    private String message; // 알림 메시지

    // Getters and Setters
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
