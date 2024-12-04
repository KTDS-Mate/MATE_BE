<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <title>투어 요청 목록</title>
    <link rel="stylesheet" type="text/css" href="/css/usertour/tour_list.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/usertour/usertourlist.js"></script>
  </head>

  <body>
    <div class="grid">
      <div class="header">
        <!-- 헤더 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <div class="tour-request-list">
          <h1>투어 요청 목록</h1>
        </div>
        <div class="search-zone">
          <form class="search-form">
          	<input id="search-val-3" type="hidden" name="regionName" value="${searchUserTourVO.regionName}"  />
          	<input id="search-val-4" type="hidden" name="orderby" value="${searchUserTourVO.orderby}"  />
            <input type="hidden" name="pageNo" class="page-no" value="${searchUserTourVO.pageNo}" />
            <div class="search-area">
          	<select class="search-type" name="searchType">
          		<option value="country" ${"country" eq searchUserTourVO.searchType ? "selected" : ""}>국가</option>
          		<option value="city" ${"city" eq searchUserTourVO.searchType ? "selected" : ""}>도시</option>
          		<option value="title" ${"title" eq searchUserTourVO.searchType ? "selected" : ""}>제목</option>
          		<option value="price" ${"price" eq searchUserTourVO.searchType ? "selected" : ""}>가격</option>
          	</select>
          	   <input type="text" name="searchKeyword" class="search-input" placeholder="국가를 입력해주세요." value="${searchUserTourVO.searchKeyword}" />
              <button class="search-button">검색</button>
            </div>
          </form>
        </div>
          <div class="region-menu-area">
            <input
              id="all"
              class="${searchUserTourVO.regionName eq '전체' ? 'checked' : ''}"
              name="regionName"
              type="button"
              value="전체" />
            <input
              id="asia"
              class="${searchUserTourVO.regionName eq '아시아' ? 'checked' : ''}"
              name="regionName"
              type="button"
              value="아시아" />
            <input
              id="eu"
              class="${searchUserTourVO.regionName eq '유럽' ? 'checked' : ''}"
              name="regionName"
              type="button"
              value="유럽" />
            <input
              id="ose"
              class="${searchUserTourVO.regionName eq '오세아니아' ? 'checked' : ''}"
              name="regionName"
              type="button"
              value="오세아니아" />
            <input
              id="n-ame"
              class="${searchUserTourVO.regionName eq '북아메리카' ? 'checked' : ''}"
              name="regionName"
              type="button"
              value="북아메리카" />
            <input
              id="s-ame"
              class="${searchUserTourVO.regionName eq '남아메리카' ? 'checked' : ''}"
              name="regionName"
              type="button"
              value="남아메리카" />
            <input
              id="af"
              class="${searchUserTourVO.regionName eq '아프리카' ? 'checked' : ''}"
              name="regionName"
              type="button"
              value="아프리카" />
          </div>
        <div class="flex-list-insert-btn">
          <div class="list-view-option">
            <div class="order-form">
            <div>
            <input
              id="latest"
              class="${searchUserTourVO.orderby eq '최신순' ? 'checked2' : ''}"
              name="orderby"
              type="button"
              value="최신순" />
            </div>
            <div>
            <input
              id="high-price"
              class="${searchUserTourVO.orderby eq '높은 가격순' ? 'checked2' : ''}"
              name="orderby"
              type="button"
              value="높은 가격순" />
            </div>
            <div>
            <input
              id="low-price"
              class="${searchUserTourVO.orderby eq '낮은 가격순' ? 'checked2' : ''}"
              name="orderby"
              type="button"
              value="낮은 가격순" />
            </div>
            <div>
            <input
              id="deadline"
              class="${searchUserTourVO.orderby eq '마감 임박순' ? 'checked2' : ''}"
              name="orderby"
              type="button"
              value="마감 임박순" />
            </div>
            </div>
            <c:if test="${not empty sessionScope._LOGIN_USER_}">
          		<div class="insertBtnGroup">
					<div class="button" onclick="javascript:moveRequest()">
					    <p class="btnText">해주세요</p>
					    <div class="btnTwo">
					      <p class="btnText2">GO!</p>
					    </div>
					 </div>
					 <div class="button" onclick="javascript:moveInsert()">
					    <p class="btnText">투어 등록</p>
					    <div class="btnTwo">
					      <p class="btnText2">GO!</p>
					    </div>
					 </div>
            	</div>
          	</c:if>
          </div>
        </div>
        <div class="tour-list-area">
          <c:choose>
            <c:when test="${not empty userTourListVO.userTourList}">
              <c:forEach
                items="${userTourListVO.userTourList}"
                var="userTourVO">
                <div class="tour-box">
                  <input
                    class="hide"
                    type="hidden"
                    data-pst-id="${userTourVO.usrTrPstId}"
                    data-divide="${userTourVO.usrTrDivide}" />
                  <c:choose>
                    <c:when
                      test="${not empty userTourVO.userTourImgList && not empty userTourVO.userTourImgList[0].usrTrRqImgIdUrl}">
                      <div>
                      <img
                        class="tour-country-image"
                        src="http://localhost:8080/C:\matepic/${userTourVO.userTourImgList[0].usrTrRqImgIdUrl}" />
                      </div>
                    </c:when>
                    <c:otherwise>
                      <div>
                      <img
                        class="tour-country-image"
                        src="/img/tourboard/mateImg.png" />
                      </div>
                    </c:otherwise>
                  </c:choose>
                  <div class="tour-cont">
                  <c:if test="${userTourVO.deadline < 3}">
                  	<span class="deadline-come">마감임박!</span>
                  </c:if>
                  <div class="tour-subject">${userTourVO.usrTrTtl}</div>
                  <div class="tour-comment">${userTourVO.usrTrPrps}</div>
                  <div>
                    <div class="all-cont">
                      <c:choose>
                      	<c:when test="${userTourVO.usrTrStts eq 'RSRVT'}">
                      		<p>예약 상태 : 예약 중</p>
                      	</c:when>
                      	<c:when test="${userTourVO.usrTrStts eq 'PRG'}">
                      		<p>예약 상태 : 투어 진행중</p>
                      	</c:when>
                      	<c:when test="${userTourVO.usrTrStts eq 'CMPLT'}">
                      		<p>예약 상태 : 투어 완료</p>
                      	</c:when>
                      	<c:otherwise>
                      		<p>예약 상태 : 모집 중</p>
                      	</c:otherwise>
                      </c:choose>
                      <div>
                        지역 : ${userTourVO.citiesVO.cityName} /
                        ${userTourVO.countriesVO.countryName}
                      </div>
                      <div class="tour-time">
                      	<img class="calendarImg" alt="캘린더" src="/img/tourboard/calendar.png" />
                         ${userTourVO.usrTrStDt} ~ ${userTourVO.usrTrEdDt}
                      </div>
                      <c:if test="${userTourVO.usrTrTm < 1440}">
	                      <div class="tour-time">
	                          <img class="clock-img" alt="시계" src="/img/tourboard/ClockImage.png">
	                      		${userTourVO.usrTrTm}분
	                      </div>
                      </c:if>
                    </div>
                  </div>
                  </div>
                  <div class="tour-cost-fee">
                  	<c:if test="${userTourVO.usrTrDivide eq 'SCHEDULE'}">
	                  	<div class="dollar">
	                    	<h2>$${userTourVO.usrTrGdHrPrc}</h2>
	                    </div>
                  	</c:if>
                     <p><span class="end">마감 ${userTourVO.deadline}일전</span></p>
                  </div>
                </div>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <div class="isempty">검색 결과가 없습니다.</div>
            </c:otherwise>
          </c:choose>
        </div>
        <div>
          <ul class="page-nav">
            <c:if test="${searchUserTourVO.hesprevGroup}">
              <li>
                  <!-- <a href="/board/list?pageNo=0&listSize=${searchMyBoardVO.listSize}"> -->
                  <a href="javascript:movepage(0);">
                    처음
                  </a>
              </li>
              <li>
                <a
                  href="javascript:movepage(${searchUserTourVO.prevGroupStartPageNo});">
                  &lt;
                </a>
              </li>
            </c:if>
            <c:forEach
              begin="${searchUserTourVO.groupStartPageNo}"
              end="${searchUserTourVO.groupEndPageNo}"
              step="1"
              var="p">
              <li class="${p eq searchUserTourVO.pageNo ? 'active' : ''}">
                <a
                  href="javascript:movepage(${p});">
                  ${p + 1}
                </a>
              </li>
            </c:forEach>
            <c:if test="${searchUserTourVO.hasNextGroup}">
              <li>
                <a
                  href="javascript:movepage(${searchUserTourVO.nextGroupStartPageNo});">
                  &gt;
                </a>
              </li>
              <li>
                <a href="javascript:movepage(${searchUserTourVO.pageCount - 1});">
                 끝
                </a>
              </li>
            </c:if>
          </ul>
        </div>
      </div>
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>
</html>
