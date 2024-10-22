package com.mate.mypage.service;

import com.mate.bbs.vo.ChatRoomListVO;
import com.mate.bbs.vo.ChatRoomVO;
import com.mate.bbs.vo.WriteChatRoomVO;
import com.mate.user.vo.UserVO;

public interface MypageService {

    public int countUsers();

    public UserVO selectOneUser(int usrId);

}
