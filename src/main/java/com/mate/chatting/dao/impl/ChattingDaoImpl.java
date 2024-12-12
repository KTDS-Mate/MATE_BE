package com.mate.chatting.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.chatting.dao.ChattingDao;
import com.mate.chatting.vo.ChattingRoomVO;
import com.mate.chatting.vo.MessageVO;
import com.mate.user.vo.UserVO;

@Repository
public class ChattingDaoImpl extends SqlSessionDaoSupport implements ChattingDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<ChattingRoomVO> selectRoomList(String usrId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectRoomList", usrId);
	}

	@Override
	public String checkChattingId(Map<String, String> map) {
		return this.getSqlSession().selectOne(NAMESPACE + ".checkChattingId", map);
	}

	@Override
	public String createChattingRoom(Map<String, String> map) {
		int result = this.getSqlSession().insert(NAMESPACE + ".createChattingRoom", map);
		String chattingId = null;
		if(result > 0) chattingId = map.get("chattingId");
		return chattingId;
	}

	@Override
	public int insertMessage(MessageVO messageVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertMessage", messageVO);
	}

	@Override
	public int updateReadFlag(Map<String, Object> paramMap) {
		return this.getSqlSession().update(NAMESPACE + ".updateReadFlag", paramMap);
	}

	@Override
	public List<MessageVO> selectMessageList(String ChattingId) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectMessageList" ,ChattingId);
	}

	@Override
	public List<UserVO> selectTarget(Map<String, Object> map) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectTarget", map);
	}
	
	
}
