package com.mate.websocket.dao;

import java.util.List;
import java.util.Map;

import com.mate.user.vo.UserVO;
import com.mate.websocket.vo.ChattingRoomVO;
import com.mate.websocket.vo.MessageVO;

public interface ChattingDao {

    String NAMESPACE = "com.mate.websocket.dao.ChattingDao";

    List<ChattingRoomVO> selectRoomList(String usrId);

    int checkChattingId(Map<String, Object> map);

    int createChattingRoom(Map<String, Object> map);

    int insertMessage(MessageVO msg);

    int updateReadFlag(Map<String, Object> paramMap);

    List<MessageVO> selectMessageList(int chattingId);

    List<UserVO> selectTarget(Map<String, Object> map);
}
