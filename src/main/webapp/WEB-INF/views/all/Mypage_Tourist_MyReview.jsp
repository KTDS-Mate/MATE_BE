<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Mypage_Tourist_MyReview</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/Mypage_Tourist_MyReview.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/common.css"
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
              <li>나의 리뷰</li>
              <li>결제 내역</li>
              <li>내 정보 수정</li>
              <li>메세지</li>
            </ul>
          </div> -->
          <div class="my-tour">
            <div class="tour-list-top">
              <div>
                <h2>나의 리뷰</h2>
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
                      <div>제목 : Tour tham quan chùa Đà Nẵng</div>
                      <div>가이드 : Jimmy Nguyễn</div>
                      <div>지역 : 다낭 / Danang Temple</div>
                      <div>날짜 : 2024-10-09 10:30 ~ 15:30</div>
                      <div>평점 : ★★★★☆</div>
                      <div>내용</div>
                      <div>
                        가이드가 한국말도 잘 하고 매우 친절했어요! 아쉬웠던 점은
                        설명이 부족한 것 같았어요 ㅠㅠ
                      </div>
                    </div>
                    <div class="right-align">[삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : Tour tham quan chùa Đà Nẵng</div>
                      <div>가이드 : Jimmy Nguyễn</div>
                      <div>지역 : 다낭 / Danang Temple</div>
                      <div>날짜 : 2024-10-09 10:30 ~ 15:30</div>
                      <div>평점 : ★★★★☆</div>
                      <div>내용</div>
                      <div>
                        가이드가 한국말도 잘 하고 매우 친절했어요! 아쉬웠던 점은
                        설명이 부족한 것 같았어요 ㅠㅠ
                      </div>
                    </div>
                    <div class="right-align">[삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : Tour tham quan chùa Đà Nẵng</div>
                      <div>가이드 : Jimmy Nguyễn</div>
                      <div>지역 : 다낭 / Danang Temple</div>
                      <div>날짜 : 2024-10-09 10:30 ~ 15:30</div>
                      <div>평점 : ★★★★☆</div>
                      <div>내용</div>
                      <div>
                        가이드가 한국말도 잘 하고 매우 친절했어요! 아쉬웠던 점은
                        설명이 부족한 것 같았어요 ㅠㅠ
                      </div>
                    </div>
                    <div class="right-align">[삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : Tour tham quan chùa Đà Nẵng</div>
                      <div>가이드 : Jimmy Nguyễn</div>
                      <div>지역 : 다낭 / Danang Temple</div>
                      <div>날짜 : 2024-10-09 10:30 ~ 15:30</div>
                      <div>평점 : ★★★★☆</div>
                      <div>내용</div>
                      <div>
                        가이드가 한국말도 잘 하고 매우 친절했어요! 아쉬웠던 점은
                        설명이 부족한 것 같았어요 ㅠㅠ
                      </div>
                    </div>
                    <div class="right-align">[삭제]</div>
                  </div>
                </div>
                <div class="list-item">
                  <div class="grid-item">
                    <div class="flex">
                      <div>제목 : Tour tham quan chùa Đà Nẵng</div>
                      <div>가이드 : Jimmy Nguyễn</div>
                      <div>지역 : 다낭 / Danang Temple</div>
                      <div>날짜 : 2024-10-09 10:30 ~ 15:30</div>
                      <div>평점 : ★★★★☆</div>
                      <div>내용</div>
                      <div>
                        가이드가 한국말도 잘 하고 매우 친절했어요! 아쉬웠던 점은
                        설명이 부족한 것 같았어요 ㅠㅠ
                      </div>
                    </div>
                    <div class="right-align">[삭제]</div>
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
