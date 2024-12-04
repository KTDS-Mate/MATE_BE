$().ready(function() {
	var loginId = $(".header-content").data("login-id");


	$(".search-btn").on("click", function() {
		movePage(0);
	})


	$(".list-size").on("change", function() {
		// var listSize = $(this).val();
		// location.href = "/board/list?pageNo=0&listSize=" + listSize;

		movePage(0);

		// $(".page-no").val("0");
		// $(".search-form").attr({
		//     "method": "GET",
		//     "action": "/board/list"
		// }).submit();

	});

	$(".close").on('click', function() {
		$("#modal").css('display', 'none');
		$(".requestList").empty();
		$("body").removeClass("modal-open");
	});

	$(window).on('click', function(event) {
		if (event.target === modal[0]) {
			$("#modal").css('display', 'none');
			$("body").removeClass("modal-open");
		}
	});

	$(".guideBtn").on('click', function() {
		$("#modal").css('display', 'block');
		$("body").addClass("modal-open");
		var usrTrPstId = $(this).data("pst-id");

		var appendedDom = $(".requestList");

		$.get(`/requestApply/${usrTrPstId}`, {}, function(result) {
			var requestGuideApplyCount = result.requestGuideApplyCount;
			if (requestGuideApplyCount === 0) {
				appendedDom.append(`<div class="redColor">등록된 투어가 없습니다!</div>`);
			}
			else {
				for (var i = 0; i < requestGuideApplyCount; i++) {
					var applyBox = $(`<div class="applyBox">
													<div class="leftModal">
														<div class="applyTitle">
															제목 : ${result.requestGuideApplys[i].gdApplyTtl}
														</div>
														<div class="applyGuide">
															<div>이름 : ${result.requestGuideApplys[i].userVO.usrLnm} ${result.requestGuideApplys[i].userVO.usrFnm}</div>
															<div>나이 : 만 ${result.requestGuideApplys[i].userVO.age}세</div>
															<div>경력 : ${result.requestGuideApplys[i].userVO.usrGdExp}년</div>
														</div>
														<div class="applySummation">
															투어 요약 : ${result.requestGuideApplys[i].trGdApplyDtl}
														</div>
														<div class="applyPrice">
															가격 : $${result.requestGuideApplys[i].gdApplyPrc}
														</div>
													</div>
													<div class="rightModal">
														<input class="viewBtn" type="button" value="투어 일정 보기" data-ps-id=${result.requestGuideApplys[i].gdApplyId} />
													</div>
												</div>`);
					appendedDom.append(applyBox);
				}
			}


		});
	});

	$(document).on('click', ".viewBtn", function() {
		var requestGuideApplyId = $(this).data("ps-id");
		console.log(requestGuideApplyId);
        location.href = `tourApply/detail?gdApplyId=${requestGuideApplyId}`;
	});
	
	
});

function movePage(pageNo) {
	var loginId = $(".header-content").data("login-id");

	$(".page-no").val(pageNo);
	$(".search-form").attr({
		"method": "GET",
		"action": `/mypage/mytour/tr-mytour/${loginId}`
	}).submit();
}

function deleteTour(usrLgnId, usrTrPstId) {
	if (confirm("정말 삭제하시겠습니까?")) {
		location.href = `/mypage/mytour/tr-mytour/${usrLgnId}/delete-${usrTrPstId}`;
	}
}



