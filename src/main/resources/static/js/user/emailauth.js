$(document).ready(function () {
    $("#auth-button").click(function() {
        var email = $("#usrEml").val();

        // 이메일 유효성 검사
        var emailRegex = /^[a-z0-9_\.\-]+@[a-z0-9\-]+\.[a-z0-9\-]+/;
        if (!email) {
            alert("이메일을 입력하세요.");
            return;
        }
        if (!emailRegex.test(email)) {
            alert("유효한 이메일 주소를 입력하세요.");
            return;
        }

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

                    // 인증번호 입력 필드와 버튼을 동적으로 생성
                    createAuthCodeInput();
                } else {
                    alert("인증번호를 전송할 수 없습니다.");
                }
            },
            error: function() {
                // 올바르지 않은 Response 도착, Redis 서버에 접속하지 못하는 경우
                alert("오류가 발생했습니다. 잠시 후 다시 시도해 주세요.");
            }
        });
    });

    // 이메일 입력 값이 변경되면 인증번호 입력 필드와 버튼 제거
    $("#usrEml").on("input", function() {
        removeAuthCodeInput();
    });

    // 인증 코드 확인 버튼 클릭 이벤트 핸들러 등록
    $(document).on('click', '#verify-btn', function() {
        // 인증 코드 확인 로직
        var authCode = $("#authCode").val();
        var email = $("#usrEml").val();

        if (!authCode) {
            alert("인증번호를 입력하세요.");
            return;
        }

        var authData = {
            email: email,
            authCode: authCode
        };

        $.ajax({
            type: "POST",
            url: "api/user/regist/verify-auth-code",
            contentType: "application/json",
            data: JSON.stringify(authData),
            success: function(response) {
                if (response.valid) {
                    alert("인증이 완료되었습니다.");
                    $("#authVerified").val("true");
                    // 인증 완료 표시 또는 추가 로직 수행
                } else {
                    alert("인증번호가 일치하지 않습니다.");
                }
            },
            error: function() {
                alert("오류가 발생했습니다. 잠시 후 다시 시도해 주세요.");
            }
        });
    });
});

function createAuthCodeInput() {
    // 이미 생성되어 있다면 중복 생성 방지
    if ($("#auth-code-group").length === 0) {
        var authCodeGroup = `
            <div class="form-group" id="auth-code-group">
                <label for="authCode">인증번호입력</label>
                <input type="text" id="authCode" name="authCode" value="" />
                <button type="button" id="verify-btn" class="send-code-btn">인증 코드 확인</button>
            </div>
        `;
        $(authCodeGroup).insertAfter($("#auth-button").parent());
    }
}

function removeAuthCodeInput() {
    $("#auth-code-group").remove();
}
