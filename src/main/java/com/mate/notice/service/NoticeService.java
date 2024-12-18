package com.mate.notice.service;

import com.mate.notice.vo.NoticeVO;
import java.util.List;

public interface NoticeService {

    // 1. 알림 생성
	public NoticeVO createNotice(NoticeVO noticeVO);

	// 2. 특정 사용자의 읽지 않은 알림 조회
    public List<NoticeVO> getUnreadNoticesByRecipientId(String recipientId);

    // 3. 알림 읽음 상태 업데이트
    public void markNoticeAsRead(String noticeId);

    // 4. 알림 삭제 처리
    public void deleteNotice(String noticeId);
    
    // 5. 알림 받기
    public List<NoticeVO> getNoticeByRecipientId(String rcpntId);
}
