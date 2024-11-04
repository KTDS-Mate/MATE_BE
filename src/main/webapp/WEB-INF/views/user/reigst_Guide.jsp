<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>가이드 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/user/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/user/reigst_Guide.css" /> <!-- 여기일단 기본css경로할게요 -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min"></script>
    <script type="text/javascript" src="/js/user/reigst_Guide"></script> <!-- 여기 js경로 지정해주세요 -->
  </head>
  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <div class="main-content">
          <div class="content-title">
            <div>
              <h2>가이드 등록</h2>
            </div>
          </div>
          <!-- <div class="content-grid"> -->
          <!--여기부터 폼 들어가는 부분이다.-->
        <form action="">                        <!--   여기에 백엔드를 위한 form action 등을 적어주세요       -->
          <div class="regist-form">
            <div class="regist-content">
              <div class="sub-content">
                <div class="sub-title">인적 사항</div>
                <div class="form-item">
                    <span>성</span>
                    <span>Shin</span>
                    <!-- 여기가 성이 나오는 부분입니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                </div>
                <div class="form-item">
                  <span>이름</span>
                  <span>Mingyu</span>
                  <!-- 마찬가지로 여기 이름!!!!!!!!!!!!!!!!!!!! -->
                </div>
                <div class="form-item">
                  <span>성별</span>
                  <span>Male</span>
                  <!-- 여기에 성별들어가게 해주세요!!!!!!!!!!!!! -->
                </div>

                <div class="form-item">
                  <!-- 안넣어도 되면 지워주시면 됩니다.-->
                  <span for="birthday">생년월일</span>
                  <span>1999-07-05</span>
                  <!-- durldp birthdayrk skdhaus ehlqslek. -->
                </div>
                <div class="form-item">
                  <span>대표번호</span>
                  <!-- 아래는 input받아올 때-->
                  <!-- 히든으로 region number넣어야하나? 백엔드할 때 수정할 내용 -->
                  <!-- <div>
                      <select name="region-number" id="region-number"></select>
                      <input class="region-number" type="text" value="1012341234" id="phone-number">
                    </div> -->
                  <span>+82 10-1234-5678</span>
                  <!-- 여기에 대표번호 출력해주시면 됩니다. 앞에는 국가코드 -->
                </div>
                <div class="form-item">
                  <span>이메일</span>
                  <span>thdekgka96@naver.com</span>
                  <!-- 여기에 이메일 주세요!!!!!!!!!!!!!!!-->
                </div>
                <div class="form-item">
                  <span>프로필 사진 (jpg, png..)</span>
                  <!-- <input type="file" id="profile"/> -->
                  <div class="filebox">
                    <input class="profile filename" placeholder="첨부파일" />
                    <label class="file-search" for="profile">파일찾기</label>
                    <input type="file" id="profile" value="" />
                  </div>
                </div>
                <div class="form-item">
                  <label for="introduce">자기소개</label>
                  <textarea name="introduce" id="introduce"></textarea>
                </div>
                <div class="form-item">
                  <span>대표 국적</span>
                  <span>대한민국</span>
                  <!-- 여기에 회원의 대표 국적이 나오면 됩니다!!!!!!!!!!-->
                </div>
                <div class="form-item">
                  <label for="active-city">활동 지역</label>
                  <div class="active-city-form">
                    <select name="select-active-city" id="active-city">
                      <option value="ko-seoul">서울</option>
                      <option value="ko-gangnam">강남</option>
                      <option value="ko-gyeonggi">경기</option>
                      <option value="ko-busan">부산</option>
                    </select>
                    <button class="plus-item">지역 추가</button>
                  </div>
                </div>
                <div class="form-item">
                  <span>신분증 사본 (jpg, png, pdf...)</span>
                  <div class="filebox">
                    <input class="idcard-img filename" placeholder="첨부파일" />
                    <label class="file-search" for="idcard-img">파일찾기</label>
                    <input type="file" id="idcard-img" value=""/>
                  </div>
                </div>
              </div>
              <!-- 자격요건 -->
              <div class="sub-content">
                <div class="sub-title">자격요건</div>
                <div class="form-item">
                  <label for="license">라이센스 명</label>
                  <div class="license">
                    <input type="text" placeholder="라이센스 명" />
                    <button class="plus-item">라이센스 추가</button>
                  </div>
                </div>
                <div class="form-item">
                  <span>라이센스 인증서류 (jpg, png, pdf..)</span>
                  <!-- <input type="file" value="license"/> -->
                  <div class="filebox">
                    <input class="license filename" placeholder="첨부파일" />
                    <label class="file-search" for="license">파일찾기</label>
                    <input type="file" id="license" value="" />
                  </div>
                </div>
              </div>
              <!-- 정산 정보 -->
              <div class="sub-content">
                <div class="sub-title">정산 정보</div>
                <div class="form-item">
                  <label for="payfal-email">페이팔 계정</label>
                  <input
                    class="email"
                    type="email"
                    id="payfal-email"
                    placeholder="payfal-address"
                  />
                </div>
              </div>
            </div>
          </div>
          <!-- 우측 등록과 취소 버튼-->
          <div class="select-btn">
              <button class="cancel-button">취소</button>
              <button class="regist-button">신청</button>
          </div>
          </form>
          </div>
          <!-- </div> -->
        </div>
      </div>
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>
</html>
