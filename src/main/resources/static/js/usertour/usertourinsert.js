$().ready(function() {

	// TODO 국가와 도시를 가져와야 함
	$("#country").on("click", function() {
		$.get("/tour/countreis", {}, function(countriesResult) {
			
			var countriesCnt = countriesResult.countriesCnt; // COUNTRIES의 개수
			
			for (i = 0; i < countriesCnt; i++) {
				$("#country").append(`<option value="${countriesResult.countries[i].id}">${countriesResult.countries[i].korname}</option>`);
			}
			
		});
	});
	
	$("#country").on("change", function() {
		
		$("#city").empty();
		$("#city").append(`<option value="">도시 선택</option>`)
		
		var countryId = $(this).val();
		
		$.get(`/tour/cities/${countryId}`, {}, function(citiesResult) {
			
			var citiesCnt = citiesResult.cities.length;
			
			for (i = 0; i < citiesCnt; i++) {
				$("#city").append(`<option value="${citiesResult.cities[i].id}">${citiesResult.cities[i].name}</option>`);
			}
			
		});
	});
	
	/*$("#country").on("change", function() {
		$("#city").empty();
		var country = $(this).val();
		var cities = [];

		if (country === "jp") {
			cities = ["도쿄", "오사카", "후쿠오카", "삿포로", "오키나와"];
		}
		else if (country === "tw") {
			cities = ["타이베이시", "신베이시", "타이난시", "타이중시"];
		}
		else if (country === "bn") {
			cities = ["하노이", "호치민", "다낭", "후에", "호이안"];
		}
		else if (country === "cn") {
			cities = ["베이징", "상하이", "항저우", "하이난"];
		}
		else if (country === "am") {
			cities = ["로스엔젤레스", "뉴욕", "괌", "시카고", "워싱턴", "하와이"];
		}
		else if (country === "eg") {
			cities = ["런던", "맨체스터", "리버풀", "코번트리"];
		}
		else if (country === "fr") {
			cities = ["파리", "마르세유", "리옹", "낭트", "니스"];
		}
		else if (country === "os") {
			cities = ["시드니", "멜버른", "브리즈번", "캔버라"];
		}
		else {
			cities = [];
		}

		cities.forEach(function(city) {
			var optionDom = $(`<option name="trCtId" value="${city}">${city}</option>`);
			$("#city").append(optionDom);
		});

	});*/

	// 투어 희망 정보를 입력할 때 추가하기 버튼을 누르면 실행
	$("#plus").on("click", function() {
		// 가상 돔으로 추가되는 div의 길이를 구함 -> index를 알기 위해
		var locsCnt = $(".locs").length;
		// userTourWriteVO에 있는 List<UserTourSchdlVO> userTourSchdulList에게 리스트 형식으로 담아줌
		// -> name="userTourSchdlList[index].컬럼명" -> 해당 컬럼에 리스트 형식으로 담음
		// 해당 방법을 사용하기 위해서는 모든 input태그를 감싸고있는 div가 하나 필요함 -> <div class="locs">...</div>
		var plusDom = $(`<div class="locs"><div>
							<label for="hope-location">장소</label>
							<input id="hope-location" name="userTourSchdlList[${locsCnt}].trLctns" type="text"/>
						</div>
						<div>
							<label for="hope-info">일정</label>
							<input id="hope-info" name="userTourSchdlList[${locsCnt}].trRqst" type="text"/>
						</div></div>`);
		// 인덱스가 담긴 가상 돔을 .loc-inf의 안쪽에 담아준다.
		$(".loc-inf").append(plusDom);
	});

});