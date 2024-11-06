$(document).ready(function () {
	
	// 휴대전화번호 중복 확인 및 정규식 검증
	$("#newPhn").keyup(function() {
		var fullNumber = iti.getNumber();
		
		// 정규 표현식을 사용해서 휴대전화번호 유효성 검증
		if (!phoneRegex.test(fullNumber)) {
			$("#newPhn-error").text("휴대전화번호를 올바르게 입력해주세요.");
			$("#newPhn").removeClass("available").addClass("unusable input-error");
			toggleSubmitButton();
			return;
		} else {
			$("#newPhn-error").text("");
			$("#newPhn").removeClass("unusable input-error").addClass("available");
		}
		// 휴대전화번호 중복 검증	
		$.get("/user/regist/availablephn",
			{ usrPhn: fullNumber },
			function (response) {
				var availablephn = response.available;
				
				if (availablephn) {
					$("#newPhn").removeClass("unusable input-error").addClass("available");
					$("#newPhn-error").text("");
				} else {
					$("#newPhn").removeClass("available").addClass("unusable input-error");
					$("#newPhn-error").text("이미 사용중인 휴대전화번호입니다.");
				}
				toggleSubmitButton();
			}
		)
	}); 

    // 새 휴대전화번호 필드에 intlTelInput 적용
    var input = document.querySelector("#newPhn");
    var iti = window.intlTelInput(input, {
        nationalMode: true,
        utilsScript: "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/utils.js"
    });

    // 휴대전화번호 검증 정규 표현식
    var phoneRegex = /^\+?[0-9]{1,15}$/;

    // 새 휴대전화번호 유효성 검사
    $("#newPhn").on("keyup change", function() {
        var isValidIntl = iti.isValidNumber(); // intlTelInput을 통한 전화번호 유효성 검사
        var fullNumber = iti.getNumber(); // 국가 코드 포함 전체 전화번호
        var isValidFormat = phoneRegex.test(fullNumber); // 정규 표현식을 통한 형식 검사

        if (!isValidIntl || !isValidFormat) {
            $("#newPhn-error").text("유효한 전화번호를 입력하세요.");
            $("#newPhn").addClass("input-error");
        } else {
            $("#newPhn-error").text("");
            $("#newPhn").removeClass("input-error");
        }
    });

    // 제출 버튼 클릭 시 전화번호 포맷 적용
    $("form").on("submit", function(event) {
        var fullNumber = iti.getNumber();
        
        // 최종 정규 표현식 확인
        if (!phoneRegex.test(fullNumber)) {
            event.preventDefault(); // 제출 중단
            $("#newPhn-error").text("올바른 형식의 전화번호를 입력하세요.");
            return false;
        }

        // 국가 코드가 포함된 전체 전화번호로 값을 설정
        $("#newPhn").val(fullNumber);
		
		alert("휴대전화 번호 변경이 완료되었습니다!")
    });
});
