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
  	<button class="getToken">Access Token 받기</button>
    <button class="kakaopay-btn">카카오페이 결제</button>
    <button class="tosspayment-btn">토스페이 통합 결제</button>
    <button class="KG-payment">KG이니시스 통합 결제</button>
    <button class="paypal-payment">페이팔 결제</button>
    <button class="only-tosspay">토스페이 결제</button>
  </body>
</html>
