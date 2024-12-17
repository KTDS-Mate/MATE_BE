package com.mate.notice.dao;

import com.mate.notice.vo.NoticeVO;
import java.util.List;

public interface NoticeDao {

    String NAMESPACE = "com.mate.notice.dao.NoticeDao";

    // 1. 알림 생성
    int insertNotice(NoticeVO noticeVO);

    // 2. 특정 사용자에 대한 읽지 않은 알림 조회
    List<NoticeVO> selectUnreadNoticesByRecipientId(String rcpntId);

    // 3. 알림 읽음 상태로 업데이트
    int updateNoticeReadStatus(String ntcId);

    // 4. 알림 삭제 처리
    int deleteNotice(String ntcId);
    
    // 5. 알림 받기
    List<NoticeVO> selectAllNoticesByReceipientId(String rcpntId);
}
