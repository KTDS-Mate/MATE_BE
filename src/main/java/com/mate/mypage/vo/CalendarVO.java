package com.mate.mypage.vo;

public class CalendarVO {

	private int calId;
	private String calGroupId;
	private String calTitle;
	private String calWriter;
	private String calContent;
	private String calStart;
	private String calEnd;
    private boolean calAllday;
	private String calTextColor;
	private String calBackColor;
	private String calBorderColor;
	private String calUrl;
	
	private CalendarUserVO calendarUserVO;
	
	
	
	
	
	
	public String getCalUrl() {
		return calUrl;
	}
	public void setCalUrl(String calUrl) {
		this.calUrl = calUrl;
	}
	public CalendarUserVO getCalendarUserVO() {
		return calendarUserVO;
	}
	public void setCalendarUserVO(CalendarUserVO calendarUserVO) {
		this.calendarUserVO = calendarUserVO;
	}
	public int getCalId() {
		return calId;
	}
	public void setCalId(int calId) {
		this.calId = calId;
	}
	public String getCalGroupId() {
		return calGroupId;
	}
	public void setCalGroupId(String calGroupId) {
		this.calGroupId = calGroupId;
	}
	public String getCalTitle() {
		return calTitle;
	}
	public void setCalTitle(String calTitle) {
		this.calTitle = calTitle;
	}
	public String getCalWriter() {
		return calWriter;
	}
	public void setCalWriter(String calWriter) {
		this.calWriter = calWriter;
	}
	public String getCalContent() {
		return calContent;
	}
	public void setCalContent(String calContent) {
		this.calContent = calContent;
	}
	public String getCalStart() {
		return calStart;
	}
	public void setCalStart(String calStart) {
		this.calStart = calStart;
	}
	public String getCalEnd() {
		return calEnd;
	}
	public void setCalEnd(String calEnd) {
		this.calEnd = calEnd;
	}
	public boolean isCalAllday() {
		return calAllday;
	}
	public void setCalAllday(boolean calAllday) {
		this.calAllday = calAllday;
	}
	public String getCalTextColor() {
		return calTextColor;
	}
	public void setCalTextColor(String calTextColor) {
		this.calTextColor = calTextColor;
	}
	public String getCalBackColor() {
		return calBackColor;
	}
	public void setCalBackColor(String calBackColor) {
		this.calBackColor = calBackColor;
	}
	public String getCalBorderColor() {
		return calBorderColor;
	}
	public void setCalBorderColor(String calBorderColor) {
		this.calBorderColor = calBorderColor;
	}
	
	
	
	
	

	
	
	
	
}
