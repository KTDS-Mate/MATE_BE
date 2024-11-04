<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="/css/Mypage_EditInfo.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/mypageModal.js"></script>

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
        <jsp:include page="../Guide_Sidebar.jsp"></jsp:include>

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
                  <button class="edit-btn btn-open-phoneNumEdit-modal">
                    수정
                  </button>
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
                <div class="factor">결제이메일 :${userVO.usrPypEml}</div>
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
                <img class="profile-img" src="/img/mypage/고양이.jpg" alt="" />
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
                <img
                  src="img/mypage/관광통역안내사.jpg"
                  alt=""
                  class="certificate-img"
                />
              </div>
              <div class="certificate-text">
                <h4>관광 통역 안내사</h4>
              </div>
            </div>

            <!-- 두 번째 자격증 항목 -->
            <div class="profile-row">
              <div class="profile-placeholder">
                <!-- 자격증 이미지를 대체할 네모 박스 -->
                <img
                  src="img/mypage/레크리에이션지도사.jpg"
                  alt=""
                  class="certificate-img"
                />
              </div>
              <div class="certificate-text">
                <h4>레크리에이션 지도사</h4>
              </div>
            </div>
            <a href="/user/editlicense/${userVO.usrId}">
            <button class="edit-btn"> 수정 </button>
            </a>
          </div>

          <div class="profile-section">
            <h3>범죄 경력 조회서</h3>
            <div class="profile-row">
              <div class="profile-placeholder">
                <!-- 이미지를 대체할 네모 박스 -->
                <img
                  src="img/mypage/범죄경력증명서_영문.jpg"
                  alt=""
                  class="certificate-img"
                />
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
