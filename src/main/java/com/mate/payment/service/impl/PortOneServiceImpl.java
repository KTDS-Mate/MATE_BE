package com.mate.payment.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mate.payment.service.PortOneService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Service
public class PortOneServiceImpl implements PortOneService {

    /**
     * 포트원 Bsse URL
     */
    private final String BASE_URL = "https://api.portone.io/v1";

    private final IamportClient iamportClient;
    
    @Autowired
    public PortOneServiceImpl(@Value("${portone.api.key}") String key,
    						  @Value("${portone.api.secret}") String secret) {
    	this.iamportClient = new IamportClient(key, secret);
    }

    
	@Override
	public IamportResponse<AccessToken> getAccessToken() {
		try {
			return iamportClient.getAuth();
		} catch (IamportResponseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public IamportResponse<Payment> cancelPayment(String impUid, String reason) {
		// 생성자에서 true를 주면 imp_uid false면 merchant_id이다.
		CancelData cancelData = new CancelData(impUid, true);
		cancelData.setReason(reason);
		try {
			return this.iamportClient.cancelPaymentByImpUid(cancelData);
		} catch (IamportResponseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
