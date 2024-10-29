package com.mate.payment.service;

import java.math.BigDecimal;

public interface PortOneService {
	
	public String getAccessToken();
	
	public void prepare(String mid, BigDecimal price) throws Exception;
		
		
}
