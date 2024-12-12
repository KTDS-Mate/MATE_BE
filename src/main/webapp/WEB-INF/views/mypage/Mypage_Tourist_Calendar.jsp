<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <title>MATE 일정관리(변경예정)</title>
    <link rel="stylesheet" type="text/css" href="/css/mypage/Mypage_Tourist_Calendar.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

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
              <jsp:include page="./TourristCalendar.jsp"></jsp:include>
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
                  	<input type="date">
       
                    <select class="select" name="start-hour" id="start-hour">
                      <option>00</option>
                      <option>01</option>
                      <option>02</option>
                      <option>03</option>
                      <option>04</option>
                      <option>05</option>
                      <option>06</option>
                      <option>07</option>
                      <option>08</option>
                      <option>09</option>
                      <option>10</option>
                      <option>11</option>
                      <option>12</option>
                      <option>13</option>
                      <option>14</option>
                      <option>15</option>
                      <option>16</option>
                      <option>17</option>
                      <option>18</option>
                      <option>19</option>
                      <option>20</option>
                      <option>21</option>
                      <option>22</option>
                      <option>23</option>
                    </select>
                    <div>:</div>
                    <select class="select" name="start-min" id="start-min">
                     <option>00</option>
                     <option>01</option>
                     <option>02</option>
                     <option>03</option>
                     <option>04</option>
                     <option>05</option>
                     <option>06</option>
                     <option>07</option>
                     <option>08</option>
                     <option>09</option>
                     <option>10</option>
                     <option>11</option>
                     <option>12</option>
                     <option>13</option>
                     <option>14</option>
                     <option>15</option>
                     <option>16</option>
                     <option>17</option>
                     <option>18</option>
                     <option>19</option>
                     <option>20</option>
                     <option>21</option>
                     <option>22</option>
                     <option>23</option>
                     <option>24</option>
                     <option>25</option>
                     <option>26</option>
                     <option>27</option>
                     <option>28</option>
                     <option>29</option>
                     <option>30</option>
                     <option>31</option>
                     <option>32</option>
                     <option>33</option>
                     <option>34</option>
                     <option>35</option>
                     <option>36</option>
                     <option>37</option>
                     <option>38</option>
                     <option>39</option>
                     <option>40</option>
                     <option>41</option>
                     <option>42</option>
                     <option>43</option>
                     <option>44</option>
                     <option>45</option>
                     <option>46</option>
                     <option>47</option>
                     <option>48</option>
                     <option>49</option>
                     <option>50</option>
                     <option>51</option>
                     <option>52</option>
                     <option>53</option>
                     <option>54</option>
                     <option>55</option>
                     <option>56</option>
                     <option>57</option>
                     <option>58</option>
                     <option>59</option>
                    </select>
                  </div>
                </div>
                <div class="schedule-flex">
                  <div>일정 종료</div>

                  <div class="schedule-content">
                    <input type="date">
       
                    <select class="select" name="start-hour" id="start-hour">
                      <option>00</option>
                      <option>01</option>
                      <option>02</option>
                      <option>03</option>
                      <option>04</option>
                      <option>05</option>
                      <option>06</option>
                      <option>07</option>
                      <option>08</option>
                      <option>09</option>
                      <option>10</option>
                      <option>11</option>
                      <option>12</option>
                      <option>13</option>
                      <option>14</option>
                      <option>15</option>
                      <option>16</option>
                      <option>17</option>
                      <option>18</option>
                      <option>19</option>
                      <option>20</option>
                      <option>21</option>
                      <option>22</option>
                      <option>23</option>
                    </select>
                    <div>:</div>
                    <select class="select" name="start-min" id="start-min">
                     <option>00</option>
                     <option>01</option>
                     <option>02</option>
                     <option>03</option>
                     <option>04</option>
                     <option>05</option>
                     <option>06</option>
                     <option>07</option>
                     <option>08</option>
                     <option>09</option>
                     <option>10</option>
                     <option>11</option>
                     <option>12</option>
                     <option>13</option>
                     <option>14</option>
                     <option>15</option>
                     <option>16</option>
                     <option>17</option>
                     <option>18</option>
                     <option>19</option>
                     <option>20</option>
                     <option>21</option>
                     <option>22</option>
                     <option>23</option>
                     <option>24</option>
                     <option>25</option>
                     <option>26</option>
                     <option>27</option>
                     <option>28</option>
                     <option>29</option>
                     <option>30</option>
                     <option>31</option>
                     <option>32</option>
                     <option>33</option>
                     <option>34</option>
                     <option>35</option>
                     <option>36</option>
                     <option>37</option>
                     <option>38</option>
                     <option>39</option>
                     <option>40</option>
                     <option>41</option>
                     <option>42</option>
                     <option>43</option>
                     <option>44</option>
                     <option>45</option>
                     <option>46</option>
                     <option>47</option>
                     <option>48</option>
                     <option>49</option>
                     <option>50</option>
                     <option>51</option>
                     <option>52</option>
                     <option>53</option>
                     <option>54</option>
                     <option>55</option>
                     <option>56</option>
                     <option>57</option>
                     <option>58</option>
                     <option>59</option>
                    </select>
                  </div>
                </div>

                <div class="schedule-flex">
                  <div>일정 내용</div>

                  <div class="schedule-content-text">
                    <textarea name="content-text" id="content-text" class="content-text" maxlength="20" placeholder="일정내용은 20자이내로 제한됩니다."></textarea>
                  </div>
                </div>
				<!-- 
                <div class="color-flex">
                  <div>테두리 표시 색상</div>

                  <div class="color-select">
                    <div class="yellow"></div>
                    <div class="green"></div>
                    <div class="pink"></div>
                    <div class="beige"></div>
                    <div class="mint"></div>
                    <div class="purple"></div>
                  </div>
                </div>
                 -->
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