<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>포트원 실습</title>
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/payment/payment.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/payment/PaymentDetail.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="grid">
      <!-- 헤더 -->
      <div class="header">
        <jsp:include page="../header.jsp"></jsp:include>
      </div>

      <!-- 메인 컨텐츠(body) -->
      <div class="content">
        <div class="main-content">
          <div class="content-title">
            <div><h2>결제 상세 내역</h2></div>
          </div>
          <div class="info-container">
            <div class="section-box">
              <div class="sub-title"><h3>결제 정보</h3></div>

              <div class="grid-info">
                <span>결제자 이름</span>
                <span>KwonHyeok</span>
              </div>
              <div class="grid-info">
                <span>가이드 이름</span>
                <span>test1</span>
              </div>
              <div class="grid-info">
                <span>투어 타입</span>
                <span>TOURIST</span>
              </div>
              <div class="grid-info">
                <span>투어 제목</span>
                <span>로그인 테스트</span>
              </div>
              <div class="grid-info">
                <span>가격</span>
                <span>30000.0</span>
              </div>
            </div>
          </div>
          <!-- 여기에 결제버튼부분이나 결제 내용 보여주면 됨 -->
          <div class="info-container">
            <div class="section-box">
              <div class="sub-title"><h3>결제 완료 정보</h3></div>

              <div class="grid-info">
                <span>결제 ID</span>
                <span>imp_859182762619</span>
              </div>
              <div class="grid-info">
                <span>결제방식</span>
                <span>point</span>
              </div>
              <div class="grid-info">
                <span>통화</span>
                <span>WON</span>
              </div>
              <div class="grid-info">
                <span>결제 상태</span>
                <span>COMPLETE</span>
              </div>
            </div>
            <div class="btn-area">
              <button class="refund">환불하기</button>
            </div>
          </div>
          <!-- 결제 플랫폼하고 기능 연결하기 -->
          <div class="btn-area">
            <button class="tosspayment-btn">토스페이 통합 결제</button>
            <button class="KG-payment">KG이니시스 통합 결제</button>
            <button class="paypal-payment">페이팔</button>
            <button class="kakaopay-btn">카카오페이</button>
            <button class="only-tosspay">토스페이</button>
            <button class="doPay">결제하기</button>
          </div>
        </div>
      </div>

      <!-- Footer -->
      <div class="footer">
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>

    <ul>
      <li class="payId">${paymentVO.payId}</li>
      <li class="trstId">${paymentVO.trstId}</li>
      <li class="trstFnm">${paymentVO.trstFnm}</li>
      <li class="gdId">${paymentVO.gdId}</li>
      <li class="gdFnm">${paymentVO.gdFnm}</li>
      <li class="payTrTp">${paymentVO.payTrTp}</li>
      <li class="payTrId">${paymentVO.payTrId}</li>
      <li class="usrTrTtl">${paymentVO.usrTrTtl}</li>
      <li class="gdTrTtl">${paymentVO.gdTrTtl}</li>
      <!-- 얘 없음 > 지금 여행자 투어니까 -->
      <li class="payCsh">${paymentVO.payCsh}</li>
      <li class="payCrtDt">${paymentVO.payCrtDt}</li>
      <li class="payCmpltDt">${paymentVO.payCmpltDt}</li>
      <!-- 얘 없음 -->
      <li class="impUid">${paymentVO.impUid}</li>
      <li class="impMid">${paymentVO.impMid}</li>
      <li class="payMthd">${paymentVO.payMthd}</li>
      <!-- 얘 없음 -->
      <li class="payCrrnc">${paymentVO.payCrrnc}</li>
      <li class="payStt">${paymentVO.payStt}</li>
    </ul>
  </body>
</html>
