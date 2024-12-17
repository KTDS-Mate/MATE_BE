package com.mate.notice.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.notice.dao.NoticeDao;
import com.mate.notice.service.NoticeService;
import com.mate.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public NoticeVO createNotice(NoticeVO noticeVO) {
	    // 알림 ID 생성 (UUID 등으로 생성 가능)
	    noticeVO.setNtcIsRd(false);
	    noticeVO.setNtcCrAt(LocalDateTime.now().toString());
	    noticeVO.setNtcIsDlt(false);

	    if (noticeVO.getNtcUrl() == null || noticeVO.getNtcUrl().isEmpty()) {
	        noticeVO.setNtcUrl("/");
	    }

	    // 알림 DAO를 통해 데이터베이스에 삽입
	    noticeDao.insertNotice(noticeVO);

	    return noticeVO;
	}

	// 2. 특정 사용자의 읽지 않은 알림 조회
	@Override
    public List<NoticeVO> getUnreadNoticesByRecipientId(String recipientId) {
        return noticeDao.selectUnreadNoticesByRecipientId(recipientId);
    }

    // 3. 알림 읽음 상태 업데이트
	@Override
    public void markNoticeAsRead(String noticeId) {
        noticeDao.updateNoticeReadStatus(noticeId);
    }

    // 4. 알림 삭제 처리
	@Override
    public void deleteNotice(String noticeId) {
        noticeDao.deleteNotice(noticeId);
    }
	
	@Override
	public List<NoticeVO> getNoticeByRecipientId(String rcpntId) {
	    return noticeDao.selectAllNoticesByReceipientId(rcpntId)
	        .stream()
	        .filter(notice -> !notice.isNtcIsDlt()) // 삭제된 알림 제외
	        .collect(Collectors.toList());
	}
}
