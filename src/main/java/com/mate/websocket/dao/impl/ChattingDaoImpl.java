package com.mate.websocket.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.user.vo.UserVO;
import com.mate.websocket.dao.ChattingDao;
import com.mate.websocket.vo.ChattingRoomVO;
import com.mate.websocket.vo.MessageVO;

@Repository
public class ChattingDaoImpl extends SqlSessionDaoSupport implements ChattingDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public List<ChattingRoomVO> selectRoomList(String usrId) {
        return this.getSqlSession().selectList(NAMESPACE + ".selectRoomList", usrId);
    }

    @Override
    public int checkChattingId(Map<String, Object> map) {
        return this.getSqlSession().selectOne(NAMESPACE + ".checkChattingId", map);
    }

    @Override
    public int createChattingRoom(Map<String, Object> map) {
        int result = this.getSqlSession().insert(NAMESPACE + ".createChattingRoom", map);
        return result > 0 ? (int) map.get("chattingId") : 0; // 수정된 부분
    }

    @Override
    public int insertMessage(MessageVO msg) {
        return this.getSqlSession().insert(NAMESPACE + ".insertMessage", msg);
    }

    @Override
    public int updateReadFlag(Map<String, Object> paramMap) {
        return this.getSqlSession().update(NAMESPACE + ".updateReadFlag", paramMap);
    }

    @Override
    public List<MessageVO> selectMessageList(int chattingId) {
        return this.getSqlSession().selectList(NAMESPACE + ".selectMessageList", chattingId);
    }

    @Override
    public List<UserVO> selectTarget(Map<String, Object> map) {
        return this.getSqlSession().selectList(NAMESPACE + ".selectTarget", map);
    }
}
