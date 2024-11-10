package com.mate.payment.service;

import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

public interface PortOneService {
	
	public IamportResponse<AccessToken> getAccessToken();
	
	public IamportResponse<Payment> cancelPayment(String imUid, String reason);
}
