package com.mate.common.googlemap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GoogleMapsConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}
