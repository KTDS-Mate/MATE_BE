<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>가이드 투어 상세보기</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/GuideRecruitmentPage.css"
    />
  </head>
  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <div class="grid-rows">
          <div class="subject">
            <div>
              <h3>${userTourVO.usrTrTtl}</h3>
            </div>
            <div class="wish-button"></div>
          </div>
          <div class="img-price">
            <div class="img-group">
              <div class="main-img">1</div>
              <div class="second-img">2</div>
              <div class="third-img">3</div>
              <div class="plus-img">4</div>
            </div>
            <div class="price-group">
              <div class="price-for">
                <h2>Price</h2>
              </div>
              <div class="price-person">
                <div class="price-ad-c">
                  <h2>${userTourVO.usrTrGdHrPrc}$</h2>
                </div>
              </div>
            </div>
          </div>
          <div class="summation-guide">
            <div class="summation">
              <div class="view-dtls">
                <h2>투어 요청 요약</h2>
                <a href="">
                  <h6>상세보기</h6>
                </a>
              </div>
              <div>
                <ol class="summation-list">
                  <li>즐겁고 재미난 투어</li>
                  <li>현지 가이드와 함께하는 투어</li>
                  <li>눈이 즐거운 투어</li>
                  <li>음식이 맛있는 투어</li>
                </ol>
              </div>
            </div>
            <div class="summation">
              <div class="view-dtls">
                <h2>희망 가이드</h2>
                <a href="">
                  <h6>상세보기</h6>
                </a>
              </div>
              <div>
                <ul class="guide-dtls-list">
                  <li>성별 : 여자</li>
                  <li>나이 : 20대</li>
                  <li>가이드 경력 : 10회 이상</li>
                </ul>
              </div>
            </div>
          </div>
          <div class="want-tour">
            <div class="want-list">
              <div class="view-dtls">
                <h2>투어에서 원하는 것</h2>
                <a href="">
                  <h6>상세보기</h6>
                </a>
              </div>
              <div>
                <ol class="summation-list">
                  <li>즐겁고 재미난 투어</li>
                  <li>현지 가이드와 함께하는 투어</li>
                  <li>눈이 즐거운 투어</li>
                  <li>음식이 맛있는 투어</li>
                </ol>
              </div>
            </div>
          </div>
          <div class="want-time">
            <div class="want-time-place">
              <div class="view-dtls">
                <h2>집결 희망 장소 / 시간</h2>
              </div>
              <div class="margin-left">
                <h2>
                  ${userTourVO.usrTrMp}
                </h2>
                <div class="flex-div">
                  <div><h3>${userTourVO.usrTrDt}</h3></div>
                  <div class="margin-right"><h4>Open In GoogleMap</h4></div>
                </div>
              </div>
            </div>
          </div>
          <div class="want-tour">
            <div class="hope-info">
              <div class="view-dtls">
                <h2>투어 희망 정보</h2>
              </div>
              <div>
                <ul class="hope-info-list">
                  <li>
                    <p class="list-item">
                      <span class="background-num">1</span> 테라스 기요미즈 도쿄
                    </p>
                    <p class="border-left">
                      숙소에서 자차로 픽업해서 사원까지 데려다 주세요
                    </p>
                  </li>
                  <li>
                    <p class="list-item">
                      <span class="background-num">2</span> 기요미즈데라 사원
                    </p>
                    <p class="border-left">
                      사원에 가서 일본인들이 즐기는 체험과 전통 문화를 경험하고
                      싶어요
                    </p>
                  </li>
                  <li>
                    <p class="list-item">
                      <span class="background-num">3</span> 기요미즈데라 사원
                    </p>
                    <p class="border-left">
                      기요미즈데라 사원 근처의 맛집에서 맛있는 음식과 술을
                      마시고 싶어요
                    </p>
                  </li>
                  <li>
                    <p class="list-item">
                      <span class="background-num">4</span> 테라스 기요미즈 도쿄
                    </p>
                    <p class="margin-left">숙소까지 데려다 주세요</p>
                  </li>
                </ul>
                <a href="">&lt;show more&gt;</a>
              </div>
            </div>
          </div>
          <div class="want-time">
            <div class="plus-info">
              <div class="view-dtls">
                <h2>추가 정보</h2>
              </div>
              <div class="margin-left">
                <h2>Etc...</h2>
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
