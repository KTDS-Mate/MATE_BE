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
    <script type="text/javascript" src="/js/user/emailauthverify.js"></script>
    <script type="text/javascript" src="/js/user/emailauth.js"></script>
</head>
<body>
    <div class="container">
        <div class="logo">
        </div>
        <h2>회원가입</h2>
        <form:form modelAttribute="registMemberVO" method="post" class="regist-form">
            <div class="form-group">
                <label for="usrLgnId">아이디</label>
                <input type="text" id="usrLgnId" name="usrLgnId" value="${registUserVO.usrLgnId}" />
                <form:errors path="usrLgnId" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <label for="usrPw">비밀번호</label>
                <input type="password" id="usrPw" name="usrPw" value="${registUserVO.usrPw}" />
                <form:errors path="usrPw" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <label for="confirmPw">비밀번호 확인</label>
                <input type="password" id="confirmPw" name="confirmPw"  value="${registUserVO.confirmPw}" />
                <form:errors path="confirmPw" element="div" cssClass="error" />
                <div class="error" ${error_password}></div>
            </div>
            
            <div class="form-group">
                <label for="usrLnm">성</label>
                <input type="text" id="usrLnm" name="usrLnm" value="${registUserVO.usrLnm}" />
                <form:errors path="usrLnm" element="div" cssClass="error" />
            </div>
            
            <div class="form-group">
                <label for="usrFnm">이름</label>
                <input type="text" id="usrFnm" name="usrFnm" value="${registUserVO.usrFnm}" />
                <form:errors path="usrFnm" element="div">
                </form:errors>
                
            </div>
            
            <div class="form-group">
                <label for="name">국적</label>
                <input type="text" id="country" name="country" value="${registUserVO.country}" />
                <form:errors path="country" element="div" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="usrPhn">전화번호</label>
                <input type="text" id="usrPhn" name="usrPhn" value="${registUserVO.usrPhn}" />
                <form:errors path="usrPhn" element="div" cssClass="error" />
            </div>
            
            <div class="form-group gender-birth">
                <label for="gender">성별</label>
                <select id="gender" name="usrGndr">
                    <option value="male">남</option>
                    <option value="female">여</option>
                </select>
                <label for="usrBd">생년월일</label>
                <input type="date" id="usrBd" name="usrBd" value="${registUserVO.usrBd}" />
            </div>
            <div class="form-group">
                <label for="usrEml">Email</label>
                <input type="email" id="usrEml" name="usrEml" value="${registUserVO.usrEml}" />
                <form:errors path="usrEml" element="div" cssClass="error">
                </form:errors>
                <button type="button" id="auth-button" class="send-code-btn">인증 메일 발송</button>
            </div>
            
            <div class="form-group">
                <label for="confirmAuthCode">인증번호입력</label>
                <input type="text" id="authCode" name="authCode" value="" />
                <button type="button" id="verify-btn" class="send-code-btn">인증 코드 확인</button>
                <button type="button" id="re-send-btn" class="send-code-btn">인증 메일 재발송</button>
                <form:errors path="confirmAuthCode" element="div" cssClass="error">
                </form:errors>
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
