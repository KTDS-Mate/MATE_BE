<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>MATE</title>
    <link rel="stylesheet" type="text/css" href="/css/editinfo.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/userlogin.js"></script>
    <script type="text/javascript" src="/js/user/userregist.js"></script>
    <script type="text/javascript" src="/js/user/emailauthverify.js"></script>
    <script type="text/javascript" src="/js/user/emailauth.js"></script>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/css/intlTelInput.min.css"
    />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/intlTelInput.min.js"></script>
  </head>
  <body>
    <div class="container">
      <h2>휴대폰 번호 변경</h2>

      <form:form
        modelAttribute="userVO"
        method="post"
        class="phone-update-form"
      >
        <div class="form-group">
          <label for="usrPhn">휴대전화번호</label>
          <form:input type="tel" path="usrPhn" id="usrPhn" />
          <form:errors path="usrPhn" element="div" cssClass="error" />
          <div class="error" id="usrPhn-error"></div>
        </div>

        <div class="form-group">
          <button type="submit" class="submit-btn">휴대폰 번호 수정</button>
        </div>
      </form:form>
    </div>
  </body>
</html>
