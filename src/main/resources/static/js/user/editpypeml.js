$.ready(function() {

	var emailRegex = /^[a-z0-9_\.\-]+@[a-z0-9\-]+\.[a-z0-9\-]+/;
	
	// 이메일 중복 확인 검사 및 이메일 유효성 검사
	$("#usrPypEml").keyup(function () {
	    var usrPypEml = $(this).val();

		// 이메일 유효성 검사
		if (!emailRegex.test(usrPypEml)) {
			$("#usrPypEml-error").text("유효한 이메일 형식이 아닙니다.");
			$("#usrPypEml").removeClass("available").addClass("unusable input-error");
			toggleSubmitButton();
			return;
		} else {
			$("#usrPypEml-error").text("");
			$("#usrPypEml").removeClass("unusable input-error").addClass("available");
		}
		
	    // 이메일 중복확인 검사
	    $.get("/user/regist/availableemail", 
			{ usrEml: usrPypEml }, 
			function (response) {
	        var availableEmail = response.available; // 이메일 사용 가능 여부

	        if (availableEmail) {
	            $("#usrPypEml").removeClass("unusable input-error").addClass("available");
				// 이메일 중복 메세지 제거
				$("#usrPypEml-error").text("");
	        } else {
	            $("#usrPypEml").removeClass("available").addClass("unusable input-error");
				// available 값이 False인 경우
				$("#usrPypEml-error").text("이미 사용중인 이메일입니다.");
	        }
	        toggleSubmitButton(); 
	    });
	});
	
	// 아이디, 비밀번호, 이메일, 휴대전화번호가 모두 사용 가능한 경우에만 제출 버튼 활성화
	function toggleSubmitButton() {
	    if ( $("#usrPypEml").hasClass("available")) {
	        $("input[type=submit]").removeAttr("disabled");
		} else {
	        $("input[type=submit]").attr("disabled", "disabled");
	    }
	}
});