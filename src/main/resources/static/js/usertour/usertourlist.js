$().ready(function() {

	var selectType = $(".search-type").val();
	var typeDom = $(".search-input");
	if (selectType === "price") {
		typeDom.attr("type", "number");
		typeDom.attr("placeholder", "가격을 입력해주세요.");
	}
	else if (selectType === "country") {
		typeDom.attr("type", "text");
		typeDom.attr("placeholder", "국가를 입력해주세요.");
	}
	else if (selectType === "city") {
		typeDom.attr("type", "text");
		typeDom.attr("placeholder", "도시를 입력해주세요.");
	}
	else {
		typeDom.attr("type", "text");
		typeDom.attr("placeholder", "제목을 입력해주세요.");
	}

	$(".search-button").on("click", function() {
		movepage(0);
	});

	$(".tour-box").on("click", function() {
		var usrTrPstId = $(this).find(".hide").data("pst-id");
		location.href = "/usertour/view?usrTrPstId=" + usrTrPstId
	});

	/**대륙 필터링에 사용 됨**/
	$("#all").on('click', function() {
		// 원래 다른 자식 요소에 걸려있는 클래스를 삭제함
		$(".country-menu-area").children().removeClass("checked");
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#asia").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#eu").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#ose").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#n-ame").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#s-ame").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#search-val-3").val($(this).val());
		movepage(0);
	});
	$("#af").on('click', function() {
		$(".country-menu-area").children().removeClass("checked");
		$("#search-val-3").val($(this).val());
		movepage(0);
	});

	/**정렬에 사용**/
	$("#latest").on('click', function() {
		// 원래 다른 자식 요소에 달려있는 클래스를 제거
		$(".list-view-option").children().removeClass("checked2");
		$("#search-val-4").val($(this).val());
		movepage(0);
	});
	$("#high-price").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		$("#search-val-4").val($(this).val());
		movepage(0);
	});
	$("#low-price").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		$("#search-val-4").val($(this).val());
		movepage(0);
	});
	$("#deadline").on('click', function() {
		$(".list-view-option").children().removeClass("checked2");
		$("#search-val-4").val($(this).val());
		movepage(0);
	});

	$(".search-type").on('change', function() {
		var type = $(this).val();
		var keywordDom = $(".search-input");

		if (type === "price") {
			keywordDom.attr("type", "number");
			keywordDom.attr("placeholder", "가격을 입력해주세요.");
		}
		else if (type === "country") {
			keywordDom.attr("type", "text");
			keywordDom.attr("placeholder", "국가를 입력해주세요.");
		}
		else if (type === "city") {
			keywordDom.attr("type", "text");
			keywordDom.attr("placeholder", "도시를 입력해주세요.");
		}
		else {
			keywordDom.attr("type", "text");
			keywordDom.attr("placeholder", "제목을 입력해주세요.");
		}

	});

});

function movepage(pageNo) {

	$(".page-no").val(pageNo);

	$(".search-form").attr({
		"method": "GET",
		"action": `/usertour/list`
	}).submit();

}
