package com.mate.payment.service;

import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

public interface PortOneService {
	
	public String getAccessToken();
	
	public IamportResponse<Payment> verifyIamport(String impUid);
	
}
