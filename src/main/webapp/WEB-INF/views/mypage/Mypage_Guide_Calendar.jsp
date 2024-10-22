<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>MATE 일정관리(변경예정)</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/Mypage_Guide_Calendar.css"
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
                <h2>일정</h2>
              </div>
            </div>

            <div class="border-line"></div>
            <!-- 캘린더 -->
            <div class="calendar">
              <!-- 년도 선택 P태그는 추후에 바꿔야 한다. -->
              <div class="year-flex">
                <p class="year-minus"></p>
                <span class="year">2024</span>
                <p class="year-plus"></p>
              </div>

              <!-- 월 선택  마찬가지로 p 태그는 추후 바꿔야한다.-->
              <div class="month-flex">
                <p class="month-minus"></p>
                <span class="month">09</span>
                <p class="month-plus"></p>
              </div>

              <div class="weekname-flex">
                <h3>Sun</h3>
                <h3>Mon</h3>
                <h3>Tue</h3>
                <h3>Wed</h3>
                <h3>Thu</h3>
                <h3>Fri</h3>
                <h3>Sat</h3>
              </div>

              <!-- flex버전 일정 보이기 위한 것에서 답이 안나와서 grid로 해보기로 함 -->
              <!-- <div class="days">
                <div class="week">
                  <div class="day-cell"><div class="day">1</div></div>
                  <div class="day-cell"><div class="day">2</div></div>
                  <div class="day-cell"><div class="day">3</div></div>
                  <div class="day-cell"><div class="day">4</div></div>
                  <div class="day-cell"><div class="day">5</div></div>
                  <div class="day-cell"><div class="day">6</div></div>
                  <div class="day-cell"><div class="day">7</div></div>
                </div>

                <div class="week">
                  <div class="day-cell"><div class="day">8</div></div>
                  <div class="day-cell"><div class="day">9</div></div>
                  <div class="day-cell"><div class="day">10</div></div>
                  <div class="day-cell"><div class="day">11</div></div>
                  <div class="day-cell"><div class="day">12</div></div>
                  <div class="day-cell"><div class="day">13</div></div>
                  <div class="day-cell"><div class="day">14</div></div>
                </div>

                <div class="week">
                  <div class="day-cell"><div class="day">15</div></div>
                  <div class="day-cell"><div class="day">16</div></div>
                  <div class="day-cell"><div class="day">17</div></div>
                  <div class="day-cell"><div class="day">18</div></div>
                  <div class="day-cell"><div class="day">19</div></div>
                  <div class="day-cell"><div class="day">20</div></div>
                  <div class="day-cell"><div class="day">21</div></div>
                </div>

              <div class="week">
                <div class="day-cell"><div class="day">22</div></div>
                <div class="day-cell"><div class="day">23</div></div>
                <div class="day-cell"><div class="day today">24</div></div>
                <div class="day-cell"><div class="day">25</div></div>
                <div class="day-cell"><div class="day">26</div></div>
                <div class="day-cell"><div class="day">27</div></div>
                <div class="day-cell"><div class="day">28</div></div>
              </div>

              <div class="week">
                <div class="day-cell"><div class="day">29</div></div>
                <div class="day-cell"><div class="day">30</div></div>
                <div class="day-cell"><div class="day">31</div></div>
                <div class="day-cell"><div class="day">1</div></div>
                <div class="day-cell"><div class="day">2</div></div>
                <div class="day-cell"><div class="day">3</div></div>
                <div class="day-cell"><div class="day">4</div></div>
              </div>

              <div class="week">
                <div class="day-cell"><div class="day">5</div></div>
                <div class="day-cell"><div class="day">6</div></div>
                <div class="day-cell"><div class="day">7</div></div>
                <div class="day-cell"><div class="day">8</div></div>
                <div class="day-cell"><div class="day">9</div></div>
                <div class="day-cell"><div class="day">10</div></div>
                <div class="day-cell"><div class="day">11</div></div>
              </div>
            </div> -->

              <div class="days">
                <div class="day">1</div>
                <div class="day schedule1-start">2</div>
                <div class="day schedule1">3</div>
                <div class="day schedule1">4</div>
                <div class="day schedule1-end">5</div>
                <div class="day">6</div>
                <div class="day">7</div>

                <div class="day">8</div>
                <div class="day">9</div>
                <div class="day">10</div>
                <div class="day">11</div>
                <div class="day">12</div>
                <div class="day">13</div>
                <div class="day">14</div>

                <div class="day">15</div>
                <div class="day">16</div>
                <div class="day">17</div>
                <div class="day">18</div>
                <div class="day">19</div>
                <div class="day">20</div>
                <div class="day">21</div>

                <div class="day">22</div>
                <div class="day">23</div>
                <div class="day schedule2-start">
                  <div class="today">24</div>
                </div>
                <div class="day schedule2">25</div>
                <div class="day schedule2">26</div>
                <div class="day schedule2">27</div>
                <div class="day schedule2-endweek">28</div>

                <div class="day schedule2-end">29</div>
                <div class="day">30</div>
                <div class="day">31</div>
                <div class="day">1</div>
                <div class="day">2</div>
                <div class="day">3</div>
                <div class="day">4</div>

                <div class="day">5</div>
                <div class="day">6</div>
                <div class="day">7</div>
                <div class="day">8</div>
                <div class="day">9</div>
                <div class="day">10</div>
                <div class="day">11</div>
              </div>
            </div>

            <div class="border-line">
              <h2>일정 추가</h2>
            </div>
            <!-- 백엔드를 위해서 여기에 form 을 넣어야 함 -->
            <form action="">
              <div class="add-schedule">
                <div class="schedule-flex">
                  <div>일정 시작</div>

                  <div class="schedule-content">
                    <select name="start-year" id="start-year">
                      년
                    </select>
                    <div>년</div>
                    <select name="start-month" id="start-mointh">
                      월
                    </select>
                    <div>월</div>
                    <select name="start-day" id="start-day">
                      일
                    </select>
                    <div>일</div>
                    <select name="start-hour" id="start-hour">
                      시
                    </select>
                    <div>:</div>
                    <select name="start-min" id="start-min">
                      분
                    </select>
                  </div>
                </div>
                <div class="schedule-flex">
                  <div>일정 종료</div>

                  <div class="schedule-content">
                    <select name="end-year" id="end-year">
                      년
                    </select>
                    <div>년</div>
                    <select name="end-month" id="end-mointh">
                      월
                    </select>
                    <div>월</div>
                    <select name="end-day" id="end-day">
                      일
                    </select>
                    <div>일</div>
                    <select name="end-hour" id="end-hour">
                      시
                    </select>
                    <div>:</div>
                    <select name="end-min" id="end-min">
                      분
                    </select>
                  </div>
                </div>

                <div class="schedule-flex">
                  <div>일정 내용</div>

                  <div class="schedule-content-text">
                    <textarea
                      name="content-text"
                      id="content-text"
                      class="content-text"
                    ></textarea>
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
            </form>
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
