$().ready(function () {
  IMP.init("imp22850400");
  const merchantUid = $('input.payId').val();
  const amount = $('input.payCsh').val();	// 결제금액 못 바꾸도록 고정
  if ($('input.payTrTp').text() === "GUIDE"){
  	var title = $('input.gdTrTtl').val();
  } else if($('input.payTrTp').val() === "TOURIST") {
	var title = $('input.usrTrTtl').val();
  }
  const name = title;
  const buyerName = $('input.trstFnm').val();
  const impMid = $('input.impMid').val();
  const impUid = $('input.impUid').val();
  
  //var pg = "html5_inicis";
  var pg = "tosspayments";
  const payMethod = "card";
  // pay_inf의 pk
  console.log(impUid);
  $('.getToken').on('click', function() {
	$.ajax({
	    url: '/getAccessToken',
	    type: 'POST',
	    success: function(rsp) {
	        console.log(rsp.token);
	    },
	    error: function(textStatus, errorThrown) {
	        console.error("토큰 발급에 실패 했습니다 :", textStatus, errorThrown);
	        alert('토큰 발급에 실패했습니다.');
	    }
	});
  });
  
  $('.refund').on("click", function(){
	$.ajax({
		url: '/cancelPayment',
		type: 'POST',
		data: {"imp_uid": impUid,"reason": "환불", },
		success: function(rsp){
			$.ajax({
				url: '/refundPayment',
				type: 'POST',
				data: {"payId": merchantUid,},
				success: function(rsp){
					if (rsp){
						alert("정상적으로 환불처리 되었습니다.");
					}else {
					alert("데이터베이스 처리에 실패하였습니다. 고객센터에 문의해주세요.");
					}
				},
				error: function (){
					alert("데이터베이스 처리에 실패하였습니다. 고객센터에 문의해주세요.");
				}
			});
			
		},
		error: function(rsp){
			console.log("환불 처리도중에 오류가 생겼습니다. 고객센터에 문의해주세요.");
		},
	});
	
  });
  
  $(".doPay").on("click", function () {
	$.ajax({	// 선검증
		type: 'get',
		url : '/verifyPayment',
		data : {"payId": merchantUid, "amount": amount },	// 얘는 위에서 받아오는 amount값을 가지고 비교한다.
		success: function(firstVerify) {
			if (firstVerify === true){
				console.log("선검증 결과 : 안전");
			    IMP.request_pay(
				    {
				        pg: pg,
				        pay_method: payMethod,
				        amount: amount, // 구매가격
				        name: name, // 구매물품 이름
				        merchant_uid: merchantUid + new Date().getTime() % 10000, // 결제에 대한 PK값 우리는 결제내역 ID가져오면 됨
						buyer_name: buyerName,	//이름대신 아이디긴 함
				    },
			      	function (rsp) {
						if (rsp.success) {
							console.log("결제 완료 결제 검증을 시작합니다.");
							$.ajax({
								type: 'get',
								url : '/verifyPayment',
								data : {"payId": merchantUid, "amount": rsp.paid_amount },
								success: function(result) {
									if (result){
										console.log(result);
										alert("올바른 결제입니다. 이용해주셔서 감사합니다.");
										$.ajax({
												type:'POST',
												url: '/successPayment',
												data: {"payId":merchantUid, "imp_uid": rsp.imp_uid,
													 "imp_mid": rsp.merchant_uid, "pay_mthd": rsp.pay_method,}, 
												success: function(result) {
													if (result){
													console.log("pk" + merchantUid + "에게 결제 아이디 imp_uid(" + rsp.imp_uid 
														+ ")와 portOne에게 부여한 결제 아이디인 imp_mid(" + rsp.merchant_uid + ")를 결제수단" 
														+ rsp.pay_method + "을 이용한 데이터를 DB에 적용하였습니다.");
													} else {
														alert("데이터베이스 등록에 실패하였습니다. 고객센터에 문의해주세요.");
													}
												},
												error: function(){
													alert("데이터베이스 등록에 실패하였습니다. 고객센터에 문의해주세요.");
												},
											});
									} else{
										alert("위조된 결제입니다. 결제를 취소합니다.");
										$.ajax({
											url: '/cancelPayment',
											type: 'POST',
											data: { "imp_uid": rsp.imp_uid, "reason": "검증 실패", },
											success: function(rsp){
													console.log(rsp.message);
											},
											error: function(){
												console.log("실행처리중 오류가 생겼습니다. 고객센터에 문의해주세요.");
											},
										});
									}
								},
								error : function() {
									alert("위조 검사 실패. 결제를 취소합니다.")
									// 방금 결제 항목을 취소(환불)
									$.ajax({
										url: '/cancelPayment',
										type: 'POST',
										data: { "imp_uid": rsp.imp_uid, "reason": "검증 실패", },
										success: function(rsp){
												console.log(rsp.message);
										},
										error: function(){
											alert("취소 처리중 오류가 생겼습니다. 고객센터에 문의해주세요.");
										},
									});
								}
							});
						}
						else {
							console.log("결제 실패");
							var msg =  rsp.error_code + "    " + rsp.error_msg;
							console.log(msg);
						}
			        },
			    );
				// IMP.Request_Pay 여기 위까지임
				//아래부터는 선검증 실패부분
			} else {
	  			alert("데이터가 변조되었습니다.");
	  			}
	  		},
	  		error : function() {
	  			alert("해당 결제의 선검증에 실패했습니다. 결제를 취소합니다.");
	  		},
		});
	});
  $("button.kakaopay-btn").on("click", function () {
	$(".date-buttons").find('input[type="button"]').removeClass("checked");
	$(this).addClass("checked");
	pg = "kakaopay";
  });
	
	
  $("button.tosspayment-btn").on("click", function () {
	pg = "tosspayments";
  });

  $("button.KG-payment").on("click", function () {
    pg = "html5_inicis"
  });

  $("button.paypal-payment").on("click", function () {
	pg = "paypal";
  });

  $("button.tosspay-btn").on("click", function () {
  	pg = "tosspay"
  });
  
});
