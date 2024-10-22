package com.mate.mypage.service.impl;

import com.mate.mypage.dao.MypageDao;
import com.mate.mypage.service.MypageService;
import com.mate.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MypageServiceImpl implements MypageService {

    @Autowired
    private MypageDao mypageDao;


    @Override
    public int countUsers() {
        int count = this.mypageDao.countUsers();

        return count;
    }

    @Override
    public UserVO selectOneUser(int usrId) {

        UserVO user = this.mypageDao.selectOneUser(usrId);

        return user;
    }
}
