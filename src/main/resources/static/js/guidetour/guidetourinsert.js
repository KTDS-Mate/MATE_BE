$().ready(function() {
	$("#inputYear").on("change", function() {
		$("#start-minutes").val("");
		$("#end-minutes").val("");
		$("#end-minutes").attr("disabled", "disabled");
		// 현재날짜보다 더 빠른 날짜를 선택할 수 없음.
		var nowDate = new Date();

		var year = nowDate.getFullYear();
		var month = ('0' + (nowDate.getMonth() + 1)).slice(-2);
		var day = ('0' + nowDate.getDate()).slice(-2);
		// 포맷 맞추기
		var dateString = year + '-' + month + '-' + day

		var inputDate = $(this).val();

		var now = new Date(dateString);
		var input = new Date(inputDate);

		if (now > input) {
			$("#start-minutes").attr("disabled", "disabled");
			alert("현재 날짜보다 이전 날짜를 선택 할 수 없습니다.");
			// 선택한 날짜 초기화
			$(this).val("");
			$("#start-minutes").val("");
		}
		else {
			$("#start-minutes").removeAttr("disabled");
		}
	});
	$("#start-minutes").on("change", function() {

		$("#end-minutes").val("");
		// 현재 시간, 분 가져오기.
		var now = new Date();
		var nowHour = new Date().getHours();
		var nowMinute = new Date().getMinutes();
		var nowTime = nowHour + ':' + nowMinute;

		var year = now.getFullYear();
		var month = ('0' + (now.getMonth() + 1)).slice(-2);
		var day = ('0' + now.getDate()).slice(-2);
		// 포맷 맞추기
		var dateString = year + month + day

		var input = $("#inputYear").val();


		input = input.replace(/-/gi, "");

		var intNowDate = parseInt(dateString);
		var intInput = parseInt(input);

		var inputTime = $(this).val();

		//var inputEndTime = $("#end-minutes").val();

		// 당일이라면 현재시간보다 입력시간이 작을 수 없다.
		if (intNowDate === intInput) {
			if (inputTime < nowTime) {
				alert("현재 시간보다 빠른 시간을 선택 할 수 없습니다.");
				$(this).val("");
			}

		}

		else {
			$("#end-minutes").removeAttr("disabled");
		}
	});
	//TODO : 10월 30일 , 국가 빠르면 평점
	// 종료 시간이 시작시간보다 빠르면 안됨.
	$("#end-minutes").on("change", function() {
		var now = new Date();
		var nowHour = new Date().getHours();
		var nowMinute = new Date().getMinutes();
		var nowTime = nowHour + ':' + nowMinute;

		var year = now.getFullYear();
		var month = ('0' + (now.getMonth() + 1)).slice(-2);
		var day = ('0' + now.getDate()).slice(-2);
		// 포맷 맞추기
		var dateString = year + month + day

		var dateInput = $("#inputYear").val();
		var startInput = $("#start-minutes").val();
		var endInput = $("#end-minutes").val();

		dateInput = dateInput.replace(/-/gi, "");
		startInput = startInput.replace(/:/gi, "");
		endInput = endInput.replace(/:/gi, "");

		/** 사용자가 설정한 날짜 int 형변환. */
		var intInputDate = parseInt(dateInput);
		/** 현재 날짜 int 형변환. */
		var intNowDate = parseInt(dateString);
		/** 사용자가 설정한 시작 시간 int 형변환 */
		var intStartHour = parseInt(startInput);
		/** 사용자가 설정한 종료 시간 int 형변환 */
		var intEndHour = parseInt(endInput);

		if (intInputDate === intNowDate || intInputDate > intNowDate) {
			if (intStartHour > intEndHour) {
				alert("시작시간보다 빠른 시간을 선택 할 수 없습니다.");
				$(this).val("");
			}
		}
	});


	// 대륙 select
	$.get(`/tour/regions`, {}, function(regionResult) {

		var regionCnt = regionResult.regionsCount;

		for (var i = 0; i < regionCnt; i++) {
			var regionDom = $(`<option value="${regionResult.regions[i].regionId}">${regionResult.regions[i].regionName}</option>`);
			$("#region").append(regionDom);

		}
	});

	$("#region").on("change", function() {

		$("#country").removeAttr("disabled");
		$("#city").attr("disabled", "disabled");
		$("#country").empty();
		$("#city").empty();
		$("#country").append(`<option value="">국가 선택</option>`);
		$("#city").append(`<option value="">도시 선택</option>`);


		var regionId = $(this).val();

		if (regionId === "") {
			$("#country").attr("disabled", "disabled");
		}

		$.get(`/tour/countries/${regionId}`, {}, function(countryResult) {
			var countryCnt = countryResult.countriesCount;

			for (var i = 0; i < countryCnt; i++) {
				var countryDom = $(`<option value="${countryResult.countries[i].countryId}">${countryResult.countries[i].countryName}</option>`)
				$("#country").append(countryDom);
			}
		});
	});
	$("#country").on("change", function() {
		$("#city").removeAttr("disabled");
		$("#city").empty();
		$("#city").append(`<option value="">도시 선택</option>`);
		var countryId = $(this).val();

		$.get(`/tour/cities/${countryId}`, {}, function(cityResult) {
			var cityCnt = cityResult.citiesCount;

			for (var i = 0; i < cityCnt; i++) {
				var cityDom = $(`<option value="${cityResult.cities[i].cityId}">${cityResult.cities[i].cityName}</option>`)
				$("#city").append(cityDom);
			}
		});
	});
	$("#maxNp").on("change", function() {
		/** 선택한 인원 */
		var inputValue = $(this).val();
		
		if(inputValue > 99) {
			alert("최대 99명까지 가능합니다.");
			$(this).val(1);
		}
		
		if (inputValue < 1) {
			alert("최대 인원을 올바르게 설정해주세요.");
			$(this).val(1);
		}
	});
	
	
	$("#trPrc").on("change", function() {
		var inputValue = $(this).val();

		if (inputValue < 1) {
			alert("올바른 가격을 설정해주세요.");
			$(this).val(1);
		}
	});
	$("#plus").on("click", function() {

		var divCnt = $(".locs").length;
		if (divCnt > 9) {
			alert("더 이상 투어 세부 일정을 추가할 수 없습니다.( 최대 10개 )");
			return
		}
		var divPlus = $(`<div class="locs">
							<div>
								<label for="hope-location">장소</label>
								<input id="hope-location" name="guideTourScheduleInfoList[${divCnt}].trDtlLct" type="text"/>
						 	</div>
						 <div>
							<label for="hope-info">일정</label>
							<input id="hope-info" name="guideTourScheduleInfoList[${divCnt}].trDtlSchd" type="text"/>
						 </div>
						 </div>`);
		$(".loc-inf").append(divPlus);
	});

	$("#info-plus").on("click", function() {

		var liCnt = $(".locs2").length;
		if (liCnt > 9) {
			alert("더 이상 투어 정보를 추가 할 수 없습니다. ( 최대 10개 )");
			return
		}
		var liPlusDom = $(`<div class="locs2">
							<div>
								<input id="hope-info" name ="guideTourDetailInfoList[${liCnt}].trDtlInf" type="text" />
							</div>
				  </div>`)
		$(".plus-inf").append(liPlusDom);

	});

	$("#incl-plus").on("click", function() {

		var inclCnt = $(".locs3").length;
		if (inclCnt > 9) {
			alert("더 이상 투어 정보를 추가 할 수 없습니다. ( 최대 10개 )");
			return
		}
		var liPlusDom = $(`<div class="locs3">
								<div>
								  <input id="hope-info" name ="guideTourProvidedList[${inclCnt}].trIncld" type="text" />
								</div>
						 	   </div>`);
		$(".incl-div").append(liPlusDom);
	});

	$("#m-btn").on("click", function() {
		$(".locs:last").remove();
	});
	$("#info-m-btn").on("click", function() {
		$(".locs2:last").remove();
	});
	$("#incl-m-btn").on("click", function() {
		$(".locs3:last").remove();
	});

});