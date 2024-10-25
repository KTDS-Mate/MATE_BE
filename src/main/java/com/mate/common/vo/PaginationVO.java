package com.mate.common.vo;

public class PaginationVO {

	/*
	 * 페이지네이션을 위한 VO
	 * 각자 검색 VO(EX> SearchUserTourVO)에 상속 받고 
	 * ServiceImpl에서 setListSize()사용해서 각자 한 화면에 보여주고 싶은 페이지 직접 할당
	 * -> EX> UserTourServiceImpl
	 */
	
	/**페이지네이션 조회**/
	private int pageNo;
	
	private int listSize;
	
	private int pageCount;
	
	/**페이지네이션 그룹 속성**/
	private int pageCountInGroup;
	
	private int groupCount;
	
	private int groupNo;
	
	private int groupStartPageNo;
	
	private int groupEndPageNo;
	
	private boolean hasNextGroup;
	
	private boolean hesprevGroup;
	
	private int nextGroupStartPageNo;
	
	private int prevGroupStartPageNo;
	
	public PaginationVO() {
		this.pageCountInGroup = 10;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int listCount) {
		// 총 페이지의 개수
		this.pageCount = (int)Math.ceil((double)listCount / this.listSize);
		/*****************페이지 그룹 관련 계산********************/
		// 총 페이지 그룹 개수
		this.groupCount = (int)Math.ceil((double)this.pageCount / this.pageCountInGroup);
		// 현재 페이지 번호
		this.groupNo = this.pageNo / this.pageCountInGroup;
		// 현재 페이지 그룹의 시작 번호
		this.groupStartPageNo = this.groupNo * this.pageCountInGroup;
		// 현재 페이지 그룹의 끝 번호
		this.groupEndPageNo = (this.groupNo + 1) * this.pageCountInGroup - 1;
		/**현재 그룹이 마지막 그룹일 경우 계산 된 현재 그룹의 페이지 번호와 실제 페이지 번호가 다름**/
		if (this.groupEndPageNo > this.pageCount) {
			this.groupEndPageNo = this.pageCount - 1;
		}
		// 다음 그룹의 존재 여부
		this.hasNextGroup = this.groupNo + 1 < this.groupCount;
		// 이전 그룹의 존재 여부
		this.hesprevGroup = this.groupNo > 0;
		// 다음 그룹의 시작 페이지 번호
		this.nextGroupStartPageNo = this.groupEndPageNo + 1;
		// 이전 그룹의 시작 페이지 번호
		this.prevGroupStartPageNo = this.groupStartPageNo - this.pageCountInGroup;
	}

	public int getPageCountInGroup() {
		return pageCountInGroup;
	}

	public void setPageCountInGroup(int pageCountInGroup) {
		this.pageCountInGroup = pageCountInGroup;
	}

	public int getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getGroupStartPageNo() {
		return groupStartPageNo;
	}

	public void setGroupStartPageNo(int groupStartPageNo) {
		this.groupStartPageNo = groupStartPageNo;
	}

	public int getGroupEndPageNo() {
		return groupEndPageNo;
	}

	public void setGroupEndPageNo(int groupEndPageNo) {
		this.groupEndPageNo = groupEndPageNo;
	}

	public boolean isHasNextGroup() {
		return hasNextGroup;
	}

	public void setHasNextGroup(boolean hasNextGroup) {
		this.hasNextGroup = hasNextGroup;
	}

	public boolean isHesprevGroup() {
		return hesprevGroup;
	}

	public void setHesprevGroup(boolean hesprevGroup) {
		this.hesprevGroup = hesprevGroup;
	}

	public int getNextGroupStartPageNo() {
		return nextGroupStartPageNo;
	}

	public void setNextGroupStartPageNo(int nextGroupStartPageNo) {
		this.nextGroupStartPageNo = nextGroupStartPageNo;
	}

	public int getPrevGroupStartPageNo() {
		return prevGroupStartPageNo;
	}

	public void setPrevGroupStartPageNo(int prevGroupStartPageNo) {
		this.prevGroupStartPageNo = prevGroupStartPageNo;
	}
}
