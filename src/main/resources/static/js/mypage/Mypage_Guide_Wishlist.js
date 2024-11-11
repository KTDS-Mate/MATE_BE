$().ready(function () {
    var loginId = $(".header-content").data("login-id");



    $(".list-size").on("change", function () {
        
        movePage(0);



    });
});

function movePage(pageNo) {
    var loginId = $(".header-content").data("login-id");

    $(".page-no").val(pageNo);
	location.href = `/mypage/wishlist/gd-wishlist/${loginId}?pageNo=${pageNo}`;

}


function deleteTour(usrLgnId, favId) {

	if (confirm("정말 삭제하시겠습니까?")) {
	       location.href = `/mypage/wishlist/gd-wishlist/${usrLgnId}/delete-${favId}`;
	   }
}





