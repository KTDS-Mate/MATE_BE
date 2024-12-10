$().ready(function() {

	$(".apply-btn").on('click', function() {
		$("#modal").css('display', 'block');
		$("body").addClass("modal-open");
	});

	$(".close").on('click', function() {
		$("#modal").css('display', 'none');
		$("body").removeClass("modal-open");
	});

	$(window).on('click', function(event) {
		if (event.target === modal[0]) {
			$("#modal").css('display', 'none');
			$("body").removeClass("modal-open");
		}
	});

	// 투어 희망 정보를 입력할 때 추가하기 버튼을 누르면 실행
	$("#plus").on("click", function() {
		// 가상 돔으로 추가되는 div의 길이를 구함 -> index를 알기 위해
		var locsCnt = $(".locs").length;
		
		if (locsCnt > 9) {
			alert("최대 10개 까지 작성할 수 있습니다!");
			return
		}
		// userTourWriteVO에 있는 List<UserTourSchdlVO> userTourSchdulList에게 리스트 형식으로 담아줌
		// -> name="userTourSchdlList[index].컬럼명" -> 해당 컬럼에 리스트 형식으로 담음
		// 해당 방법을 사용하기 위해서는 모든 input태그를 감싸고있는 div가 하나 필요함 -> <div class="locs">...</div>
		var plusDom = $(`		<div class="locs">
			                		<div>
			                			<label><span class="red">*</span> 시간</label>
			                			<input id="hope-time" name="userTourSchdlList[${locsCnt}].trTm" type="datetime-local" required="required" />
			                		</div>
									<div>
										<label for="hope-location"><span class="red">*</span> 장소</label>
										<input id="hope-location" name="userTourSchdlList[${locsCnt}].trLctns" type="text" required="required" />
									</div>
									<div>
										<label for="hope-info"><span class="red">*</span> 일정</label>
										<textarea id="hope-info" name="userTourSchdlList[${locsCnt}].trRqst" type="text" required="required"></textarea>
									</div>
								</div>`);
		// 인덱스가 담긴 가상 돔을 .loc-inf의 안쪽에 담아준다.
		$(".loc-inf").append(plusDom);
	});

	$("#m-btn").on('click', function() {
		var locsCnt = $(".locs").length;

		if (locsCnt <= 1) {
			alert("최소 1개는 작성해야 합니다!");
			return
		}
		$(".locs:last").remove();
	});

	// 현재 보고있는 게시글의 아이디
	var pstId = $(".ttl-wb").data("pst-id");
	// 현재 로그인 한 유저의 로그인 아이디
	var usrLgnId = $(".header-content").data("login-id");
	// 즐겨찾기 추가 URL
	var url = `/favorite/${pstId}`;
	// 현재 예약 상태
	var stts = $(".ttl-wb").data("pst-stts");

	$.get(url, {}, function(favoriteResult) {
		var favoriteCnt = favoriteResult.favoriteCount;
		for (var i = 0; i < favoriteCnt; i++) {
			// 만약 즐겨찾기 리스트에 있는 누른 회원이 현재 로그인 한 회원과 같다면?
			if (favoriteResult.favoriteList[i].usrLgnId === usrLgnId) {
				$(".wish-button").addClass("isAlready");
				break;
			}
		}
	});

	$(".wish-button").on('click', function() {
		// 만약 로그인을 하지 않았다면?
		if (usrLgnId == "") {
			alert("로그인 후 사용 가능합니다.");
			// 로그인 화면으로 보내고 해당 function 종료
			location.href = "/user/login"
			return
		}
		// 마무리로 컨펌받음
		// 만약 해당 게시글의 즐겨찾기 리스트 중 누른 사람이 이미 눌렀다면?
		$.get(url, {}, function(favoriteResult) {
			// 해당 게시글의 즐겨찾기 횟수
			var favoriteCnt = favoriteResult.favoriteCount;
			// 기본 false할당
			var isAlready = false;

			for (var i = 0; i < favoriteCnt; i++) {
				// 만약 즐겨찾기 리스트에 있는 누른 회원이 현재 로그인 한 회원과 같다면?
				if (favoriteResult.favoriteList[i].usrLgnId === usrLgnId) {
					// isAlready에 true 할당
					isAlready = true;
					// for문 종료
					break;
				}
			}
			// 만약 이미 있다면?
			if (isAlready) {
				if (confirm("이미 즐겨찾기에 추가 된 게시글입니다. 삭제하시겠습니까?")) {
					$.get(`/favorite/delete/${pstId}/${usrLgnId}`, {}, function() {
						// 그냥 삭제 쿼리 실행
					});
					location.reload();
				}
				else {
					alert("취소하였습니다.");
				}
			}
			else {
				// 즐겨찾기를 누르지 않았다면?
				// 객체 리터럴에 선언을 한 이유 : 해당 포스트 아이디를 파라미터로 받아오기 위해서. 
				// 그럼 유저는? controller에서 session에서 직접 받음
				$.post(url
					, { pstId: $(".ttl-wb").data("pst-id") }
					, function(createdResult) {
						if (createdResult.result) {
							location.reload();
						}
						else {
							alert("즐겨찾기에 추가에 실패하였습니다!");
						}
					})
			}
		});


	});

});
