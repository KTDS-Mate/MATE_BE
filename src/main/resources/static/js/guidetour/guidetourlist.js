$().ready(function() {

	var selectType = $(".search-type").val();
	var typeDom = $(".search-input");
	if (selectType == "region") {
		typeDom.attr("placeholder", "찾고싶은 대륙을 입력하세요.");
	}
	else if (selectType == "country") {
		typeDom.attr("placeholder", "찾고싶은 국가를 입력하세요.");
	}
	else if (selectType == "city") {
		typeDom.attr("placeholder", "찾고싶은 도시를 입력하세요.");
	}
	else {
		typeDom.attr("placeholder", "찾고싶은 제목를 입력하세요.");
	}

	$(".search-button").on("click", function() {
		movepage(0);
	});

	$(".tour-box").on("click", function() {
		var gdTrPstId = $(this).find(".hide").data("gdpst-id");
		location.href = "/guidetour/info?gdTrPstId=" + gdTrPstId
	});

	/**대륙 필터링에 사용 됨**/
	$("#all").on('click', function() {
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#asia").on('click', function() {
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#eu").on('click', function() {
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#ose").on('click', function() {
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#n-ame").on('click', function() {
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#s-ame").on('click', function() {
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#af").on('click', function() {
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	/**정렬에 사용**/
	$("#high-price").on("click", function() {
		$("#search-val-4").val($(this).val());
		movepage(0);
	});
	$("#row-price").on("click", function() {
		$("#search-val-4").val($(this).val());
		movepage(0);
	});
	$("#deadline").on("click", function() {
		$("#search-val-4").val($(this).val());
		movepage(0);
	});
	$("#latest").on("click", function() {
		$("#search-val-4").val($(this).val());
		movepage(0);
	});
	$("#high-rating").on("click", function() {
		$("#search-val-4").val($(this).val());
		movepage(0);
	});

	$(".search-button").on("click", function() {
		movepage(0);
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

	$(".search-form").attr({
		"method": "GET",
		"action": `/guidetour/list`
	}).submit();
}