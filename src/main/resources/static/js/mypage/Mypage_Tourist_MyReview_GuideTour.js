$().ready(function () {
    var usrLgnId = $(".header-content").data("login-id");


    $(".search-btn").on("click", function () {
        movePage(0);
    })
	
	
	$(".guide").on("click" , function() {
			goToGuideReview(usrLgnId);
		})
		
	$(".guide-tour").on("click" , function() {
			goToGuideTourReview(usrLgnId);
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

    $(".page-no").val(pageNo);
    $(".search-form").attr({
        "method": "GET",
        "action": `/mypage/review/tr-guidetour/${loginId}`
    }).submit();
}

function goToGuideReview(usrLgnId) {
	location.href = `/mypage/review/tr-guide/${usrLgnId}`;
}

function goToGuideTourReview(usrLgnId) {
	location.href = `/mypage/review/tr-guidetour/${usrLgnId}`;
}


function deleteTour(usrLgnId, usrTrPstId) {
	if (confirm("정말 삭제하시겠습니까?")) {
	       location.href = `/mypage/review/tr-guidetour/${usrLgnId}/delete-${usrTrPstId}`;
	   }
}



