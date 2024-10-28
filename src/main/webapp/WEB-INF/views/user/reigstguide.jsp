<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>MATE 즐겨찾기</title>
    <link rel="stylesheet" type="text/css" href="/css/reigst_Guide.css" />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/common.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
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
            <div class="regist-form">
                <div class="regist-content">
                    <div class="sub-title">인적 사항</div>
                    <div class="sub-content">

                    <div class="form-item">
                      <label for="first-name">성</label>
                      <div> ${usrVO.usrLnm} </div>
                    </div>
                    
                    <div class="form-item">
                      <label for="last-name">이름</label>
                      <div> ${usrVO.usrFnm} </div>
                    </div>
                    
                    <div class="form-item">
                        <label for="gender">성별</label>
                        <div>${usrVO.usrGndr}</div>
                    </div>

                    <div class="form-item">
                        <label for="birthday">생년월일</label>
                        <div> ${usrVO.usrBd} </div>
                    </div>
                    
                    <div class="form-item">
                        <label for="phone-number">휴대전화번호</label>
                        <div> ${usrVO.usrPhn} </div>
                    </div>
                   
                   <div class="form-item">
                        <label for="email">이메일</label>
                        <div class="email-form"> ${usrVO.usrEml}</div>
                   </div>

                    <div class="form-item">
                        <label for="profile">프로필 사진</br>(250X250크기의 <br>  jpg, png 형식)</label>
                        <div class="img-form">
                            <div>(여기에 파일경로)</div>
                            <button>이미지 업로드</button>
                        </div>
                    </div>

                    <div class="form-item">
                        <label for="introduce">자기소개</label>
                        <textarea name="introduce" id="introduce"></textarea>
                    </div>

                    <div class="form-item">
                        <label for="country">대표 국적</label>
                        <input type="text" value="South Korea" id="country">
                    </div>

                    <div class="form-item">
                        <label for="active-area">활동 지역</label>
                        <div class="active-area-form">
                            <input type="text" value="Seoul" id="active-area">
                            <button>+</button>
                        </div>
                    </div>

                    <div class="form-item">
                        <label for="">신분증 사본</br> (jpg, png, pdf...)</label>
                        <div class="img-form">
                            <div>(신분증 사본 경로)</div>
                            <button>업로드</button>
                        </div>
                    </div>
                </div>
                <!-- 자격요건 -->
                    <div class="sub-title">자격요건</div>

                    <div class="sub-content">
                        <div class="form-item">
                        <label for="">라이센스 명</label>
                        <div>
                            <div class="license">
                                <input type="text" value="라이센스명">
                                <button>+</button>
                            </div>
                        </div>
                    </div>

                    <div class="form-item">
                        <label for="">라이센스 인증서류</br>(jpg, png, pdf..)</label>
                        <div class="img-form">
                            <div>서류 업로드 경로</div>
                            <button>업로드</button>
                        </div>
                    </div>
                </div>
                    <!-- 정산 정보 -->
                    <div class="sub-title">정산 정보</div>

                    <div class="sub-content">
                    <div class="form-item">
                        <label for="payfal-email">페이팔 계정</label>
                        <div class="email-form">
                            <input class="email" type="text" id="payfal-front-email">
                            <p>@</p>
                            <input class="email" type="text" id = "payfal-back-email">
                            <select class="email" name="payfal-back-email" id="payfal-back-email"></select>
                        </div>
                    </div>
                    </div>

                    <div class="regist-button"><button>신청</button></div>
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
