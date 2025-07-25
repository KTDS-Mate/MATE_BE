package com.mate.payment.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.payment.dao.PaymentDao;
import com.mate.payment.vo.PaymentVO;
import com.mate.payment.vo.SearchPaymentVO;
import com.mate.payment.vo.WritePaymentVO;

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
	public List<PaymentVO> selectAllMyPayment(SearchPaymentVO searchPaymentVO) {
		return this.getSqlSession().selectList(NAMESPACE+".selectAllMyPayment", searchPaymentVO);
	}
	
	@Override
	public int selectAllMyPaymentCount(SearchPaymentVO searchPaymentVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectAllMyPaymentCount", searchPaymentVO);
	}
	
	@Override
	public PaymentVO selectOnePayment(String payId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOnePayment", payId);
	}
	
	@Override
	public double selectOnePaymentAmount(String payId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOnePaymentAmount", payId);
	}
	
	@Override
	public int updateSuccessPayment(PaymentVO paymentVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateSuccessPayment", paymentVO);
	}
	
	@Override
	public int updateRefundPayment(String payId) {
		return this.getSqlSession().update(NAMESPACE+".updateRefundPayment", payId);
	}
	
	@Override
	public List<PaymentVO> selectSearchMyPayment(SearchPaymentVO searchPaymentVO) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectSearchMyPayment", searchPaymentVO);
	}
	
	@Override
	public int selectSearchMyPaymentCount(SearchPaymentVO searchPaymentVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectSearchMyPaymentCount", searchPaymentVO);
	}
	
	@Override
	public int insertTrstTrPayment(WritePaymentVO writePaymentVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertTrstTrPayment", writePaymentVO);
	}
	
	@Override
	public WritePaymentVO selectUsrTrPayInf(String trId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectUsrTrPayInf", trId);
	}
	
	@Override
	public int selectTrstTrPaymentCnt(String gdApplyId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectTrstTrPaymentCnt", gdApplyId);
	}
	
	@Override
	public int updateCancelTrstTour(PaymentVO paymentVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateCancelTrstTour", paymentVO);
	}
	
	@Override
	public int selectApplyCnt(PaymentVO paymentVO) {
		return this.getSqlSession().selectOne( NAMESPACE + ".selectApplyCnt", paymentVO);
	}
	
	@Override
	public int updateCancelApply(PaymentVO paymentVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateCancelApply", paymentVO);
	}
	
	@Override
	public int updateCancelGdTour(PaymentVO paymentVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateCancelGdTour", paymentVO); 
	}
	
}