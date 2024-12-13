package com.mate.chatting.dao;

import java.util.List;
import java.util.Map;

import com.mate.chatting.vo.ChattingRoomVO;
import com.mate.chatting.vo.MessageVO;
import com.mate.user.vo.UserVO;

public interface ChattingDao {

	public String NAMESPACE = "com.mate.chatting.dao.ChattingDao";
	
	public List<ChattingRoomVO> selectRoomList(String usrId);
	
	public String checkChattingId(Map<String, String> map);
	
	public String createChattingRoom(Map<String, String> map);
	
	public int insertMessage(MessageVO messageVO);
	
	public int updateReadFlag(Map<String, Object> paramMap);
	
	public List<MessageVO> selectMessageList(String ChattingId);
	
	public List<UserVO> selectTarget(Map<String, Object> map);
}
