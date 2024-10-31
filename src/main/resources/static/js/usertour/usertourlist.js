$().ready(function() {

	$(".search-button").on("click", function() {
		movepage(0);
	});

	$(".tour-box").on("click", function() {
		var usrTrPstId = $(this).find(".hide").data("pst-id");
		location.href = "/usertour/view?usrTrPstId=" + usrTrPstId
	});

	$("#all").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$(".country-form").attr({
			"method": "GET",
			"action": 'list?regionName=' + $(this).val()
		}).submit();
	});
	$("#asia").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$(".country-form").attr({
			"method": "GET",
			"action": 'list?regionName=' + $(this).val()
		}).submit();
	});
	$("#eu").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$(".country-form").attr({
			"method": "GET",
			"action": 'list?regionName=' + $(this).val()
		}).submit();
	});
	$("#ose").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$(".country-form").attr({
			"method": "GET",
			"action": 'list?regionName=' + $(this).val()
		}).submit();
	});
	$("#n-ame").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$(".country-form").attr({
			"method": "GET",
			"action": 'list?regionName=' + $(this).val()
		}).submit();
	});
	$("#s-ame").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$(".country-form").attr({
			"method": "GET",
			"action": 'list?regionName=' + $(this).val()
		}).submit();
	});

	changeColor();

});

function movepage(pageNo) {
	$(".page-no").val(pageNo);

	$(".search-form").attr({
		"method": "GET",
		"action": "list"
	}).submit();
}

function changeColor() {

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