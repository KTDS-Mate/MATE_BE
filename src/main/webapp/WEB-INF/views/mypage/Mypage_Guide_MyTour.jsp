<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Mypage_Guide_MyTour</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/Mypage_Guide_MyTour.css"
    />
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
          <jsp:include page="../sidebar.jsp"></jsp:include>

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
          <div class="my-tour">
            <div class="tour-list-top">
              <div>
                <h2>투어 목록</h2>
              </div>
              <div>
                <h5>
                  <span class="gray"
                    >예약중인 투어는 수정 및 삭제를 할 수 없습니다!</span
                  >
                </h5>
              </div>
            </div>
            <div class="border"></div>
            <div class="tour-list">
              <div class="search-area">
                <div class="sort-button"><h3>날짜 순 ↓</h3></div>
                <input
                  id="search-content"
                  type="text"
                  placeholder="찾고 싶은 투어를 검색해 주세요."
                />
                <div class="search-button"><h3>검색</h3></div>
              </div>
              <div class="list-area">
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : 오사카 숨은 맛집 탐방</div>
                      <div>날짜 : 2024-10-20 09:00 ~ 21:30</div>
                      <div>지역 : 일본 / Osaka</div>
                      <div>예약 상태 : 예약중</div>
                    </div>
                    <div class="right-align">[수정] / [삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : 오사카 숨은 맛집 탐방</div>
                      <div>날짜 : 2024-10-20 09:00 ~ 21:30</div>
                      <div>지역 : 일본 / Osaka</div>
                      <div>예약 상태 : 예약중</div>
                    </div>
                    <div class="right-align">[수정] / [삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : 오사카 숨은 맛집 탐방</div>
                      <div>날짜 : 2024-10-20 09:00 ~ 21:30</div>
                      <div>지역 : 일본 / Osaka</div>
                      <div>예약 상태 : 예약중</div>
                    </div>
                    <div class="right-align">[수정] / [삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : 오사카 숨은 맛집 탐방</div>
                      <div>날짜 : 2024-10-20 09:00 ~ 21:30</div>
                      <div>지역 : 일본 / Osaka</div>
                      <div>예약 상태 : 예약중</div>
                    </div>
                    <div class="right-align">[수정] / [삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : 오사카 숨은 맛집 탐방</div>
                      <div>날짜 : 2024-10-20 09:00 ~ 21:30</div>
                      <div>지역 : 일본 / Osaka</div>
                      <div>예약 상태 : 예약중</div>
                    </div>
                    <div class="right-align">[수정] / [삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : 오사카 숨은 맛집 탐방</div>
                      <div>날짜 : 2024-10-20 09:00 ~ 21:30</div>
                      <div>지역 : 일본 / Osaka</div>
                      <div>예약 상태 : 예약중</div>
                    </div>
                    <div class="right-align">[수정] / [삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : 오사카 숨은 맛집 탐방</div>
                      <div>날짜 : 2024-10-20 09:00 ~ 21:30</div>
                      <div>지역 : 일본 / Osaka</div>
                      <div>예약 상태 : 예약중</div>
                    </div>
                    <div class="right-align">[수정] / [삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : 오사카 숨은 맛집 탐방</div>
                      <div>날짜 : 2024-10-20 09:00 ~ 21:30</div>
                      <div>지역 : 일본 / Osaka</div>
                      <div>예약 상태 : 예약중</div>
                    </div>
                    <div class="right-align">[수정] / [삭제]</div>
                  </div>
                </div>
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
