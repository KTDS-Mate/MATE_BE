//package com.mate.chat2.service.impl;
//
//import com.mate.chat2.dao.Chat2Dao;
//import com.mate.chat2.service.Chat2Service;
//import com.mate.chat2.vo.Chat2Room;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class Chat2ServiceImpl implements Chat2Service {
//
//    @Autowired
//    private Chat2Dao chat2Dao;
//
//    @Override
//    public List<Chat2Room> selectChat2RoomList() {
//        return List.of();
//    }
//
////    @Override
////    public int openChat2Room(Chat2Room chat2Room) {
////
////        int result = (int)chat2Dao.openChat2Room(chat2Room);
////
////        if(result > 0){
////            result = (int)chat2Room.getChatRoomId();
////        }
////
////        return result;
////    }
//}
