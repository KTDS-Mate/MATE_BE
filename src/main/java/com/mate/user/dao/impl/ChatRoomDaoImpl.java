package com.mate.member.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.bbs.dao.ChatRoomDao;
import com.mate.bbs.vo.ChatRoomVO;
import com.mate.bbs.vo.WriteChatRoomVO;

@Repository
public class ChatRoomDaoImpl extends SqlSessionDaoSupport implements ChatRoomDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public int selectChatRoomAllCount() {
        return getSqlSession().selectOne("selectChatRoomAllCount");
    }

    @Override
    public List<ChatRoomVO> selectAllChatRoom() {
        return getSqlSession().selectList("selectAllChatRoom");
    }

    @Override
    public int insertNewChatRoom(WriteChatRoomVO writeChatRoomVO) {
        return getSqlSession().insert("insertNewChatRoom", writeChatRoomVO);
    }

    @Override
    public ChatRoomVO selectChatRoomById(String id) {
        return getSqlSession().selectOne("selectChatRoomById", id);
    }

    @Override
    public int deleteChatRoomById(String id, boolean isDeleted) {
        return getSqlSession().update("deleteChatRoomById", id);
    }

}
