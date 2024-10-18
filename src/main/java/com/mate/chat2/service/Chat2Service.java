package com.mate.chat2.service;

import com.mate.chat2.vo.Chat2Room;

import java.util.List;

public interface Chat2Service {

    List<Chat2Room> selectChat2RoomList();

    int openChat2Room(Chat2Room chat2Room);
}
