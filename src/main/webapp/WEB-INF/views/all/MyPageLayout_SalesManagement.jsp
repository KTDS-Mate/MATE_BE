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
      href="/css/MyPageLayout_SalesManagement.css"
    />
  </head>

  <body>
    <div class="grid">
      <!--  -->
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <!--  -->

      <div class="content">
        <div class="content-grid">
          <!-- side-bar 공통파일 -->
          <jsp:include page="../sidebar.jsp"></jsp:include>
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
            <div class="total-sale">
              <h2>총 매출은 32,585,000원 입니다.</h2>
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
