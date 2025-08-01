$().ready(function() {
	
	// 현재 모든 날짜와 시간을 가져옴
	var nowDate = new Date();
	// 현재 시간을 가져옴
	var nowHour = nowDate.getHours();
	// 현재 분을 가져옴
	var nowMinutes = nowDate.getMinutes();
	// 비교 대상과의 포멧을 맞춤
	var nowTime = nowHour + ':' + nowMinutes;
	
	// 시작 시간 기본 값을 현재 시간으로 설정
	$("#start-time").val(nowTime);
	
	$("#inputYear").on("change", function() {
		// 현재 날짜(년월일)보다 느리면(이전이면) 안됨
		// 현재 날짜를 가져옴
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + today.getDate()).slice(-2);
		// 포맷 맞추기
		var dateString = year + '-' + month + '-' + day
		// 입력한 값 가져옴
		var inputYear = $(this).val();
		// Date 타입으로 변환
		var nowDate = new Date(dateString);
		var inputDate = new Date(inputYear);
		// int 타입으로 변환
		var formattingNow = dateString.replace(/-/gi, "");
		var formattingInput = inputYear.replace(/-/gi, "");
		var intNow = parseInt(formattingNow);
		var intInput = parseInt(formattingInput);
		
		if (intNow === intInput) {
			// 만약 당일로 다시 바꾼다면?
			// 시간 입력 값 초기화
			$("#start-time").val("");
			$("#end-time").val("");
		}
		// 만약 입력 한 시간이 현재 시간보다 느리다(이전이다)라면 입력 값 초기화
		if (nowDate > inputDate) {
			alert("지난 날은 입력하실 수 없습니다!");
			$(this).val("");
			$("#start-time").attr('disabled', 'disabled');
			$("#start-time").val(nowTime);
		}
		else {
			$("#start-time").removeAttr('disabled');
			$("#start-time").val(nowTime);
		}
		
	});

	$("#start-time").on('change', function() {
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + today.getDate()).slice(-2);

		var nowDateString = year + month + day; // YYYYMMDD
		var inputDateString = $("#inputYear").val(); // YYYY-MM-DD
		inputDateString = inputDateString.replace(/-/gi, ""); // YYYYMMDD
		// 현재 날짜를 Int로 변경
		var intNowDate = parseInt(nowDateString);
		// 입력한 날짜를 Int로 변경
		var intInputDate = parseInt(inputDateString);
		// 당일 예약이라면? 
		// 현재 시간보다 이전을 선택할 수 없게 해야 함
		var inputVal = $(this).val();
		if (intNowDate === intInputDate) {
			if (inputVal < nowTime) {
				alert("현재 시간보다 이전을 선택하실 수 없습니다!");
				$(this).val("");
			}
			else {
				// 올바르게 입력했다면 disabled 해제
				$("#end-time").removeAttr("disabled");
			}
		}
		else {
			// 아니라면 모든 시간대 선택 가능
			$("#end-time").removeAttr("disabled");
		}
	});

	$("#end-time").on('change', function() {
		// 사용자가 입력한 시작 시간을 가져옴
		var startTime = $("#start-time").val();
		// 현재 입력한 종료 시간을 가져옴
		var endTime = $(this).val();
		// 만약 시작 시간보다 이전을 선택했다면 alert후 값 초기화
		if (endTime < startTime) {
			alert("시작 시간보다 빠르게 입력하실 수 없습니다!");
			$(this).val("");
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
		var plusDom = $(`<div class="locs">
						<div>
							<label for="hope-location">장소</label>
							<input id="hope-location" name="userTourSchdlList[${locsCnt}].trLctns" type="text" required="required" />
						</div>
						<div>
							<label for="hope-info">일정</label>
							<input id="hope-info" name="userTourSchdlList[${locsCnt}].trRqst" type="text" required="required" />
						</div>
						</div>`);
		// 인덱스가 담긴 가상 돔을 .loc-inf의 안쪽에 담아준다.
		$(".loc-inf").append(plusDom);
	});

	$("#m-btn").on('click', function() {
		$(".locs:last").remove();
	});
	
	// 대륙은 기존 한번 만 가져옴(바뀌지 않음)
	$.get("/tour/regions", {}, function(regionResult) {
		var regionsCnt = regionResult.regionsCount;
		// 대륙의 수 만큼 for문을 돌며 append
		for (var i = 0; i < regionsCnt; i++) {
			var regionOption = $(`<option value="${regionResult.regions[i].regionId}">${regionResult.regions[i].regionName}</option>`);
			$("#region").append(regionOption);
		}
	});

	// 대륙 select 창이 바뀔 때 마다 호출
	$("#region").on('change', function() {
		// 국가 선택 창이 열림
		$("#country").removeAttr("disabled");
		// 바뀌면 안에 있는 내용이 다 날아가고 바뀌어야 함
		$("#country").empty();
		// 도시까지 선택했다가 바꾸면 도시도 비워줌
		$("#city").empty();
		// 모두 날렸으니 기본 값을 넣어줌
		$("#country").append(`<option value="">국가 선택</option>`);
		$("#city").append(`<option value="">도시 선택</option>`);
		// 국가를 선택하지 않았으니 disabled를 걸어줘서 선택 못하게 막음
		$("#city").attr("disabled", 'disabled');
		// 대륙 ID를 가져옴
		var regionId = $(this).val();
		
		// 만약 대륙아이디가 공백이다 => 대륙 선택을 클릭했다 면 국가 선택도 막음
		if (regionId === "") {
			$("#country").attr("disabled", 'disabled');
		}
		
		
		// 대륙 별 국가 정보를 가져옴
		$.get(`/tour/countries/${regionId}`, {}, function(countryResult) {
			var countriesCnt = countryResult.countriesCount;

			for (var i = 0; i < countriesCnt; i++) {
				var countryOption = $(`<option value="${countryResult.countries[i].countryId}">${countryResult.countries[i].countryName}</option>`);
				$("#country").append(countryOption);
			}

		});

	});
	// 국가가 바뀔 때 마다 호출
	$("#country").on('change', function() {
		// 도시 선택창 활성화
		$("#city").removeAttr("disabled");
		// 국가가 바뀔 때마다 비워줌
		$("#city").empty();
		// 기본 값 설정
		$("#city").append(`<option value="">도시 선택</option>`);

		var countryId = $(this).val();
	
		// 국가 별 도시를 가져옴
		$.get(`/tour/cities/${countryId}`, {}, function(cityResult) {
			var citiesCnt = cityResult.citiesCount;
			
			for (var i = 0; i < citiesCnt; i++) {
				var cityOption = $(`<option value="${cityResult.cities[i].cityId}">${cityResult.cities[i].cityName}</option>`);
				$("#city").append(cityOption);
			}
		});

	});

	$("#tourNp").on('change', function() {
		var npVal = $(this).val();

		if (npVal < 1) {
			alert("0 또는 음수를 지정할 수 없습니다!");
			$(this).val(1);
		}
	});

	$("#trPrc").on('change', function() {
		var trPrcVal = $(this).val();
		var defaultPrc = 30;
				
		if (trPrcVal < defaultPrc) {
			alert("최소 가격은 30$ 이상입니다!");
			$(this).val(defaultPrc);
		}

	});

	$("#add-file").on('click', function () {
		var fileCnt = $(".file-group").length;

		// 파일 첨부 개수 제한
		if (fileCnt > 9) {
			alert("파일은 최대 10개까지 첨부 가능합니다!");
			return
		}
				
		var fileDom = $(`<div class="file-group">
						 	<input id="img-file" type="file" name="userTourImgList[${fileCnt}].usrTrRqImgIdUrl}" required="required" accept=".jpg,.jpeg,.img,.png" />
						 </div>`);
		$(".file-list").append(fileDom);
	});
	
	$("#del-file").on('click', function() {
		$(".file-group:last").remove();
	});

	// 파일 확장자 검증
	$(document).on('change', "#img-file", function() {
		// 현재 입력받은 파일
		var fileVal = $(this).val();
		// .앞에 있는 글자를 날리고 소문자로 변경 -> 확장자만 가져옴
		var fileType = fileVal.split(".").pop().toLowerCase();
		// 입력 가능한 확장자 리스트
		var fileTypeArr = ['jpg', 'jpeg', 'img', 'png'];
		
		// inArray => 만약 fileTypeArr 안에 있는 파일이 아닌 다른 확장자를 받으면 -1을 내보냄
		if ($.inArray(fileType, fileTypeArr) == -1) {
			alert("이미지 파일만 등록 가능합니다!");
			// 값 초기화
			$(this).val("");
		}
		else {
			$(this).val(fileVal);
		}
		
	});
		
});
