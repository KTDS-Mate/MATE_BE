<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MATE</title>
    <link rel="stylesheet" type="text/css" href="/css/editinfo.css">
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
        <h2>비밀번호 변경</h2>
        
        <form:form modelAttribute="userVO" method="post" class="password-update-form">
        
            <div class="form-group">
                <form:input type="password" path="usrPwd"  />
                <form:errors path="usrPwd" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <form:input type="password" path="confirmPwd" placeholder="새 비밀번호를 입력하세요." />
                <form:errors path="confirmPwd" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <form:input type="password" path="confirmPwd" placeholder="새 비밀번호를 한번 더 입력하세요." />
                <form:errors path="confirmPwd" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <button type="submit" class="submit-btn">비밀번호 변경</button>
            </div>
        </form:form>
    </div>
</body>
</html>
