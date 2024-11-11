package com.mate.payment.dao;

import java.util.List;

import com.mate.payment.vo.PaymentVO;
import com.mate.payment.vo.SearchPaymentVO;
import com.mate.payment.vo.WritePaymentVO;
import com.mate.user.vo.UserVO;

public interface PaymentDao {
	
	public String NAMESPACE = "com.mate.payment.dao.PaymentDao";
	
	public int selectAllPaymentCount();
	public List<PaymentVO> selectAllPayment();
	
	public List<PaymentVO> selectAllMyPayment(SearchPaymentVO searchPaymentVO);
	public int selectAllMyPaymentCount(SearchPaymentVO searchPaymentVO);
	
	public String selectUserId(String usrLgnId);
	
	public PaymentVO selectOnePayment(String payId);
	
	public double selectOnePaymentAmount(String payId);
	
	public int updateSuccessPayment(PaymentVO paymentVO);
	
	public int updateRefundPayment(String payId);
	
	public List<PaymentVO> selectSearchMyPayment(SearchPaymentVO searchPaymentVO);
	public int selectSearchMyPaymentCount(SearchPaymentVO searchPaymentVO);
	
	public int insertTrstTrPayment(WritePaymentVO writePaymentVO);
	
	public WritePaymentVO selectUsrTrPayInf(String trId);
	
}
