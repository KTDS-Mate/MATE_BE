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
            <input id="search-val-1" type="hidden" name="searchType" value="${searchUserTourVO.searchType}"  />
            <input id="search-val-3" type="hidden" name="regionName" value="${searchUserTourVO.regionName}"  />
            <input id="search-val-4" type="hidden" name="orderby" value="${searchUserTourVO.orderby}"  />
            <input
              type="hidden"
              name="pageNo"
              class="page-no"
              value="${searchUserTourVO.pageNo}" />
            <div class="search-area">
            <select class="search-type" name="searchType">
              <option value="country" class='${"country" eq searchUserTourVO.searchType ? "selected" : ""}'>국가</option>
              <option value="city" class='${"city" eq searchUserTourVO.searchType ? "selected" : ""}'>도시</option>
              <option value="title" class='${"title" eq searchUserTourVO.searchType ? "selected" : ""}'>제목</option>
              <option value="price" class='${"price" eq searchUserTourVO.searchType ? "selected" : ""}'>가격</option>
            </select>
              <input
                type="text"
                name="searchKeyword"
                class="search-input"
                placeholder="국가를 입력해주세요."
                value="${searchUserTourVO.searchKeyword}" />
              <button class="search-button">검색</button>
            </div>
          </form>
        </div>
        <form class="region-form">
          <div class="region-menu-area">
            <!-- 선택 한 대륙이 바뀌어도 값을 가져가기 위해 hidden에 담아둠 -->
            <input
              id="region-hide"
              type="hidden"
              value="${searchUserTourVO.regionName}" />
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
        </form>
        <div class="flex-list-insert-btn">
          <div class="list-view-option">
          	<c:if test="${not empty sessionScope._LOGIN_USER_}">
          		<div>
            	<a class="insert-tour-btn" href="/usertour/insert">투어 등록</a>
            	</div>
          	</c:if>
            <form class="order-form">
            <input
              id="latest"
              class="${searchUserTourVO.orderby eq '최신순' ? 'checked2' : ''}"
              name="orderby"
              type="button"
              value="최신순" />
            <input
              id="high-price"
              class="${searchUserTourVO.orderby eq '높은 가격순' ? 'checked2' : ''}"
              name="orderby"
              type="button"
              value="높은 가격순" />
            <input
              id="low-price"
              class="${searchUserTourVO.orderby eq '낮은 가격순' ? 'checked2' : ''}"
              name="orderby"
              type="button"
              value="낮은 가격순" />
            <input
              id="deadline"
              class="${searchUserTourVO.orderby eq '마감 임박순' ? 'checked2' : ''}"
              name="orderby"
              type="button"
              value="마감 임박순" />
            </form>
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
                    data-pst-id="${userTourVO.usrTrPstId}" />
                  <c:choose>
                    <c:when
                      test="${not empty userTourVO.userTourImgList && not empty userTourVO.userTourImgList[0].usrTrRqImgIdUrl}">
                      <div>
                      <img
                        class="tour-country-image"
                        src="${userTourVO.userTourImgList[0].usrTrRqImgIdUrl}" />
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
                  	<span class="deadline-come">마감일이 얼마 남지 않았습니다!</span>
                  </c:if>
                  <div class="tour-subject">${userTourVO.usrTrTtl}</div>
                  <div class="tour-comment">${userTourVO.usrTrPrps}</div>
                  <div>
                    <div>
                      <p>
                        투어일 : ${userTourVO.usrTrStDt}
                      </p>
                      <div>
                        지역 : ${userTourVO.citiesVO.cityName} /
                        ${userTourVO.countriesVO.countryName}
                      </div>
                      <div class="tour-time">
                          <img class="clock-img" alt="시계" src="/img/tourboard/ClockImage.png">
                      		${userTourVO.usrTrTm}분
                      </div>
                      <c:choose>
                      	<c:when test="${userTourVO.usrTrStts eq 'RSRVT'}">
                      		<div>예약 상태 : 예약 중</div>
                      	</c:when>
                      	<c:when test="${userTourVO.usrTrStts eq 'PRG'}">
                      		<div>예약 상태 : 투어 진행중</div>
                      	</c:when>
                      	<c:when test="${userTourVO.usrTrStts eq 'CMPLT'}">
                      		<div>예약 상태 : 투어 완료</div>
                      	</c:when>
                      	<c:otherwise>
                      		<div>예약 상태 : 모집 중</div>
                      	</c:otherwise>
                      </c:choose>
                    </div>
                  </div>
                  </div>
                  <div class="tour-cost-fee">
                  	<div class="dollar">
                    	<h1>$${userTourVO.usrTrGdHrPrc}</h1>
                    </div>
                     <p>마감 ${userTourVO.deadline}일전</p>
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
                  <a href="javascript:movePage(0)">
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
                  href="javascript:movepage(${p})">
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
                <a href="javascript:movePage(${searchMyApplyTourVO.pageCount - 1})">
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
