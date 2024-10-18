<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Mypage_Tourist_MyTour</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/guide_total_tourlist.css"
    />
  </head>

  <body>
    <div class="grid">
      <!--  -->
      <div class="header">
        <!-- 헤더 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <!--  -->

      <div class="content">
        <div class="my-tour">
          <div class="border"></div>

          <div class="align-button">
            <span class="align-button-text">대륙</span>
            <span class="align-button-text">요금</span>
            <span class="align-button-text">정렬순서</span>
          </div>

          <div class="tour-box">
            <img src="/image/tourlist/베니스.jpg" alt="" />
            <div class="tour-contents">
              <h3>테스트제목</h3>
              <p class="tour-contents-text">날짜 :2024.02.12 ~ 2024.03.02</p>
              <p class="tour-contents-text">투어인원 : 2명</p>
              <p class="tour-contents-text">치안 : ★★★★</p>
              <p class="tour-contents-text">비용 : 1,050,000원</p>
              <p class="tour-contents-text">가이드 평점 : 3.5</p>
            </div>
          </div>

          <div class="tour-box">
            <img src="/image/tourlist/라스베가스 야경.jpg" alt="" />
            <div class="tour-contents">
              <h3>테스트제목</h3>
              <p class="tour-contents-text">날짜 :2024.02.12 ~ 2024.03.02</p>
              <p class="tour-contents-text">투어인원 : 2명</p>
              <p class="tour-contents-text">치안 : ★★★★</p>
              <p class="tour-contents-text">비용 : 1,050,000원</p>
              <p class="tour-contents-text">가이드 평점 : 3.5</p>
            </div>
          </div>

          <div class="tour-box">
            <img src="/image/tourlist/베트남 퀴논 도시.jpg" alt="" />
            <div class="tour-contents">
              <h3>테스트제목</h3>
              <p class="tour-contents-text">날짜 :2024.02.12 ~ 2024.03.02</p>
              <p class="tour-contents-text">투어인원 : 2명</p>
              <p class="tour-contents-text">치안 : ★★★★</p>
              <p class="tour-contents-text">비용 : 1,050,000원</p>
              <p class="tour-contents-text">가이드 평점 : 3.5</p>
            </div>
          </div>

          <div class="tour-box">
            <img src="/image/tourlist/삿포로 온천.jpg" alt="" />
            <div class="tour-contents">
              <h3>테스트제목</h3>
              <p class="tour-contents-text">날짜 :2024.02.12 ~ 2024.03.02</p>
              <p class="tour-contents-text">투어인원 : 2명</p>
              <p class="tour-contents-text">치안 : ★★★★</p>
              <p class="tour-contents-text">비용 : 1,050,000원</p>
              <p class="tour-contents-text">가이드 평점 : 3.5</p>
            </div>
          </div>

          <!-------------------------------------------------------------->
        </div>
      </div>
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>
</html>
