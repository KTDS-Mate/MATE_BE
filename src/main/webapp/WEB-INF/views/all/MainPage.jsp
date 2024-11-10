
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <title>MATE</title>
    <link rel="stylesheet" type="text/css" href="/css/main/MainPage.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/main/mainPictureCarousel.js"></script>
    <script type="text/javascript" src="/js/main/recommendCities.js"></script>
  </head>
  <body>
    <div class="grid">
      <!--  -->
      <div class="header">
          <!-- 헤더 공통파일 -->
          <jsp:include page="./MainHeader.jsp"></jsp:include>
      </div>
      <!--  -->
  
      <div class="content">
        <div class="container">
            <jsp:include page="./destinationSelectModal.jsp" />
            <jsp:include page="./calendarModal.jsp" />
            <div class="firstLayer">
                <div class="mainPictureCarouselArea" data-bs-ride="carousel">
                    <img
                    src="/public/mainForward.png"
                    alt="이전 버튼"
                    class="picForwardButton"
                    />
                    <div class="centerArea">
                      <div class="mainPicTextArea">
                        <div class="touristText">
                          <span>Meet Your Guide</span>
                          <h1>Make Your Tour</h1>
                        </div>
                        <div class="guideText hidden">
                          <span>Find Your Tourist</span>
                        </div>
                      </div>
                      <div class="menuArea">

                        <div class="userTypeArea">
                          <div class="touristButton">
                            <span onclick="selected">Tourist</span>
                          </div>
                          <div class="guideButton">
                            <span>Guide</span>
                          </div>
                        </div>
                        <div class="whenWhereArea">
                          <div class="where">
                            <h2>Where</h2>
                            <p></p>
                            <h3></h3>
                          </div>
                          <div class="when">
                            <h2>When</h2>
                            <div class="whenSelectArea">
                              <h3> </h3>
                            </div>
                          </div>
                        </div>

                      </div>
                      <div class="tourSearchButton">
                        <h2 class="tourSearchButtonText">Search</h2>
                      </div>
                    </div>
                    <img
                    src="/public/mainBackward.png"
                    alt="다음 버튼"
                    class="picBackwardButton"
                  />
                  <div class="mainPictureCarousel">
                    <div class="picAreas">
                      <div class="picArea">
                        <div class="picAreaItem">
                          <img src="/public/MainPic1.png" alt="대문사진1">
                        </div>
                      </div>
                      <div class="picArea">
                        <div class="picAreaItem">
                          <img src="/public/MainPic2.png" alt="대문사진2">
                        </div>
                      </div>
                      <div class="picArea">
                        <div class="picAreaItem">
                          <img src="/public/MainPic3.png" alt="대문사진3">
                        </div>
                      </div>
                      <div class="picArea">
                        <div class="picAreaItem">
                          <img src="/public/MainPic4.png" alt="대문사진4">
                        </div>
                      </div>
                      <div class="picArea">
                        <div class="picAreaItem">
                          <img src="/public/MainPic5.png" alt="대문사진5">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              
            <div class="secondLayer">
                <div class="reasonTextArea">
                    <span>Why MATE?</span>
                </div>
                <div class="reasonsArea">
                    <div class="reasonOneArea">
                        <img src="/public/1번여행사진.png" alt="이유사진1">
                        <span>유니크한 투어</span>
                        <div class="reasonDetailArea">
                            현지 가이드만이 제공하는<br>유니크한 투어를 경험해 보세요!
                        </div>
                    </div>
                    <div class="reasonOneArea">
                        <img src="/public/2번여행사진.png" alt="이유사진1">
                        <span>공정한 가격, 모두를 위한 혜택</span>
                        <div class="reasonDetailArea">
                            가이드, 여행자가 직접 투어 금액을 설정합니다.<br>투명하고 합리적인 여행을 경험하세요!
                        </div>
                    </div>
                    <div class="reasonOneArea">
                        <img src="/public/5번여행사진.png" alt="이유사진1">
                        <span>나만의 특별한 여행</span>
                        <div class="reasonDetailArea">
                            여행자님의 취향과 일정이 반영된<br>나만의 특별한 여행을 설계해 보세요!
                        </div>
                    </div>
                </div>
            </div>
            <div class="thirdLayer">
              <h2>실시간 주문 폭주 여행지</h2>
              <div class="recommendCitiesAreaWrapper">
                <div class="recommendCitiesAreaOne">

                </div>
              </div>
            </div>
            
            <div class="borderLine"></div>

            <div class="fourthLayer">
              <h2>이 달의 핫플 여행지</h2>
              <div class="recommendCitiesAreaWrapper">
                <div class="recommendCitiesAreaTwo">
                  
                </div>
              </div>
            </div>
            
            <div class="borderLine"></div>
            
            <div class="fifthLayer">
              <h2>맛있는 음식이 있는 여행지</h2>
              <div class="recommendCitiesAreaWrapper">
                <div class="recommendCitiesAreaThree">
                  
                </div>
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
  
  </div>
  </body>
</html>

