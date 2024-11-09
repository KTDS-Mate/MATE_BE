<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    
    <link rel="stylesheet" type="text/css" href="/css/user/modal.css">
    <link rel="stylesheet" type="text/css" href="/css/user/frag-editphn.css">
    <link rel="stylesheet" type="text/css" href="/css/user/editinfo.css" />
    <link rel="stylesheet" type="text/css" href="/css/mypage/Mypage_EditInfo.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/intl-tel-input@24.6.1/build/css/intlTelInput.css">
    
    <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" type="image/x-icon" sizes="16x16">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <title>Mypage_Tourist_EditInfo</title>
  </head>

  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <!-- side-bar 공통파일 -->
        <!-- 사이드바 -->

        <jsp:include page="../Tourist_Sidebar.jsp"></jsp:include>

        <!-- 본문 내용 -->
        <div class="main-content">
          <div class="info-section">
            <h2>개인 정보 관리</h2>
            <div class="info-item">
              <h3>아이디 : ${userVO.usrLgnId}</h3>
              <div class="factor">이메일 : ${userVO.usrEml}</div>
              <div class="info-item">
                <div class="info-row">
                  <div class="factor">전화번호 : ${userVO.usrPhn}</div>
                  <button class="edit-btn" id="openEditPhoneModal">
                    수정
                  </button>
                </div>
                
               <div class="info-row">
                  <div class="factor">비밀번호 변경</div>
                  <button id="changePwdBtn" class="edit-btn btn-open-pwEdit-modal">수정</button>
               </div>
              </div>
            </div>
          </div>

          <div class="payment-section">
            <h2>결제 수단 관리</h2>
            <div class="info-item">
              <div class="info-row">
                <div class="factor">PayPal Email :${userVO.usrPypEml}</div>
                <button class="edit-btn btn-open-pypEdit-modal">수정</button>
              </div>
            </div>
          </div>

          <div class="guide-section">
            <div class="info-row">
              <h2>가이드 등록</h2>
              <button class="edit-btn">
                <a href="/user/guideregist">등록</a>
              </button>
            </div>
          </div>
        </div>
      </div>
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
    
   	<!-- 모달 -->
	<div id="modal">
	    <div class="modal-content">
	    	<button class="close-button" aria-label="Close modal">X</button>
	    	<div id="modalBody">
	        <!-- AJAX로 로드된 콘텐츠가 여기에 삽입됩니다 -->
	        </div>
	    </div>
	</div>
	
   	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- intl-tel-input JS -->
    <script src="https://cdn.jsdelivr.net/npm/intl-tel-input@24.6.1/build/js/intlTelInput.min.js"></script>
    <!-- intl-tel-input utils.js -->
    <script src="https://cdn.jsdelivr.net/npm/intl-tel-input@24.6.1/build/js/utils.js"></script>
    <script type="text/javascript" src="/js/user/modal.js"></script>
    <script type="text/javascript" src="/js/user/editpwd-modal.js"></script>
	
  </body>
</html>
