<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="/css/Mypage_EditInfo.css" />
    <title>Mypage_Tourist_EditInfo</title>
  </head>

  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <!-- 사이드바 -->
        <!-- side-bar 공통파일 -->
        <!--<jsp:include page="../sidebar.jsp"></jsp:include>-->
        <div class="sidebar-left">
          <ul class="sidebar-left-list">
            <li class="disabled">캘린더</li>
            <li class="disabled">즐겨찾기</li>
            <li class="disabled">나의 등록 투어</li>
            <li class="disabled">나의 리뷰</li>
            <li class="disabled">결제 내역</li>
            <li class="active">내 정보 수정</li>
            <li class="disabled">메세지</li>
          </ul>
        </div>

        <!-- 본문 내용 -->
        <div class="main-content">
          <div class="info-section">
            <h2>개인 정보 관리</h2>
            <div class="info-item">
              <h3>아이디 : ${usrVO.usrLgnId}</h3>
              <div class="factor">이메일 : ${usrVO.usrEml}</div>
              <div class="info-item">
                <div class="info-row">
                  <div class="factor">전화번호 : ${usrVO.usrPhn}</div>
                  <button class="edit-btn">수정</button>
                </div>
                <div class="info-row">
                  <div class="factor">비밀번호 변경</div>
                  <button class="edit-btn">수정</button>
                </div>
              </div>
            </div>
          </div>

          <div class="payment-section">
            <h2>결제 수단 관리</h2>
            <div class="info-item">
              <div class="info-row">
                <div class="factor">결제이메일 :${usrVO.usrPypEml}</div>
                <button class="edit-btn">수정</button>
              </div>
            </div>
          </div>

          <div class="guide-section">
            <div class="info-row">
              <h2>가이드 등록</h2>
              <button class="edit-btn">등록</button>
            </div>
          </div>

          <div class="profile-section">
            <h3>프로필 사진 관리</h3>
            <div class="profile-row">
              <div class="profile-placeholder">
                <!-- 이미지를 대체할 네모 박스 -->
                <img class="profile-img" src="/img/mypage/고양이.jpg" alt="">
              </div>
              <button class="edit-btn">수정</button>
            </div>
          </div>

          <div class="profile-section">
            <h3>자격증 관리</h3>

            <!-- 첫 번째 자격증 항목 -->
            <div class="profile-row">
              <div class="profile-placeholder">
                <!-- 자격증 이미지를 대체할 네모 박스 -->
                <img src="img/mypage/관광통역안내사.jpg" alt="" class="certificate-img" />
              </div>
              <div class="certificate-text">
                <h4>관광 통역 안내사</h4>
              </div>
              <button class="edit-btn">수정</button>
            </div>

            <!-- 두 번째 자격증 항목 -->
            <div class="profile-row">
              <div class="profile-placeholder">
                <!-- 자격증 이미지를 대체할 네모 박스 -->
                <img src="img/mypage/레크리에이션지도사.jpg" alt="" class="certificate-img" />
              </div>
              <div class="certificate-text">
                <h4>레크리에이션 지도사</h4>
              </div>
              <button class="edit-btn">수정</button>
            </div>
          </div>

          <div class="profile-section">
            <h3>범죄 경력 조회서</h3>
            <div class="profile-row">
              <div class="profile-placeholder">
                <!-- 이미지를 대체할 네모 박스 -->
                <img src="img/mypage/범죄경력증명서_영문.jpg" alt="" class="certificate-img" />
              </div>
              <button class="edit-btn">수정</button>
            </div>
          </div>
        </div>
      </div>
      <div class="footer">
        <!-- footer 공통파일-->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>

  </html>