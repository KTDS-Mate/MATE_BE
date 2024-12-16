package com.mate.notice.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.notice.dao.NoticeDao;
import com.mate.notice.vo.NoticeVO;

@Repository
public class NoticeDaoImpl extends SqlSessionDaoSupport implements NoticeDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertNotice(NoticeVO noticeVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNotice", noticeVO);
	}

	@Override
	public List<NoticeVO> selectUnreadNoticesByRecipientId(String rcpntId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectUnreadNoticesByRecipientId", rcpntId);
	}

	@Override
	public int updateNoticeReadStatus(String ntcId) {
		return this.getSqlSession().update(NAMESPACE + ".updateNoticeReadStatus", ntcId);
	}

	@Override
	public int deleteNotice(String ntcId) {
		return this.getSqlSession().update(NAMESPACE + ".deleteNotice", ntcId);
	}
}
