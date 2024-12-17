package com.mate.cms.customerService.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mate.cms.customerService.vo.CustomerServiceAnswerVO;
import com.mate.cms.customerService.vo.CustomerServiceVO;
import com.mate.cms.customerService.vo.CustomerServiceWriteVO;
import com.mate.cms.customerService.vo.SearchCustomerServiceVO;

public interface CustomerServiceDao {

	public String NAMESPACE = "com.mate.cms.customerService.dao.CustomerServiceDao";
	/** 사용자가 문의사항 넣을 때 사용 **/
	public int insertNewCustomerService(CustomerServiceWriteVO customerServiceWriteVO);
	/** 본인이 작성한 문의사항 개수 가져오기 **/
	public int selectCustomerServiceCount(@Param("usrLgnId") String usrLgnId, @Param("search") SearchCustomerServiceVO searchCustomerServiceVO);
	/** 본인이 작성한 문의사항 리스트 가져오기 **/
	public List<CustomerServiceVO> selectCustomerServiceList(@Param("usrLgnId") String usrLgnId, @Param("search") SearchCustomerServiceVO searchCustomerServiceVO);
	
	// ------------------ CMS
	/** 해당 문의사항에 답변 시 실행 **/
	public int updateCustomerService(CustomerServiceAnswerVO customerServiceAnswerVO);
	/** 문의사항 SOFT DELETE **/
	public int deleteCustomerService(String cstmrSrvcCntrId);
	/** cms용 개수 **/
	public int selectCustomerServiceCountForCms(SearchCustomerServiceVO searchCustomerServiceVO);
	/** cms용 리스트 **/
	public List<CustomerServiceVO> selectCustomerServiceListForCms(SearchCustomerServiceVO searchCustomerServiceVO);
}
