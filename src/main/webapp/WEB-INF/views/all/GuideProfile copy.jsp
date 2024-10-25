<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="/css/GuideProfile copy.css" />
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
          <div class="guideInfoArea">
            <div class="guidePicArea">
              <img src="/public/가이드 샘플 사진.jpg" alt="가이드 사진" />
            </div>
            <div class="guideProfileArea">
              <div class="guideProfileTitleArea">
                <span>가이드 프로필</span>
                <img src="/public/guide/ChatButton.png" onClick="location.href='index.html'" alt="채팅 버튼" />
              </div>
              <div class="guideProfileDetailArea">
                <!-- 하단에 있는 테이블들의 td 를 실제 db 값으로 수정해야함. -->
                <table class="guideDetailTable">
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
                    <th>Language: </th>
                    <td>Japanese<br>English</td>
                  </tr>
                </table>
                <div class="seperateLine">
                  <img src="/public/seperateLine.png" alt="구분선">
                </div>
                <table class="guideDetailTable">
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
                    <th>Area: </th>
                    <td>Japan<br>U.S.A</td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
          <div class="guideReviewArea">
            <div class="guideReviewTitleArea">
              <span>가이드 평점 및 후기</span>
              <h3 class="showDetail" onclick="location.href='index.html'">상세보기</h3>
            </div>
            <div class="guideReviewDetailArea">
              <div class="averageRatingArea">
                <img src="/public/Star 1.png" alt="별점 아이콘" class="star">
                <span class="averageRating">4.8</span>
              </div>
              <div class="ratingArea">
                <div class="ratingFiveArea">
                  <img src="/public/Star 1.png" alt="별점 5점" class="star">
                  <span class="rating">5</span>
                  <meter class="ratingGage" min="0" max="100" value="90"></meter>
                  <span class="ratingCount">4834</span>
                </div>
                <div class="ratingFourArea">
                  <img src="/public/Star 1.png" alt="별점 4점" class="star">
                  <span class="rating">4</span>
                  <meter class="ratingGage" min="0" max="100" value="4"></meter>
                  <span class="ratingCount">124</span>
                </div>
                <div class="ratingThreeArea">
                  <img src="/public/Star 1.png" alt="별점 3점" class="star">
                  <span class="rating">3</span>
                  <meter class="ratingGage" min="0" max="100" value="3"></meter>
                  <span class="ratingCount">50</span>
                </div>
                <div class="ratingTwoArea">
                  <img src="/public/Star 1.png" alt="별점 2점" class="star">
                  <span class="rating">2</span>
                  <meter class="ratingGage" min="0" max="100" value="2"></meter>
                  <span class="ratingCount">20</span>
                </div>
                <div class="ratingOneArea">
                  <img src="/public/Star 1.png" alt="별점 1점" class="star">
                  <span class="rating">1</span>
                  <meter class="ratingGage" min="0" max="100" value="1"></meter>
                  <span class="ratingCount">10</span>
                </div>
              </div>
              <div class="reviewArea">
                
              </div>
            </div>
              
            </div>
            <div class="guideTourListArea">현재 신청 가능한 투어 프로그램</div>
            <div class="guideContactArea">Contact</div>
            <div class="guideInformationArea">소개글</div>
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

