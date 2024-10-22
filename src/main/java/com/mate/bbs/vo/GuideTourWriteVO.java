package com.mate.bbs.vo;

import java.util.List;

public class GuideTourWriteVO {

	
	/**
	 * 가이드 유저 성
	 */
	private String usrLnm;
	/**
	 * 가이드 유저 이름
	 */
	private String usrFnm;
	/**
	 * 투어 제목
	 */
	private String gdTrTtl;
	
	/**
	 * 투어 장소 (국가 도시)
	 */
	private String ctNm;
	/**
	 * 투어 날짜
	 */
	private String gdTrDt;
	
	/**
	 * 끝날짜
	 */
	private String gdTrTm;
	
	/**
	 * 투어 요약
	 */
	private String gdTrSmry;
	/**
	 * 투어 상세정보(목적)
	 */
	private String gdTrPrps;
	
	/**
	 * 투어 비용
	 */
	private int gdTrPrc;
	
	/**
	 * 투어 미팅 포인트
	 */
	private String gdTrMp;
	/**
	 *  투어제공항목 리스트
	 */
	private List<GuideTourProvidedVO> guideTourProvidedList;
	/**
	 * 투어 사진 리스트
	 */
	private List<GuideTourImgVO> guideTourImgList;
	/**
	 * 가이드 투어 상세정보 리스트 VO
	 */
	private List<GuideTourDetailInfoVO> guideTourDetailInfoList;
	
	
	
}
