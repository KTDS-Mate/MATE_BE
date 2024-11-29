package com.mate.websocket.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.common.utils.MessageUtil;
import com.mate.user.vo.UserVO;
import com.mate.websocket.dao.ChattingDao;
import com.mate.websocket.service.ChattingService;
import com.mate.websocket.vo.ChattingRoomVO;
import com.mate.websocket.vo.MessageVO;

@Service
public class ChattingServiceImpl implements ChattingService {

    @Autowired
    private ChattingDao chattingDao;

    @Override
    public List<ChattingRoomVO> selectRoomList(String usrId) {
        return chattingDao.selectRoomList(usrId);
    }

    @Override
    public int checkChattingId(Map<String, Object> map) {
        return chattingDao.checkChattingId(map);
    }

    @Override
    public int createChattingRoom(Map<String, Object> map) {
        return chattingDao.createChattingRoom(map);
    }

    @Override
    public int insertMessage(MessageVO msg) {
        msg.setMessageContent(MessageUtil.XSSHandling(msg.getMessageContent()));
        return chattingDao.insertMessage(msg);
    }

    @Override
    public int updateReadFlag(Map<String, Object> paramMap) {
        return chattingDao.updateReadFlag(paramMap);
    }

    @Override
    public List<MessageVO> selectMessageList(Map<String, Object> paramMap) {
        List<MessageVO> messageList = chattingDao.selectMessageList((int) paramMap.get("chattingId"));

        if (!messageList.isEmpty()) {
            chattingDao.updateReadFlag(paramMap);
        }

        return messageList;
    }

    @Override
    public List<UserVO> selectTarget(Map<String, Object> map) {
        return chattingDao.selectTarget(map);
    }
}
