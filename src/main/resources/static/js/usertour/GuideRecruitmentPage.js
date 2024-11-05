$().ready(function() {
	// 현재 보고있는 게시글의 아이디
	var pstId = $(".ttl-wb").data("pst-id");
	// 현재 로그인 한 유저의 로그인 아이디
	var usrLgnId = $(".header-content").data("login-id");
	// 즐겨찾기 추가 URL
	var url = `/favorite/${pstId}`;

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
		if (confirm("즐겨찾기에 추가하시겠습니까?")) {
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
						alert("삭제되었습니다!");
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
								alert("즐겨찾기에 추가되었습니다!");
								location.reload();
							}
							else {
								alert("즐겨찾기에 추가에 실패하였습니다!");
							}
						})
				}
			});

		}
		else {
			// confirm에서 취소를 눌렀을 때
			alert("취소하였습니다.");
		}

	});



});
