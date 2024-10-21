package com.mate.chat.dao;

import java.util.List;

import com.mate.chat.vo.ChatVO;
import com.mate.chat.vo.WriteChatVO;

public interface ChatDao {

    public List<ChatVO> selectAllChats();

    public int insertNewChat(WriteChatVO writeChatVO);

    public ChatVO selectOneChat(Long id);

    public int readChat(Long id);
}
