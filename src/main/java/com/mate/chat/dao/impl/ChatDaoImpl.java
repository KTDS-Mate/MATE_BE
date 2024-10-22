//package com.mate.chat.dao.impl;
//
//import java.util.List;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.mate.chat.dao.ChatDao;
//import com.mate.chat.vo.ChatVO;
//import com.mate.chat.vo.WriteChatVO;
//
//@Repository
//public class ChatDaoImpl extends SqlSessionDaoSupport implements ChatDao {
//
//    @Autowired
//    @Override
//    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
//        super.setSqlSessionTemplate(sqlSessionTemplate);
//    }
//
//    @Override
//    public List<ChatVO> selectAllChats() {
//        return getSqlSession().selectList("selectAllChats");
//    }
//
//    @Override
//    public int insertNewChat(WriteChatVO writeChatVO) {
//        return this.getSqlSession().insert("insertNewChat", writeChatVO);
//    }
//
//    @Override
//    public ChatVO selectOneChat(Long id) {
//        return this.getSqlSession().selectOne("selectOneChat", id);
//    }
//
//    @Override
//    public int readChat(Long id) {
//        return this.getSqlSession().selectOne("readChat", id);
//    }
//}
