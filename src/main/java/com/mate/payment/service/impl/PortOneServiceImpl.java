package com.mate.payment.service.impl;

import java.net.http.HttpHeaders;

import org.springframework.stereotype.Service;

import com.mate.payment.service.PortOneService;

@Service
public class PortOneServiceImpl implements PortOneService{
	
	
	
	
	
	/**
	 * 포트원 토큰 발급 URL
	 */
	private final String BASE_URL = "https://api.portone.io/v1";
	
	/**
	 * MATE 포트원 API KEY
	 */
    private final String CLIENT_ID = "8408511610228667";
    
    /**
     * MATE 포트원 API SECRET KEY
     */
    private final String CLIENT_SECRET = "fWQcZ0aEmO4NgPxu2cs8gNe8ODxM9YHf0A7FwlkxmtlMa6rvaXQ5RrBBqcQvfMOmUv0EsxfzTMYNF5Ts";
	
	@Override
	public String getAccessToken() {
		String tokenUrl = BASE_URL + "/users/getToken";
//		HttpHeaders headers = new HttpHeaders();
		
		return null;
	}
	
	
}
