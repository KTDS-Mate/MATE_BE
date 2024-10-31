$().ready(function () {
    var loginId = $(".header-content").attr("data-loginId");





    $(".list-size").on("change", function () {
        
        movePage(0);



    });
});

function movePage(pageNo) {
    var loginId = $(".header-content").attr("data-loginId");
	console.log(pageNo);

    $(".page-no").val(pageNo);
	location.href = `/mypage/wishlist/gd-wishlist/${loginId}?pageNo=${pageNo}`;

}





