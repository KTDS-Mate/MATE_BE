package com.mate.notice.service.impl;

import java.util.List;

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
	public void createNotice(NoticeVO noticeVO) {
		noticeDao.insertNotice(noticeVO);
	}

	@Override
	public List<NoticeVO> getUnreadNoticesByRecipientId(String rcpntId) {
		return noticeDao.selectUnreadNoticesByRecipientId(rcpntId);
	}

	@Override
	public void markNoticeAsRead(String ntcId) {
		noticeDao.updateNoticeReadStatus(ntcId);
	}

	@Override
	public void removeNotice(String ntcId) {
		noticeDao.deleteNotice(ntcId);
	}
	
	@Override
	public boolean sendNotification(String token, String message) {
        if (token == null || token.isEmpty()) {
            System.out.println("Invalid token: Notification not sent.");
            return false; // 토큰이 없는 경우 실패 처리
        }

        try {
            // 실제 알림 전송 로직 (예제)
            // 외부 서비스 예: Firebase, AWS SNS 등 연동
            System.out.println("Sending notification to token: " + token);
            System.out.println("Message: " + message);

            // TODO: 알림 전송 로직 구현 (Firebase Admin SDK 사용 예시)
            /*
            Message notificationMessage = Message.builder()
                .setToken(token)
                .putData("title", "New Notification")
                .putData("body", message)
                .build();

            String response = FirebaseMessaging.getInstance().send(notificationMessage);
            System.out.println("Successfully sent message: " + response);
            */

            return true; // 전송 성공
        } catch (Exception e) {
            System.err.println("Failed to send notification: " + e.getMessage());
            return false; // 전송 실패
        }
    }
}
