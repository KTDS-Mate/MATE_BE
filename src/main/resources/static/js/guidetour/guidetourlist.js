$().ready(function() {
	$(".search-button").on("click", function() {
		movepage(0);
	});
	
	$(".tour-box").on("click", function() {
		var gdTrPstId = $(this).find(".hide").data("gdpst-id");
		console.log(gdTrPstId);
		location.href = "/guidetour/info?gdTrPstId=" + gdTrPstId
	});
});

function movepage (pageNo){
	$(".page-no").val(pageNo);
	
	$(".search-form").attr({
		"method": "GET",
		"action": "guidetour/list"
	}).submit();
}