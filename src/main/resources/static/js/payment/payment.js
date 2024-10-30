$().ready(function () {
  IMP.init("imp22850400");
  const merchantUid = $('.payId').text();
  console.log("payId는 " + merchantUid);

  const amount = $('.payCsh').text();	// 결제금액 못 바꾸도록 고정
  console.log("가격은 " + amount);
  
  if ($('.payTrTp').text() === "GUIDE"){
  	var title = $('.gdTrTtl').text();
  } else if($('.payTrTp').text() === "TOURIST") {
	var title = $('.usrTrTtl').text();
  }
  const name = title;
  console.log("결제할 이름 " + name)
  
  const buyerName = $('.trstId').text();
  console.log("결제자 유저 UID " + buyerName)
  
  
  // pay_inf의 pk
  $('.getToken').on('click', function() {
	$.ajax({
	    url: '/getAccessToken',
	    type: 'GET',
	    success: function(result) {
	        console.log("받아온 토큰 : " + result);
	    },
	    error: function(textStatus, errorThrown) {
	        console.error("토큰 발급에 실패 했습니다 :", textStatus, errorThrown);
	        alert('토큰 발급에 실패했습니다.');
	    }
	});
  });
  
  $('.do').on("click", function(){
	
	$.ajax({
		type: 'get',
		url : '/verifyPayment',
		data : {"payId": merchantUid, "amount": amount },
		success: function(result) {
			console.log("변조 검사를 실시합니다.");
			if (result == true){
				alert("올바른 결제입니다. 이용해주셔서 감사합니다.")
				// 결제 완료 ajax 실행
				
				
			} else {
				alert("위조된 결제입니다. 결제를 취소합니다.")
				// TODO 결제 취소
			}
		},
		error : function() {
			alert("결제 검증에 실패했습니다. 결제를 취소합니다.");
			// TODO 여기에 결제 취소가 들어가야한다.(일단 취소되는지 확인을 먼저 해야함)
		}
	});
  });
  
  

  $("button.kakaopay-btn").on("click", function () {
	const pg = "kakaopay";
	const payMethod = "card";
	$.ajax({	// 선검증
		type: 'get',
		url : '/verifyPayment',
		data : {"payId": merchantUid, "amount": amount },	// 얘는 위에서 받아오는 amount값을 가지고 비교한다.
		success: function(firstVerify) {
			if (firstVerify == true){
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
							console.log(rsp.pay_method);
							$.ajax({
								type: 'get',
								url : '/verifyPayment',
								data : {"payId": merchantUid, "amount": rsp.paid_amount },	// 실제로 결제된 금액을 가지고 비교한다.
								success: function(result) {
									if (result == true){
										alert("올바른 결제입니다. 이용해주셔서 감사합니다.")
										// 결제 완료 ajax 실행
										// post로 update하면 됨
										$.ajax({
											type: 'post',
											url: '/successPayment',
											data: {"payId":merchantUid, "pay_mthd": rsp.pay_method,
													 "iam_uid": rsp.iam_uid, "iam_mid": rsp.iam_mid}, 
											success: function() {
												console.log("pk" + merchantUid + "에게 결제 아이디 iam_uid(" + rsp.iam_uid 
													+ ")와 portOne에게 부여한 결제 아이디인 iam_mid(" + rsp.iam_mid + ")를 결제수단" 
													+ rsp.pay_method + "을 이용한 데이터를 DB에 적용하였습니다.");
											},
										});
										
									} else {
										alert("위조된 결제입니다. 결제를 취소합니다.")
										// TODO 결제 취소
										// 야르~~~
									}
								},
								error : function() {
									alert("결제 검증에 실패했습니다. 결제를 취소합니다.");
									// TODO 여기에 결제 취소가 들어가야한다. (일단 취소되는지 확인을 먼저 해야함)
									// 야르~~~
								}
							});
							var result = {
								"payId": rsp.merchant_uid, // 결제번호
								//등등
							};
						}
						else {
							console.log("결제 실패");
							var msg =  rsp.error_code + "    " + rsp.error_msg;
							console.log(msg);
							
							var result = {
								error_code : rsp.error_code,
							}
						}
			        },
			    );
				
			} else {
	  			console.log("데이터가 변조되었습니다.");
	  			}
	  		},
	  		error : function() {
	  			console.log("결제 선검증에 실패했습니다. 결제를 취소합니다.");
	  		},
		});
	});

  $("button.tosspayment-btn").on("click", function () {
    IMP.request_pay(
      {
        pg: "tosspayments",
        pay_method: pay_method,
        amount: amount, // 구매가격
        name: name, // 구매물품 이름
        merchant_uid: merchant_uid, // 결제에 대한 PK값 우리는 결제내역 ID가져오면 됨
        // 여기에 추가적인 내용을 추가할 수 있음, 자세한 것은 포트원 API페이지 참조
      },
      function (rsp) {
        const { status, err_msg } = rsp;
        if (err_msg) {
          alert(err_msg);
        }
        if (status == "paid") {
          const { imp_uid } = rsp;
          verifyPayment(imp_uid);
        }
      }
    );
  });

  $("button.KG-payment").on("click", function () {
    IMP.request_pay(
      {
        pg: "html5_inicis",
        pay_method: pay_method,
        amount: amount, // 구매가격
        name: name, // 구매물품 이름
        merchant_uid: merchant_uid, // 결제에 대한 PK값 우리는 결제내역 ID가져오면 됨
        // 여기에 추가적인 내용을 추가할 수 있음, 자세한 것은 포트원 API페이지 참조
      },
      function (rsp) {
        const { status, err_msg } = rsp;
        if (err_msg) {
          alert(err_msg);
        }
        if (status == "paid") {
          const { imp_uid } = rsp;
          verifyPayment(imp_uid);
        }
      }
    );
  });

  $("button.paypal-payment").on("click", function () {
    IMP.request_pay(
      {
        pg: "paypal",
        pay_method: pay_method,
        amount: amount, // 구매가격
        name: name, // 구매물품 이름
        merchant_uid: merchant_uid, // 결제에 대한 PK값 우리는 결제내역 ID가져오면 됨
        // 여기에 추가적인 내용을 추가할 수 있음, 자세한 것은 포트원 API페이지 참조
      },
      function (rsp) {
        const { status, err_msg } = rsp;
        if (err_msg) {
          alert(err_msg);
        }
        if (status == "paid") {
          const { imp_uid } = rsp;
          verifyPayment(imp_uid);
        }
      }
    );
  });

  $("button.only-tosspay").on("click", function () {
    IMP.request_pay(
      {
        pg: "tosspay",
        pay_method: pay_method,
        amount: amount, // 구매가격
        name: name, // 구매물품 이름
        merchant_uid: merchant_uid, // 결제에 대한 PK값 우리는 결제내역 ID가져오면 됨
        // 여기에 추가적인 내용을 추가할 수 있음, 자세한 것은 포트원 API페이지 참조
      },
      function (rsp) {
		console.log(rsp);
        const { status, err_msg } = rsp;
        if (err_msg) {
          alert(err_msg);
        }
        if (status == "paid") {
          const { imp_uid } = rsp;
          verifyPayment(imp_uid);
        }
      }
    );
  });  
});


function prepare(merchantUid, amount) {
	var isSafe = false;
	$.ajax({	// 사전 검사
		type: 'get',
		url : '/verifyPayment',
		data : {"payId": merchantUid, "amount": amount },
		success: function(result) {
			if (result == true){
				isSafe = true;
				console.log("변조 안됐습니다. 안전합니다.");
			} else {
				console.log("데이터가 변조되었습니다.");
			}
		},
		error : function() {
			console.log("결제 검증에 실패했습니다. 결제를 취소합니다.");
		},
	});
	return isSafe;
}