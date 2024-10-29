package com.mate.payment.service.impl;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mate.payment.service.PortOneService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.PrepareData;

import okhttp3.internal.http2.ErrorCode;

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
	public String getAccessToken() {
//		String tokenUrl = BASE_URL + "/users/getToken"; // 포트	원 API설명에서는 post /users/getToken을 불러오라던데 뭔가 다르다... 웹에서 js로 사용할때만인가..?	
		try {
			return iamportClient.getAuth().getResponse().getToken();
		} catch (IamportResponseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void prepare(String mid, BigDecimal price) throws Exception {
		try {
			this.iamportClient.postPrepare(new PrepareData(String.valueOf(mid), price));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
