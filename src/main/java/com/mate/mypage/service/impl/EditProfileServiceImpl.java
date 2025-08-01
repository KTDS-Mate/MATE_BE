package com.mate.mypage.service.impl;

import com.mate.mypage.dao.EditProfileDao;
import com.mate.mypage.service.EditProfileService;
import com.mate.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditProfileServiceImpl implements EditProfileService {

    @Autowired
    private EditProfileDao editProfileDao;


    @Override
    public int countUsers() {
        int count = this.editProfileDao.countUsers();

        return count;
    }

    @Override
    public UserVO selectOneUser(String usrLgnId) {

        UserVO user = this.editProfileDao.selectOneUser(usrLgnId);

        return user;
    }

	@Override
	public int updateOneUser(UserVO userVO) {
		
		int success = this.editProfileDao.updateOneUser(userVO);
		return success;
	}
    
   
}
