package com.mate.cms.customerService.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mate.cms.customerService.dao.CustomerServiceDao;
import com.mate.cms.customerService.vo.CustomerServiceWriteVO;

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
	
}
