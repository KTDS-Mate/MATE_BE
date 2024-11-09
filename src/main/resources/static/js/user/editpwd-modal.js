$(document).ready(function() {

    var modal = $("#modal");
    var modalBody = $(".modal-content");
    var previousFocus;

    // modalBody 선택 확인
    if (modalBody.length === 0) {
        console.error("#modal-content 요소가 DOM에 존재하지 않습니다.");
    }

    // 모달 열기 버튼 클릭
    $("#changePwdBtn").on("click", function(){
        // 이전 포커스 저장
        previousFocus = document.activeElement;

        // 모달 표시
        modal.addClass("show");

        // Ajax로 모달 컨텐츠 불러오기
        $.ajax({
            url: "/user/editpwd",
            type: "GET",
            success: function(data) {
                modalBody.html(data);

                // DOM이 업데이트된 후 폼 요소 확인
                setTimeout(function() {
                    var form = modalBody.find("#pwdChangeForm")[0];
                    if (form) {
                        $("#currentPwd").focus();
                        initPwdChangeForm();
                    } else {
                        console.error("#pwdChangeForm 요소를 찾을 수 없습니다.");
                    }
                }, 0);
            },
            error: function() {
                modalBody.html("");
                alert("비밀번호 변경 폼을 불러오는데 실패했습니다.");
            }
        });

    });

    // 모달 닫기 버튼 클릭
    $(document).on("click", ".close-btn", function(){
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

    // 폼 검증 및 제출 핸들러 초기화 함수
    function initPwdChangeForm() {
        var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\-=/]).{8,16}$/;

        // 제출 버튼 토글 on/off
        function toggleSubmitButton() {
            var isCurrentPwdFilled = $("#currentPwd").val().trim() !== "";
            var isNewPwdValid = passwordRegex.test($("#newPwd").val());
            var isConfirmPwdMatch = $("#confirmPwd").val() === $("#newPwd").val();

            $(".submit-btn").prop("disabled", !(isCurrentPwdFilled && isNewPwdValid && isConfirmPwdMatch));
        }

        // 현재 비밀번호 실시간 검증
        $("#currentPwd").on("input", function () {
            var currentPwd = $(this).val();

            if (currentPwd.trim() !== "") {
                $.ajax({
                    url: "/user/checkCurrentPassword",
                    type: "POST",
                    data: { currentPwd: currentPwd },
                    success: function (response) {
                        if (response.isValid) {
                            $("#currentPwd-error").text("");
                            $("#currentPwd").removeClass("input-error").addClass("valid");
                        } else {
                            $("#currentPwd-error").text(response.message);
                            $("#currentPwd").removeClass("valid").addClass("input-error");
                        }
                        toggleSubmitButton();
                    },
                    error: function () {
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
        $("#newPwd").on("input", function () {
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
        $("#confirmPwd").on("input", function () {
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

        // 제출 버튼 초기 상태 설정
        toggleSubmitButton();

        // 폼 제출 핸들러
        $(document).on("submit", "#pwdChangeForm", function (e) {
            e.preventDefault();

            var form = $(this);
            var currentPwd = $("#currentPwd").val();
            var newPwd = $("#newPwd").val();
            var confirmPwd = $("#confirmPwd").val();

            $.ajax({
                url: form.attr("action"),
                type: "POST",
                data: {
                    currentPwd: currentPwd,
                    newPwd: newPwd,
                    confirmPwd: confirmPwd
                },
                success: function (response) {
                    if (response.success) {
                        alert(response.message);
                        closeModal();
                        location.reload(); // 페이지 새로고침 또는 업데이트
                    } else {
                        alert(response.message);
                    }
                },
                error: function () {
                    alert("비밀번호 변경에 실패했습니다.");
                }
            });
        });
    }

});
