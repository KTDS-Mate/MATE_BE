$().ready(function () {
	
	// 중복 확인 
	
	$("#id").keyup(function () {
		// 서버에 get 요청
		$.get(
			// 중복 확인 처리용 URL 호출
			"/user/regist/availableid",
			// 현재 입력된 값을 서버로 보낸다.
			// $(this).val()로 입력값을 가져옴.
			{ id: $(this).val() },
			function (availableResponse) { // 서버에서 응답받은 객체
				var id = availableResponse.usrLgnId; // 서버에서 응답받은 아이디 값
				var availableid = availableResponse.available; // 아이디 사용여부를 나타내는 boolean 값
				
				if (availableid) { // 응답값이 true이면 -> 아이디가 사용 가능하다면
					// #id 입력 필드에 availableid 클래스 추가(사용가능여부 표시)
					$("#id").addClass("available");
					// 사용불가능(unusable 클래스) 상태 제거
					$("#id").removeClass("unusable");
					// submit 버튼의 disabled 상태 제거
					$("input[type=submit]").removeAttr("disabled");
				} else {
					$("#id").addClass("unusable");
					$("#id").removeClass("available");
					$("input[type=submit]").attr("disabled", "disabled");
				}
			}
		)
	});
	
	$("#email").keyup(function () {
		$.get(
			"/user/regist/availableemail",
			{ email: $(this).val() },
			function (avaliableResponse){
				var email = avaliableResponse.usrEml;
				var availableemail = avaliableResponse.available;
				
				if(availableemail) {
					// 사용가능한 이메일인 경우
					$("#email").addClass("available");
					$("#email").removeClass("unusable");
					$("input[type=submit]").removeAttr("disabled");
				} else {
					// 사용 불가능한 이메일인 경우
					$("#email").addClass("unusable");
					$("#email").removeClass("available");
					$("input[type=submit]").attr("disabled", "disabled");
				}
			}
		)
	});
});