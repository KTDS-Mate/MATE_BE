<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/css/userlogin.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/userlogin.js"></script>
  </head>
  <body>
    <div class="login-container">
      <div class="login-box">
        <form:form class="login-form" modelAttribute="loginUserVO" method="post" action="/user/login">
        <!-- nextUrl 설정 -->
        <input type="hidden" name="nextUrl" value="${loginUserVO.nextUrl}" />
        
          <!-- 아이디 입력 -->
          <input type="text" id="id" class="login-input" name="usrLgnId" value="${loginUserVO.usrLgnId}" />
          <form:errors path="usrLgnId" cssClass="error-message" />
          <%-- <c:if test="${not empty usrLgnIdError}">
            <div class="error-message">${usrLgnIdError}</div>
          </c:if> --%>
          
          <!-- 비밀번호 입력 -->
          <input id="password" type="password" name="usrPwd" class="login-input" />
          <form:errors path="usrPwd" cssClass="error-message" />
          <%-- <c:if test="${not empty usrPwdError}">
            <div class="error-message">${usrPwdError}</div>
          </c:if> --%>
          
          <!-- 로그인 실패 메세지 출력 -->
          <c:if test="${not empty loginError}">
          	<div class="error-message">${loginError}</div>
          </c:if>
          
          <%-- <form:errors element="div" cssClass="error-message" /> --%>
          
          <button type="submit" class="login-btn">로그인</button>
        
        <div class="login-options">
          <a href="#">회원 가입</a> | 
          <a href="#">아이디 찾기</a> | 
          <a href="#">비밀번호 찾기</a>
        </div>
		</form:form>
      </div>
    </div>
  </body>
