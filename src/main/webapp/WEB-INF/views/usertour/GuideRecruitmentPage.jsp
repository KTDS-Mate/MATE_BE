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
      href="/css/usertour/GuideRecruitmentPage.css"
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
          <div class="firstLayer">
            <div class="tourPicArea">
              <div class="bigPicArea btn-open-pic-modal">
                <img src="/public/다낭.jpg" alt="사진 1" />
              </div>
              <div class="smallPicAreas">
                <div class="smallPicArea btn-open-pic-modal">
                  <img class="brs" src="/public/다낭.jpg" alt="사진 1" />
                </div>
                <div class="smallPicArea btn-open-pic-modal">
                  <img src="/public/다낭.jpg" alt="사진 2" />
                </div>
                <div class="morePicArea">
                  <img
                    src="/img/tourboard/MorePicButton.png"
                    alt="더보기 버튼"
                    onclick="location.href='index.html'"
                  />
                </div>
              </div>
            </div>
            <div class="priceArea">
              <div class="priceTitleArea">
                <span>Price for One Team</span>
              </div>
              <div class="priceDetailArea">
                <div class="hour">
              	  <h4 class="maxNp">투어 인원 : ${userTourVO.usrTrNp} 명</h4>
                </div>
                <div class="price">
                  <span>${userTourVO.usrTrGdHrPrc} $</span>
                </div>
                <c:if test="${sessionScope._LOGIN_USER_.usrIsGd eq 'Y'}">
                  <c:choose>
                    <c:when test="${userTourVO.usrTrStts eq 'RCRTNG'}">
                      <div class="reserveButton">
	                    <span>예약 요청</span>
	                  </div>
                    </c:when>
                    <c:otherwise>
                      <div class="non-reserveButton">
	                    <span>예약 중</span>
	                  </div>
                    </c:otherwise>
                  </c:choose>
                </c:if>
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
                <p>나이 : ${userTourVO.gdAge}대</p>
                <p>경력 : ${userTourVO.gdCrr}년 차</p>
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
                <span>집결 장소</span>
                <h3 class="showDetail">
                  상세보기
                </h3>
              </div>
              <div class="rallyPointDetailArea">
                <div class="summaryArea">
                  <div class="rallyPointSummaryArea">
                    <div>
                      <h1>${userTourVO.usrTrMp}</h1>
                    </div>
                    <div>
                      <h3>${userTourVO.usrTrStDt} ~ ${userTourVO.usrTrEdDt}</h3>
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
          <div class="fifthLayer">
            <div class="tourInfoArea">
              <div class="tourInfoTitleArea">
                <span>투어 세부 일정</span>
              </div>
              <div class="tourInfoDetailArea">
                <ul class="hope-info-list">
                	<c:choose>
                		<c:when test="${not empty userTourVO.userTourSchdlList}">
			                <c:forEach items="${userTourVO.userTourSchdlList}"
			                		   var="userTourSchdlList"
			                		   varStatus="index">
			                		   <li>
			                		   	  <div class="list-item">
			                		   	  	<span class="background-num">
			                		   	  		${index.index + 1}</span>
			                		   	  		${userTourSchdlList.trLctns}
			                		   	  </div>
			                		   	  <div class="border-left">${userTourSchdlList.trRqst}</div>
			                		   </li>
			                </c:forEach>
			                <li>
			                  <div class="list-item">
			                    <span class="background-num"></span>
			                  </div>
			                </li>
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
