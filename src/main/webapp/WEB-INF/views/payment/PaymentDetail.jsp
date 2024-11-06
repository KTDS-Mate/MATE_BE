<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
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
                <span class="trstFnm">${paymentVO.trstFnm}</span>
              </div>
              <div class="grid-info">
                <span>가이드 이름</span>
                <span class="gdFnm">${paymentVO.gdFnm}</span>
              </div>
              <div class="grid-info">
                <span>투어 타입</span>
                <span class="payTrTp">${paymentVO.payTrTp}</span>
                
              </div>
              <div class="grid-info">
                <span>투어 제목</span>
                <c:if test="${paymentVO.payTrTp eq 'TOURIST'}">
                	<span class="usrTrTtl">${paymentVO.usrTrTtl}</span>
                </c:if>
                <c:if test="${paymentVO.payTrTp eq 'GUIDE'}">
                	<span class="gdTrTtl">${paymentVO.gdTrTtl}</span>
                </c:if>
                
              </div>
              <div class="grid-info">
                <span>가격</span>
                <span class="payCsh">${paymentVO.payCsh}</span>
              </div>
              <div class="grid-info">
                <span>통화</span>
                <span class="payCrrnc">${paymentVO.payCrrnc}</span>
               </div>
            </div>
          </div>
          <!-- 여기에 결제버튼부분이나 결제 내용 보여주면 됨 -->
          <c:if test="${paymentVO.payStt ne 'WAITING'}"> 
	          <div class="info-container">
	            <div class="section-box">
	              <div class="sub-title"><h3>결제 세부 정보</h3></div>
	
	              <div class="grid-info">
	                <span>결제 ID</span>
	                <span class="impUid">${paymentVO.impUid}</span>
	              </div>
	              <div class="grid-info">
	                <span>결제방식</span>
	                <span class="payMthd">${paymentVO.payMthd}</span>
	              </div>
	              <div class="grid-info">
	                <span>통화</span>
	                <span class="payCrrnc">${paymentVO.payCrrnc}</span>
	              </div>
	              <div class="grid-info">
	                <span>결제 상태</span>
	                <span class="payStt">${paymentVO.payStt}</span>
	              </div>
	            </div>
	            <c:if test="${paymentVO.payStt eq 'COMPLETE'}">
		            <div class="btn-area">
		              <button class="refund">환불하기</button>
		            </div>
	            </c:if>
	          </div>
          </c:if>
          <!-- 결제 플랫폼하고 기능 연결하기 -->
          <c:if test="${paymentVO.payStt eq 'WAITING'}">
          <div class="payment-btn-area">
          	<button class="tosspayment-btn">
				토스 통합결제
          	</button>
          	<button class="KG-payment checked">
				이니시스 통합결제
          	</button>
          	<button class="kakaopay-btn">
				카카오페이          	
          	</button>
          	<button class="tosspay-btn">
				토스페이
          	</button>
          	<button class="paypal-payment">
				페이팔
          	</button>
          </div>   
	          <div class="btn-area">
	            
	            <button class="doPay">결제하기</button>
	          </div>
          </c:if>
        </div>
      </div>

      <!-- Footer -->
      <div class="footer">
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>

      <input type="hidden" class="payId" value ="${paymentVO.payId}" />
      <input type="hidden" class="trstId" value ="${paymentVO.trstId}"/>
      <input type="hidden" class="trstFnm" value ="${paymentVO.trstFnm}"/>
      <input type="hidden" class="gdId" value ="${paymentVO.gdId}"/>
      <input type="hidden" class="gdFnm" value ="${paymentVO.gdFnm}"/>
      <input type="hidden" class="payTrTp" value ="${paymentVO.payTrTp}"/>
      <input type="hidden" class="payTrId" value ="${paymentVO.payTrId}"/>
      <input type="hidden" class="usrTrTtl" value ="${paymentVO.usrTrTtl}"/>
      <input type="hidden" class="gdTrTtl" value ="${paymentVO.gdTrTtl}"/>
      <!-- 얘 없음 > 지금 여행자 투어니까 -->
      <input type="hidden" class="payCsh" value ="${paymentVO.payCsh}"/>
      <input type="hidden" class="payCrtDt" value ="${paymentVO.payCrtDt}"/>
      <input type="hidden" class="payCmpltDt" value ="${paymentVO.payCmpltDt}"/>
      <input type="hidden" class="impUid" value ="${paymentVO.impUid}"/>
      <input type="hidden" class="impMid" value ="${paymentVO.impMid}"/>
      <input type="hidden" class="payMthd" value ="${paymentVO.payMthd}"/>
      <input type="hidden" class="payCrrnc" value ="${paymentVO.payCrrnc}"/>
      <input type="hidden" class="payStt" value ="${paymentVO.payStt}"/>
  </body>
</html>
