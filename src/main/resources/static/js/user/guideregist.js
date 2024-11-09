// cityIndex와 licenseIndex 초기화
var cityIndex = 0;
var licenseIndex = 0;

// 국가 선택에 따라 도시 목록을 가져오는 함수
function guideregist(countryId) {
    var dropdown = document.getElementById("customDropdown");

    // 국가가 선택되지 않은 경우 드롭다운 초기화
    if (!countryId) {
        dropdown.innerHTML = '<li class="placeholder-option">도시를 선택하세요</li>';
        dropdown.classList.add("hidden");
        return;
    }

    $.ajax({
        url: '/user/getCities/' + countryId,
        type: "GET",
        dataType: "json",
        success: function(data) {
            dropdown.innerHTML = '';

            if (data && data.length > 0) {
                // 도시 목록 추가
				data.forEach(function(city) {
				    var cityItem = document.createElement("li");
				    cityItem.textContent = city.cityName;
				    cityItem.setAttribute("data-city-id", city.cityId);
				    cityItem.onclick = function() {
				        selectCity(city.cityId, city.cityName);
				    };
				    dropdown.appendChild(cityItem);
				});
			} else {
			    var noCityItem = document.createElement("li");
			    noCityItem.textContent = "도시가 없습니다";
			    noCityItem.className = "placeholder-option";
			    dropdown.appendChild(noCityItem);
			}
		// 드롭다운 표시
		dropdown.classList.remove("hidden");
		}
	});
}
// 도시를 선택하는 함수
function selectCity(cityId, cityName) {
    var selectedOption = document.querySelector("#citySelection .selected-option");
    selectedOption.textContent = cityName;
    selectedOption.setAttribute("data-city-id", cityId);

    var dropdown = document.getElementById("customDropdown");
    dropdown.classList.add("hidden");
}

// 드롭다운 토글
function toggleDropdown() {
    var dropdown = document.getElementById("customDropdown");
    var selectedOption = document.querySelector("#citySelection .selected-option");

    // 드롭다운 위치 설정
    var rect = selectedOption.getBoundingClientRect();
    dropdown.style.position = "absolute"; // 위치를 절대 위치로 설정
    dropdown.style.top = (rect.bottom + window.scrollY) + "px"; // '도시를 선택하세요' 바로 아래로 설정
    dropdown.style.left = rect.left + "px"; // '도시를 선택하세요'의 왼쪽에 맞춤
    dropdown.style.width = (rect.width + 150) + "px"; // 

    // 드롭다운의 표시 상태를 토글 (visibility 사용)
    if (dropdown.classList.contains("hidden")) {
        dropdown.classList.remove("hidden");
        dropdown.style.visibility = "visible"; // 드롭다운 표시
    } else {
        dropdown.classList.add("hidden");
        dropdown.style.visibility = "hidden"; // 드롭다운 숨김
    }
}

// 도시를 추가하는 함수
function addCity() {
    var selectedOption = document.querySelector("#citySelection .selected-option");
    var cityId = selectedOption.getAttribute("data-city-id");
    var cityName = selectedOption.textContent;

    if (!cityId || cityName === "도시를 선택하세요") {
        alert("도시를 선택하세요.");
        return;
    }

    // 이미 추가된 도시인지 확인
    if (document.getElementById("city-" + cityId)) {
        alert("이미 추가된 도시입니다.");
        return;
    }

    var cityList = document.getElementById("addedCitiesList");

    // 새로운 도시 항목 생성
    var newCity = document.createElement("li");
    newCity.id = "city-" + cityId;

    // 도시 이름 텍스트
    var cityText = document.createElement("span");
    cityText.textContent = cityName;
    newCity.appendChild(cityText);

    // 삭제 버튼
    var deleteButton = document.createElement("button");
    deleteButton.textContent = "x";
    deleteButton.type = "button"; // 폼 제출 방지
    deleteButton.onclick = function() {
        cityList.removeChild(newCity);

        // 숨겨진 입력 필드 제거
        var cityInput = document.getElementById("cityInput-" + cityId);
        if (cityInput) {
            cityInput.parentNode.removeChild(cityInput);
        }
    };
    newCity.appendChild(deleteButton);

    // 리스트에 추가
    cityList.appendChild(newCity);

    // 선택 초기화
    selectedOption.textContent = "도시를 선택하세요";
    selectedOption.removeAttribute("data-city-id");

    // 숨겨진 필드 생성
    var cityInput = document.createElement("input");
    cityInput.type = "hidden";
    cityInput.name = "cities[" + cityIndex + "].cityId";
    cityInput.value = cityId;
    cityInput.id = "cityInput-" + cityId;
    document.getElementById("citySelection").appendChild(cityInput);

    cityIndex++;
}

// 라이센스 항목을 추가하는 함수
function addLicenseItem() {
    licenseIndex++;

    var additionalLicensesDiv = document.getElementById("additionalLicenses");

    // 라이센스 명 입력
    var licenseDiv = document.createElement("div");
    licenseDiv.className = "form-item";

    var label = document.createElement("label");
    label.setAttribute("for", "license-" + licenseIndex);
    label.textContent = "라이센스명:";

    var licenseInput = document.createElement("input");
    licenseInput.type = "text";
    licenseInput.id = "license-" + licenseIndex;
    licenseInput.name = "licenses[" + licenseIndex + "].lcnNm";
    licenseInput.placeholder = "라이센스 명";

    licenseDiv.appendChild(label);
    licenseDiv.appendChild(licenseInput);

    // 라이센스 파일 입력
    var fileDiv = document.createElement("div");
    fileDiv.className = "form-item";

    var fileLabel = document.createElement("label");
    fileLabel.textContent = "라이센스 인증서류:";

    var fileInput = document.createElement("input");
    fileInput.type = "file";
    fileInput.id = "lcnImgFile-" + licenseIndex;
    fileInput.name = "licenses[" + licenseIndex + "].lcnImgFile";

    fileDiv.appendChild(fileLabel);
    fileDiv.appendChild(fileInput);

	// 추가 라이센스 섹션의 끝에 항목 추가
	additionalLicensesDiv.appendChild(licenseDiv);
	additionalLicensesDiv.appendChild(fileDiv);
}

// 외부 클릭 시 드롭다운 닫기
document.addEventListener("DOMContentLoaded", function() {
    document.addEventListener("click", function(event) {
        var dropdown = document.getElementById("customDropdown");
        var selectBox = document.querySelector("#citySelection");

        if (!selectBox.contains(event.target) && !dropdown.classList.contains("hidden")) {
            dropdown.classList.add("hidden");
        }
    });
});