$().ready(function() {

	var loginId = $(".header-content").data("login-id");


	$(".activate").on('click', function() {
		var pstId = $(this).data("pst-id");
		var divide = $(this).data("divide");
		if (divide === 'REQUEST') {
			location.href = `/usertour/view/request?usrTrPstId=${pstId}`
		}
		else {
			location.href = `/usertour/view?usrTrPstId=${pstId}`
		}
	});


	$(".list-size").on("change", function() {

		movePage(0);



	});
});

function movePage(pageNo) {
	var loginId = $(".header-content").data("login-id");

	$(".page-no").val(pageNo);
	location.href = `/mypage/wishlist/tr-wishlist/${loginId}?pageNo=${pageNo}`;

}

function deleteTour(usrLgnId, favId) {
	if (confirm("정말 삭제하시겠습니까?")) {
		location.href = `/mypage/wishlist/tr-wishlist/${usrLgnId}/delete-${favId}`;
	}
	else {
		alert("취소하였습니다.");
	}
}





