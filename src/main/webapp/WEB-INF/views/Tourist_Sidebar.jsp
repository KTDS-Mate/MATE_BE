<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <link rel="stylesheet" type="text/css" href="/css/Tourist_Sidebar.css" />

  <div class="my-page">
    <ul class="list">
      <li class="calendar"><a href="/mypage/calendar/tr-calendar/${sessionScope._LOGIN_USER_.usrLgnId}">캘린더</a></li>
      <li class="wishlist"><a href="/mypage/wishlist/tr-wishlist/${sessionScope._LOGIN_USER_.usrLgnId}">즐겨찾기</a></li>
      <li class="mytour"><a href="/mypage/mytour/tr-mytour/${sessionScope._LOGIN_USER_.usrLgnId}">나의 등록 투어</a></li>
      <li class="reveiw"><a href="/mypage/reveiw/tr-review/${sessionScope._LOGIN_USER_.usrLgnId}">나의 리뷰</a></li>
      <li class="payment"><a href="/mypage/payment/tr-payment/${sessionScope._LOGIN_USER_.usrLgnId}">결제 내역</a></li>
      <li class="edit-profile"><a href="/mypage/edit-profile/tr-profile/${sessionScope._LOGIN_USER_.usrLgnId}">내 정보 수정</a></li>
      <li class="message"><a href="/mypage/message/tr-message/${sessionScope._LOGIN_USER_.usrLgnId}">메세지</a></li>
    </ul>
  </div>