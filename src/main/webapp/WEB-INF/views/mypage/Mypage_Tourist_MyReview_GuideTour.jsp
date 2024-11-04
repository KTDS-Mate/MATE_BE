<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8" />
    <title>Mypage_Tourist_MyReview</title>
    <link rel="stylesheet" type="text/css" href="/css/mypage/Mypage_Tourist_MyReview_GuideTour.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
      <script type="text/javascript" src="/js/mypage/Mypage_Tourist_MyReview_GuideTour.js"></script>
  </head>

  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <div class="content-grid">
          <!-- side-bar 공통파일 -->
          <jsp:include page="../Tourist_Sidebar.jsp"></jsp:include>


          <div class="my-tour">
            <div class="tour-list-top">
              <div>
                <h2>나의 리뷰</h2>
              </div>
            </div>
            <div class="border"></div>
            
            <div class="guide-button">
                <button class="guide guide-style">가이드리뷰</button>
                <button class="guide-tour guide-style-check">투어리뷰</button>
              </div>
            
            <div class="tour-list">
            
              <form class="search-form">

                  <div class="search-area">

                    <input type="hidden" name="pageNo" class="page-no" value="${searchGuideTourReviewVO.pageNo}">

                    <select class="search-type" name="searchType">
                      <option value="gdTrRvwTtl" ${"gdTrRvwTtl" eq searchGuideTourReviewVO.searchType ? "selected" : "" }>제목
                      </option>
                      <option value="gdTrRvwCntnt" ${"gdTrRvwCntnt" eq searchGuideTourReviewVO.searchType ? "selected" : "" }>내용
                      </option>
                      <option value="cityName" ${"cityName" eq searchGuideTourReviewVO.searchType ? "selected" : "" }>도시이름
                      </option>
                      <option value="countryName" ${"countryName" eq searchGuideTourReviewVO.searchType ? "selected" : "" }>국가이름
                      </option>
                    </select>
                    <input type="text" class="search-keyword" name="searchKeyword"
                      value="${searchGuideTourReviewVO.searchKeyword}" placeholder="찾고 싶은 투어를 검색해 주세요." />
                    <button type="button" class="search-btn">검색</button>


                  </div>
                </form>


                <div class="list-area">

                  <c:choose>
                    <c:when test="${not empty guideTourReviewListVO.reviewList}">
                      <c:forEach items="${guideTourReviewListVO.reviewList}" var="review">
                        <div class="list-item">
                          <div class="grid-item">
                            <div class="flex">
                              <div>투어제목 : ${review.gdTrRvwTtl}</div>
                              <div>지역 : ${review.myBoardVO.searchCityAndCountryVO.countriesVO.countryName} /
                                ${review.myBoardVO.searchCityAndCountryVO.cityName}</div>
                              <div>날짜 : ${review.myBoardVO.gdTrStDt} ~ ${review.myBoardVO.gdTrEdDt}</div>
                              <div>평점 : ${review.gdTrRvwRtng}</div>
                              <div>내용 : </div>
                              <div>
                                ${review.gdTrRvwCntnt}
                              </div>
                            </div>
                            <div class="right-align">
                              <a
                                href="javascript:deleteTour('${sessionScope._LOGIN_USER_.usrLgnId}', '${review.gdTrRvwId}')">삭제</a>
                            </div>
                          </div>
                        </div>
                      </c:forEach>
                    </c:when>
                    <c:otherwise>
                      <div class="list-item">
                        <div class="grid-item">
                          <div class="flex">
                            <div>게시글이 없습니다.</div>
                          </div>
                        </div>
                      </div>
                    </c:otherwise>
                  </c:choose>


                </div><!-- list-area 클래스 -->

                <ul class="page-nav">
                  <c:if test="${searchGuideTourReviewVO.hesprevGroup}">
                    <li>
                      <!-- <a href="/board/list?pageNo=0&listSize=${searchGuideTourReviewVO.listSize}"> -->
                      <a href="javascript:movePage(0)">
                        처음
                      </a>
                    </li>
                    <li>
                      <a href="javascript:movePage(${searchGuideTourReviewVO.prevGroupStartPageNo})">
                        이전
                      </a>
                    </li>
                  </c:if>
                  <c:forEach begin="${searchGuideTourReviewVO.groupStartPageNo}" end="${searchGuideTourReviewVO.groupEndPageNo}"
                    step="1" var="p">
                    <li class="${p eq searchGuideTourReviewVO.pageNo ? 'active' : ''}">
                      <!-- a href="/mypage/mytour/gd-mytour/${sessionScope._LOGIN_USER_.usrLgnId}?pageNo=${p}" -->
                      <a href="javascript:movePage(${p})">

                        ${p+1}

                      </a>
                    </li>
                  </c:forEach>
                  <c:if test="${searchGuideTourReviewVO.hasNextGroup}">
                    <li>
                      <a href="javascript:movePage(${searchGuideTourReviewVO.nextGroupStartPageNo})">
                        다음
                      </a>
                    </li>
                    <li>
                      <a href="javascript:movePage(${searchGuideTourReviewVO.pageCount - 1})">
                        끝
                      </a>
                    </li>
                  </c:if>
                </ul>


              </div>
            </div>
          </div>
        </div>
        <div class="footer">
          <!-- footer 공통파일 -->
          <jsp:include page="../footer.jsp"></jsp:include>
        </div>
      </div>
    </body>

    </html>