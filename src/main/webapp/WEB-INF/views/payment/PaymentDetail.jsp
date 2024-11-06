<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <title>포트원 실습</title>
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/payment/payment.js"></script>
  </head>
  <body>
	<ul>
  		<li class="payId">${paymentVO.payId}</li>
  		<li class=trstId>${paymentVO.trstId}</li>
  		<li class="trstFnm">${paymentVO.trstFnm}</li>
  		<li class="gdId">${paymentVO.gdId}</li>
  		<li class="gdFnm">${paymentVO.gdFnm}</li>
  		<li class="payTrTp">${paymentVO.payTrTp}</li>
  		<li class="payTrId">${paymentVO.payTrId}</li>
  		<li class="usrTrTtl">${paymentVO.usrTrTtl}</li>
  		<li class="gdTrTtl">${paymentVO.gdTrTtl}</li>	<!-- 얘 없음 > 지금 여행자 투어니까 -->
  		<li class="payCsh">${paymentVO.payCsh}</li>
  		<li class="payCrtDt">${paymentVO.payCrtDt}</li>
  		<li class="payCmpltDt">${paymentVO.payCmpltDt}</li>	<!-- 얘 없음 -->
  		<li class="impUid">${paymentVO.impUid}</li>
  		<li class="impMid">${paymentVO.impMid}</li>
  		<li class="payMthd">${paymentVO.payMthd}</li>	<!-- 얘 없음 -->
  		<li class="payCrrnc">${paymentVO.payCrrnc}</li>
  		<li class="payStt">${paymentVO.payStt}</li>
	</ul>
	<div>
    <button class="doPay">결제 시작</button>
  	<button class="getToken">Access Token 받기</button>
  	</div>
    <button class="kakaopay-btn">카카오페이 결제</button>
    <button class="tosspayment-btn">토스페이 통합 결제</button>
    <button class="KG-payment">KG이니시스 통합 결제</button>
    <button class="paypal-payment">페이팔 결제</button>
    <button class="only-tosspay">토스페이 결제</button>
	<div><button class="refund">환불하기</button></div>
  </body>
</html>
