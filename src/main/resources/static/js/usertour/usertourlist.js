$().ready(function() {

	$(".search-button").on("click", function() {
		movepage(0);
	});

	$(".tour-box").on("click", function() {
		var usrTrPstId = $(this).find(".hide").data("pst-id");
		location.href = "/usertour/view?usrTrPstId=" + usrTrPstId
	});

	/**대륙 필터링에 사용 됨**/
	$("#all").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		location.href = "/usertour/list?regionName=" + $(this).val(); + "&orderby=최신순"
	});
	$("#asia").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		location.href = "/usertour/list?regionName=" + $(this).val(); + "&orderby=최신순"
	});
	$("#eu").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		location.href = "/usertour/list?regionName=" + $(this).val(); + "&orderby=최신순"
	});
	$("#ose").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		location.href = "/usertour/list?regionName=" + $(this).val(); + "&orderby=최신순"
	});
	$("#n-ame").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		location.href = "/usertour/list?regionName=" + $(this).val(); + "&orderby=최신순"
	});
	$("#s-ame").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		location.href = "/usertour/list?regionName=" + $(this).val(); + "&orderby=최신순"
	});
	$("#af").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		location.href = "/usertour/list?regionName=" + $(this).val(); + "&orderby=최신순"
	});

	/**정렬에 사용**/
	$("#latest").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		var regionName = $("#region-hide").val();
		location.href = "/usertour/list?regionName=" + regionName + "&orderby=" + $(this).val();
	});
	$("#high-price").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		var regionName = $("#region-hide").val();
		location.href = "/usertour/list?regionName=" + regionName + "&orderby=" + $(this).val();
	});
	$("#low-price").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		var regionName = $("#region-hide").val();
		location.href = "/usertour/list?regionName=" + regionName + "&orderby=" + $(this).val();
	});
	$("#deadline").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		var regionName = $("#region-hide").val();
		location.href = "/usertour/list?regionName=" + regionName + "&orderby=" + $(this).val();
	});


});

function movepage(pageNo) {
	$(".page-no").val(pageNo);

	$(".search-form").attr({
		"method": "GET",
		"action": "list"
	}).submit();
}
