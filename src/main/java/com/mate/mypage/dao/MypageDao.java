package com.mate.mypage.dao;

import java.util.List;

import com.mate.bbs.vo.ChatRoomVO;
import com.mate.bbs.vo.WriteChatRoomVO;
import com.mate.user.vo.UserVO;

public interface MypageDao {

    public String NAMESPACE = "com.mate.mypage.dao.MypageDao";

    public int countUsers();

    public UserVO selectOneUser(int usrId);


}
