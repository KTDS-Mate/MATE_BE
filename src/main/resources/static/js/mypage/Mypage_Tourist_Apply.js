$().ready(function() {
	var usrLgnId = $(".header-content").data("loginid");
	
	$(".order").on('change', function () {
			var otpVal = $(this).val();
			
			location.href = "/mypage/tr-apply-tour/" + usrLgnId + "&orderby=" + otpVal;
		});
	
	// 등록한 게시글의 개수
	var trLength = $(".result-sum").length;
	
	for (var i = 0; i < trLength; i++) {
		// 투어 상태
		var sttsVal =  $(`#re-${i}`).find(".apply-hide").data("stts");
		console.log(`${i + 1}번째 글` + sttsVal)
		// 결제 상태
		var paySttsVal = $(`#re-${i}`).find(".apply-hide").data("pay-stts");
		// 투어 일자
		var stringStDt = $(`#re-${i}`).find("#st").text();
		var dateStDt = new Date(stringStDt);
		// 현재 시간
		var nowDate = new Date();
		// 버튼 활성화 조건
		// 예약 시 선 결제가 완료가 되어있어야 하고 현재 투어를 진행중이여야 함
		var isPossible = paySttsVal === 'COMPLETE' && nowDate > dateStDt && sttsVal === 'PRG'
		
		// 활성화 조건에 어긋나면 disabled를 걸어줌
		if (!isPossible) {
			$(`#re-${i}`).find("#success-btn").prop('disabled', true);
		}
		
	}
	
	// 동적으로 추가 된 요소를 모두 가져오기 위해 이벤트를 위임함
	$(document).on('click', "#success-btn", function() {
		
		var usrTrPstId = $(this).closest(".result-sum").find(".apply-hide").data("pst-id");
		
		if (confirm("야르")) {
			location.href = `/mypage/tr-apply-tour/complete/${usrTrPstId}/${usrLgnId}`;
		}
		
	});

});


function movePage(pageNo) {
    var loginId = $(".header-content").attr("data-loginId");

    $(".page-no").val(pageNo);
	
    $(".search-form").attr({
        "method": "GET",
        "action": `/mypage/tr-apply-tour/${loginId}`
    }).submit();
}
