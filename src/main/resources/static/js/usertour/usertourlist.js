$().ready(function() {
	$(".search-button").on("click", function() {
		movepage(0);
	});
});

function movepage (pageNo){
	$(".page-no").val(pageNo);
	
	$(".search-form").attr({
		"method": "GET",
		"action": "usertour/list"
	}).submit();
}