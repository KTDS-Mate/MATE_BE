<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="/css/userregist.css">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/userlogin.js"></script>
    <script type="text/javascript" src="/js/user/userregist.js"></script>
    <script type="text/javascript" src="/js/user/emailauthverify.js"></script>
    <script type="text/javascript" src="/js/user/emailauth.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/css/intlTelInput.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/intlTelInput.min.js"></script>

</head>
<body>
    <div class="container">
        <div class="logo">
        </div>
        <h2>회원가입</h2>
        <!-- form:input
        	 registUserVO와 같은 모델 객체에 직접 바인딩 되어야 하는 정보의 경우에 사용한다.
        	 value 값을 지정하지 않아도 바인딩 됨.
          -->
        <form:form modelAttribute="registUserVO" method="post" class="regist-form">
            <div class="form-group">
                <label for="usrLgnId">아이디</label>
                <form:input path="usrLgnId" id="usrLgnId" />
                <div class="error" id="usrLgnId-error"></div>
            </div>
            
            <div class="form-group">
                <label for="usrPw">비밀번호</label>
                <form:password path="usrPw" id="usrPw" />
                <div class="error" id="usrPw-error"></div>
            </div>
            
            <div class="form-group">
                <label for="confirmPw">비밀번호 확인</label>
                <form:password path="confirmPw" id="confirmPw" />
                <div class="error" id="confirmPw-error"></div>
            </div>
            
            <div class="form-group">
                <label for="usrLnm">성</label>
                <form:input path="usrLnm" id="usrLnm" />
                <form:errors path="usrLnm" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <label for="usrFnm">이름</label>
                <form:input path="usrFnm" id="usrFnm" />
                <form:errors path="usrFnm" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <label for="name">국적</label>
                <form:input path="country" id="country" />
                <form:errors path="country" element="div" cssClass="error" />
            </div>
            
			<div class="form-group">
                <label for="usrPhn">휴대전화번호</label>
                <form:input type="tel" path="usrPhn" id="usrPhn" />
                <form:errors path="usrPhn" element="div" cssClass="error" />
                <div class="error" id="usrPhn-error"></div>
            </div>
            
            <div class="form-group gender-birth">
                <label for="usrGndr">성별</label>
                <form:select path="usrGndr" id="usrGndr" >
                	<form:option value="">선택하세요</form:option>
                    <form:option value="male">남</form:option>
                    <form:option value="female">여</form:option>
                </form:select>
                <form:errors path="usrGndr" element="div" cssClass="error" />
                
                <label for="usrBd">생년월일</label>
                <input type="date" id="usrBd" name="usrBd" value="${registUserVO.usrBd}" />
                <form:errors path="usrBd" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <label for="usrEml">Email</label>
                <form:input path="usrEml" id="usrEml" />
                <div class="error" id="usrEml-error"></div>
                <button type="button" id="auth-button" class="send-code-btn">인증 메일 발송</button>
            </div>
            
            <!-- 아래 항목들은 ModelAttribute에 바인딩할 필요가 없으므로 form:input을 사용하지 않는다. (폼데이터 바인딩이 필요 없음) -->
            
            <div class="form-group">
                <label for="authCode">인증번호입력</label>
                <input type="text" id="authCode" name="authCode" value="" />
                <button type="button" id="verify-btn" class="send-code-btn">인증 코드 확인</button>
            </div>
            
            <!-- 인증 여부 서버 전송 -->
            <input type="hidden" id="authVerified" name="authVerified" value="false" />
            
            <div class="form-group submit-btn">
                <input type="submit" value="회가입" />
            </div>
        </form:form>
    </div>
</body>
</html>
