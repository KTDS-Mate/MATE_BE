package com.mate.mypage.service;

import com.mate.user.vo.UserVO;

public interface MypageService {

    public int countUsers();

    public UserVO selectOneUser(int usrId);

}
