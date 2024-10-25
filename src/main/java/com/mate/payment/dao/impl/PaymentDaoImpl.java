package com.mate.payment.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.payment.dao.PaymentDao;
import com.mate.payment.vo.PaymentVO;

@Repository
public class PaymentDaoImpl extends SqlSessionDaoSupport implements PaymentDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectAllPaymentCount() {
		int cnt = this.getSqlSession().selectOne(NAMESPACE + ".selectAllPaymentCount");
		return cnt;
	}
	
	@Override
	public List<PaymentVO> selectAllPayment() {
		return this.getSqlSession().selectList(NAMESPACE+".selectAllPayment");
	}
	
	@Override
	public List<PaymentVO> selectAllMyPayment(String trstId) {
		return this.getSqlSession().selectList(NAMESPACE+".selectAllMyPayment", trstId);
	}
	
	@Override
	public int selectAllMyPaymentCount(String trstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAllMyPaymentCount", trstId);
	}
	
	
}
