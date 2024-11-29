package com.mate.websocket.vo;

public class MessageVO {

	private String messageId;
	private String messageContent;
	private String readFlag;
	private String senderId;
	private String targetId;
	private String chattingId;
	private String sendTime;

	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getChattingId() {
		return chattingId;
	}
	public void setChattingId(String chattingId) {
		this.chattingId = chattingId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	@Override
	public String toString() {
		return "MessageVO [messageId=" + messageId + ", messageContent=" + messageContent + ", readFlag=" + readFlag
				+ ", senderId=" + senderId + ", targetId=" + targetId + ", chattingId=" + chattingId + ", sendTime="
				+ sendTime + "]";
	}
}
