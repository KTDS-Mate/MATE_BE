package com.mate.cms.paymentService.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.cms.paymentService.dao.PaymentServiceDao;
import com.mate.cms.paymentService.vo.PaymentServiceUpdateVO;
import com.mate.cms.paymentService.vo.PaymentServiceVO;
import com.mate.cms.paymentService.vo.SearchPaymentServiceVO;

@Repository
public class PaymentServiceDaoImpl extends SqlSessionDaoSupport implements PaymentServiceDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<PaymentServiceVO> selectAllPaymentService(SearchPaymentServiceVO searchPaymentServiceVO) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllPaymentService", searchPaymentServiceVO);
	}
	
	@Override
	public int selectPaymentServiceCount() {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectPaymentServiceCount");
	}
	
	@Override
	public int updatePayStts(PaymentServiceUpdateVO paymentServiceUpdateVO) {
		return this.getSqlSession().update(NAMESPACE + ".updatePayStts", paymentServiceUpdateVO);
	}
	
}
