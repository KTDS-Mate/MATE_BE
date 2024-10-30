$().ready(function() {
	$("#inputYear").on("change", function() {
		$("#start-minutes").val("");
		// 현재날짜보다 더 빠른 날짜를 선택할 수 없음.
		var nowDate = new Date();
		console.log(nowDate);

		var year = nowDate.getFullYear();
		var month = ('0' + (nowDate.getMonth() + 1)).slice(-2);
		var day = ('0' + nowDate.getDate()).slice(-2);
		// 포맷 맞추기
		var dateString = year + '-' + month + '-' + day
		console.log(dateString);

		var inputDate = $(this).val();
		console.log(inputDate);

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
			else {
				$("#end-minutes").removeAttr("disabled");
			}
		}
	});
	//TODO : 10월 30일 , 국가 빠르면 평점
	// 종료 시간이 시작시간보다 빠르면 안됨.
	$("#end-minutes").on("change", function() {
		
	});
	
	
	// 대륙 select
	$.get(`/tour/regions`, {}, function(regionResult) {
		
		var regionCnt = regionResult.regionsCount;
		
		for (var i = 0; i < regionCnt; i++) {
			var regionDom = $(`<option value=${regionResult.regions[i].regionId}>${regionResult.regions[i].regionName}</option>`);
			$("#region").append(regionDom);
		}
	});
	
	$("#region").on("change", function() {
		
	});
	
	
	
	
	$.get(`/tour/countries/{regionId}`, {}, function(countryResult) {
		
		var countryCnt = countryResult.countriesCount;
		
		for(var i = 0; i < countryCnt; i++) {
			var countryDom = $(`<option value=${countryResult.countries[i].countryId}>${countryResult.countries[i].countryName}</option>`)
			$("#country").append(countryDom);
		}
		
	})
	
});