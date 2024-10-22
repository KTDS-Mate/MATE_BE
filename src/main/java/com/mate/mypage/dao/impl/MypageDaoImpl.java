package com.mate.mypage.dao.impl;

import com.mate.mypage.dao.MypageDao;
import com.mate.user.vo.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MypageDaoImpl extends SqlSessionDaoSupport implements MypageDao {

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
    public UserVO selectOneUser(int usrId) {
        return this.getSqlSession().selectOne(NAMESPACE + ".selectOneUser" , usrId);
    }
}
