$().ready(function () {
	const trstId = 'USR-20241025-000036';
	data = {"trstId": trstId, "endDate": '2024-05-01',};
	
	$('.align-button').on("click", function(){
		buttonVal = $(this).val();
		// if(buttonVal === '1week' )
		// 여기서 오늘 날자 가져오는 것을 이용하여 일주일 전을 startDt로 잡는다.
		// endDt는 주지않는다. 어차피 endDt 없으면 자동으로 sysdate가져가게 할 것임.
		
		$.ajax({
			url: '/mypage/payment/periodSearch',
			type: 'GET',
			contentType: 'application/json',
			data: {"trstId": trstId, "endDate": '2024-05-01',},
			success: function(response){
				console.log(response);
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
	
}
