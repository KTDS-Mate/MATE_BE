package com.mate.mail.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mate.mail.dao.EmailDao;
import com.mate.mail.vo.EmailVO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSendServiceImpl implements EmailSendService {

	private static final Logger log = LoggerFactory.getLogger(EmailSendServiceImpl.class);
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private EmailDao emailDao;
	
	// 이메일 인증 코드 발송 메서드
	@Override
	public void sendAuthMail(EmailVO emailVO) {
		// 인증 코드
		String authCode = "";
		// 이 email은 사용자 입력값(사용자가 인증을 요청한 email)
        String email = emailVO.getEmail();
        
        try {
            // 인증코드 생성 (6자리)
            Random random = new Random();
            // 0 이상 1_000_000미만 숫자 생성. 자릿수가 모자라면 앞에 0을 채운다.
            authCode = String.format("%06d", random.nextInt(1000000));
            
            // 메일 내용 설정
            // 메일 메세지를 생성하기 위한 MimeMessage 객체 생성
            MimeMessage message = javaMailSender.createMimeMessage();
            
            // 이메일 메세지 구성하기 위한 MimeMessageHelper 객체 생성. 
            /**
             * message : 생성한 MimeMessage 전달.
             * true : MultiPart메세지 허용. (ex: 첨부 파일 등)
             * "UTF-8" : 메세지 인코딩 방식 설정. 설정하지 않을 경우 메일 열람시 인코딩이 깨져서 출력된다.
             */
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            // 메세지 수신자 설정. email 변수에 저장된 이메일 주소로 설정됨.
            helper.setTo(email);
            // 메일 제목 설정
            helper.setSubject("메이트 회원가입 이메일 인증");
            
            // 메일 내용
            String messageToUser =  """
            	    <div>
                    <h1> 안녕하세요! Mate 입니다.</h1>
                    <br>
                    <h3>회원가입 이메일 인증 코드입니다.</h3>
                    <br>
                    <div>아래 코드를 회원가입 창으로 돌아가 입력해주세요.</div>
                    인증코드 : <strong>%s</strong>
                    <br>
                </div>
                """.formatted(authCode);
            // true or false: 본문 내용이 HTML 형식인지 아닌지를 지정. true 일 경우 HTML 형식.
            helper.setText(messageToUser, true);
            
            // 메일 발송
            javaMailSender.send(message);
            
            // emailVO 객체에 생성한 authCode를 설정함
            emailVO.setAuthCode(authCode);
            emailVO.setIssueTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")));
            
            // 전에 발급했던 인증 코드가 있는 경우 무효화
            emailDao.invalidatePrevAuthCode(email);
            // 인증 정보 DB에 저장.
            emailDao.insertNewAuthCode(emailVO);
            
        } catch (MessagingException e) {
            log.error("이메일 전송 중 에러가 발생했습니다. 이메일: {}", email, e);
            throw new RuntimeException("이메일 전송에 실패하였습니다.");
        }

	}
	
	// 비밀번호 재발급 메일 발송 메서드
	@Override
	public String sendPasswordAuthMail(EmailVO emailVO) throws MessagingException {
	    // 임시 비밀번호로 설정
	    String tempPassword = emailVO.getAuthCode(); 
	    String email = emailVO.getEmail();
	    
	    
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(email);
        helper.setSubject("메이트 비밀번호 재설정 안내");

        String messageToUser = """
            <div>
                <h1>안녕하세요! Mate 입니다.</h1>
                <p>요청하신 임시 비밀번호를 발송해 드립니다.</p>
                <p>임시 비밀번호: <strong>%s</strong></p>
                <p>로그인 후 반드시 비밀번호를 변경하시기 바랍니다.</p>
            </div>
            """.formatted(tempPassword);
        
        helper.setText(messageToUser, true);
        javaMailSender.send(message);
	        
	    return tempPassword;
	}
	
	@Override
	public Map<String, Object> verifyAuthCode(EmailVO emailVO) { // 인증 코드 검증
		
		Map<String, Object> response = new HashMap<>();
		// AuthCode 가져오기
		// DB의 email주소에 매핑되어있는 인증 코드와 발급시간을 가져온다.
		EmailVO storedEmailVO = emailDao.getAuthCodeByEmail(emailVO.getEmail()); 
		log.debug("storedEmailVO null 체크: {}", storedEmailVO);
		
		// DB에 저장된 authCode가 null 일 경우 false 반환
		if (storedEmailVO == null) {
	        response.put("valid", false);
	        response.put("message", "인증 코드가 존재하지 않습니다.");
	        return response;
	    }
		
		// 발급 시간과 현재 시간을 비교하여 5분 이내인지 확인
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        LocalDateTime issueTime  = LocalDateTime.parse(storedEmailVO.getIssueTime(), formatter);
        LocalDateTime currentTime = LocalDateTime.now();
		
		// 만약 5분을 초과했다면 인증 실패
		if (Duration.between(issueTime, currentTime).toMinutes() > 5) {
			response.put("valid", false);
			response.put("message", "인증 코드 유효시간이 초과되었습니다.");
			return response;
		}
		
		// 인증코드가 일치할 경우 true 반환
		if (storedEmailVO.getAuthCode().trim().equals(emailVO.getAuthCode().trim())) {
			response.put("valid", true);
			response.put("message", "인증이 완료되었습니다.");
			emailDao.markAuthCodeAsVerified(emailVO.getEmail());
		// 실패할 경우 False 반환
		} else {
			System.out.println("코드 " + storedEmailVO.getAuthCode());
			System.out.println("입력한 코드 " + emailVO.getAuthCode());
			
			response.put("valid", false);
			response.put("message", "인증코드가 일치하지 않습니다.");
		}
		
		return response;
	}
	
	@Override
	public void sendUserIdEmail(String usrEml, String userId) throws MessagingException {
	    // 메일 제목 설정
	    String subject = "메이트 아이디 찾기 안내";

	    // 메일 내용 작성
	    String messageToUser = """
	        <div>
	            <h1>안녕하세요! Mate 입니다.</h1>
	            <p>요청하신 아이디 정보를 아래와 같이 안내 드립니다.</p>
	            <p>아이디: <strong>%s</strong></p>
	            <p>Mate를 이용해 주셔서 감사합니다.</p>
	            </div>
	        """.formatted(userId);

	    // MimeMessage 생성 및 설정
	    MimeMessage message = javaMailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	    helper.setTo(usrEml);
	    helper.setSubject(subject);
	    helper.setText(messageToUser, true);

	    // 메일 발송
	    javaMailSender.send(message);
	}

}
