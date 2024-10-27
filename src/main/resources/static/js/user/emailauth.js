$().ready(function () {
	$("#auth-button").click(function() {
		var email = $("#usrEml").val();
		var emailVO = {
			email: email
		};
		
		$.ajax({
			type: "POST",
			url: "/user/regist/send-auth-mail",
			contentType: "application/json",
			data: JSON.stringify(emailVO),
			// controller로부터 code값이 담긴 JSON response를 받으면 인증번호 전송 성공
			success: function (response) {
				if (response.code) {
					alert("입력한 메일로 인증번호가 전송되었습니다.");
				} else {
					alert("인증번호를 전송할 수 없습니다.")
				}
			},
			error: function() {
				// 올바르지 않은 Response 도착, Redis 서버에 접속하지 못하는 경우
				alert("오류가 발생했습니다. 잠시 후 다시 시도해 주세요.")
			}
		})
	});
});