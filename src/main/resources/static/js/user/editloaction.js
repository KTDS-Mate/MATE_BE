function loadCities(countryId) {
    if (!countryId) {
        var dropdown = document.getElementById("city-dropdown");
        dropdown.innerHTML = '<li class="placeholder-option">도시를 선택하세요</li>';
        return;
    }

    $.ajax({
        url: '/user/getCities/' + countryId,
        type: "GET",
        dataType: "json",
        success: function(data) {
            var dropdown = document.getElementById("city-dropdown");
            dropdown.innerHTML = '';

            if (data && data.length > 0) {
                var defaultOption = document.createElement("li");
                defaultOption.className = "placeholder-option";
                defaultOption.textContent = "도시를 선택하세요";
                defaultOption.onclick = function() {
                    selectCity('', '도시를 선택하세요');
                };
                dropdown.appendChild(defaultOption);

                data.forEach(function(city) {
                    var cityItem = document.createElement("li");
                    cityItem.textContent = city.cityName;
                    cityItem.onclick = function() {
                        selectCity(city.cityId, city.cityName);
                    };
                    dropdown.appendChild(cityItem);
                });

                dropdown.style.display = "block";
            } else {
                dropdown.innerHTML = '<li class="placeholder-option">도시가 없습니다</li>';
            }
        }
    });
}

function selectCity(cityId, cityName) {
    var selectedOption = document.querySelector(".selected-option");
    selectedOption.textContent = cityName;
    selectedOption.setAttribute("data-city-id", cityId);

    var dropdown = document.getElementById("city-dropdown");
    dropdown.style.display = "none";
}

function toggleDropdown() {
    var dropdown = document.getElementById("city-dropdown");
    dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
}

let cityIndex = 0;

function addCity() {
    var selectedOption = document.querySelector(".selected-option");
    var cityId = parseInt(selectedOption.getAttribute("data-city-id"), 10);
    var cityName = selectedOption.textContent;

    if (isNaN(cityId) || cityName === "도시를 선택하세요") {
        alert("도시를 선택하세요.");
        return;
    }

    if (document.getElementById("city-" + cityId)) {
        alert("이미 추가된 도시입니다.");
        return;
    }

    var cityList = document.getElementById("addedCitiesList");

    var newCity = document.createElement("li");
    newCity.id = "city-" + cityId;

    var cityText = document.createElement("span");
    cityText.textContent = cityName;
    newCity.appendChild(cityText);

    var deleteButton = document.createElement("button");
    deleteButton.textContent = "삭제";
    deleteButton.onclick = function() {
        cityList.removeChild(newCity);
        var cityInput = document.getElementById("cityInput-" + cityId);
        if (cityInput) {
            cityInput.parentNode.removeChild(cityInput);
        }
    };
    newCity.appendChild(deleteButton);

    cityList.appendChild(newCity);

    selectedOption.textContent = "도시를 선택하세요";
    selectedOption.removeAttribute("data-city-id");

    var cityInputDiv = document.getElementById("cityInputs");
    var cityInput = document.createElement("input");
    cityInput.type = "hidden";
    cityInput.name = "cities[" + cityIndex + "].cityId";
    cityInput.value = cityId;
    cityInput.id = "cityInput-" + cityId;
    cityInputDiv.appendChild(cityInput);

    cityIndex++;
}
