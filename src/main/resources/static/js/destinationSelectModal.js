$().ready(function () {
  let countryId = null; // countryId 변수를 null로 초기화합니다.

  const $where = $(".where");
  const $searchModal = $("#destinationSelectModal");
  const $searchInput = $("#searchInput");
  const $searchResults = $("#searchResults");
  const $whereH3 = $(".where > h3");
  const initialDestination = "Select Destination"; // 초기 선택된 장소 텍스트
  const $regionDisplay = $("#regionDisplay"); // 지역 이름을 표시할 요소

  // 초기 선택된 장소를 h3에 설정
  function setInitialDestination() {
    $whereH3.text(initialDestination);
    $regionDisplay.text(""); // 초기 지역 텍스트를 비웁니다.
  }

  // 모달 열기 함수
  function openDestinationSelectModal() {
    $searchModal.removeClass("hidden");
    generateCalendar();
  }

  // 모달 닫기 함수
  function closeDestinationSelectModal() {
    $searchModal.addClass("hidden");
  }

  // 국가 선택 이벤트
  $(".country-select").on("click", function () {
    countryId = $(this).data("country-id"); // 선택된 국가의 ID를 설정
    console.log("선택된 countryId:", countryId); // countryId 확인 로그 추가

    if (countryId) {
      // 선택된 국가에 해당하는 지역 이름을 가져옴
      $.ajax({
        url: `/tour/regions/${countryId}`, // 서버에서 지역 이름을 검색
        type: "GET",
        dataType: "json",
        success: function (data) {
          if (data && data.regionName) {
            $regionDisplay.text(data.regionName); // 지역 이름 표시
          } else {
            $regionDisplay.text("지역 정보가 없습니다");
          }
        },
        error: function () {
          alert("지역 정보를 가져오는 중 오류가 발생했습니다.");
        },
      });
    } else {
      alert("국가 ID를 설정하는 데 오류가 발생했습니다.");
    }
  });

  // 검색 버튼 클릭 이벤트
  $("#searchButton").on("click", function () {
    console.log("검색 버튼 클릭됨");

    const searchTerm = $searchInput.val().trim(); // 사용자가 입력한 도시 이름
    console.log("입력된 도시 이름:", searchTerm); // 입력된 도시 이름을 콘솔에 출력

    if (searchTerm) {
      // 도시 이름으로 AJAX 요청을 보냅니다.
      $.ajax({
        url: countryId ? `/tour/cities/${countryId}` : `/tour/cities`, // 국가가 선택된 경우와 선택되지 않은 경우를 처리
        type: "GET",
        data: {
          term: searchTerm, // 입력된 도시 이름
        },
        dataType: "json",
        success: function (data) {
          console.log("AJAX 성공:", data); // 데이터 확인
          $searchResults.empty(); // 이전 검색 결과를 비웁니다.

          if (data && data.cities && data.cities.length > 0) {
            // 수정된 데이터 구조에 맞춰 검사
            data.cities.forEach(function (city) {
              const $cityItem = $("<div></div>").text(
                `${city.CITY_NAME}, ${city.COUNTRY_NAME}`
              ); // 도시와 국가 이름을 모두 출력
              $searchResults.append($cityItem);
            });
          } else {
            $searchResults.html(
              '<div class="placeholder-option">도시가 없습니다</div>'
            );
          }
        },
        error: function (xhr, status, error) {
          console.error("AJAX 오류:", status, error, xhr.responseText); // 오류 메시지 확인
          alert("도시 검색 중 오류가 발생했습니다.");
        },
      });
    } else {
      alert("검색어를 입력해 주세요.");
    }
  });

  // 모달 열기 버튼
  $where.on("click", function (e) {
    e.stopPropagation();
    openDestinationSelectModal();
  });

  $searchModal.on("click", function (e) {
    e.stopPropagation(); // 모달 내부 클릭 시 닫히지 않도록 방지
  });

  // 이미지 전환 버튼 클릭 시 모달 닫히지 않도록 이벤트 추가
  $(".picForwardButton, .picBackwardButton").on("click", function (e) {
    e.stopPropagation(); // 이벤트 전파 중지
  });

  // 목적지 검색 모달 외부 클릭 시 모달 닫기
  $(document).on("click", function (event) {
    if (
      !$searchModal.hasClass("hidden") &&
      !$(event.target).closest($searchModal).length
    ) {
      console.log("목적지 검색 Modal 외부 영역 클릭됨.");
      $searchModal.addClass("hidden");
    }
  });

  setInitialDestination();
});
