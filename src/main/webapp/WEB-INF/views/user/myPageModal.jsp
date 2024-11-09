<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <title>MATE</title>
    <link rel="stylesheet" type="text/css" href="/css/myPageModal.css" />
    <script type="text/javascript" src="/js/user/editPhn.js"></script>
    <script type="text/javascript" src="/js/user/editpwd.js"></script>
    <script type="text/javascript" src="/js/user/editpypeml.js"></script>
    <script type="text/javascript" src="/js/user/emailauth.js"></script>
    <script type="text/javascript" src="/js/user/emailauthverify.js"></script>
    <script type="text/javascript" src="/js/user/userregist.js"></script>
    <script type="text/javascript" src="/js/user/userlogin.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/user/editinfo.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/myPageModal.js"></script>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/css/intlTelInput.min.css"
    />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/intlTelInput.min.js"></script>
  </head>
  <body>
    <dialog id="phoneNumEditModal" class="phoneNumEditModal hidden">
      <h2>휴대폰 번호 변경</h2>

		<form:form modelAttribute="userVO" method="post" action="/user/editphone" class="phone-update-form">
            <!-- 새 휴대전화번호 입력 필드 -->
            <div class="form-group">
                <label for="newPhn">새 휴대전화번호</label>
                <input type="tel" id="newPhn" name="newPhn" required />
                <div class="error" id="newPhn-error"></div>
            </div>

            <div class="form-group">
                <button type="submit" class="submit-btn">휴대폰 번호 수정</button>
            </div>
        </form:form>
    </dialog>

    <dialog id="pwEditModal" class="pwEditModal hidden">
      <h2>비밀번호 변경</h2>

      <form:form modelAttribute="userVO" method="post" action="/user/editpwd" class="password-update-form" >
        <!-- 현재 비밀번호 입력 필드 -->
        <div class="form-group">
          <label for="currentPwd">현재 비밀번호</label>
          <input type="password" id="currentPwd" name="currentPwd" placeholder="현재 비밀번호를 입력하세요." required />
          <div class="error" id="currentPwd-error"></div>
        </div>

        <!-- 새 비밀번호 입력 필드 -->
        <div class="form-group">
          <label for="newPwd">새 비밀번호</label>
          <input type="password" id="newPwd" name="newPwd" placeholder="새 비밀번호를 입력하세요." required />
          <div class="error" id="newPwd-error"></div>
        </div>

        <!-- 새 비밀번호 확인 입력 필드 -->
        <div class="form-group">
          <label for="confirmPwd">새 비밀번호 확인</label>
          <input type="password" id="confirmPwd" name="confirmPwd" placeholder="새 비밀번호를 한번 더 입력하세요." required />
          <div class="error" id="confirmPwd-error"></div>
        </div>

        <div class="form-group">
          <button type="submit" class="submit-btn">비밀번호 변경</button>
        </div>
      </form:form>
    </dialog>

    <dialog id="pypEditModal" class="pypEditModal hidden">
      <h2>PayPal Email 주소 변경</h2>

        <form:form modelAttribute="userVO" method="post" class="email-update-form">
			<div class="form-group">
	            <label for="usrPypEml">PayPal Email 변경</label>
	            <form:input type="email" path="usrPypEml" id="usrPypEml" />
	            <form:errors path="usrPypEml" element="div" cssClass="error" />
	            <div class="error" id="usrEml-error"></div>
	        </div>
	        
            <div class="form-group">
                <button type="submit" class="submit-btn">PayPal Email 주소 변경</button>
            </div>
        </form:form>
    </dialog>

    <dialog id="profilePhotoEditModal" class="profilePhotoEditModal hidden">
      <jsp:include page="../user/edit-profile-image.jsp" />
    </dialog>
    <dialog id="certificateEditModal" class="certificateEditModal hidden">
      <jsp:include page="../user/editlicense.jsp" />
    </dialog>
    <dialog id="crimeEditModal" class="crimeEditModal hidden">
      <jsp:include page="../user/edit-cbc-image.jsp" />
    </dialog>
    <dialog id="locationEditModal" class="locationEditModal hidden"></dialog>
    <dialog id="idEditModal" class="idEditModal hidden">
      <jsp:include page="../user/edit-id-image.jsp" />
    </dialog>
  </body>
</html>
 --%>