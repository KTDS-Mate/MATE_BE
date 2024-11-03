$().ready(function() {
	
	// 동적으로 추가 된 요소를 모두 가져오기 위해 이벤트를 위임함
	$(document).on('click', "#success-btn", function() {
		var sttsVal = $(this).closest(".result-sum").find(".apply-hide").data("stts");
		
		if (sttsVal === 'PRG') {
			$(this).prop('disabled', false);
		}
		else {
			$(this).prop('disabled', true);
		}
		
	});
	
});