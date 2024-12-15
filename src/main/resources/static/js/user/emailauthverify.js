$().ready(function() {

	$("#verify-btn").click(function() {
		var email = $("#usrEml").val();
		var authCode = $("#authCode").val();
		
		if (!email || !authCode) {
			alert("이메일과 인증 코드를 입력해주세요!");
			return;
		}
		
		var emailVO = {
			email: email,
			authCode: authCode
		};
		
		$.ajax({
			type: "POST",
			url: "api/user/regist/verify-auth-code",
			contentType: "application/json",
			data: JSON.stringify(emailVO),
			success: function(response) {
				if (response.valid) {
					alert("인증이 완료되었습니다. 회원 가입을 완료하세요!")
					$("#authVerified").val("true");
				} else {
					alert(response.message);
				}
			},
			error: function() {
				alert("잠시 후 다시 시도해주세요.")
			}
		})
	});
	
});