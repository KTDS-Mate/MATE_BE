package com.mate.chat2.dao;

import com.mate.chat2.vo.Chat2Room;

import java.util.List;

public interface Chat2Dao {

    public String NAMESPACE = "com.mate.chat2.dao.Chat2Dao";

    public List<Chat2Room> selectChat2RoomList();

    public int openChat2Room(Chat2Room chat2Room);
}
