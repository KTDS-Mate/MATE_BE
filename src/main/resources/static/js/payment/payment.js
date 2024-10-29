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
  
  $.ajax({		// 사전 등록한다.
	url: "/prepare",
	method: "post",
	contentType: "application/json",
	data: JSON.stringify({
		merchant_uid: merchantUid,
		amount: amount
	})
  });
  
  
  
  var pg = "kakaopay"	// 얜 나중에 바꿀 수 있도록 함수를 만들 예정이다.
  var payMethod = "card";	// 위의 pg와 마찬가지 
  var mRedirectUrl = "www.naver.com";
  
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
	
	
    IMP.request_pay(
      {
        pg: "kakaopay",
        pay_method: payMethod,
        amount: amount, // 구매가격
        name: name, // 구매물품 이름
        merchant_uid: merchantUid + new Date().getTime() % 10000, // 결제에 대한 PK값 우리는 결제내역 ID가져오면 됨
		buyer_name: buyerName,	//이름대신 아이디긴 함
      },
      function (rsp) {
		if (rsp.success) {
			console.log("결제 완료");
			var msg = '결제 완료';
			msg += '// 고유ID : ' + rsp.imp_uid;
			msg += '// 상점 거래ID : ' + rsp.merchant_uid;
			msg += '// 졀게 금액 : ' + rsp.paid_amount;
			$.ajax({
				type: 'get',
				url : '/verifyPayment',
				data : {"payId": merchantUid, "amount": rsp.paid_amount },
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
			var result = {
				"payId": rsp.merchant_uid, // 결제번호
				//등등
			};
		}
		else {
			console.log("결제 실패");
			var msg ='결제에 실패했습니다.';
			var result = {
				error_code : rsp.error_code,
			}
		}
		
	
        },
      );
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





