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
  </head>
  <body>
	<ul>
  		<li> ${paymentVO.payId} </li>
  		<li> ${paymentVO.trstId} </li>
  		<li> ${paymentVO.gdId} </li>
  		<li> ${paymentVO.gdFnm} </li>
  		<li> ${paymentVO.payTrTp} </li>
  		<li> ${paymentVO.payTrId} </li>
  		<li> ${paymentVO.usrTrTtl} </li>
  		<li> ${paymentVO.gdTrTtl} </li>	<!-- 얘 없음 > 가이드 투어니까 -->
  		<li> ${paymentVO.payCsh} </li>
  		<li> ${paymentVO.payCrtDt} </li>
  		<li> ${paymentVO.payCmpltDt} </li>	<!-- 얘 없음 -->
  		<li> ${paymentVO.payKey} </li>
  		<li> ${paymentVO.payMthd} </li>	<!-- 얘 없음 -->
  		<li> ${paymentVO.payCrrnc} </li>
  		<li> ${paymentVO.payStt} </li>
	</ul>

  	<button class="getToken">Access Token 받기</button>
    <button class="kakaopay-btn">카카오페이 결제</button>
    <button class="tosspayment-btn">토스페이 통합 결제</button>
    <button class="KG-payment">KG이니시스 통합 결제</button>
    <button class="paypal-payment">페이팔 결제</button>
    <button class="only-tosspay">토스페이 결제</button>
  </body>
</html>
