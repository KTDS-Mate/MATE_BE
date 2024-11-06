<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8" />
    <title>MATE 일정관리(변경예정)</title>
    <link rel="stylesheet" type="text/css" href="/css/mypage/Mypage_Guide_Calendar.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet">
      
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
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
          <!-- 수정이 예정 되어있음 -->
          <!-- 좌측의 네비게이션 바 -->
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
          <!-- 좌측 네비게이션 바 -->

          <div class="main-content">
            <div class="content-title">
              <div>
                <h2>일정</h2>
              </div>
            </div>

            <div class="border-line"></div>
            <!-- 캘린더 -->
            <div class="calendar">
              <jsp:include page="./GuideCalendar.jsp"></jsp:include>
            </div>

            <div class="border-line">
              <h2>일정 추가</h2>
            </div>
            <!-- 백엔드를 위해서 여기에 form 을 넣어야 함 -->
            
            
            <form:form modelAttribute="writeBoardVO" method="post" enctype="multipart/form-data">
            
              <div class="add-schedule">
                <div class="schedule-flex">
                  <div>일정 시작</div>

                  <div class="schedule-content">
                    <select class="select" name="start-year" id="start-year">
                      <option>2024</option>
                    </select>
                    <div>년</div>
                    <select class="select" name="start-month" id="start-mointh">
                      <option>1</option>
                    </select>
                    <div>월</div>
                    <select class="select" name="start-day" id="start-day">
                      <option>1</option>
                    </select>
                    <div>일</div>
                    <select class="select" name="start-hour" id="start-hour">
                      <option>00</option>
                    </select>
                    <div>:</div>
                    <select class="select" name="start-min" id="start-min">
                     <option>00</option>
                    </select>
                  </div>
                </div>
                <div class="schedule-flex">
                  <div>일정 종료</div>

                  <div class="schedule-content">
                    <select name="end-year" id="end-year">
                      <option>2024</option>
                    </select>
                    <div>년</div>
                    <select name="end-month" id="end-mointh">
                      <option>1</option>
                    </select>
                    <div>월</div>
                    <select name="end-day" id="end-day">
                      <option>1</option>
                    </select>
                    <div>일</div>
                    <select name="end-hour" id="end-hour">
                      <option>00</option>
                    </select>
                    <div>:</div>
                    <select name="end-min" id="end-min">
                      <option>00</option>
                    </select>
                  </div>
                </div>

                <div class="schedule-flex">
                  <div>일정 내용</div>

                  <div class="schedule-content-text">
                    <textarea name="content-text" id="content-text" class="content-text"></textarea>
                  </div>
                </div>

                <div class="color-flex">
                  <div>캘린더 표시 색상</div>

                  <div class="color-select">
                    <div class="yellow"></div>
                    <div class="green"></div>
                    <div class="pink"></div>
                    <div class="beige"></div>
                    <div class="mint"></div>
                    <div class="purple"></div>
                  </div>
                </div>
                <div class="schedule-add-button">
                  <input type="submit" class="schedule-submit" value="추가" />
                </div>
              </div>
            </form:form>
            
            
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