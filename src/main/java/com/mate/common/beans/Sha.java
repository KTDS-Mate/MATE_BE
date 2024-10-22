package com.mate.common.beans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
<<<<<<< HEAD
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Configuration
public class Sha {

	public static final Logger logger = LoggerFactory.getLogger(Sha.class);

=======


// @Component
// @Configuration : Spring Bean 을 수동으로 생성하는 기능도 있음
public class Sha {

	public static final Logger logger = LoggerFactory.getLogger(Sha.class);
	
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
	/**
	 * SHA-256 암호화 함
	 * @param source 원본
	 * @param salt(String) SALT 값
	 * @return
	 */
	public String getEncrypt(String source, String salt) {
		return getEncrypt(source, salt.getBytes());
	}
<<<<<<< HEAD

=======
	
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
	/**
	 * SHA-256 암호화 함
	 * @param source 원본
	 * @param salt(byte[]) SALT 값
	 * @return
	 */
	public String getEncrypt(String source, byte[] salt) {
<<<<<<< HEAD

		String result = "";

		byte[] a = source.getBytes();
		byte[] bytes = new byte[a.length + salt.length];

		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);

			byte[] byteData = md.digest();

=======
		
		String result = "";
		
		byte[] a = source.getBytes();
		byte[] bytes = new byte[a.length + salt.length];
		
		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			
			byte[] byteData = md.digest();
			
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}
<<<<<<< HEAD

=======
			
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
			 logger.error(e.getMessage());
		}
<<<<<<< HEAD

		return result;
	}

=======
		
		return result;
	}
	
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
	/**
	 * SALT를 얻어온다.
	 * @return
	 */
	public String generateSalt() {
		Random random = new Random();
<<<<<<< HEAD

		byte[] salt = new byte[8];
		random.nextBytes(salt);

=======
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < salt.length; i++) {
			// byte 값을 Hex 값으로 바꾸기.
			sb.append(String.format("%02x",salt[i]));
		}
<<<<<<< HEAD

		return sb.toString();
	}

//	public static void main(String[] args) {
//
//		Sha sha = new Sha();
//
//		// 1. salt 생성
//		String salt = sha.generateSalt();
//
=======
		
		return sb.toString();
	}
	
//	public static void main(String[] args) {
//		
//		Sha sha = new Sha();
//		
//		// 1. salt 생성
//		String salt = sha.generateSalt();
//		
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
//		// 2. 평문을 암호화
//		String password = "password1234";
//		String encryptedPassword = sha.getEncrypt(password, salt);
//		System.out.println(encryptedPassword);
//		System.out.println(salt);
//	}
<<<<<<< HEAD

=======
	
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
}
