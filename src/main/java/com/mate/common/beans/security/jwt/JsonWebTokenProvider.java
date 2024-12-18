package com.mate.common.beans.security.jwt;

import java.time.Duration;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mate.user.vo.UserVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JsonWebTokenProvider {
	
	@Value("${app.jwt.issuer:hello-spring-security}")
	private String issuer;
	
	@Value("${app.jwt.secret-key:spring-security-secret-key-random-token-key}")
	private String secretKey;
	
	/**
	 * 사용자에게 보낼 토큰 생성
	 * @param duration : 토큰 유효 기간
	 * @param userVO : 토큰에 넣을 사용자 정보
	 * @return JWT
	 */
	public String generateJwt(Duration duration, UserVO userVO) {
		
		// 1. 토큰의 유효기간 생성
		Date now = new Date();
		Date expiry = new Date(now.getTime() + duration.toMillis());
		
		// 2. 토큰 암/복호화를 위한 키 생성 (secretKey 이용)
		SecretKey tokenKey = Keys.hmacShaKeyFor(this.secretKey.getBytes());
		
		// 3. 토큰 생성 후 반환
		return Jwts.builder()
							.issuer(issuer) // JWT 발급 주체
							.subject("SpringSecurityJwtToken") // Token명
							.claim("user", userVO) // JWT에 포함시킬 회원 정보
							.claim("email", userVO.getUsrEml())
							.claim("name", userVO.getUsrLgnId())
							.claim("authority", userVO.getAuthority())
							.issuedAt(now) // 발급 시간
							.expiration(expiry) // 유효 시간
							.signWith(tokenKey) // 암호화에 사용될 비밀키 설정
							.compact(); // JWT를 문자열 형태로 변환
	}
	
	
	/**
	 * 사용자가 보내준 토큰을 검증해 사용자 정보를 조회한다.
	 * @param jwt : 사용자가 보낸 토큰
	 * @return : 토큰 내부에 있는 회원의 정보
	 */
	public UserVO getUserFromJwt(String jwt) throws JsonProcessingException {
		
		if (jwt == null) {
			return null;
		}
		
		// 토큰 검증 결과는 userVO, 암호화에 사용된 비밀키를 이용해서 복호화를 진행한다.
		SecretKey tokenKey = Keys.hmacShaKeyFor(this.secretKey.getBytes());
		
		Claims claims = Jwts.parser()
						.verifyWith(tokenKey) // 암호화된 토큰 복호화
						.requireIssuer(this.issuer) // 이 시스템이 만든 복호화된 토큰인지 체
						.requireSubject("SpringSecurityJwtToken") // issuer와 SpringSecurityJwtToken 비교. 안맞을 경우 변조된 토큰
						.build() // 토큰 복호화 진행 -> claim들 가져올 수 있음
						.parseSignedClaims(jwt) // claim 가져오기
						.getPayload(); // payload할 경우 claim을 준다.

		// !!!!!!
		System.out.println("Decoded Claims:" + claims);
		
		Object jwtUser = claims.get("user");
		String email = claims.get("email", String.class);
		
		// JSON 데이터를 UserVO 인스턴스로 반환한다.
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(jwtUser);
		UserVO userVO = om.readValue(json, UserVO.class);
		return userVO;
	}
}