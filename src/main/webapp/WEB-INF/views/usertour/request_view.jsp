<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>${userTourVO.usrTrTtl}</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/usertour/request_view.css"
    />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script
      type="text/javascript"
      src="/js/guidetour/tourReviewCarousel.js"
    ></script>
    <script
      type="text/javascript"
      src="/js/guidetour/guideReviewCarousel.js"
    ></script>
        <script
      type="text/javascript"
      src="/js/usertour/GuideRecruitmentPage.js"
    ></script>
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
        <div class="container">
          <div class="title">
          	<input 
          	  class="ttl-wb" 
          	  type="hidden" 
          	  data-pst-id="${userTourVO.usrTrPstId}"
          	  data-pst-stts="${userTourVO.usrTrStts}" />
            <h1>${userTourVO.usrTrTtl}</h1>
            <div class="wish-button"></div>
          </div>
          <!-- <div class="reviewWriteModal hidden"> -->
          <jsp:include page="../guidetour/Modal.jsp" />
          <div class="thirdLayer">
            <div class="tourOfferArea">
              <div class="offerTitleArea">
                <span>기본 정보</span>
              </div>
              <div class="want-guide">
                <p>여행지 :  ${userTourVO.citiesVO.cityName} / ${userTourVO.countriesVO.countryName}</p>
                <p>여행 일자 : ${userTourVO.usrTrStDt} ~ ${userTourVO.usrTrEdDt}</p>
                <p>인원 : ${userTourVO.usrTrNp}명</p>
              </div>
            </div>
          </div>
          <div class="thirdLayer">
            <div class="tourOfferArea">
              <div class="offerTitleArea">
                <span>희망 가이드</span>
              </div>
              <div class="want-guide">
                <c:choose>
                  <c:when test="${userTourVO.gdGndr eq 'male'}">
                    <p>성별 : 남자</p>
                  </c:when>
                  <c:when test="${userTourVO.gdGndr eq 'female'}">
                    <p>성별 : 여자</p>
                  </c:when>
                  <c:otherwise>
                    <p>성별 : 상관없음</p>
                  </c:otherwise>
                </c:choose>
                <c:choose>
                  <c:when test="${userTourVO.gdAge eq 0}">
                    <p>나이 : 상관없음</p>
                  </c:when>
                  <c:otherwise>
                    <p>나이 : ${userTourVO.gdAge}대</p>
                  </c:otherwise>
                </c:choose>
                <p>${userTourVO.gdWntRq}</p>
              </div>
            </div>
          </div>
          <div class="thirdLayer">
            <div class="tourOfferArea">
              <div class="offerTitleArea">
                <span>투어 요구 사항</span>
              </div>
              <div class="offerDetailArea">
                <h1>${userTourVO.usrTrPrps}</h1>
              </div>
            </div>
          </div>
          <div class="fourthLayer">
            <div class="rallyPointArea">
              <div class="rallyPointTitleArea">
                <span>만나는 장소</span>
              </div>
              <div class="rallyPointDetailArea">
                <div class="summaryArea">
                  <div class="rallyPointSummaryArea">
                    <div>
                      <h1>${userTourVO.usrTrMp}</h1>
                    </div>
                    <div>
                      <h3>${userTourVO.usrTrRqDtl}</h3>
                    </div>
                  </div>
                </div>
                <div class="mapApiArea">
                  <span>Google Map</span>
                  <div class="apiArea"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="applyBtn">
          	<button>지원하기</button>
          </div>
        </div>
      </div>
    </div>
    <div class="footer">
      <!-- footer 공통파일 -->
      <jsp:include page="../footer.jsp"></jsp:include>
    </div>
  </body>
</html>
