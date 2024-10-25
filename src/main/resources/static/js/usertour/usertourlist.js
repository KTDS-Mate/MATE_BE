$().ready(function() {
	$(".search-button").on("click", function() {
		movepage(0);
	});
	
	$(".tour-box").on("click", function() {
		var usrTrPstId = $(this).find(".hide").data("pst-id");
		console.log(usrTrPstId);
		location.href = "/usertour/view?usrTrPstId="+ usrTrPstId
	});
	
});

function movepage (pageNo){
	$(".page-no").val(pageNo);
	
	$(".search-form").attr({
		"method": "GET",
		"action": "usertour/list"
	}).submit();
}