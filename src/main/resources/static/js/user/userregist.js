$().ready(function () {
	
	// 정규표현식 설정
	var idRegex = /^[a-z0-9-_]{5,21}$/;
	
	// 비밀번호 정규 표현식
	var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\-=/]).{8,16}$/; 
	
	$("#usrLgnId").keyup(function() {
		var usrLgnId = $(this).val();
		
		// 정규표현식으로 아이디 입력값 유효성 검사
		if (!idRegex.test(usrLgnId)) {
			// 유효하지 않은 아이디 형식으로 입력이 되었을 경우 에러 메세지 출력
			$("#usrLgnId-error").text("아이디: 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
			$("#usrLgnId").removeClass("available").addClass("unusable input-error");
			toggleSubmitButton();
			// 중복 확인 요청을 보내지 않음
			return;
		} else {
			// 유효성검사 통과 시 경고 메세지 삭제
			$("#usrLgnId-error").text("");
			$("#usrLgnId").removeClass("unusable input-error").addClass("available")
		}
		
		// 아이디 중복 확인 유효성 검사
		$.get("/user/regist/availableid", 
			{ usrLgnId: usrLgnId }, 
			function (response) {
			    var availableid = response.available; // 아이디 사용 가능 여부
	
			    if (availableid) {
			        $("#usrLgnId").removeClass("unusable input-error").addClass("available");
					// 아이디 중목 메세지 제거
					$("#usrLgnId-error").text("");
			    } else {
			        $("#usrLgnId").removeClass("available").addClass("unusable input-error");
					// available 값이 false인 경우
					$("#usrLgnId-error").text("이미 사용 중인 아이디입니다.");
			    }
			    toggleSubmitButton(); // 아이디 상태 변경 후 제출 버튼 활성화 여부 확인
			});
	});
	
	// 정규식을 사용한 사용자 입력 비밀번호값 유효성 검사
	$("#usrPw").keyup(function() {
		var usrPw = $(this).val();
		var confirmPw = $("#confirmPw").val();
		
		if (!passwordRegex.test(usrPw)) {
			$("#usrPw-error").text("비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
			$("#usrPw").removeClass("available").addClass("unusable input-error");
		} else {
			$("#usrPw-error").text("");
			$("#usrPw").removeClass("unusable input-error").addClass("available");
			
			// 비밀번호 확인 값이 있을 경우 일치여부 확인
			if (confirmPw) {
				if (usrPw !== confirmPw) {
					$("#confirmPw-error").text("비밀번호가 일치하지 않습니다.");
					$("#confirmPw").removeClass("available").addClass("unusable input-error");
				} else {
					$("#confirmPw-error").text("");
					$("#confirmPw").removeClass("unusable input-error").addClass("available");
				}
			}
		}
		toggleSubmitButton();
	});
	
	// 실시간 비밀번호 입력값 교차 검증
	$("#confirmPw").keyup(function() {
		var usrPw = $("#usrPw").val();
		var confirmPw = $(this).val();
		
		if (!usrPw) {
			$("#confirmPw-error").text("비밀번호를 입력하세요.");
			$("#confirmPw").removeClass("available").addClass("unusable input-error");
			//$("input[type=submit]").attr("disabled", "disabled");
		} else if (usrPw !== confirmPw){
			$("#confirmPw-error").text("비밀번호가 일치하지 않습니다.");
			$("#confirmPw").removeClass("available").addClass("unusable input-error");
			//$("input[type=submit]").removeAttr("disabled");
		} else {
			$("#confirmPw-error").text("");
			$("#confirmPw").removeClass("unusable input-error").addClass("available");
		}
		toggleSubmitButton();
	});

    // 이메일 중복 확인
    $("#usrEml").keyup(function () {
        var usrEml = $(this).val();

        // 서버에 get 요청
        $.get("/user/regist/availableemail", 
			{ usrEml: usrEml }, 
			function (response) {
            var availableemail = response.available; // 이메일 사용 가능 여부

            if (availableemail) {
                $("#usrEml").removeClass("unusable input-error").addClass("available");
				// 이메일 중복 메세지 제거
				$("#usrEml-error").text("");
            } else {
                $("#usrEml").removeClass("available").addClass("unusable input-error");
				// available 값이 False인 경우
				$("#usrEml-error").text("이미 사용중인 이메일입니다.");
            }
            toggleSubmitButton(); 
        });
    });

	// 휴대전화번호 중복 확인
	$("#usrPhn").keyup(function() {
		var usrPhn = $(this).val();
		
		$.get("/user/regist/availablephn",
			{ usrPhn: usrPhn },
			function (response) {
				var availablephn = response.available;
				
				if (availablephn) {
					$("#usrPhn").removeClass("unusable input-error").addClass("available");
					$("#usrPhn-error").text("");
				} else {
					$("#usrPhn").removeClass("available").addClass("unusable input-error");
					$("#usrPhn-error").text("이미 사용중인 휴대전화번호입니다.");
				}
				toggleSubmitButton();
			}
		)
	});
	
    // 아이디, 비밀번호, 이메일, 휴대전화번호가 모두 사용 가능한 경우에만 제출 버튼 활성화
    function toggleSubmitButton() {
        if ($("#usrLgnId").hasClass("available") && $("#usrPw").hasClass("available") 
			&& $("#usrEml").hasClass("available") && $("#confirmPw").hassClass("available")
			&& $("#usrPhn").hassClass("available")) 
			{
            $("input[type=submit]").removeAttr("disabled");
        
		} else {
            $("input[type=submit]").attr("disabled", "disabled");
        }
    }
	

});
