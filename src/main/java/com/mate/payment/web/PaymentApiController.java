package com.mate.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mate.payment.service.PaymentService;
import com.mate.payment.service.PortOneService;

@RestController
@RequestMapping("/api/v1")
public class PaymentApiController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PortOneService portOneService;

}
