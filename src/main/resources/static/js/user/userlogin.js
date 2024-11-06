$().ready(function () {
	// 현재 웹 페이지의 url 정보를 가져온다.  호스트 이름과 포트 번호 이후의 경로 = ex) /user/login (localhost:8080은 빠진다.)
	var pathname = location.pathname;
	// 현재 url의 쿼리 파라미터를 가져와서 search에 저장. login?user=123 이면 search는 ?user=123
	// pathname 이후의 쿼리파라미터.
	var search = location.search;
	// 다음으로 보여줄 Url 변수 선언
	var nextUrl = "";
	// 만약 현재 경로가 user/login이면 로그인을 하려는 것.
	if (pathname === "/user/login") {
		// 다음으로 보여줄 url은 /mate
		nextUrl = "/";
		
	} else {
		// 현재 페이지가 로그인 페이지가 아니면 -> 로그인 후에 현재 페이지로 돌아 갈 수 있도록 설정.
		nextUrl = pathname + search;
	}
	// <input type="hidden" name="nextUrl" /> 얘의 nextUrl을 설정해주는 것.
	$("input[name=nextUrl]").val(nextUrl);
});

$(document).ready(function() {

    var message = $(".login-container").data("message");
    var messageType = $(".login-container").data("message-type");

    console.log("message:" + message);
    console.log("messageType:" + message);

    if (message) {
        if (messageType === "success" || messageType === "error") {
            alert(message);
        }
    }
});
