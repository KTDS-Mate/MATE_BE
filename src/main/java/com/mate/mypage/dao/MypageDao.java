package com.mate.mypage.dao;

import com.mate.user.vo.UserVO;

public interface MypageDao {

    public String NAMESPACE = "com.mate.mypage.dao.MypageDao";

    public int countUsers();

    public UserVO selectOneUser(int usrId);


}
