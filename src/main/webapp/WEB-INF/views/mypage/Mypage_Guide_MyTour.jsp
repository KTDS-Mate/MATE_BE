<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8" />
      <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
      <title>Mypage_Guide_MyTour</title>
      <link rel="stylesheet" type="text/css" href="/css/mypage/Mypage_Guide_MyTour.css" />
      <link rel="stylesheet" type="text/css" href="/css/common.css" />
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link
        href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
        rel="stylesheet">

      <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
      <script type="text/javascript" src="/js/mypage/Mypage_Guide_MyTour.js"></script>
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
            <jsp:include page="../Guide_Sidebar.jsp"></jsp:include>


            <div class="my-tour">
              <div class="tour-list-top">
              
                <div>
                  <h2>투어 목록</h2>
                </div>
                
                <div>
                  <h5>
                    <span class="gray">예약중인 투어는 수정 및 삭제를 할 수 없습니다!</span>
                  </h5>
                </div>
                
              </div>
              
              <div class="border"></div>
              
              <div class="tour-list">
                <form class="search-form">

                  <div class="search-area">

                    <input type="hidden" name="pageNo" class="page-no" value="${searchMyBoardVO.pageNo}">

                    <select class="search-type" name="searchType">
                      <option value="gdTrTtl" ${"gdTrTtl" eq searchMyBoardVO.searchType ? "selected" : "" }>투어제목
                      </option>
                      <option value="cityName" ${"cityName" eq searchMyBoardVO.searchType ? "selected" : "" }>도시이름
                      </option>
                      <option value="countryName" ${"countryName" eq searchMyBoardVO.searchType ? "selected" : "" }>국가이름
                      </option>
                    </select>
                    <input type="text" class="search-keyword" name="searchKeyword"
                      value="${searchMyBoardVO.searchKeyword}" placeholder="찾고 싶은 투어를 검색해 주세요." />
                    <button type="button" class="search-btn">검색</button>


                  </div>
                </form>
                <div class="list-area">

                  <c:choose>
                    <c:when test="${not empty boardListVO.boardList}">
                      <c:forEach items="${boardListVO.boardList}" var="board">
                        <div class="list-item">
                          <div class="grid-item">
                            <div class="flex">
                              <div>제목 : ${board.gdTrTtl}</div>
                              <div>날짜 : ${board.gdTrStDt} ~ ${board.gdTrEdDt}</div>
                              <div>지역 : ${board.searchCityAndCountryVO.countriesVO.countryName} /
                                ${board.searchCityAndCountryVO.cityName}</div>
                              <div>예약 상태 : 예약중</div>
                            </div>

                            <div class="right-align">
                              <a href="">수정</a>
                              /
                              <a
                                href="javascript:deleteTour('${sessionScope._LOGIN_USER_.usrLgnId}', '${board.gdTrPstId}')">삭제</a>
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



                </div>

                <ul class="page-nav">
                  <c:if test="${searchMyBoardVO.hesprevGroup}">
                    <li>
                      <!-- <a href="/board/list?pageNo=0&listSize=${searchMyBoardVO.listSize}"> -->
                      <a href="javascript:movePage(0)">
                        처음
                      </a>
                    </li>
                    <li>
                      <a href="javascript:movePage(${searchMyBoardVO.prevGroupStartPageNo})">
                        이전
                      </a>
                    </li>
                  </c:if>
                  <c:forEach begin="${searchMyBoardVO.groupStartPageNo}" end="${searchMyBoardVO.groupEndPageNo}"
                    step="1" var="p">
                    <li class="${p eq searchMyBoardVO.pageNo ? 'active' : ''}">
                      <!-- a href="/mypage/mytour/gd-mytour/${sessionScope._LOGIN_USER_.usrLgnId}?pageNo=${p}" -->
                      <a href="javascript:movePage(${p})">

                        ${p+1}

                      </a>
                    </li>
                  </c:forEach>
                  <c:if test="${searchMyBoardVO.hasNextGroup}">
                    <li>
                      <a href="javascript:movePage(${searchMyBoardVO.nextGroupStartPageNo})">
                        다음
                      </a>
                    </li>
                    <li>
                      <a href="javascript:movePage(${searchMyBoardVO.pageCount - 1})">
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