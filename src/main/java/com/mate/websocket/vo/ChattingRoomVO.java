package com.mate.websocket.vo;

public class ChattingRoomVO {

	private String chattingId;
	private String lastMessage;
	private String sendTime;
	private String targetId;
	
	private int notReadCount;
	
	

	public String getChattingId() {
		return chattingId;
	}
	public void setChattingId(String chattingId) {
		this.chattingId = chattingId;
	}
	public String getLastMessage() {
		return lastMessage;
	}
	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public int getNotReadCount() {
		return notReadCount;
	}
	public void setNotReadCount(int notReadCount) {
		this.notReadCount = notReadCount;
	}
	@Override
	public String toString() {
		return "ChattingRoomVO [chattingId=" + chattingId + ", lastMessage=" + lastMessage + ", sendTime=" + sendTime
				+ ", targetId=" + targetId + ", notReadCount=" + notReadCount + "]";
	}

}
