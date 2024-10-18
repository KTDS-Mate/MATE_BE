package com.mate.message.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.mate.message.dao.MessageDao;
import com.mate.message.vo.MessageVO;

@Repository
public class MessageDaoImpl extends SqlSessionDaoSupport implements MessageDao {

    @Override
    public List<MessageVO> selectAllMessages() {
        return List.of();
    }

    @Override
    public int insertNewMessage(MessageVO messageVO) {
        return 0;
    }

    @Override
    public int deleteMessageById(String id, boolean isDeleted) {
        return 0;
    }
}
