<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8" />
    <title>MATE 즐겨찾기</title>
    <link rel="stylesheet" type="text/css" href="/css/mypage/Mypage_Tourist_Wishlist.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet">
     <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/mypage/Mypage_Tourist_Wishlist.js"></script>
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

          <!-- 좌측 네비게이션 바 -->

          <div class="main-content">
            <div class="content-title">
            
              <div>
                <h2>즐겨찾기</h2>
              </div>
              
              <div>
                  <h5>
                    <span class="gray">즐겨찾기 등록한 게시글리스트입니다. (하트 클릭시 즐겨찾기가 삭제됩니다)</span>
                  </h5>
                </div>
              
            </div>
            
            <div class="border"></div>

            <div class="wishlist">
            <input type="hidden" name="pageNo" class="page-no" value="${paginationVO.pageNo}">
              <!-- 즐겨찾기 전체 박스-->
              <div>
              
              <c:choose>
              <c:when test="${not empty trWishlistVO.wishlist}">
              <c:forEach  items="${trWishlistVO.wishlist}" var="wish">
              <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <a href="javascript:deleteTour('${sessionScope._LOGIN_USER_.usrLgnId}', '${wish.favId}')"><img class="check" src="/img/wishlist/check.png" alt="check"/></a>
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">${wish.trMyBoardVO.usrTrTtl}</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          ${wish.trMyBoardVO.usrTrStDt} ~ ${wish.trMyBoardVO.usrTrEdDt}
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">
                        ${wish.trMyBoardVO.searchCityAndCountryVO.countriesVO.countryName} /
                                ${wish.trMyBoardVO.searchCityAndCountryVO.cityName}
                        </div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">
                        ${wish.trMyBoardVO.usrTrGdHrPrc}
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="activate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->
              </c:forEach>
              </c:when>
              <c:otherwise>
              <div class="one-wishlist">
                        <div class="right-element">
                          <div class="wishlist-info">
                            <div>게시글이 없습니다.</div>
                          </div>
                        </div>
                      </div>
              </c:otherwise>
              </c:choose>
                

                
              </div>
              <!-- pagenation-->
              <ul class="page-nav">
                  <c:if test="${paginationVO.hesprevGroup}">
                    <li>
                      <!-- <a href="/board/list?pageNo=0&listSize=${searchMyBoardVO.listSize}"> -->
                      <a href="javascript:movePage(0)">
                        처음
                      </a>
                    </li>
                    <li>
                      <a href="javascript:movePage(${paginationVO.prevGroupStartPageNo})">
                        이전
                      </a>
                    </li>
                  </c:if>
                  <c:forEach begin="${paginationVO.groupStartPageNo}" end="${paginationVO.groupEndPageNo}"
                    step="1" var="p">
                    <li class="${p eq paginationVO.pageNo ? 'active' : ''}">
                      <!-- a href="/mypage/mytour/gd-mytour/${sessionScope._LOGIN_USER_.usrLgnId}?pageNo=${p}" -->
                      <a href="javascript:movePage(${p})">

                        ${p+1}

                      </a>
                    </li>
                  </c:forEach>
                  <c:if test="${paginationVO.hasNextGroup}">
                    <li>
                      <a href="javascript:movePage(${paginationVO.nextGroupStartPageNo})">
                        다음
                      </a>
                    </li>
                    <li>
                      <a href="javascript:movePage(${paginationVO.pageCount - 1})">
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
        <!-- footer 공통파일-->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>

  </html>