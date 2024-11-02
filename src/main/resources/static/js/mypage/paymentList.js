/*
	data = {
		"trstId": trstId,
		"tourType" : 'TOURIST',
		"payState" : 'COMPLETE',
		"startDate": '2023-03-01',
		"endDate": '2024-05-01',
		"searchType": '최근일주일',
	};
*/
	

$().ready(function () {
	const trstId = 'USR-20241025-000036';
	
	$(".search-button").on("click", function() {
			movepage(0);
	});
	
	$('.align-button').on("click", function(){
		buttonVal = $(this).val();
		// if(buttonVal === '1week' )
		// 여기서 오늘 날자 가져오는 것을 이용하여 일주일 전을 startDt로 잡는다.
		// endDt는 주지않는다. 어차피 endDt 없으면 자동으로 sysdate가져가게 할 것임.
		
		$.ajax({
			url: '/mypage/payment/periodSearch',
			type: 'GET',
			contentType: 'application/json',
			//data: {"trstId": trstId, "endDate": '2024-05-01',},
			data : {
					"trstId": trstId,
					"searchType": '1개월',
					"tourType" : 'GUIDE',
					"payState" : 'COMPLETE',
					
				},
			success: function(response){
				//console.log(response);
				refreshNewData(response);
				// TODO DB에서 받아온 데이터(paymentListVO)를 주고,
				// 수정하는 함수를 넣어야합니다.
				// 아무것도 없다면 비어있다는 것 까지 출력시킨다.
			},
			error: function() {
				alert("데이터를 가져오며 에러가 발생하였습니다.");
			}
		});
	});
});

function refreshNewData(ListVO) {
	$('.elements-list').html("");
	
	if (ListVO && ListVO.length > 0) {
		ListVO.forEach(function (payItem) {
			
			if(payItem.payTrTp === 'TOURIST'){
				var TrTtl = payItem.usrTrTtl;
			}else if (payItem.payTrTp === 'GUIDE'){
				var TrTtl = payItem.gdTrTtl;
			}
			var row = `
			<tr>
			  <td>${payItem.payId}</td>
			  <td>${payItem.payCrtDt}</td>
			  <td>${payItem.payTrTp}</td>
			  <td>${TrTtl}</td>
			  <td>${payItem.gdFnm}</td>
			  <td>${payItem.payStt}</td>
			  <td>${payItem.payCsh}</td>
			</tr>
			  `;
			$('.elements-list').append(row);
		});
	} else {
		$('.elements-list').html('<tr><td colspan="7">결제 내역이 존재하지 않습니다.</td></tr>');
	}
}

function movepage(pageNo) {
	$(".page-no").val(pageNo);
}





























