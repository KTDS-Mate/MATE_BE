$().ready(function () {
  const $where = $(".where");
  const $searchModal = $("#destinationSelectModal");
  const $searchInput = $("#searchInput");
  const $searchResults = $("#searchResults");
  const $whereH3 = $(".where > h3");
  const initialDestination = "Select Destination"; // 초기 선택된 장소 텍스트

  // 초기 선택된 장소를 h3에 설정
  function setInitialDestination() {
    $whereH3.text(initialDestination);
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

  // 검색 버튼 클릭 이벤트
  $("#searchButton").on("click", function () {
    const searchTerm = $searchInput.val().trim();
    if (searchTerm) {
      $.ajax({
        url: "/search", // 서버에서 검색할 URL
        method: "GET",
        data: { query: searchTerm },
        success: function (data) {
          // 데이터가 배열 형태로 온다고 가정
          displaySearchResults(data);
        },
        error: function () {
          alert("검색 중 오류가 발생했습니다.");
        },
      });
    }
  });

  // 검색 결과 표시
  function displaySearchResults(results) {
    $searchResults.empty();
    results.forEach((result) => {
      const $item = $('<div class="resultItem"></div>').text(result);
      $item.on("click", function () {
        $whereH3.text(result); // 선택된 결과로 변경
        closeDestinationSelectModal(); // 모달 닫기
      });
      $searchResults.append($item);
    });
  }

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

  setInitialDestination();
});
