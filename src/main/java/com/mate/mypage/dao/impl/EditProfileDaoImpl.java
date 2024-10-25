package com.mate.mypage.dao.impl;

import com.mate.mypage.dao.EditProfileDao;
import com.mate.user.vo.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EditProfileDaoImpl extends SqlSessionDaoSupport implements EditProfileDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }


    @Override
    public int countUsers() {

        return this.getSqlSession().selectOne(NAMESPACE + ".countUsers");
    }

    @Override
    public UserVO selectOneUser(String usrId) {
        return this.getSqlSession().selectOne(NAMESPACE + ".selectOneUser" , usrId);
    }
}
