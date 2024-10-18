<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="/css/GuideProfile.css" />
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
        <div class="guideContentFrame">
          <div class="group">
            <h1 class="title">가이드 프로필 상세 조회</h1>
            <div class="guidePicAndProfileArea">
              <div class="guidePicAndAuthArea">
                <div class="guidePicArea">
                  <div class="picWrapper">
                    <div class="pictureArea">
                      <img
                        class="guidePicture"
                        src="/public/가이드 샘플 사진.jpg"
                      />
                    </div>
                  </div>
                </div>

                <img class="authMark" src="/public/가이드 인증 마크.png" />
              </div>
              <div class="guideProfileArea">
                <div class="guideProfileInArea">
                  <div class="littleSubtitleArea">
                    <div class="littleSubtitleInArea">
                      <div class="littleSubtitleBackground"></div>
                      <h2 class="textArea">가이드 프로필</h2>
                      <img class="chatButton" src="/public/guide/ChatButton.png" />
                    </div>
                  </div>
                  <div class="profileContentArea">
                    <div class="profileContentInArea">
                      <div class="nameArea">
                        <input class="name" placeholder=" Name :" type="text" />
                        <h3 class="guideName">Yuki</h3>
                      </div>
                      <div class="genderArea">
                        <div class="gender">Gender :</div>
                        <div class="sex">Female</div>
                      </div>
                      <div class="ageArea">
                        <div class="element">24</div>
                        <div class="age">Age :</div>
                      </div>
                      <div class="languageArea">
                        <div class="language">Language :</div>
                        <div class="japanese-english">Japanese<br />English</div>
                      </div>
                      <div class="experienceArea">
                        <div class="experienceInArea">
                          <div class="experienceCount">12</div>
                          <div class="experience">Experience :</div>
                        </div>
                      </div>
                      <div class="countryArea">
                        <div class="country">Country :</div>
                        <div class="bornCountry">Japan</div>
                      </div>
                      <div class="licenseArea">
                        <div class="licenseNameArea">
                          International<br />Guide License
                        </div>
                        <div class="license">License :</div>
                      </div>
                      <div class="activeAreaArea">
                        <div class="area">Area :</div>
                        <div class="activeCountry">Japan<br />U.S.A</div>
                      </div>
                      <img class="profileAreaLine" src="/public/profileAreaLine.png" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="guideRatingAndReviewArea">
              <div class="subtitleArea">
                <div>
                  <div class="subtitleInArea">
                    <h2 class="textAreaTwo">가이드 평점 및 후기</h2>
                  </div>
                </div>
                <div class="viewMore">상세보기</div>
              </div>
              <div class="guideRatingArea">
                <div class="guideRatingInArea"><div class="rectangle-3"></div></div>
                <div class="main-area">
                  <div class="ratingAvgArea">
                    <img class="star" src="/public/Star 1.png" />
                    <div class="text-wrapper-14">4.8</div>
                  </div>
                  <div class="rating-one">
                    <div class="div-2">
                      <img class="star" src="/public/Star 1.png" />
                      <div class="text-wrapper-14">1</div>
                    </div>
                    <div class="rating-count">0</div>
                    <div class="rating-gage-yellow-wrapper">
                      <div class="rating-gage-yellow"></div>
                    </div>
                  </div>
                  <div class="rating-two">
                    <div class="div-2">
                      <img class="star" src="/public/Star 1.png" />
                      <div class="text-wrapper-14">2</div>
                    </div>
                    <div class="rating-count">0</div>
                    <div class="rating-gage-yellow-wrapper">
                      <div class="rating-gage-yellow"></div>
                    </div>
                  </div>
                  <div class="rating-three">
                    <div class="div-2">
                      <img class="star" src="/public/Star 1.png" />
                      <div class="text-wrapper-14">3</div>
                    </div>
                    <div class="rating-count">1</div>
                    <div class="rating-gage-yellow-wrapper">
                      <div class="rating-gage-yellow-2"></div>
                    </div>
                  </div>
                  <div class="rating-four">
                    <div class="div-2">
                      <img class="star" src="/public/Star 1.png" />
                      <div class="text-wrapper-14">4</div>
                    </div>
                    <div class="rating-count">124</div>
                    <div class="rating-gage-yellow-wrapper">
                      <div class="rating-gage-yellow-3"></div>
                    </div>
                  </div>
                  <div class="rating-five">
                    <div class="div-2">
                      <img class="star" src="/public/Star 1.png" />
                      <div class="text-wrapper-14">5</div>
                    </div>
                    <div class="rating-count">4834</div>
                    <div class="rating-gage-yellow-wrapper">
                      <div class="rating-gage-yellow-4"></div>
                    </div>
                  </div>
                  <div class="review-area">
                    <div class="overlap-8">
                      <div class="overlap-group-6">
                        <div class="review-title">Amazing Day!</div>
                        <div class="review-write-day">SEP. 2024</div>
                      </div>
                      <div class="review-rating">
                        <img class="star-2" src="/public/Star 1.png" />
                        <img class="star-3" src="/public/Star 1.png" />
                        <img class="star-4" src="/public/Star 1.png" />
                        <img class="star-5" src="/public/Star 1.png" />
                        <img class="star-6" src="/public/Star 1.png" />
                      </div>
                      <div class="review-writer">RainyMoon</div>
                      <p class="review-plot-area">Yuki is an Amazing Guide!!</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="canReserveTourListArea">
              <div class="subtitleArea">
                <div class="overlap-group">
                  <div class="rectangle"></div>
                  <p class="text-wrapper">현재 신청 가능한 투어 프로그램</p>
                  <img class="line" src="img/line-7-4.svg" />
                </div>
              </div>
              <div class="overlap-wrapper">
                <div class="overlap">
                  <div class="tour-program-area">
                    <div class="prefix-tourtitlearea">
                      <p class="p">Let’s try Tokyo’s famous Restaurant!</p>
                      <div class="prefix"></div>
                    </div>
                    <div class="spend-time-area">
                      <img class="ic-search-time" src="/public/clock.png" />
                      <div class="text-wrapper-2">6 Hour</div>
                    </div>
                  </div>
                  <div class="tour-program-area-2">
                    <div class="spend-time-area">
                      <img
                        class="ic-search-time"
                        src="/public/clock.png"
                      />
                      <div class="text-wrapper-2">6 Hour</div>
                    </div>
                    <div class="prefix-tourtitlearea">
                      <p class="p">
                        Let’s make good memories with deer at Nara Park!
                      </p>
                      <div class="prefix"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="contactArea">
              <div class="div">
                <div class="overlap-group">
                  <div class="rectangle"></div>
                  <h2 class="textAreaThree">Contact</h2>
                  <img class="line" src="img/line-7.svg" />
                </div>
              </div>
              <div class="overlap-group-wrapper">
                <div class="overlap-2">
                  <div class="e-mailarea">
                    <div class="text-wrapper-5">E-mail :</div>
                    <div class="text-wrapper-6">yuki01@gmail.com</div>
                  </div>
                  <div class="name-area">
                    <div class="text-wrapper-5">SNS :</div>
                    <p class="line-ID">LINE ID - yuki01</p>
                    <p class="x-ID">X ID - @yuki01</p>
                  </div>
                  <div class="phone-num-area">
                    <div class="overlap-group-2">
                      <div class="phone-num">Phone-num:</div>
                      <div class="text-wrapper-8">+8210-0000-0000</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="introductionArea">
              <div class="div">
                <div class="overlap-group">
                  <div class="rectangle"></div>
                  <h2 class="text-wrapper-3">소개글</h2>
                  <img class="line" src="img/line-7-2.svg" />
                </div>
              </div>
              <div class="overlap-wrapper">
                <div class="overlap">
                  <div class="introduction-writing-wrapper">
                    <p class="introduction-writing">
                      Hello!<br />
                      My name is Yuki!<br /><br />
                      I was born in Japan, and I’m native Japanese.<br />
                      If you want imposing memory in Japan,<br />
                      Please Contact me!<br /><br />
                      Have a good day!
                    </p>
                  </div>
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

