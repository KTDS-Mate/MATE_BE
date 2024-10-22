<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>MATE 즐겨찾기</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/Mypage_Tourist_Wishlist.css"
    />
  </head>
  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <div class="header">
          <!-- header 공통파일 -->
          <jsp:include page="../header.jsp"></jsp:include>
        </div>
        <div class="content-grid">
          <!-- side-bar 공통파일 -->
          <jsp:include page="../sidebar.jsp"></jsp:include>
          <!-- 수정이 예정 되어있음 -->
          <!-- 좌측의 네비게이션 바 -->
          <!-- <div class="my-page">
            <ul class="list">
              <li>캘린더</li>
              <li>즐겨찾기</li>
              <li>나의 등록 투어</li>
              <li>매출 관리</li>
              <li>내 정보 수정</li>
              <li>메세지</li>
            </ul>
          </div> -->
          <!-- 좌측 네비게이션 바 -->

          <div class="main-content">
            <div class="content-title">
              <div>
                <h2>즐겨찾기</h2>
              </div>
            </div>

            <div class="wishlist">
              <!-- 즐겨찾기 전체 박스-->
              <div>
                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="check"
                        src="/image/wishlist/check.png"
                        alt="check"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">퀘백 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241020 14:00 ~ 241020 18:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">퀘백</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">250,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="activate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->

                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="check"
                        src="/image/wishlist/check.png"
                        alt="check"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">서울 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241025 10:00 ~ 241025 15:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">서울</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">200,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="deactivate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->
                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="uncheck"
                        src="/image/wishlist/uncheck.png"
                        alt="uncheck"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">서울 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241025 10:00 ~ 241025 15:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">서울</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">200,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="activate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->
                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="check"
                        src="/image/wishlist/check.png"
                        alt="check"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">서울 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241025 10:00 ~ 241025 15:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">서울</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">200,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="activate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->

                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="check"
                        src="/image/wishlist/check.png"
                        alt="check"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">서울 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241025 10:00 ~ 241025 15:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">서울</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">200,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="activate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->
                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="uncheck"
                        src="/image/wishlist/uncheck.png"
                        alt="uncheck"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">서울 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241025 10:00 ~ 241025 15:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">서울</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">200,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="activate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->
                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="check"
                        src="/image/wishlist/check.png"
                        alt="check"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">서울 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241025 10:00 ~ 241025 15:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">서울</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">200,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="activate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->
                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="check"
                        src="/image/wishlist/check.png"
                        alt="check"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">서울 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241025 10:00 ~ 241025 15:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">서울</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">200,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="activate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->
                <!-- 즐겨찾기 하나 -->
                <div class="one-wishlist">
                  <div class="right-element">
                    <div>
                      <img
                        class="uncheck"
                        src="/image/wishlist/uncheck.png"
                        alt="uncheck"
                      />
                    </div>
                    <div class="wishlist-info">
                      <div>
                        <div>제목 :</div>
                        <div class="info-content">서울 안내해드립니다.</div>
                      </div>
                      <div>
                        <div>날짜 :</div>
                        <div class="info-content">
                          241025 10:00 ~ 241025 15:30
                        </div>
                      </div>
                      <div>
                        <div>지역 :</div>
                        <div class="info-content">서울</div>
                      </div>
                      <div>
                        <div>가격 :</div>
                        <div class="info-content">200,000 WON</div>
                      </div>
                    </div>
                  </div>
                  <div class="goto-button">
                    <button class="deactivate">페이지 이동</button>
                  </div>
                </div>
                <!-- 즐겨찾기 하나 -->
              </div>
              <!-- pagenation-->
              <div class="paging">
                <p class="page-minus"></p>
                <div>1</div>
                <!-- 한 페이지 못 채워서 나머지는 생략
                <div>2</div>
                <div>3</div>
                <div>4</div>
                <div>5</div>
                -->
                <p class="page-plus"></p>
              </div>
            </div>
          </div>
        </div>
        <div class="footer">
          <!-- footer 공통파일 -->
          <jsp:include page="../footer.jsp"></jsp:include>
        </div>
      </div>
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>
</html>
