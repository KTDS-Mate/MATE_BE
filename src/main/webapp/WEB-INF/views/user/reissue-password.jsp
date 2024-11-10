<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MATE - 비밀번호 찾기</title>
    <link rel="stylesheet" type="text/css" href="/css/user/editinfo.css">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/reissuepassword.js"></script>
</head>
<body>

      <div class="header">
        <!-- 헤더 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>

    <div class="container" data-message="${message}" data-message-type="${messageType}">
        <h2>비밀번호 찾기</h2>
        
        <form:form modelAttribute="userVO" method="post" action="/user/reissue-password" class="password-update-form">
            
            <!-- 아이디 입력 필드 -->
            <div class="form-group">
                <label for="usrLgnId">아이디</label>
                <input type="text" id="usrLgnId" name="usrLgnId" placeholder="아이디를 입력하세요." required />
                <div class="error" id="usrLgnId-error"></div>
            </div>
            
            <!-- 이메일 입력 필드 -->
            <div class="form-group">
                <label for="usrEml">이메일</label>
                <input type="email" id="usrEml" name="usrEml" placeholder="이메일을 입력하세요." required />
                <div class="error" id="usrEml-error"></div>
            </div>
            
            <!-- 비밀번호 찾기 버튼 -->
            <div class="form-group">
                <button type="submit" class="submit-btn">비밀번호 찾기</button>
            </div>
        </form:form>
    </div>
    
       <div class="footer">
      <!-- footer 공통파일 -->
      <jsp:include page="../footer.jsp"></jsp:include>
    </div>
</body>
</html>
