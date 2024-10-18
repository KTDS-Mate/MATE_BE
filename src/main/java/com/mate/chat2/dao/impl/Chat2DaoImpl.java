package com.mate.chat2.dao.impl;

import com.mate.chat2.dao.Chat2Dao;
import com.mate.chat2.vo.Chat2Room;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Chat2DaoImpl extends SqlSessionDaoSupport implements Chat2Dao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public List<Chat2Room> selectChat2RoomList() {
        return this.getSqlSession().selectList(NAMESPACE + ".selectChat2RoomList");
    }

    @Override
    public int openChat2Room(Chat2Room chat2Room) {
        return this.getSqlSession().insert(NAMESPACE + ".openChat2Room", chat2Room);
    }
}
