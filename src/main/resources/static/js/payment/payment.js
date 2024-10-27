$().ready(function () {
  IMP.init("imp22850400");

  var pay_method = "card";
  const amount = "6000";	// 결제금액 못 바꾸도록 고정
  var name = "상품명";

  // 결제에 성공하면 이 uid로 다시 결제 못한다. PK처럼 중복이 안되는 값을 넣어야한다.
  var merchant_uid = "ORD-20241007-000214";

  $('.getToken').on('click', function() {
	$.ajax({
	    url: '/getAccessToken',
	    type: 'GET',
	    success: function(result) {
	        console.log("받아온 토큰 : " +result);
	    },
	    error: function(textStatus, errorThrown) {
	        console.error("토큰 발급에 실패 했습니다 :", textStatus, errorThrown);
	        alert('토큰 발급에 실패했습니다.');
	    }
	});
  });
  

  $("button.kakaopay-btn").on("click", function () {
    IMP.request_pay(
      {
        pg: "kakaopay",
        pay_method: pay_method,
        amount: amount, // 구매가격
        name: name, // 구매물품 이름
        merchant_uid: merchant_uid, // 결제에 대한 PK값 우리는 결제내역 ID가져오면 됨
        // 여기에 추가적인 내용을 추가할 수 있음, 자세한 것은 포트원 API페이지 참조
      },
      function (rsp) {
		if (rep.success){
			//성공한 경우
			var msg = '결제가 완료되었습니다.';
			var result = {
				"payId": rsp.merchant_uid, // 결제번호
				//등등
			};
			
		}
		
		
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





