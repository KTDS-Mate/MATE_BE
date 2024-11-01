function loadCities(countryId) {

    if (!countryId) {
        var dropdown = document.getElementById("customDropdown");
        dropdown.innerHTML = '<li class="placeholder-option">도시를 선택하세요</li>';
        return;
    }

    $.ajax({
        url: '/user/getCities/' + countryId,
        type: "GET",
        dataType: "json",
        success: function(data) {

            var dropdown = document.getElementById("customDropdown");
            dropdown.innerHTML = '';
            
            if (data && data.length > 0) {
                // 기본 옵션 추가
                var defaultOption = document.createElement("li");
                defaultOption.className = "placeholder-option";
                defaultOption.textContent = "도시를 선택하세요";
                defaultOption.onclick = function() {
                    selectCity('', '도시를 선택하세요');
                };
                dropdown.appendChild(defaultOption);

                // 도시 목록 추가
                data.forEach(function(city) {
                    var cityItem = document.createElement("li");
                    cityItem.textContent = city.cityName;
                    cityItem.onclick = function() {
                        selectCity(city.cityId, city.cityName);
                    };
                    dropdown.appendChild(cityItem);
                });

                // 드롭다운 표시
                dropdown.style.display = "block";
            } else {
                dropdown.innerHTML = '<li class="placeholder-option">도시가 없습니다</li>';
            }
        }
    });
}

// selectCity 함수 추가
function selectCity(cityId, cityName) {
    var selectedOption = document.querySelector(".selected-option");
    selectedOption.textContent = cityName;
    selectedOption.setAttribute("data-city-id", cityId);
    
	console.log("data-city-id: ", cityId);
	
    var dropdown = document.getElementById("customDropdown");
    dropdown.style.display = "none";
}

function toggleDropdown() {
    var dropdown = document.getElementById("customDropdown");
    if (dropdown.style.display === "block") {
        dropdown.style.display = "none";
    } else {
        dropdown.style.display = "block";
    }
}

var cityIndex = 0;

function addCity() {
	
	var selectedOption = document.querySelector(".selected-option");
	var cityId = parseInt(selectedOption.getAttribute("data-city-id"), 10);
	var cityName = selectedOption.textContent;

	if (isNaN(cityId) || cityName === "도시를 선택하세요") {
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
	deleteButton.textContent = "삭제";

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
	var cityInputDiv = document.getElementById("cityInputs");
	var cityInput = document.createElement("input");
	
	cityInput.type = "hidden";
	cityInput.name = "cities[" + cityIndex + "].cityId";
	cityInput.value = cityId;
	cityInput.id = "cityInput-" + cityId;
	cityInputDiv.appendChild(cityInput);	
	
	cityIndex++;
}

var licenseIndex = 1;

function addLicenseItem() {
	var additionalLicensesDiv = document.getElementById("additionalLicenses");
	
	var licenseDiv = document.createElement("div");
	licenseDiv.className = "form-item";
	
	var label = document.createElement("label");
	label.setAttribute("for", "license-" + licenseIndex);
	label.textContent = "라이센스 명";
	
	var licenseInputDiv = document.createElement("div");
	licenseInputDiv.className = "license";
	
	var licenseInput = document.createElement("input");
	licenseInput.setAttribute("type", "text");
	licenseInput.setAttribute("id", "license-" + licenseIndex);
	licenseInput.setAttribute("name", "licenses[" + licenseIndex + "].lcnNm");
	licenseInput.setAttribute("placeholder", "라이센스 명");
	
	licenseInputDiv.appendChild(licenseInput);
	licenseDiv.appendChild(label);
	licenseDiv.appendChild(licenseInputDiv);
	
	var fileDiv = document.createElement("div");
	fileDiv.className = "form-item";
	
	var span = document.createElement("span");
	span.textContent = "라이센스 인증서류";
	
	var fileboxDiv = document.createElement("div");
	fileboxDiv.className = "filebox";
	
	var fileInput = document.createElement("input");
	fileInput.setAttribute("type", "file");
	fileInput.setAttribute("id", "lcnImgFile-" + licenseIndex);
	fileInput.setAttribute("name", "licenses[" + licenseIndex + "].lcnImgFile");
	fileInput.className = "licenseImg filename";
	fileInput.setAttribute("placeholder", "(jpg, png, pdf..)");
	
	var labelFileSearch = document.createElement("label");
	labelFileSearch.className = "file-search";
	labelFileSearch.setAttribute("for", "lcnImgFile-" + licenseIndex);
	labelFileSearch.textContent = "파일 찾기";
	
	fileboxDiv.appendChild(fileInput);
	fileboxDiv.appendChild(labelFileSearch);
	fileDiv.appendChild(span);
	fileDiv.appendChild(fileboxDiv);
	
	additionalLicensesDiv.appendChild(licenseDiv);
	additionalLicensesDiv.appendChild(fileDiv);
	
	licenseIndex++;
}

// DOM이 완전히 로드된 후에 이벤트 리스너 추가
document.addEventListener("DOMContentLoaded", function() {
    // 외부 클릭 시 드롭다운 닫기
    document.addEventListener("click", function(event) {
        var dropdown = document.getElementById("customDropdown");
        var selectBox = document.querySelector(".custom-select-box");
        
        if (!selectBox.contains(event.target)) {
            dropdown.style.display = "none";
        }
    });
});