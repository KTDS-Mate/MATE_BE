$().ready(function () {
	var loginId = $(".header-content").data("login-id");	
	console.log(loginId);

    $(".search-btn").on("click", function () {
        console.log(loginId);
        movePage(0);
    })


    $(".list-size").on("change", function () {
        // var listSize = $(this).val();
        // location.href = "/board/list?pageNo=0&listSize=" + listSize;

        movePage(0);

        // $(".page-no").val("0");
        // $(".search-form").attr({
        //     "method": "GET",
        //     "action": "/board/list"
        // }).submit();

    });
});

function movePage(pageNo) {
    var loginId = $(".header-content").data("login-id");
    console.log(loginId);
	

    $(".page-no").val(pageNo);
    $(".search-form").attr({
        "method": "GET",
        "action": `/mypage/mytour/gd-mytour/${loginId}`
    }).submit();
}

function deleteTour(usrLgnId, usrTrPstId) {
	if (confirm("정말 삭제하시겠습니까?")) {
	       location.href = `/mypage/mytour/gd-mytour/${usrLgnId}/delete-${usrTrPstId}`;
	   }
}



