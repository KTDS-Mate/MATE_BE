
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="/css/main/MainPage.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/main/mainPictureCarousel.js"></script>
    <script type="text/javascript" src="/js/main/userTypeSelected.js"></script>
    <script type="text/javascript" src="/js/main/topDestinations.js"></script>
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
                <div class="mainPictureCarouselArea" data-bs-ride="carousel"> <!-- wrapper -->
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
                                        <h3>  </h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tourSearchButton">
                            <h2 class="tourSearchButtonText">Search</h2>
                        </div>
                    </div>
                    <img
                    src="/public/mainForward.png"
                    alt="이전 버튼"
                    class="picForwardButton"
                    />
                    <div class="mainPictureCarousel"> <!-- carousel-list-->
                        <div class="picArea"> <!-- carousel-container -->
                            <div class="picAreaItem"> <!-- carousel-item -->
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
                    <img
                    src="/public/mainBackward.png"
                    alt="다음 버튼"
                    class="picBackwardButton"
                    />
                </div>
            </div>
            <div class="secondLayer">
                <div class="reasonTextArea">
                    <span>Why MATE?</span>
                </div>
                <div class="reasonsArea">
                    <div class="reasonOneArea">
                        <img src="/public/customerSupport.png" alt="이유사진1">
                        <span>24/7 customer support</span>
                        <div class="reasonDetailArea">
                            No matter the time zone, we're here to help.
                        </div>
                    </div>
                    <div class="reasonOneArea">
                        <img src="/public/Coin.png" alt="이유사진1">
                        <span>Earn rewards</span>
                        <div class="reasonDetailArea">
                            Explore, earn, redeem, and repeat with our loyalty program.
                        </div>
                    </div>
                    <div class="reasonOneArea">
                        <img src="/public/Plan.png" alt="이유사진1">
                        <span>Plan your way</span>
                        <div class="reasonDetailArea">
                            Stay felxible with free cancellation and the option to reserve now and pay later at no additional cost.
                        </div>
                    </div>
                </div>
            </div>
            <div class="thirdLayer">
                <!-- <h1>실시간 인기 여행지 TOP 10</h1>
                <div class="topDestinations" id="topDestinations"></div> -->
            <div class="fourthLayer">

            </div>
            <div class="fifthLayer">

            </div>
        </div>
      </div>
  
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </div>
  
  </div>
  </body>
</html>

