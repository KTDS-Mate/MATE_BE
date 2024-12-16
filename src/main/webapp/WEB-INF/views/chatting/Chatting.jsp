<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <title>채팅방</title>

    <link rel="stylesheet" href="/css/chatting/chatting.css">
    <link rel="stylesheet" type="text/css" href="/css/main/MainPage.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/chatting/chatting.js"></script>
</head>

<body>
  <div class="grid">
    <!-- Header -->
    <div class="header">
        <jsp:include page="../all/MainHeader.jsp"></jsp:include>
    </div>

    <!-- Content -->
    <div class="content">
      <div class="container">
        
        <!-- 추가 버튼 및 팝업 -->
        <button id="addTarget">추가</button>

        <div id="addTargetPopupLayer" class="popup-layer-close">
          <span id="closeBtn">&times;</span>

          <div class="target-input-area">
            <input type="search" id="targetInput" placeholder="닉네임 또는 이메일을 입력하세요" autocomplete="off">
          </div>

          <ul id="resultArea">
            <!-- 검색 결과가 여기에 출력됩니다. -->
          </ul>
        </div>

        <!-- 채팅방 목록 -->
        <div class="chatting-area">
          <ul class="chatting-list">
            <c:forEach var="room" items="${roomList}">
              <li class="chatting-item" chat-no="${room.chattingNo}" target-no="${room.targetNo}">
                <div class="item-header">
                  <c:if test="${not empty room.targetProfile}">
                    <img class="list-profile" src="${room.targetProfile}">
                  </c:if>
                  <c:if test="${empty room.targetProfile}">
                    <img class="list-profile" src="/resources/images/user.png">
                  </c:if>
                </div>
                <div class="item-body">
                  <p>
                    <span class="target-name">${room.targetNickName}</span>
                    <span class="recent-send-time">${room.sendTime}</span>
                  </p>
                  <div>
                    <p class="recent-message">${room.lastMessage}</p>

                    <c:if test="${room.notReadCount > 0}">
                      <p class="not-read-count">${room.notReadCount}</p>
                    </c:if>
                  </div>
                </div>
              </li>
            </c:forEach>
          </ul>

          <!-- 채팅 내용 영역 -->
          <div class="chatting-content">
            <ul class="display-chatting">
              <!-- 채팅 메시지 리스트 출력 영역 -->
            </ul>

            <div class="input-area">
              <textarea id="inputChatting" rows="3"></textarea>
              <button id="send">보내기</button>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Footer -->
    <div class="footer">
      <jsp:include page="../footer.jsp"></jsp:include>
    </div>
  </div>
</body>