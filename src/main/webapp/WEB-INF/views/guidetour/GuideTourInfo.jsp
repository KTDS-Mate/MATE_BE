<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/guidetour/GuideTourInfo.css"
    />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script
      type="text/javascript"
      src="/js/guidetour/tourReviewCarousel.js"
    ></script>
    <script
      type="text/javascript"
      src="/js/guidetour/guideReviewCarousel.js"
    ></script>
    <script
      type="text/javascript"
      src="/js/guidetour/guidetourInfo.js"
    ></script>
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
            <input
              class="ttl-wb"
              type="hidden"
              data-gd-pst-id="${guideTourVO.gdTrPstId}"
            />
            <h1>${guideTourVO.gdTrTtl}</h1>
            <div class="wish-button"></div>
          </div>
          <!-- <div class="reviewWriteModal hidden"> -->
          <jsp:include page="Modal.jsp" />
          <div class="firstLayer">
          	<c:choose>
          		<c:when test="${guideTourVO.guideImgCount == 0}">
          			<div class="bigOneImgArea">
		              <div class="oneImgArea btn-open-pic-modal" data-img-url="/img/tourlist/기본이미지.png">
		                <img src="/img/tourlist/기본이미지.png" alt="기본 이미지" />
		              </div>
		            </div>
          		</c:when>
          		<c:when test="${guideTourVO.guideImgCount == 1}">
          			<div class="bigOneImgArea">
		              <div class="oneImgArea btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[0].gdTrImgUrl}">
		                <img src="${guideTourVO.guideTourImgList[0].gdTrImgUrl}" alt="사진 1" />
		              </div>
		            </div>
          		</c:when>
          		<c:when test="${guideTourVO.guideImgCount == 2}">
          			<div class="tourPicArea">
		              <div class="twoImgArea1 btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[0].gdTrImgUrl}">
		                <img src="${guideTourVO.guideTourImgList[0].gdTrImgUrl}" alt="사진 1" />
		              </div>
		              <div class="twoImgArea2 btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[1].gdTrImgUrl}">
		                  <img class="brs" src="${guideTourVO.guideTourImgList[1].gdTrImgUrl}" alt="사진 1" />
		              </div>
		            </div>
          		</c:when>
          		<c:when test="${guideTourVO.guideImgCount == 3}">
          			<div class="tourPicArea">
		              <div class="bigPicArea btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[0].gdTrImgUrl}">
		                <img src="${guideTourVO.guideTourImgList[0].gdTrImgUrl}" alt="사진 1" />
		              </div>
		              <div class="smallPicAreas">
		                <div class="threeImgArea1 btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[1].gdTrImgUrl}">
		                  <img class="brs" src="${guideTourVO.guideTourImgList[1].gdTrImgUrl}" alt="사진 1" />
		                </div>
		                <div class="threeImgArea2 btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[2].gdTrImgUrl}">
		                  <img src="${guideTourVO.guideTourImgList[2].gdTrImgUrl}" alt="사진 2" />
		                </div>
		              </div>
		            </div>
          		</c:when>
          		<c:otherwise>
          			<div class="tourPicArea">
		              <div class="bigPicArea btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[0].gdTrImgUrl}">
		                <img src="${guideTourVO.guideTourImgList[0].gdTrImgUrl}" alt="사진 1" />
		              </div>
		              <div class="smallPicAreas">
		                <div class="smallPicArea btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[1].gdTrImgUrl}">
		                  <img class="brs" src="${guideTourVO.guideTourImgList[1].gdTrImgUrl}" alt="사진 1" />
		                </div>
		                <div class="smallPicArea btn-open-pic-modal" data-img-url="${guideTourVO.guideTourImgList[2].gdTrImgUrl}">
		                  <img src="${guideTourVO.guideTourImgList[2].gdTrImgUrl}" alt="사진 2" />
		                </div>
		                <div class="morePicArea">
		                  <img class="beforeImg" src="${guideTourVO.guideTourImgList[3].gdTrImgUrl}" alt="사진 3" />
		                  <img class="opacityImg" src="/img/tourlist/불투명처리.png" alt="사진 불투명 처리" />
		                  <img
		                    class="plusImgBtn"
		                    src="/img/tourboard/MorePicButton.png"
		                    alt="더보기 버튼"
		                  />
		                </div>
		              </div>
		            </div>
          		</c:otherwise>
          	</c:choose>
            <div class="priceArea">
              <div class="priceTitleArea">
                <span>Price</span>
              </div>
              <div class="priceDetailArea">
                <div class="hour">
                  <h4 class="maxNp">최대 인원 : ${guideTourVO.gdTrMxNp} 명</h4>
                </div>
                <div class="price">
                  <span>${guideTourVO.gdTrPrc} $</span>
                </div>
                <c:if test="${sessionScope._LOGIN_USER_.usrIsGd eq 'N'}">
                  <div class="reserveButton">
                    <span onclick="location.href='index.html'">예약 요청</span>
                  </div>
                </c:if>
              </div>
            </div>
          </div>
          <div class="secondLayer">
            <div class="tourSummaryArea">
              <div class="summaryTitleArea">
                <span>투어 요약</span>
                <h3 class="showDetail" onclick="location.href='index.html'">
                  상세보기
                </h3>
              </div>
              <div class="summaryDetailArea">
                <h4>
                  ${guideTourVO.countriesVO.countryName} /
                  ${guideTourVO.citiesVO.cityName}
                </h4>
                <h5>${guideTourVO.gdTrStDt} ~ ${guideTourVO.gdTrEdDt}</h5>
                <h1>${guideTourVO.gdTrSmry}</h1>
              </div>
            </div>
            <div class="guideProfileArea">
              <div class="profileTitleArea">
                <span>가이드 프로필</span>
                <h3 class="showDetail" onclick="location.href='index.html'">
                  상세보기
                </h3>
              </div>
              <div class="profileDetailArea">
                <img
                  src="${guideTourVO.userVO.gdPrflImg}"
                  onerror="this.onerror=null; this.src='/img/guide/가이드 샘플 사진.png';"
                  alt="가이드 사진"
                />
                <div class="profileSummaryArea">
                  <c:choose>
                    <c:when test="${guideTourVO.userVO.usrGndr == 'male'}">
                      <h1>성별 : 남자</h1>
                    </c:when>
                    <c:otherwise>
                      <h1>성별 : 여자</h1>
                    </c:otherwise>
                  </c:choose>
                  <h1>
                    이름 : ${guideTourVO.userVO.usrLnm}
                    ${guideTourVO.userVO.usrFnm}
                  </h1>
                  <h1>나이 : 만 ${guideTourVO.guideAge} 세</h1>
                  <h1>가이드 경력 : ${guideTourVO.userVO.usrGdExp} 번</h1>
                </div>
              </div>
            </div>
          </div>
          <div class="thirdLayer">
            <div class="tourOfferArea">
              <div class="offerTitleArea">
                <span>투어에서 제공하는 것</span>
                <h3 class="showDetail" onclick="location.href='index.html'">
                  상세보기
                </h3>
              </div>
              <div class="offerDetailArea">
                <c:forEach
                  items="${guideTourVO.guideTourProvidedList}"
                  var="guideTourProvidedVO"
                >
                  <h1>${guideTourProvidedVO.trIncld}</h1>
                </c:forEach>
              </div>
            </div>
          </div>
          <div class="fourthLayer">
            <div class="rallyPointArea">
              <div class="rallyPointTitleArea">
                <span>집결 장소</span>
                <h3 class="showDetail" onclick="location.href='index.html'">
                  상세보기
                </h3>
              </div>
              <div class="rallyPointDetailArea">
                <div class="summaryArea">
                  <div class="rallyPointSummaryArea">
                    <h1>${guideTourVO.gdTrMp}</h1>
                  </div>
                </div>
                <div class="mapApiArea">
                  <span>Google Map</span>
                  <div class="apiArea"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="fifthLayer">
            <div class="tourInfoArea">
              <div class="tourInfoTitleArea">
                <span>투어 세부 일정</span>
                <!--  <h3 class="showDetail" onclick="location.href='index.html'">
                  상세보기
                </h3>-->
              </div>
              <div class="tourInfoDetailArea">
                <ul class="hope-info-list">
                  <c:choose>
                    <c:when
                      test="${not empty guideTourVO.guideTourScheduleInfoList && not empty guideTourVO.guideTourScheduleInfoList[0].trDtlLct}"
                    >
                      <c:forEach
                        items="${guideTourVO.guideTourScheduleInfoList}"
                        var="guideTourScheduleInfoVO"
                        varStatus="index"
                      >
                        <li>
                          <div class="list-item">
                            <span class="background-num">
                              ${index.index + 1}</span
                            >
                            ${guideTourScheduleInfoVO.trDtlLct}
                          </div>
                          <div class="border-left">
                            ${guideTourScheduleInfoVO.trDtlSchd}
                          </div>
                        </li>
                      </c:forEach>
                    </c:when>
                    <c:otherwise>
                      <li>
                        <p>작성된 세부 일정이 없습니다.</p>
                      </li>
                    </c:otherwise>
                  </c:choose>
                </ul>
              </div>
            </div>
          </div>
          <div class="fifthLayer">
            <div class="tourInfoArea">
              <div class="tourInfoTitleArea">
                <span>투어 추가 정보</span>
                <h3 class="showDetail" onclick="location.href='index.html'">
                  상세보기
                </h3>
              </div>
              <div class="tourInfoDetailArea">
                <div class="tourInfoSummaryArea">
                  <ul class="plus-inf">
                    <c:forEach
                      items="${guideTourVO.guideTourDetailInfoList}"
                      var="guideTourDetailInfoVO"
                    >
                      <li>${guideTourDetailInfoVO.trDtlInf}</li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <div class="sixthLayer">
            <div class="touristPicArea">
              <div class="touristPicTitleArea">
                <span>여행자 투어 사진</span>
                <h3 class="showDetail" onclick="location.href='index.html'">
                  상세보기
                </h3>
              </div>
              <div class="touristPicDetailArea">
                <div class="touristPicturesArea">
                  <div class="touristBigPicArea btn-open-pic-modal">
                    <img src="/public/일본.jpg" alt="큰 사진1" />
                  </div>
                  <div class="touristSmallPicAreas">
                    <div class="touristSmallPicArea btn-open-pic-modal">
                      <img src="/public/일본.jpg" alt="작은 사진1" />
                    </div>
                    <div class="touristSmallPicArea btn-open-pic-modal">
                      <img src="/public/일본.jpg" alt="작은 사진2" />
                    </div>
                    <div class="touristSmallPicArea btn-open-pic-modal">
                      <img src="/public/일본.jpg" alt="작은 사진3" />
                    </div>
                    <div
                      class="touristMorePicArea"
                      onclick="location.href='index.html'"
                    >
                      <h1>+ 999</h1>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="seventhLayer">
            <div class="tourReviewArea">
              <div class="tourReviewTitleArea">
                <span>투어 평점 및 후기</span>
                <div class="titleButtons">
                  <h2 class="writeReview btn-open-review-modal">후기 작성</h2>
                </div>
              </div>
              <div class="tourReviewDetailArea">
                <div class="tourReviewRatingArea">
                  <div class="averageRatingArea">
                    <img
                      src="/public/Star.png"
                      alt="별점 아이콘"
                      class="bigStar"
                    />
                    <c:choose>
                      <c:when
                        test="${not empty reviewList.guideTourReviewList && not empty reviewList.guideTourReviewList[0].reviewAvg}"
                      >
                        <span class="averageRating"
                          >${reviewList.guideTourReviewList[0].reviewAvg}</span
                        >
                      </c:when>
                      <c:otherwise>
                        <span class="averageRating"> 0 </span>
                      </c:otherwise>
                    </c:choose>
                  </div>
                  <div class="ratingArea">
                    <div class="ratingFiveArea">
                      <img src="/public/Star.png" alt="별점 5점" class="star" />
                      <span class="rating">5</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="${reviewList.guideTourReviewList[0].sumCount}"
                        value="${reviewList.guideTourReviewList[0].fiveCount}"
                      ></meter>
                      <span class="ratingCount"
                        >${reviewList.guideTourReviewList[0].fiveCount}</span
                      >
                    </div>
                    <div class="ratingFourArea">
                      <img src="/public/Star.png" alt="별점 4점" class="star" />
                      <span class="rating">4</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="${reviewList.guideTourReviewList[0].sumCount}"
                        value="${reviewList.guideTourReviewList[0].fourCount}"
                      ></meter>
                      <span class="ratingCount"
                        >${reviewList.guideTourReviewList[0].fourCount}</span
                      >
                    </div>
                    <div class="ratingThreeArea">
                      <img src="/public/Star.png" alt="별점 3점" class="star" />
                      <span class="rating">3</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="${reviewList.guideTourReviewList[0].sumCount}"
                        value="${reviewList.guideTourReviewList[0].threeCount}"
                      ></meter>
                      <span class="ratingCount"
                        >${reviewList.guideTourReviewList[0].threeCount}</span
                      >
                    </div>
                    <div class="ratingTwoArea">
                      <img src="/public/Star.png" alt="별점 2점" class="star" />
                      <span class="rating">2</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="${reviewList.guideTourReviewList[0].sumCount}"
                        value="${reviewList.guideTourReviewList[0].twoCount}"
                      ></meter>
                      <span class="ratingCount"
                        >${reviewList.guideTourReviewList[0].twoCount}</span
                      >
                    </div>
                    <div class="ratingOneArea">
                      <img src="/public/Star.png" alt="별점 1점" class="star" />
                      <span class="rating">1</span>
                      <meter
                        class="ratingGage"
                        min="0"
                        max="${reviewList.guideTourReviewList[0].sumCount}"
                        value="${reviewList.guideTourReviewList[0].oneCount}"
                      ></meter>
                      <span class="ratingCount"
                        >${reviewList.guideTourReviewList[0].oneCount}</span
                      >
                    </div>
                  </div>
                </div>
                <div class="reviewsArea">
                  <div class="reviewCarouselArea">
                    <img
                      src="/public/forward.png"
                      alt="이전 버튼"
                      class="reviewForwardButton"
                    />
                    <div class="reviewCarousel">
                      <c:forEach
                        items="${reviewList.guideTourReviewList}"
                        var="reviews"
                      >
                        <div class="reviewArea">
                          <div class="smallReviewArea">
                            <div class="someoneReviewFirstArea">
                              <c:choose>
                                <c:when test="${reviews.gdTrRvwRtng eq 1}">
                                  <img
                                    src="/public/Star.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                  <img
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                  <img
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                  <img
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                  <img
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                </c:when>
                                <c:when test="${reviews.gdTrRvwRtng eq 2}">
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
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                  <img
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                  <img
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                </c:when>
                                <c:when test="${reviews.gdTrRvwRtng eq 3}">
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
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                  <img
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                </c:when>
                                <c:when test="${reviews.gdTrRvwRtng eq 4}">
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
                                    src="/public/StarOff.png"
                                    alt="별점 아이콘"
                                    class="starTwo"
                                  />
                                </c:when>
                                <c:otherwise>
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
                                </c:otherwise>
                              </c:choose>
                              <span class="someoneReviewTitleArea"
                                >${reviews.gdTrRvwTtl}</span
                              >
                            </div>
                            <div class="someoneReviewSecondArea">
                              <span class="reviewWriterArea"
                                >${reviews.userVO.usrLnm}
                                ${reviews.userVO.usrFnm}</span
                              >
                              <span class="reviewWritingDate"
                                >${reviews.gdTrRvwCrtdat}</span
                              >
                            </div>
                          </div>
                          <div class="reviewTextArea">
                            <span>${reviews.gdTrRvwCntnt}</span>
                          </div>
                        </div>
                      </c:forEach>

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
                      class="reviewBackwardButton"
                    />
                  </div>
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
  </body>
</html>
