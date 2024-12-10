package com.mate.cms.customerService.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.cms.customerService.dao.CustomerServiceDao;
import com.mate.cms.customerService.vo.CustomerServiceAnswerVO;
import com.mate.cms.customerService.vo.CustomerServiceVO;
import com.mate.cms.customerService.vo.CustomerServiceWriteVO;
import com.mate.cms.customerService.vo.SearchCustomerServiceVO;

@Repository
public class CustomerServiceDaoImpl extends SqlSessionDaoSupport implements CustomerServiceDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertNewCustomerService(CustomerServiceWriteVO customerServiceWriteVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewCustomerService", customerServiceWriteVO);
	}

	@Override
	public int selectCustomerServiceCount(SearchCustomerServiceVO searchCustomerServiceVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectCustomerServiceCount", searchCustomerServiceVO);
	}

	@Override
	public List<CustomerServiceVO> selectCustomerServiceList(SearchCustomerServiceVO searchCustomerServiceVO) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectCustomerServiceList", searchCustomerServiceVO);
	}
	
	@Override
	public int updateCustomerService(CustomerServiceAnswerVO customerServiceAnswerVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateCustomerService", customerServiceAnswerVO);
	}

	@Override
	public int deleteCustomerService(String cstmrSrvcCntrId) {
		return this.getSqlSession().update(NAMESPACE + ".deleteCustomerService", cstmrSrvcCntrId);
	}
	
}
