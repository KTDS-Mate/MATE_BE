$().ready(function() {
	$(".search-button").on("click", function() {
		movepage(0);
	});

	$(".tour-box").on("click", function() {
		var gdTrPstId = $(this).find(".hide").data("gdpst-id");
		console.log(gdTrPstId);
		location.href = "/guidetour/info?gdTrPstId=" + gdTrPstId
	});

	/**정렬에 사용**/
	$("#high-price").on("click", function() {
		// 다른 자식 요소에 달려있는 클래스 삭제
		$(".list-view-option").children().removeClass("checked2");
		// url을 파라미터에 담아서 전송
		var regionName = $("#region-hide").val();
		location.href = "/guidetour/list?regionName=" + regionName + "&orderBy=" + $(this).val();
	});
	$("#row-price").on("click", function() {
		// 다른 자식 요소에 달려있는 클래스 삭제
		$(".list-view-option").children().removeClass("checked2");
		// url을 파라미터에 담아서 전송
		var regionName = $("#region-hide").val();
		location.href = "/guidetour/list?regionName=" + regionName + "&orderBy=" + $(this).val();
	});
	$("#deadline").on("click", function() {
		// 다른 자식 요소에 달려있는 클래스 삭제
		$(".list-view-option").children().removeClass("checked2");
		// url을 파라미터에 담아서 전송
		var regionName = $("#region-hide").val();
		location.href = "/guidetour/list?regionName=" + regionName + "&orderBy=" + $(this).val();
	});
	$("#latest").on("click", function() {
		// 다른 자식 요소에 달려있는 클래스 삭제
		$(".list-view-option").children().removeClass("checked2");
		// url을 파라미터에 담아서 전송
		var regionName = $("#region-hide").val();
		location.href = "/guidetour/list?regionName=" + regionName + "&orderBy=" + $(this).val();
	});
	$("#high-rating").on("click", function() {
		// 다른 자식 요소에 달려있는 클래스 삭제
		$(".list-view-option").children().removeClass("checked2");
		// url을 파라미터에 담아서 전송
		var regionName = $("#region-hide").val();
		location.href = "/guidetour/list?regionName=" + regionName + "&orderBy=" + $(this).val();
	});

	$(".search-button").on("click", function() {
		
		$(".search-form").attr({
			"method": "GET",
			"action": "list"
		}).submit();
	});

	$(".search-type").on("click", function() {
		var type = $(this).val();
		var keyword = $(".search-input");
		
		if (type == "region") {
			keyword.attr("placeholder", "찾고싶은 대륙을 입력하세요.");
		}
		else if (type == "country") {
			keyword.attr("placeholder", "찾고싶은 국가를 입력하세요.");
		}
		else if (type == "city") {
			keyword.attr("placeholder", "찾고싶은 도시를 입력하세요.");
		}
		else {
			keyword.attr("placeholder", "찾고싶은 제목를 입력하세요.");
		}
	});
});

function movepage(pageNo) {
	$(".page-no").val(pageNo);
	

}