package com.mate.mypage.service;

import com.mate.user.vo.UserVO;

public interface EditProfileService {

    public int countUsers();

    public UserVO selectOneUser(String usrLgnId);
    
    public int updateOneUser(UserVO userVO);

}
