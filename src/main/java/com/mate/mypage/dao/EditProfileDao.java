package com.mate.mypage.dao;

import com.mate.user.vo.UserVO;

public interface EditProfileDao {

    public String NAMESPACE = "com.mate.mypage.dao.EditProfileDao";

    public int countUsers();

    public UserVO selectOneUser(String usrId);


}
