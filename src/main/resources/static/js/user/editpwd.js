$(document).ready(function () {
    // 비밀번호 정규 표현식
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\-=/]).{8,16}$/;

	// 현재 비밀번호 검증
	    $("#currentPwd").on("input", function() {
	        var currentPwd = $(this).val();

	        if (currentPwd.trim() !== "") {
	            $.ajax({
	                url: "/user/checkCurrentPassword",  // 서버의 현재 비밀번호 검증 URL
	                type: "POST",
	                data: { currentPwd: currentPwd },
	                success: function(response) {
	                    if (response.isValid) {
	                        $("#currentPwd-error").text("");
	                        $("#currentPwd").removeClass("input-error").addClass("valid");
	                    } else {
	                        $("#currentPwd-error").text("현재 비밀번호가 올바르지 않습니다.");
	                        $("#currentPwd").removeClass("valid").addClass("input-error");
	                    }
	                    toggleSubmitButton();
	                },
	                error: function() {
	                    $("#currentPwd-error").text("서버와의 통신 오류가 발생했습니다.");
	                    $("#currentPwd").addClass("input-error");
	                    toggleSubmitButton();
	                }
	            });
	        } else {
				$("#currentPwd-error").text("현재 비밀번호를 입력해주세요.");
				$("#currentPwd").addClass("input-error");
				toggleSubmitButton();
	        }
	    });
	
    // 새 비밀번호 유효성 검사
    $("#newPwd").on("input", function() {
        var newPwd = $(this).val();
        if (!passwordRegex.test(newPwd)) {
            $("#newPwd-error").text("비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
            $("#newPwd").addClass("input-error");
        } else {
            $("#newPwd-error").text("");
            $("#newPwd").removeClass("input-error");
        }
        toggleSubmitButton();
    });

    // 새 비밀번호 확인 일치 여부 검사
    $("#confirmPwd").on("input", function() {
        var confirmPwd = $(this).val();
        var newPwd = $("#newPwd").val();

        if (confirmPwd !== newPwd) {
            $("#confirmPwd-error").text("비밀번호가 일치하지 않습니다.");
            $("#confirmPwd").addClass("input-error");
        } else {
            $("#confirmPwd-error").text("");
            $("#confirmPwd").removeClass("input-error");
        }
        toggleSubmitButton();
    });

    // 제출 버튼 활성화 검사 함수
    function toggleSubmitButton() {
        var isCurrentPwdFilled = $("#currentPwd").val().trim() !== "";
        var isNewPwdValid = passwordRegex.test($("#newPwd").val());
        var isConfirmPwdMatch = $("#confirmPwd").val() === $("#newPwd").val();
        
        $(".submit-btn").attr("disabled", !(isCurrentPwdFilled && isNewPwdValid && isConfirmPwdMatch));
    }
});
