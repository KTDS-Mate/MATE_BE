$().ready(function () {
    // 제출버튼 비활성화
    $("input[type=submit]").attr("disabled", "disabled");
    
    // 아이디 정규 표현식 설정
    var idRegex = /^[a-z0-9-_]{5,21}$/;
    
    // 비밀번호 정규 표현식
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\-=/]).{8,16}$/;
	
	// 휴대전화번호 정규 표현식
	var phoneRegex = /^\+?[0-9]{10,15}$/; // 최소 10자리로 수정
    
    // 이메일 정규 표현식
    var emailRegex = /^[a-z0-9_\.\-]+@[a-z0-9\-]+\.[a-z0-9\-]+/;

	// intl-tel-input 초기화
	var input = document.querySelector("#usrPhn");
	var iti = window.intlTelInput(input, {
	    nationalMode: false, // 국제 전화번호 형식으로 설정
	    initialCountry: "auto",
	    geoIpLookup: function(callback) {
	        $.get('https://ipinfo.io', function() {}, "jsonp").always(function(resp) {
	            var countryCode = (resp && resp.country) ? resp.country : "kr";
	            callback(countryCode);
	        });
	    },
	    utilsScript: "https://cdn.jsdelivr.net/npm/intl-tel-input@18.1.1/build/js/utils.js" // 최신 버전 사용
	});

	input.addEventListener("change", function() {
	    var selectedCountryData = iti.getSelectedCountryData();
	    // 국가코드도 저장.
	    $("#usrCountryCode").val(selectedCountryData.dialCode);
	    console.log("국가코드", selectedCountryData.iso2);
	    console.log("전화번호", iti.getNumber());
	});

    // 아이디 유효성 검사 및 중복 확인
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
                    // 아이디 중복 메세지 제거
                    $("#usrLgnId-error").text("");
                } else {
                    $("#usrLgnId").removeClass("available").addClass("unusable input-error");
                    // available 값이 false인 경우
                    $("#usrLgnId-error").text("이미 사용 중인 아이디입니다.");
                }
                toggleSubmitButton(); // 아이디 상태 변경 후 제출 버튼 활성화 여부 확인
            });
    });
    
    // 비밀번호 유효성 검사
    $("#usrPwd").keyup(function() {
        var usrPwd = $(this).val();
        var confirmPwd = $("#confirmPwd").val();
        
        if (!passwordRegex.test(usrPwd)) {
            $("#usrPwd-error").text("비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
            $("#usrPwd").removeClass("available").addClass("unusable input-error");
        } else {
            $("#usrPwd-error").text("");
            $("#usrPwd").removeClass("unusable input-error").addClass("available");
            
            // 비밀번호 확인 값이 있을 경우 일치여부 확인
            if (confirmPwd) {
                if (usrPwd !== confirmPwd) {
                    $("#confirmPwd-error").text("비밀번호가 일치하지 않습니다.");
                    $("#confirmPwd").removeClass("available").addClass("unusable input-error");
                } else {
                    $("#confirmPwd-error").text("");
                    $("#confirmPwd").removeClass("unusable input-error").addClass("available");
                }
            }
        }
        toggleSubmitButton();
    });
    
    // 비밀번호 확인 유효성 검사
    $("#confirmPwd").keyup(function() {
        var usrPwd = $("#usrPwd").val();
        var confirmPwd = $(this).val();
        
        if (!usrPwd) {
            $("#confirmPwd-error").text("비밀번호를 입력하세요.");
            $("#confirmPwd").removeClass("available").addClass("unusable input-error");
        } else if (usrPwd !== confirmPwd){
            $("#confirmPwd-error").text("비밀번호가 일치하지 않습니다.");
            $("#confirmPwd").removeClass("available").addClass("unusable input-error");
        } else {
            $("#confirmPwd-error").text("");
            $("#confirmPwd").removeClass("unusable input-error").addClass("available");
        }
        toggleSubmitButton();
    });

    // 이메일 중복 확인 검사 및 이메일 유효성 검사
    $("#usrEml").keyup(function () {
        var usrEml = $(this).val();

        // 이메일 유효성 검사
        if (!emailRegex.test(usrEml)) {
            $("#usrEml-error").text("유효한 이메일 형식이 아닙니다.");
            $("#usrEml").removeClass("available").addClass("unusable input-error");
            toggleSubmitButton();
            return;
        } else {
            $("#usrEml-error").text("");
            $("#usrEml").removeClass("unusable input-error").addClass("available");
        }
        
        // 이메일 중복확인 검사
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

	// 휴대전화번호 중복 확인 및 유효성 검증
	$("#usrPhn").on("keyup change", function() {
	    var usrPhn = iti.getNumber(); // 국제 전화번호 형식으로 가져옴
	    var isValidIntl = iti.isValidNumber();
	    var isValidFormat = phoneRegex.test(usrPhn);

	    // 휴대전화번호 유효성 검증
	    if (!isValidIntl || !isValidFormat) {
	        $("#usrPhn-error").text("휴대전화번호를 올바르게 입력해주세요.");
	        $("#usrPhn").removeClass("available").addClass("unusable input-error");
	        toggleSubmitButton();
	        return;
	    } else {
	        $("#usrPhn-error").text("");
	        $("#usrPhn").removeClass("unusable input-error").addClass("available");
	    }

	    // 휴대전화번호 중복 검증	
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
	    );
	});

    // 대표 국적 선택 유효성 검사
    $("#country").change(function () {
        if ($(this).val() === "") {
            $("#country-error").text("대표 국적을 선택해주세요.");
            $(this).addClass("input-error");
        } else {
            $("#country-error").text("");
            $(this).removeClass("input-error");
        }
        toggleSubmitButton();
    });

    // 제출 버튼 활성화/비활성화 토글 함수
    function toggleSubmitButton() {
        if ($("#usrLgnId").hasClass("available") && $("#usrPwd").hasClass("available") 
            && $("#usrEml").hasClass("available") && $("#confirmPwd").hasClass("available")
            && $("#usrPhn").hasClass("available") && $("#country").val() !== "") {
            $("input[type=submit]").removeAttr("disabled");
        
        } else {
            $("input[type=submit]").attr("disabled", "disabled");
        }
    }
});
