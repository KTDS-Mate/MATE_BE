package com.mate.bbs.vo;

public class GuideTourDetailInfoVO {

   /**
    * 가이드 등록 투어 일정에 대한 상세정보 pk
    */
   private String trDtlId;
   /**
    * 가이드가 등록한 투어 게시글 아이디
    */
   private String gdTrPstId;
   /**
    * 투어 일정에 대한 추가 정보
    */
   private String trDtlInf;
   
   public String getTrDtlId() {
      return trDtlId;
   }
   public void setTrDtlId(String trDtlId) {
      this.trDtlId = trDtlId;
   }
   public String getGdTrPstId() {
      return gdTrPstId;
   }
   public void setGdTrPstId(String gdTrPstId) {
      this.gdTrPstId = gdTrPstId;
   }
   public String getTrDtlInf() {
      return trDtlInf;
   }
   public void setTrDtlInf(String trDtlInf) {
      this.trDtlInf = trDtlInf;
   }
}
