package com.mate.chat.service;

import com.mate.chat.vo.ChatListVO;
import com.mate.chat.vo.ChatVO;
import com.mate.chat.vo.WriteChatVO;

public interface ChatService {

    public ChatListVO selectAllChats();

    public boolean createNewChat(WriteChatVO writeChatVO);

    public ChatVO selectOneChat(Long id, boolean isChecked);
}
