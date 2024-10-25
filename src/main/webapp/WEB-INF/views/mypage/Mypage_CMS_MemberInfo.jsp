<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="ko">

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="/css/Mypage_CMS_MemberInfo.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet">
    <title>회원 정보 관리</title>
  </head>

  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일-->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <!-- 헤더 영역은 비워둠 -->
      <div class="content">
        <!-- 사이드바 -->

        <div class="sidebar">
          <!-- CMS side-bar 공통 파일이 있으면 추가 -->
          <!-- <jsp:include page="../header.jsp"></jsp:include> -->
          <div class="menu-group">
            <div class="menu-item">회원 관리</div>
            <div class="submenu-group">
              <div class="submenu-item">회원 정보</div>
              <div class="submenu-item">가이드 프로필</div>
            </div>
          </div>

          <div class="menu-group">
            <div class="menu-item">투어 관리</div>
            <div class="submenu-group">
              <div class="submenu-item">투어 리스트</div>
              <div class="submenu-item">투어 상태 관리</div>
            </div>
          </div>

          <div class="menu-group">
            <div class="menu-item">결제 관리</div>
            <div class="submenu-group">
              <div class="submenu-item">회원 정보</div>
            </div>
          </div>
        </div>

        <!-- 회원 정보 박스 -->
        <div class="main-content">
          <!-- 검색 바와 버튼 -->
          <div class="search-container">
            <div class="search-wrapper">
              <input type="text" placeholder="검색할 아이디를 입력하세요." class="search-bar" />
              <button class="search-button">🔍</button>
            </div>
          </div>

          <!-- 회원 정보 테이블 -->
          <div class="table-header">
            <div class="header-title">회원 정보</div>
            <div class="button-group">
              <button class="tab-btn active">전체</button>
              <button class="tab-btn">여행자</button>
              <button class="tab-btn">가이드</button>
            </div>
          </div>
          <table class="member-table">
            <thead class="table-header-custom">
              <tr>
                <th>회원구분</th>
                <th>이름</th>
                <th>아이디</th>
                <th>이메일</th>
                <th>승인여부</th>
                <th>수정</th>
                <th>삭제</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>일반회원</td>
                <td>박기문</td>
                <td>Moon</td>
                <td>Moon@naver.com</td>
                <td>승인</td>
                <td><button class="edit-btn">수정</button></td>
                <td><button class="delete-btn">삭제</button></td>
              </tr>
              <tr>
                <td>가이드</td>
                <td>함츄핑</td>
                <td>ping</td>
                <td>pingpingHam@naver.com</td>
                <td>승인</td>
                <td><button class="edit-btn">수정</button></td>
                <td><button class="delete-btn">삭제</button></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>

  </html>