<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8" />
      <title>Mypage_Guide_MyTour</title>
      <link rel="stylesheet" type="text/css" href="/css/Mypage_Guide_MyTour.css" />
      <link rel="stylesheet" type="text/css" href="/css/common.css" />
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link
        href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
        rel="stylesheet">
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
                <div class="search-area">
                  <div class="sort-button">
                    <h3>날짜 순 ↓</h3>
                  </div>
                  <input id="search-content" type="text" placeholder="찾고 싶은 투어를 검색해 주세요." />
                  <div class="search-button">
                    <h3>검색</h3>
                  </div>
                </div>
                <div class="list-area">

                  <c:choose>
                    <c:when test="${not empty boardListVO.boardList}">
                      <c:forEach items="${boardListVO.boardList}" var="board">
                        <div class="list-item">
                          <div class="grid-item">
                            <div class="flex">
                              <div>제목 : ${board.gdTrTtl}</div>
                              <div>날짜 : ${board.gdTrStDt} ~ ${board.gdTrEdDt}</div>
                              <div>지역 : 일본 / Osaka</div>
                              <div>예약 상태 : 예약중</div>
                            </div>
                            <div class="right-align">
                              <a href="">수정</a>
                              /
                              <a href="/mypage/mytour/gd-mytour/delete-${board.gdTrPstId}">삭제</a>
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
                <div class="page">
                  <div>1</div>
                  <div>2</div>
                  <div>3</div>
                  <div>4</div>
                  <div>5</div>
                  <div>6</div>
                  <div>7</div>
                  <div>8</div>
                  <div>9</div>
                </div>
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