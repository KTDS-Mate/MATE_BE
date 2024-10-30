$().ready(function() {

	$(".search-button").on("click", function() {
		movepage(0);
	});

	$(".tour-box").on("click", function() {
		var usrTrPstId = $(this).find(".hide").data("pst-id");
		console.log(usrTrPstId);
		location.href = "/usertour/view?usrTrPstId=" + usrTrPstId
	});

	changeColor();
});

function movepage(pageNo) {
	$(".page-no").val(pageNo);

	$(".search-form").attr({
		"method": "GET",
		"action": "usertour/list"
	}).submit();
}


function changeColor() {
	$("#all").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#all").addClass("checked");
	});
	$("#asia").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#asia").addClass("checked");
	});
	$("#eu").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#eu").addClass("checked");
	});
	$("#ose").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#ose").addClass("checked");
	});
	$("#n-ame").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#n-ame").addClass("checked");
	});
	$("#s-ame").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#s-ame").addClass("checked");
	});

	$("#latest").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		$("#latest").addClass("checked2");
	});
	$("#high-price").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		$("#high-price").addClass("checked2");
	});
	$("#low-price").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		$("#low-price").addClass("checked2");
	});
	$("#deadline").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		$("#deadline").addClass("checked2");
	});
}