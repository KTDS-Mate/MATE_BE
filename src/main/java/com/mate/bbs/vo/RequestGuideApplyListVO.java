package com.mate.bbs.vo;

import java.util.List;

public class RequestGuideApplyListVO {

	private int requestGuideApplyCount;
	
	private List<RequestGuideApplyVO> requestGuideApplyList;

	public int getRequestGuideApplyCount() {
		return requestGuideApplyCount;
	}

	public void setRequestGuideApplyCount(int requestGuideApplyCount) {
		this.requestGuideApplyCount = requestGuideApplyCount;
	}

	public List<RequestGuideApplyVO> getRequestGuideApplyList() {
		return requestGuideApplyList;
	}

	public void setRequestGuideApplyList(List<RequestGuideApplyVO> requestGuideApplyList) {
		this.requestGuideApplyList = requestGuideApplyList;
	}
	
}
