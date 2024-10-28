$().ready(function () {
	var loginId = $(".header-content").data("loginId");
	
	
    $(".search-btn").on("click" , function(){
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
	var loginId = $(".header-content").data("loginId");
	
	
    $(".page-no").val(pageNo);
    $(".search-form").attr({
        "method": "GET",
        "action": `/gd-mytour/${loginId}`
    }).submit();
}

