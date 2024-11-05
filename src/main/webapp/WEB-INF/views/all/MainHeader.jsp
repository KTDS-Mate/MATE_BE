<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link rel="stylesheet" type="text/css" href="/css/main/MainHeader.css" />

<div
  class="header-content"
  data-loginId="${sessionScope._LOGIN_USER_.usrLgnId}"
>
  <div class="logo">
    <a href="/"><img src="/public/Logo.png" alt="로고" /></a>
  </div>

  <div class="header-right-menu">
    <div>
      <a href="">
        <img class="message-icon" src="/public/chat.png" alt="채팅버튼" />
      </a>
    </div>
    <div>
      <a href="">
        <img
          class="alram-icon"
          src="/public/alarmOnButton.png"
          alt="알람버튼"
        />
      </a>
    </div>
    <!-- // http://localhost:8080/board/list?pageNo=1&listSize=10 -->
    <c:choose>
      <c:when test="${empty sessionScope._LOGIN_USER_}">
        <div>
          <a href="/user/login">로그인</a>
        </div>
        <div>
          <a href="/user/regist">회원가입</a>
        </div>
      </c:when>
      <c:otherwise>
        <div>
          <a href="/user/logout">로그아웃</a>
        </div>
        <div>
          <a
            href="/mypage/edit-profile/choice?usrLgnId=${sessionScope._LOGIN_USER_.usrLgnId}&usrIsGd=${sessionScope._LOGIN_USER_.usrIsGd}"
            >마이페이지</a
          >
        </div>
      </c:otherwise>
    </c:choose>
  </div>
</div>
<div class="header-center-menu">
  <div>
    <a
      href="http://mate.com:8080/usertour/list?pageNo=0&listSize=9&regionName=전체&orderby=최신순"
      >투어 요청 목록</a
    >
  </div>
  <div><a href="">가이드 투어 목록</a></div>
  <div><a href="">가이드 목록</a></div>
</div>
