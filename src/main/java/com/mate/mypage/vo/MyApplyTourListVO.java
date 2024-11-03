package com.mate.mypage.vo;

import java.util.List;

import com.mate.bbs.vo.UserTourVO;

public class MyApplyTourListVO {

	private int myApplyTourCount;
	
	private List<UserTourVO> myApplyTourList;

	public int getMyApplyTourCount() {
		return myApplyTourCount;
	}

	public void setMyApplyTourCount(int myApplyTourCount) {
		this.myApplyTourCount = myApplyTourCount;
	}

	public List<UserTourVO> getMyApplyTourList() {
		return myApplyTourList;
	}

	public void setMyApplyTourList(List<UserTourVO> myApplyTourList) {
		this.myApplyTourList = myApplyTourList;
	}

}
