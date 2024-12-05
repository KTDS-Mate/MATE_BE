<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="/css/usertour/tour_apllyInfo.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
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
        <div class="container">
          <div class="title">
            <input
              id=""
              type="hidden"
              data-gd-pst-id="${tourApplyVO.gdApplyId}"
            />
            <h1>${tourApplyVO.gdApplyTtl}</h1>
          </div>
          <div class="firstLayer">
          
            <div class="priceArea">
              <div class="priceTitleArea">
                <span>Price</span>
              </div>
              <div class="priceDetailArea">
                <div class="hour">
                  <h4 class="maxNp">인원 : ${userTourVO.usrTrNp} 명</h4>
                </div>
                <div class="price">
                  <span>제시 금액 : ${tourApplyVO.gdApplyPrc} $</span>
                </div>
                  <div class="reserveButton">
                    <span onclick="location.href=`/tourApply/accept?gdApplyId=${tourApplyVO.gdApplyId}`">수락</span>
                  </div>
                  <div class="reserveButton">
                    <span onclick="location.href=`/tourApply/refusal?gdApplyId=${tourApplyVO.gdApplyId}`">거절</span>
                  </div>
              </div>
            </div>
          </div>
          <div class="secondLayer">
            <div class="tourSummaryArea">
              <div class="summaryTitleArea">
                <span>투어 요약</span>
              </div>
              <div class="summaryDetailArea">
                <h5>${userTourVO.usrTrStDt} ~ ${userTourVO.usrTrEdDt}</h5>
                <h1>${tourApplyVO.trGdApplyDtl}</h1>
              </div>
            </div>
            <div class="guideProfileArea">
              <div class="profileTitleArea">
                <span>가이드 프로필</span>
              </div>
              <div class="profileDetailArea">
                <!-- <img
                  src="${guideTourVO.userVO.gdPrflImg}"
                  onerror="this.onerror=null; this.src='/img/guide/가이드 샘플 사진.jpg';"
                  alt="가이드 사진"
                /> -->
                사진일단 주석
                <div class="profileSummaryArea">
                  <c:choose>
                    <c:when test="${guideVO.usrGndr == 'male'}">
                      <h1>성별 : 남자</h1>
                    </c:when>
                    <c:otherwise>
                      <h1>성별 : 여자</h1>
                    </c:otherwise>
                  </c:choose>
                  <h1>
                    이름 : ${guideVO.usrLnm}
                    ${guideVO.usrFnm}
                  </h1>
                  <h1>나이 : 만 ${tourApplyVO.gdAge} 세</h1>
                  <h1>가이드 경력 : ${guideVO.usrGdExp} 년</h1>
                </div>
              </div>
            </div>
          </div>
          
          <div class="fourthLayer">
            <div class="rallyPointArea">
              <div class="rallyPointTitleArea">
                <span>집결 장소</span>
              </div>
              <div class="rallyPointDetailArea">
                <div class="summaryArea">
                  <div class="rallyPointSummaryArea">
                    <h1>${tourApplyVO.trGdApplyMp}</h1>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          <div class="fifthLayer">
            <div class="tourInfoArea">
              <div class="tourInfoTitleArea">
                <span>투어 세부 일정</span>
              </div>
              <div class="tourInfoDetailArea">
                <ul class="hope-info-list">
                  <c:choose>
                    <c:when
                      test="${not empty tourApplyVO.trSchdlList && not empty tourApplyVO.trSchdlList[0].trLctns}"
                    >
                      <c:forEach
                        items="${tourApplyVO.trSchdlList}"
                        var="guideTourScheduleInfoVO"
                        varStatus="index"
                      >
                        <li>
                          <div class="list-item">
                            <span class="background-num">
                              ${index.index + 1}
                            </span>
                            (${guideTourScheduleInfoVO.trTm}) ${guideTourScheduleInfoVO.trLctns}
                          </div>
                          <div class="border-left">
                            ${guideTourScheduleInfoVO.trRqst}
                          </div>
                        </li>
                      </c:forEach>
                    </c:when>
                    <c:otherwise>
                      <li>
                        <p>작성된 세부 일정이 없습니다.</p>
                      </li>
                    </c:otherwise>
                  </c:choose>
                </ul>
              </div>
            </div>
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
