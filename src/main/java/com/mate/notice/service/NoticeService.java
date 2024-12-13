package com.mate.notice.service;

import com.mate.notice.vo.NoticeVO;
import java.util.List;

public interface NoticeService {

    // 1. 알림 생성
    public void createNotice(NoticeVO noticeVO);

    // 2. 특정 사용자에 대한 읽지 않은 알림 조회
    public List<NoticeVO> getUnreadNoticesByRecipientId(String rcpntId);

    // 3. 알림 읽음 상태로 업데이트
    public void markNoticeAsRead(String ntcId);

    // 4. 알림 삭제 처리
    public void removeNotice(String ntcId);
}
