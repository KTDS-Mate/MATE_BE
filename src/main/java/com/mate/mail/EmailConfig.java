package com.mate.mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Value("${spring.mail.username}") // yml에서 spring.mail.username값을 주입 받음.
	private String username; // 이메일 계정의 사용자 이름 저장
	
	@Value("${spring.mail.password}") // yml에서 spring.mail.password값을 주입 받음.
	private String password;

	@Bean
	public JavaMailSender javaMailSender() {
		
		// JavaMailSenderImpl 인스턴스 생성
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		// 메일 서버 호스트 설정
		javaMailSender.setHost("smtp.gmail.com");
		// 메일 서버 포트 설정
		javaMailSender.setPort(587);
		// 메일 계정 사용자 이름 설정
		javaMailSender.setUsername(username);
		// 메일 계정 비밀번호 설정
		javaMailSender.setPassword(password);
		
		// 메일 속성 추가 설정을 위한 Properties 객체 생성
		Properties javaMailProperties = new Properties();
		// 메일 전송 프로토콜 설정
		javaMailProperties.put("mail.transport.protocol", "smtp");
		// SMTP 인증 활성화 
		javaMailProperties.put("mail.smtp.auth", "true");
		// TLS(보안)를 사용해서 보안 연결 활성화
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		// 디버그 설정
		javaMailProperties.put("mail.debug", "true");
		// SSL 연결할때 smtp.gmail.com을 신뢰하도록 설정
		javaMailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// SSL 프로토콜 설정.1.3은 안됬었음.
		javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		// 추가한 설정들 javaMailSender에 적용
		javaMailSender.setJavaMailProperties(javaMailProperties);
		
		return javaMailSender;
	}
}
