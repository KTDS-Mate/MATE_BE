<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/mypage/Mypage_EditInfo.css"
    />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/userlogin.js"></script>
    <script type="text/javascript" src="/js/user/userregist.js"></script>
    <script type="text/javascript" src="/js/user/emailauthverify.js"></script>
    <script type="text/javascript" src="/js/user/emailauth.js"></script>
    <script type="text/javascript" src="/js/user/editlicense.js"></script>
    <script type="text/javascript" src="/js/user/editlocation.js"></script>
    <script type="text/javascript" src="/js/user/editphn.js"></script>
    <script type="text/javascript" src="/js/user/editpwd.js"></script>
    <script type="text/javascript" src="/js/user/editpypeml.js"></script>
    <script type="text/javascript" src="/js/user/loadcities.js"></script>

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
            <jsp:include page="../user/myPageModal.jsp" />
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
                  <button class="edit-btn btn-open-pwEdit-modal">수정</button>
                </div>
              </div>
            </div>
          </div>

          <div class="payment-section">
            <h2>결제 수단 관리</h2>
            <div class="info-item">
              <div class="info-row">
                <div class="factor">결제이메일 :${userVO.usrPypEml}</div>
                <button class="edit-btn btn-open-pypEdit-modal">수정</button>
              </div>
            </div>
          </div>

          <div class="payment-section">
            <h2>경력 및 활동 지역</h2>
            <div class="info-item">
              <!-- 경력 표시 -->
              <div class="info-row">
                <div class="factor">경력 : ${registGuideVO.usrGdExp}</div>
                <button class="edit-btn btn-open-locationEdit-modal">
                  수정
                </button>
              </div>

              <div class="info-row">
                <div class="factor">
                  대표 국적 : ${registGuideVO.countryName}
                </div>
                <button class="edit-btn btn-open-locationEdit-modal">
                  수정
                </button>
              </div>

              <div class="info-row">
                <div class="factor">
                  활동 도시 :
                  <c:forEach
                    items="${registGuideVO.cities}"
                    var="city"
                    varStatus="status"
                  >
                    <span>${city.cityName}(${city.country.countryName})</span>
                    <c:if test="${!status.last}">, </c:if>
                  </c:forEach>
                </div>
                <button class="edit-btn btn-open-locationEdit-modal">
                  수정
                </button>
              </div>

              <div class="profile-section">
                <h3>프로필 사진 관리</h3>
                <div class="profile-row">
                  <div class="profile-placeholder">
                    <!-- 이미지를 대체할 네모 박스 -->
                    <img
                      class="profile-img"
                      src="/img/mypage/고양이.jpg"
                      alt=""
                    />
                  </div>
                  <button class="edit-btn btn-open-profilePhotoEdit-modal">
                    수정
                  </button>
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

                <button class="edit-btn btn-open-certificateEdit-modal">
                  수정
                </button>
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
                  <button class="edit-btn btn-open-crimeEdit-modal">
                    수정
                  </button>
                </div>
              </div>

              <div class="profile-section">
                <h3>신분증 관리</h3>
                <div class="profile-row">
                  <div class="profile-placeholder">
                    <!-- 이미지를 대체할 네모 박스 -->
                    <img
                      src="img/mypage/범죄경력증명서_영문.jpg"
                      alt=""
                      class="certificate-img"
                    />
                  </div>
                  <button class="edit-btn btn-open-idEdit-modal">수정</button>
                </div>
              </div>
            </div>
          </div>
          <div class="footer">
            <!-- footer 공통파일-->
            <jsp:include page="../footer.jsp"></jsp:include>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
