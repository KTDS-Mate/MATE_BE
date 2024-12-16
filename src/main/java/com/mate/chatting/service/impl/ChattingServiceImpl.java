package com.mate.chatting.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.chatting.dao.ChattingDao;
import com.mate.chatting.service.ChattingService;
import com.mate.chatting.vo.ChattingRoomVO;
import com.mate.chatting.vo.MessageVO;
import com.mate.user.vo.UserVO;

@Service
public class ChattingServiceImpl implements ChattingService{

	@Autowired
	private ChattingDao chattingDao;

	@Override
	public List<ChattingRoomVO> selectRoomList(String usrId) {
		return chattingDao.selectRoomList(usrId);
	}

	@Override
	public String checkChattingId(Map<String, String> map) {
		return chattingDao.checkChattingId(map);
	}

	@Override
	public String createChattingRoom(Map<String, String> map) {
		return chattingDao.createChattingRoom(map);
	}

	@Override
	public int insertMessage(MessageVO messageVO) {
		return chattingDao.insertMessage(messageVO);
	}

	@Override
	public int updateReadFlag(Map<String, Object> paramMap) {
		return chattingDao.updateReadFlag(paramMap);
	}

	@Override
	public List<MessageVO> selectMessageList(Map<String, Object> paramMap) {
		List<MessageVO> messageList = chattingDao.selectMessageList(String.valueOf(paramMap.get("chattingId")));
		
		if(!messageList.isEmpty()) {
			int result = chattingDao.updateReadFlag(paramMap);
		}
		
		return messageList;
	}

	@Override
	public List<UserVO> selectTarget(Map<String, Object> map) {
		return chattingDao.selectTarget(map);
	}
	
	
}
