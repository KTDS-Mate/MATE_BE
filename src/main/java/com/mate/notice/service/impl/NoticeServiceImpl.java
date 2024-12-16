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
}
