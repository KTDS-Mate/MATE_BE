<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/common.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
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

          <div class="align-button">
            <span class="align-button-text">대륙</span>
            <span class="align-button-text">요금</span>
            <span class="align-button-text">정렬순서</span>
          </div>

<c:forEach items="${guideTourListVO.guideTourList}" var="guidTourVO">
          <div class="tour-box">
            <img src="/img/tourlist/베니스.jpg" alt="" />
            <div class="tour-contents">
              <h3>${guidTourVO.gdTrTtl}</h3>
              <p class="tour-contents-text">날짜 :${guidTourVO.gdTrStDt} ~ ${guidTourVO.gdTrEdDt}</p>
              <p class="tour-contents-text">투어 최대인원 : ${guidTourVO.gdTrMxNp}명</p>
              <p class="tour-contents-text">비용 : ${guidTourVO.gdTrPrc}$</p>
              <p class="tour-contents-text">가이드 평점 : ${guidTourVO.avgRvw}</p>
            </div>
          </div>
</c:forEach>

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
