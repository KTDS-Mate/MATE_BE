//package com.mate.chat.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.mate.chat.dao.ChatDao;
//import com.mate.chat.service.ChatService;
//import com.mate.chat.vo.ChatListVO;
//import com.mate.chat.vo.ChatVO;
//import com.mate.chat.vo.WriteChatVO;
//
//@Service
//public class ChatServiceImpl implements ChatService {
//
//    @Autowired
//    private ChatDao chatDao;
//
//    @Override
//    public ChatListVO selectAllChats() {
//
//        ChatListVO chatListVO = new ChatListVO();
//
//        chatListVO.setChatVOList(chatDao.selectAllChats());
//
//        return chatListVO;
//    }
//
//    @Override
//    public boolean createNewChat(WriteChatVO writeChatVO) {
//
//        int createCount = chatDao.insertNewChat(writeChatVO);
//        return createCount > 0;
//    }
//
//    @Override
//    public ChatVO selectOneChat(Long id, boolean isChecked) {
//
//        if(!isChecked){
//            isChecked = true;
//        }
//
//        ChatVO chatVO = this.chatDao.selectOneChat(id);
//        chatVO.setChecked(isChecked);
//        if(chatVO == null){
//            throw new IllegalArgumentException("잘못된 접근입니다.");
//        }
//        return chatVO;
//    }
//}
