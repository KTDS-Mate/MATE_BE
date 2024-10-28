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
      href="/css/guidetour/guide_total_tourlist.css"
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
<script type="text/javascript" src="/js/guidetour/guidetourlist.js"></script>
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
      <div class="search-zone">
               <form class="search-form">
                  <input type="hidden" name="pageNo" class="page-no" value="${searchGuideTourVO.pageNo}" />
                   <div class="search-area">
                       <input type="text" class="search-input" placeholder="찾고싶은 국가를 입력하세요." />
                       <button class="search-button">검색</button>
                   </div>
               </form>
      </div>
      <div class="tour"><a href="">투어 등록하기</a></a></div>
      <div class="list-view-option">
      			
                <div><a href="">높은 비용순</a></div>
                <div><a href="">낮은 비용순</a></div>
                <div><a href="">최신순</a></div>
                <div><a href="">평점 높은순</a></div>
      </div>
        <div class="my-tour">
		   <c:forEach items="${guideTourListVO.guideTourList}" var="guideTourVO">
		   		<div class="tour-img">
		   		<input class="hide" type="hidden" data-gdpst-id="${guideTourVO.gdTrPstId}" />
		        <c:choose>
			        <c:when test="${not empty guideTourVO.guideTourImgList && not empty guideTourVO.guideTourImgList[0].gdTrImgUrl}">
			        	<div class="tour-box">
			            <img src="${guideTourVO.guideTourImgList[0].gdTrImgUrl}" />
			        </c:when>
			        <c:otherwise>
			          <div class="tour-box">
			            <img src="/img/tourlist/베니스.jpg" alt="mate 기본이미지" />
			        </c:otherwise>
		        </c:choose>
		            <div class="tour-contents">
		              <h2>${guideTourVO.gdTrTtl}</h2>
		              <p class="tour-contents-text"><span>나라 :</span> ${guideTourVO.citiesVO.cityName}</p>
		              <p class="tour-contents-text"><span>날짜 :</span> ${guideTourVO.gdTrStDt} ~ ${guideTourVO.gdTrEdDt}</p>
		              <p class="tour-contents-text"><span>투어 최대인원 :</span> ${guideTourVO.gdTrMxNp}명</p>
		              <p class="tour-contents-text"><span>비용 :</span> ${guideTourVO.gdTrPrc}$</p>
		              <p class="tour-contents-text"><span>가이드 평점 :</span> ${guideTourVO.avgRvw}</p>
		            </div>
		          </div>
			</c:forEach>
		</div>
          <!-------------------------------------------------------------->
        <div class="page-area">
               <ul class="page-nav">
                  <c:if test="${searchGuideTourVO.hesprevGroup}">
                     <li>
                        <a href="javascript:movepage(${searchGuideTourVO.prevGroupStartPageNo});">
                           &lt;
                        </a>
                     </li>
                  </c:if>
                  <c:forEach begin="${searchGuideTourVO.groupStartPageNo}"
                           end="${searchGuideTourVO.groupEndPageNo}"
                           step="1"
                           var="p">
                     <li class="${p eq searchGuideTourVO.pageNo ? 'active' : ''}">
                        <a href="/guidetour/list?pageNo=${p}&listSize=${searchGuideTourVO.listSize}">
                           ${p + 1}
                        </a>
                     </li>
                  </c:forEach>
                  <c:if test="${searchGuideTourVO.hasNextGroup}">
                     <li>
                        <a href="javascript:movepage(${searchGuideTourVO.nextGroupStartPageNo});">
                           &gt;
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
