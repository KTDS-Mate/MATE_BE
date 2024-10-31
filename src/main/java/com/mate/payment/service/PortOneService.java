package com.mate.payment.service;

public interface PortOneService {
	
	public String getAccessToken();
	
	public void cancelPayment(String imUid, String reason);
}
