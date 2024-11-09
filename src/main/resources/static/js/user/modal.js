$(document).ready(function() {

    var modal = $("#modal");
    var modalBody = $("#modalBody");
    var previousFocus;
    var iti; // 전역 변수로 선언

    // modalBody 선택 확인
    if (modalBody.length === 0) {
        console.error("#modalBody 요소가 DOM에 존재하지 않습니다.");
    }

    // 모달 열기 버튼 클릭
    $("#openEditPhoneModal").on("click", function(){
        // 이전 포커스 저장
        previousFocus = document.activeElement;

        // 모달 표시
        modal.addClass("show");

        // Ajax로 모달 컨텐츠 불러오기
        $.ajax({
            url: "/user/editphone/modal",
            type: "GET",
            success: function(data) {
                modalBody.html(data);

                // DOM이 업데이트된 후 input#newPhn 확인
                setTimeout(function() {  // DOM 업데이트를 보장하기 위해 setTimeout 사용
                    var input = modalBody.find("#newPhn")[0];
                    if (input) {
                        $("#newPhn").focus();
                        initializeIntlTelInput(input);
                    } else {
                        console.error("input#newPhn 요소를 찾을 수 없습니다.");
                    }
                }, 0);
            },
            error: function() {
                modalBody.html("");
                alert("로딩 실패");
            }
        });

    });

    // 모달 닫기 버튼 클릭 (이벤트 위임 사용)
    $(document).on("click", ".close-button", function(){
        closeModal();
    });

    // esc 키 누르면 모달 닫기
    $(document).on("keydown", function(event) {
        if (event.key === "Escape") {
            closeModal();
        }
    });

    // 모달 외부 클릭 시 닫기
    $(document).on("click", "#modal", function(event) {
        if ($(event.target).is("#modal")) {
            closeModal();
        }
    });

    // 모달 닫기 함수
    function closeModal() {
        modal.removeClass("show");
        modalBody.html(""); // 콘텐츠 비우기
        if (previousFocus) {
            $(previousFocus).focus(); // 이전 포커스로 돌아가기
        }
    }

    // 로드 된 폼 제출하기
    $(document).on("submit", "#editPhoneForm", function(e) {
        // 기본 폼 제출 방지
        e.preventDefault();

        var form = $(this);
        var input = document.getElementById("newPhn");
        var newPhn = iti.getNumber(); // 전역 변수 iti 사용
        var errorDiv = $("#newPhn-error");

        // 휴대전화번호 유효성 검사
        var phoneRegex = /^\+?[0-9]{10,15}$/; // 최소 10자리로 수정
        if (!phoneRegex.test(newPhn)) {
            errorDiv.text("휴대전화번호를 올바르게 입력해주세요.");
            return;
        } else {
            errorDiv.text(""); // 에러메세지 초기화
        }

        // 폼 제출
        $.ajax({
            url: form.attr("action"),
            type: "POST",
            data: { newPhn: newPhn },
            success: function(response) {
                if (response.success) {
                    alert(response.message);
                    closeModal();
                    location.reload();
                } else {
                    errorDiv.text(response.message);
                }
            },
            error: function() {
                alert("서버의 응답이 없습니다.");
            }	
        });
    });

    // intl-tel-input 초기화 함수
    function initializeIntlTelInput(input) {
        if (!input) {
            console.error("input 요소가 전달되지 않았습니다.");
            return;
        }

        iti = window.intlTelInput(input, {
            nationalMode: false,
            initialCountry: "auto",
            // 유저의 IP 기반을 바탕으로 국가 자동 설정.
            geoIpLookup: function(callback) {
                $.get('https://ipinfo.io', function() {}, "jsonp").always(function(resp) {
                    var countryCode = (resp && resp.country) ? resp.country : "kr";
                    callback(countryCode);
                });
            },
            utilsScript: "https://cdn.jsdelivr.net/npm/intl-tel-input@24.6.1/build/js/utils.js"
        });

        var phoneRegex = /^\+?[0-9]{10,15}$/; // 최소 10자리로 수정

        // 제출 버튼 토글 on/off
        function toggleSubmitButton() {
            if ($("#newPhn").hasClass("available")) {
                $(".submit-btn").prop("disabled", false);
            } else {
                $(".submit-btn").prop("disabled", true);
            }
        }

        // 새 휴대전화번호 유효성 검사
        $("#newPhn").on("keyup change", function() {
            var isValidIntl = iti.isValidNumber();
            var fullNumber = iti.getNumber();
            var isValidFormat = phoneRegex.test(fullNumber);

            if (!isValidIntl || !isValidFormat) {
                $("#newPhn-error").text("유효한 전화번호를 입력하세요.");
                $("#newPhn").addClass("input-error").removeClass("available");
            } else {
                $("#newPhn-error").text("");
                $("#newPhn").removeClass("input-error").addClass("available");
            }
            toggleSubmitButton();
        });

        // 휴대전화번호 중복 확인 및 정규식 검증
        $("#newPhn").on("keyup change", function(){
            var fullNumber = iti.getNumber();

            if (!iti.isValidNumber()){
                $("#newPhn-error").text("휴대전화번호를 올바르게 입력해주세요.");
                $("#newPhn").removeClass("available").addClass("unusable input-error");
                toggleSubmitButton();
                return;
            } else {
                $("#newPhn-error").text("");
                $("#newPhn").removeClass("unusable input-error").addClass("available");
            }

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
            );
        });
    }

});
