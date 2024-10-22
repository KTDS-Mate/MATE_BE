package com.mate.mypage.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.mypage.dao.MyReviewDao;
import com.mate.mypage.vo.MyReviewVO;

@Repository
public class MyReviewDaoImpl extends SqlSessionDaoSupport implements MyReviewDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectMyReviewAllCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectMyReviewAllCount");
	}
	@Override
	public List<MyReviewVO> selectAllMyReview() {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllMyReview");
	}
	
}
