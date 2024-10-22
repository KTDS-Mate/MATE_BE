<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Mypage_Tourist_MyTour</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/MyPageLayout_PaymentDetails.css"
    />
<<<<<<< HEAD
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/common.css"
    />
  </head>

  <body>
    <div class="grid">
      <!--  -->
      <div class="header">
        <!-- header 공통파일 -->
<<<<<<< HEAD
        <jsp:include page="../Tourist_Sidebar.jsp"></jsp:include>
=======
        <jsp:include page="../header.jsp"></jsp:include>
>>>>>>> 7fdc88c21f13c221feb51b125c0e27e69a623dce
      </div>
      <!--  -->

      <div class="content">
        <div class="content-grid">
          <!-- side-bar 공통파일 -->
          <jsp:include page="../Tourist_Sidebar.jsp"></jsp:include>
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
          <div class="my-tour">
            <div class="tour-list-top">
              <div>
                <h1 style="font-weight: bold">결제 내역</h1>
              </div>
            </div>

            <div class="border"></div>

            <div class="guide-text">
              <span class="sample">
                최근 2년간 주문내역을 조회하실 수 있습니다
              </span>
            </div>

            <!-- 필터 박스 --------------------------------------------------------------->
            <div class="filter-box">
              <div class="filter-grid">
                <!-- 날짜 버튼들 -->

                <div class="date-buttons">
                  <div class="align-button">
                    <span class="sample1"> 최근일주일</span>
                  </div>
                  <div class="align-button">
                    <span class="sample1"> 1개월</span>
                  </div>
                  <div class="align-button">
                    <span class="sample1"> 3개월</span>
                  </div>
                  <div class="align-button">
                    <span class="sample1"> 6개월</span>
                  </div>
                </div>

                <!-- 날짜 입력란 -->
                <div class="date-range">
                  <input type="date" value="2023-09-18" />
                  ~
                  <input type="date" value="2024-09-18" />
                </div>

                <!-- 투어명 선택 -->
                <div class="tour-name">
                  <select>
                    <option value="">투어명</option>
                    <!-- 추가 옵션 -->
                  </select>
                </div>

                <!-- 조회 버튼 -->
                <button>조회</button>
              </div>
            </div>
            <!-------------------------------------------------------------->

            <div class="tour-list">
              <table class="payment-table">
                <thead>
                  <th>투어번호</th>
                  <th>결제요청일자</th>
                  <th>투어명</th>
                  <th>가이드</th>
                  <th>결제상태</th>
                  <th>투어금액</th>
                </thead>
                <tbody>
                  <tr>
                    <td>A12345678</td>
                    <td>2024.09.18</td>
                    <td>베니스 황혼의 곤돌라투어</td>
                    <td>워씽시</td>
                    <td>완료</td>
                    <td>300,000원</td>
                  </tr>
                  <tr>
                    <td>A12345678</td>
                    <td>2024.09.18</td>
                    <td>베니스 황혼의 곤돌라투어</td>
                    <td>워씽시</td>
                    <td>완료</td>
                    <td>300,000원</td>
                  </tr>
                  <tr>
                    <td>A12345678</td>
                    <td>2024.09.18</td>
                    <td>베니스 황혼의 곤돌라투어</td>
                    <td>워씽시</td>
                    <td>완료</td>
                    <td>300,000원</td>
                  </tr>
                </tbody>
              </table>
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
