<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link rel="stylesheet" type="text/css" href="/css/Guide_Sidebar.css" />    
<div class="my-page">
            <ul class="list">
              <li class="calendar"><a href="/mypage/calendar/gd-calendar/${sessionScope._LOGIN_USER_.usrLgnId}">캘린더</a></li>
              <li class="wishlist"><a href="/mypage/wishlist/gd-wishlist/${sessionScope._LOGIN_USER_.usrLgnId}">즐겨찾기</a></li>
              <li class="mytour"><a href="/mypage/mytour/gd-mytour/${sessionScope._LOGIN_USER_.usrLgnId}">나의 등록 투어</a></li>
              <li class="myapplytour"><a href="/mypage/gd-apply-tour/${sessionScope._LOGIN_USER_.usrLgnId}">나의 신청 투어</a></li>
              <li class="sales"><a href="/mypage/payment/list/${sessionScope._LOGIN_USER_.usrLgnId}">매출 관리</a></li>
              <li class="edit-profile"><a href="/mypage/edit-profile/gd-profile/${sessionScope._LOGIN_USER_.usrLgnId}">내 정보 수정</a></li>
              <li class="message"><a href="/mypage/message/gd-message/${sessionScope._LOGIN_USER_.usrLgnId}">메세지</a></li>
            </ul>
</div>


