<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <title>여행자 투어 등록</title>
  <link rel="stylesheet" type="text/css" href="/css/Guide_TourInsert.css" />
</head>

<body>
  <div class="grid">
    <div class="header">
      <!-- header 공통파일 -->
      <jsp:include page="../header.jsp"></jsp:include>
    </div>
    <div class="content">
      <div class="content-grid">
        <div class="where-going">
          <div class="where-search">
            <div class="search-div">
              <div>
                <input id="search" type="text" placeholder="진행할 투어 장소는 어디신가요?" />
              </div>
              <div class="search-btn">
                <img src="/img/tourboard/Search.png" alt="검색 버튼" />
              </div>
            </div>
            <div class="travle-list">
              <ul>
                <li>영국</li>
                <li>베트남 / 다낭</li>
                <li>괌</li>
                <li>일본 / 오사카</li>
                <li>이탈리아</li>
              </ul>
            </div>
          </div>
          <div class="img-div">
            <div class="background-img"></div>
          </div>
        </div>
        <div class="input-div">
          <div class="calendar">
            <h3>원하는 투어 날짜를 입력해주세요!</h3>
            <div class="datepicker">
              <div class="datepicker-top">
                <div class="month-selector">
                  <button class="arrow">
                    <i class="material-icons">&lt;</i>
                  </button>
                  <span class="month-name">December 2020</span>
                  <button class="arrow">
                    <i class="material-icons">&gt;</i>
                  </button>
                </div>
              </div>
              <div class="datepicker-calendar">
                <span class="day">Mo</span>
                <span class="day">Tu</span>
                <span class="day">We</span>
                <span class="day">Th</span>
                <span class="day">Fr</span>
                <span class="day">Sa</span>
                <span class="day">Su</span>
                <button class="date faded">30</button>
                <button class="date">1</button>
                <button class="date">2</button>
                <button class="date">3</button>
                <button class="date">4</button>
                <button class="date">5</button>
                <button class="date">6</button>
                <button class="date">7</button>
                <button class="date">8</button>
                <button class="date">9</button>
                <button class="date">10</button>
                <button class="date">11</button>
                <button class="date">12</button>
                <button class="date">13</button>
                <button class="date">14</button>
                <button class="date">15</button>
                <button class="date">16</button>
                <button class="date">17</button>
                <button class="date">18</button>
                <button class="date">19</button>
                <button class="date">20</button>
                <button class="date">21</button>
                <button class="date">22</button>
                <button class="date">23</button>
                <button class="date">24</button>
                <button class="date">25</button>
                <button class="date">26</button>
                <button class="date">27</button>
                <button class="date">28</button>
                <button class="date">29</button>
                <button class="date">30</button>
                <button class="date">31</button>
                <button class="date faded">1</button>
                <button class="date faded">2</button>
                <button class="date faded">3</button>
              </div>
            </div>
          </div>
          <div class="datetime">
            <div class="start-time">
              <select name="start-hour" id="start-hour">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
              </select>
              <div>
                <h3>시</h3>
              </div>
              <select name="start-minute" id="start-minute">
                <option value="0">0</option>
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
                <option value="20">20</option>
                <option value="25">25</option>
                <option value="30">30</option>
                <option value="35">35</option>
                <option value="40">40</option>
                <option value="45">45</option>
                <option value="50">50</option>
                <option value="55">55</option>
              </select>
              <div>
                <h3>분</h3>
              </div>
            </div>
            <div class="end-time">
              <select name="end-hour" id="end-hour">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
              </select>
              <div>
                <h3>시</h3>
              </div>
              <select name="end-minute" id="end-minute">
                <option value="0">0</option>
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
                <option value="20">20</option>
                <option value="25">25</option>
                <option value="30">30</option>
                <option value="35">35</option>
                <option value="40">40</option>
                <option value="45">45</option>
                <option value="50">50</option>
                <option value="55">55</option>
              </select>
              <div>
                <h3>분</h3>
              </div>
            </div>
          </div>
          <div class="see-all">
            <div class="user-input">
              <div class="want-to-do">
                <div>
                  <h4>투어테마</h4>
                </div>
                <div>핫플레이스 투어</div>
              </div>
              <div class="place">
                <div>
                  <h4>장소</h4>
                </div>
                <div>Danang Temple</div>
              </div>
              <div class="meeting-place">
                <div>
                  <h4>만날 장소</h4>
                </div>
                <div></div>
              </div>
              <div class="requset">
                <div>
                  <h4>투어제공항목</h4>
                </div>
                <div>
                  1.와이파이</br>
                  2.차량</br>
                  3.물
                </div>
              </div>
              <div class="list">
                <div>
                  <h6>Open In GoogleMap</h6>
                </div>
              </div>
            </div>
            <div class="right-align">
              <input type="submit" value="시간대 선택 완료" />
            </div>
          </div>
        </div>

        <!-- 사진 등록 필드----------------------------------------------------------------------------------------------------------------------- -->
        <div class="photo-view">
          <div class="photo-view-div">
            <img class="guide-photo" src="/img/tourlist/라스베가스 야경.jpg" alt="">
            <img class="big-guide-photo" src="/img/tourlist/라스베가스 카지노.jpeg" alt="">
            <img class="guide-photo" src="/img/tourlist/라스베가스 호텔.jpg" alt="">
            <img class="guide-photo" src="/img/tourlist/베트남 퀴논 해변.jpg" alt="">
            <img class="guide-photo" src="/img/tourlist/별하늘.jpg" alt="">
          </div>
          <div class="photo">
            <div class="right-align">
              <input type="submit" value="사진등록" />
            </div>
          </div>
        </div>
        <!-- 사진 등록 필드----------------------------------------------------------------------------------------------------------------------- -->




        <div class="final-view">
          <div class="final-view-div">
            <div class="group-one">
              <div>
                <h3>베트남 / 다낭</h3>
              </div>
              <div>
                <h3>투어 테마</h3>
              </div>
              <div>
                <h3>2024-10-30 12:30 ~ 14:30</h3>
              </div>
            </div>
            <div class="group-two">
              <div>만날장소 : 다낭 / Radisson Hotel</div>
              <div>
                <h6>Open In GoogleMap</h6>
              </div>
            </div>
            <div class="group-three">
              <h2>투어상세정보</h2>
              <p>
                내가 꼴리는데로 진행할테니 따라오기나 해
              </p>
            </div>
            <div class="group-four">
              <div>
                <h2>투어요약</h2>
                <p>12:30 - 만남</p>
                <p>13:00 - 출발</p>
                <p>14:30 - 종료</p>
              </div>
              <div class="select-container">

              </div>
            </div>
          </div>
          <div class="price">
            <div class="guide-price">
              <div>투어 비용 :</div>
              <div><input type="number" min="0" value="0" /></div>
              <div>$</div>
            </div>
            <div class="right-align">
              <input type="submit" value="투어등록" />
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