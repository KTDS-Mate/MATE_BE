<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
  <link rel="stylesheet" type="text/css" href="/css/Header.css" />
  <div class="header-content">
    <div class="logo">
      <a href="/"><img src="/public/Logo.png" alt="로고" /></a>
    </div>

    <div class="header-center-menu">
      <div><a href="">투어 요청 목록</a></div>
      <div><a href="/guidetour/list?pageNo=0&listSize=5">가이드 투어 목록</a></div>
      <div><a href="">가이드 목록</a></div>
    </div>
    <div class="header-right-menu">
      <div>
        <a href="">
          <img class="message-icon" src="/public/chat.png" alt="채팅버튼" />
        </a>
      </div>
      <div>
        <a href="">
          <img class="alram-icon" src="/public/alarmOnButton.png" alt="알람버튼" />
        </a>
      </div>
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
						${sessionScope._LOGIN_USER_.usrId}
					</div>
					<div>
						<a href="/mypage/mytour/gd-mytour">로그아웃</a>
					</div>
					<div>
						<a href="/mypage/mytour/gd-mytour">마이페이지</a>
					</div>
				</c:otherwise>
			</c:choose>
    </div>
  </div>