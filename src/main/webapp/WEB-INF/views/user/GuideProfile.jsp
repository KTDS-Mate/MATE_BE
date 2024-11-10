<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" href="/css/user/GuideProfile.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/guidetour/guideReviewCarousel.js"></script>
  </head>
  <body>
    <div class="grid">
      <!--  -->
      <div class="header">
          <!-- 헤더 공통파일 -->
          <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <!--  -->
  
      <div class="content">
        <div class="container">
          <div class="title">
            <h1>가이드 프로필 상세 조회</h1>
          </div>
          <jsp:include page="../guidetour/Modal.jsp" />
          <div class="firstLayer">
            <div class="guidePicArea">
              <img src="/public/가이드 샘플 사진.jpg" alt="가이드 사진" class="guidePicture">
              <img src="/public/가이드 인증 마크.png" alt="가이드 인증 마크" class="guideAuthMark">
            </div>
            <div class="guideProfileArea">
              <div class="guideProfileTitleArea">
                <span>가이드 프로필</span>
                <img src="/public/guide/ChatButton.png" alt="채팅 보내기 버튼" class="guideProfileChatButton">
              </div>
              <div class="guideProfileDetailArea">
                <table class="profileTable">
                  <tr>
                    <th>Name : </th>
                    <td>Yuki</td>
                  </tr>
                  <tr>
                    <th>Gender : </th>
                    <td>Female</td>
                  </tr>
                  <tr>
                    <th>Age : </th>
                    <td>24</td>
                  </tr>
                  <tr>
                    <th>Language : </th>
                    <td>Japanese<br>English</td>
                  </tr>
                </table>
                <img class="profileAreaLine" src="/public/profileAreaLine.png" />
                <table class="profileTable">
                  <tr>
                    <th>Experience : </th>
                    <td>12</td>
                  </tr>
                  <tr>
                    <th>Country : </th>
                    <td>Japan</td>
                  </tr>
                  <tr>
                    <th>License : </th>
                    <td>International<br>Guide License</td>
                  </tr>
                  <tr>
                    <th>Area : </th>
                    <td>Japan<br>U.S.A</td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
          <div class="secondLayer">
            <div class="guideReviewArea">
              <div class="guideReviewTitleArea">
                <span>가이드 평점 및 후기</span>
                <div class="titleButtons">
                  <h2 class="writeReview btn-open-review-modal">후기 작성</h2>
                  <h3 class="showDetail btn-open-review-list-modal">
                    모두 보기
                  </h3>
                </div>
              </div>
              <div class="guideReviewDetailArea">
                <div class="guideReviewRatingArea">
                  <div class="averageRatingArea">
                    <img
                      src="/public/Star.png"
                      alt="별점 아이콘"
                      class="bigStar"
                    />
                    <span class="averageRating">4.8</span>
                  </div>
                  <div class="ratingArea">
                    <div class="ratingFiveArea">
                      <img src="/public/Star.png" alt="별점 5점" class="star" />
                      <span class="rating">5</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="100"
                        value="90"
                      ></meter>
                      <span class="ratingCount">4834</span>
                    </div>
                    <div class="ratingFourArea">
                      <img src="/public/Star.png" alt="별점 4점" class="star" />
                      <span class="rating">4</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="100"
                        value="4"
                      ></meter>
                      <span class="ratingCount">124</span>
                    </div>
                    <div class="ratingThreeArea">
                      <img src="/public/Star.png" alt="별점 3점" class="star" />
                      <span class="rating">3</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="100"
                        value="3"
                      ></meter>
                      <span class="ratingCount">50</span>
                    </div>
                    <div class="ratingTwoArea">
                      <img src="/public/Star.png" alt="별점 2점" class="star" />
                      <span class="rating">2</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="100"
                        value="2"
                      ></meter>
                      <span class="ratingCount">20</span>
                    </div>
                    <div class="ratingOneArea">
                      <img src="/public/Star.png" alt="별점 1점" class="star" />
                      <span class="rating">1</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="100"
                        value="1"
                      ></meter>
                      <span class="ratingCount">10</span>
                    </div>
                  </div>
                </div>
                <div class="guideReviewsArea">
                  <div class="guideReviewCarouselArea">
                    <img
                      src="/public/forward.png"
                      alt="이전 버튼"
                      class="guideReviewForwardButton"
                    />
                    <div class="guideReviewCarousel">
                      <div class="guideReviewOneArea">
                        <div class="smallReviewArea">
                          <div class="someoneReviewFirstArea">
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <span class="someoneReviewTitleArea"
                              >Amazing Day!</span
                            >
                          </div>
                          <div class="someoneReviewSecondArea">
                            <span class="reviewWriterArea">RainyMoon</span>
                            <span class="reviewWritingDate">SEP.2024</span>
                          </div>
                        </div>
                        <div class="reviewTextArea">
                          <span>Harry is an Amazing Guide!!</span>
                        </div>
                      </div>
                      <div class="guideReviewOneArea">
                        <div class="smallReviewArea">
                          <div class="someoneReviewFirstArea">
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <span class="someoneReviewTitleArea"
                              >Amazing Day!</span
                            >
                          </div>
                          <div class="someoneReviewSecondArea">
                            <span class="reviewWriterArea">RainyMoon</span>
                            <span class="reviewWritingDate">SEP.2024</span>
                          </div>
                        </div>
                        <div class="reviewTextArea">
                          <span>Harry is an Amazing Guide!!</span>
                        </div>
                      </div>
                      <div class="guideReviewOneArea">
                        <div class="smallReviewArea">
                          <div class="someoneReviewFirstArea">
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <img
                              src="/public/Star.png"
                              alt="별점 아이콘"
                              class="starTwo"
                            />
                            <span class="someoneReviewTitleArea"
                              >Amazing Day!</span
                            >
                          </div>
                          <div class="someoneReviewSecondArea">
                            <span class="reviewWriterArea">RainyMoon</span>
                            <span class="reviewWritingDate">SEP.2024</span>
                          </div>
                        </div>
                        <div class="reviewTextArea">
                          <span>Harry is an Amazing Guide!!</span>
                        </div>
                      </div>
                      <div
                        class="moreReviewListButtonArea btn-open-review-list-modal"
                      >
                        <div class="smallReviewArea">
                          <img
                            src="/public/plusicon.png"
                            alt="더 보기 버튼"
                            class="moreReviewButton"
                          />
                        </div>
                        <div class="moreReviewTextArea">
                          <span>모든 리뷰 목록 보기</span>
                        </div>
                      </div>
                    </div>
                    <img
                      src="/public/backward.png"
                      alt="다음 버튼"
                      class="guideReviewBackwardButton"
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="thirdLayer">
            <div class="reservableTourListArea">
              <div class="reservableTourListTitleArea">
                <span>현재 신청 가능한 투어 프로그램</span>
                <div class="titleButtons">
                  <h3 class="showDetail" onclick="location.href='index.html'">
                    상세 보기
                  </h3>
                </div>
              </div>
              <div class="reservableTourListDetailArea">
                <div class="oneTourArea" onclick="location.href='index.html'">
                  <img src="/public/Prefix_2.png" alt="목차 아이콘" class="prefixIcon">
                  <span class="oneTourTitle">Let's try Tokyo's famous Restaurant!</span>
                  <div class="spendTime">
                    <img src="/public/clock.png" alt="시계 아이콘" class="clock">
                    <span class="howManyHour">6</span>
                    <span>Hour</span>
                  </div>
                </div>
                <div class="oneTourArea" onclick="location.href='index.html'">
                  <img src="/public/Prefix_2.png" alt="목차 아이콘" class="prefixIcon">
                  <span class="oneTourTitle">Let's try Tokyo's famous Restaurant!</span>
                  <div class="spendTime">
                    <img src="/public/clock.png" alt="시계 아이콘" class="clock">
                    <span class="howManyHour">6</span>
                    <span>Hour</span>
                  </div>
                </div>
                <div class="oneTourArea" onclick="location.href='index.html'">
                  <img src="/public/Prefix_2.png" alt="목차 아이콘" class="prefixIcon">
                  <span class="oneTourTitle">Let's try Tokyo's famous Restaurant!</span>
                  <div class="spendTime">
                    <img src="/public/clock.png" alt="시계 아이콘" class="clock">
                    <span class="howManyHour">6</span>
                    <span>Hour</span>
                  </div>
                </div>
                <div class="oneTourArea" onclick="location.href='index.html'">
                  <img src="/public/Prefix_2.png" alt="목차 아이콘" class="prefixIcon">
                  <span class="oneTourTitle">Let's try Tokyo's famous Restaurant!</span>
                  <div class="spendTime">
                    <img src="/public/clock.png" alt="시계 아이콘" class="clock">
                    <span class="howManyHour">6</span>
                    <span>Hour</span>
                  </div>
                </div>
                <div class="oneTourArea" onclick="location.href='index.html'">
                  <img src="/public/Prefix_2.png" alt="목차 아이콘" class="prefixIcon">
                  <span class="oneTourTitle">Let's try Tokyo's famous Restaurant!</span>
                  <div class="spendTime">
                    <img src="/public/clock.png" alt="시계 아이콘" class="clock">
                    <span class="howManyHour">6</span>
                    <span>Hour</span>
                  </div>
                </div>
                <div class="oneTourArea" onclick="location.href='index.html'">
                  <img src="/public/Prefix_2.png" alt="목차 아이콘" class="prefixIcon">
                  <span class="oneTourTitle">Let's try Tokyo's famous Restaurant!</span>
                  <div class="spendTime">
                    <img src="/public/clock.png" alt="시계 아이콘" class="clock">
                    <span class="howManyHour">6</span>
                    <span>Hour</span>
                  </div>
                </div>
                <div class="oneTourArea" onclick="location.href='index.html'">
                  <img src="/public/Prefix_2.png" alt="목차 아이콘" class="prefixIcon">
                  <span class="oneTourTitle">Let's try Tokyo's famous Restaurant!</span>
                  <div class="spendTime">
                    <img src="/public/clock.png" alt="시계 아이콘" class="clock">
                    <span class="howManyHour">6</span>
                    <span>Hour</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="fourthLayer">
            <div class="contactArea">
              <div class="contactTitleArea">
                <span>Contact</span>
              </div>
              <div class="contactDetailArea">
                <table class="emmailAndPhoneNum">
                  <tr>
                    <th>E-mail : </th>
                    <td>yuki01@gmail.com</td>
                  </tr>
                  <!-- <tr>
                    <th>Phone-num : </th>
                    <td>+82) 10-0000-0000</td>
                  </tr> -->
                </table>
                <!-- <table class="SNS">
                  <tr>
                    <th>SNS : </th>
                    <td>LINE ID - yuki01<br>X ID - @yuki01</td>
                  </tr>
                </table> -->
              </div>
            </div>
          </div>
          <div class="fifthLayer">
            <div class="informationArea">
              <div class="informationTitleArea">
                <span>소개글</span>
              </div>
              <div class="informationDetailArea">
                <div class="informtaionTextArea">
                  <span>
                    Lorem Ipsum is simply dummy text of the printing and
                    typesetting industry. Lorem Ipsum has been the industry's
                    standard dummy text ever since the 1500s, when an unknown
                    printer took a galley of type and scrambled it to make a type
                    specimen book. It has survived not only five centuries, but also
                    the leap into electronic typesetting, remaining essentially
                    unchanged. It was popularised in the 1960s with the release of
                    Letraset sheets containing Lorem Ipsum passages, and more
                    recently with desktop publishing software like Aldus PageMaker
                    including versions of Lorem Ipsum.
                  </span>
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
  
  </div>
  </body>
</html>

