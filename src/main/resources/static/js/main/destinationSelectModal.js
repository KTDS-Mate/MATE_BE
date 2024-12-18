$().ready(function () {
  // DOM 요소들
  const $where = $('.where');
  const $searchModal = $('#destinationSelectModal');
  const $searchInput = $('.searchInput');
  const $searchResults = $('#searchResults');
  const $searchResultArea = $('#searchResultArea');
  const $whereH3 = $('.where > h3');
  const $searchTypeSelect = $('.searchType');
  const $touristButton = $('.touristButton');
  const $guideButton = $('.guideButton');
  const $searchButton = $('.tourSearchButton');

  const initialDestination = 'Select Destination'; // 초기 선택된 장소 텍스트
  let searchType = $searchTypeSelect.val(); // 기본 검색 타입 (국가, 도시 등)

  // 초기 선택된 장소를 h3에 설정
  function setInitialDestination() {
    $whereH3.text(initialDestination);
  }

  // 검색 타입 변경 시 입력 필드 placeholder 업데이트
  function updatePlaceholder() {
    const placeholderText =
      searchType === 'country'
        ? '국가를 입력해주세요.'
        : searchType === 'city'
        ? '도시를 입력해주세요.'
        : '제목을 입력해주세요.';
    $searchInput.attr('placeholder', placeholderText);
  }

  // 검색 타입 선택 시 이벤트
  $searchTypeSelect.on('change', function () {
    searchType = $(this).val();
    updatePlaceholder();
  });

  // 모달 열기 및 닫기
  function openDestinationSelectModal() {
    $searchModal.removeClass('hidden');
  }

  function closeDestinationSelectModal() {
    $searchModal.addClass('hidden');
  }

  // 'where' 클릭 시 모달 열기
  $where.on('click', function (e) {
    e.stopPropagation();
    openDestinationSelectModal();
  });

  // 모달 외부 클릭 시 닫기
  $(document).on('click', function (event) {
    if (
      !$searchModal.hasClass('hidden') &&
      !$(event.target).closest($searchModal).length
    ) {
      closeDestinationSelectModal();
    }
  });

  // 검색 버튼 클릭 시 AJAX 호출
  $('.searchButton').on('click', function (e) {
    e.preventDefault();
    const searchValue = $searchInput.val();
    if (searchValue) {
      $.ajax({
        url: '/tour/search',
        method: 'GET',
        data: { query: searchValue, type: searchType },
        success: function (data) {
          $searchResultArea.empty();
          if (data.results && data.results.length > 0) {
            data.results.forEach(function (result) {
              const resultItem = $('<div class="result-item"></div>').text(
                searchType === 'country' ? result.countryName : result.cityName
              );
              $searchResultArea.append(resultItem);
            });
          } else {
            $searchResultArea.text('검색 결과가 없습니다.');
          }
        },
        error: function () {
          $searchResultArea.text('검색 중 오류가 발생했습니다.');
        },
      });
    } else {
      $searchResultArea.text('검색어를 입력해주세요.');
    }
  });

  // Enter 키로 검색 실행
  $searchInput.on('keypress', function (e) {
    if (e.which === 13) {
      e.preventDefault();
      $('.searchButton').trigger('click');
    }
  });

  // 결과 항목 클릭 시 처리
  $searchResultArea.on('click', '.result-item', function () {
    const selectedText = $(this).text();
    $whereH3.text(selectedText);
    closeDestinationSelectModal();
  });

  // 버튼 선택 함수
  function selectButton($selectedButton) {
    $touristButton.removeClass('selectedButton');
    $guideButton.removeClass('selectedButton');
    $selectedButton.addClass('selectedButton');
  }

  // 처음 접속 시 touristButton이 선택되도록 설정
  selectButton($touristButton);

  // touristButton 클릭 시 선택 처리
  $touristButton.on('click', function () {
    selectButton($touristButton);
  });

  // guideButton 클릭 시 선택 처리
  $guideButton.on('click', function () {
    selectButton($guideButton);
  });

  // tourSearchButton 클릭 시 이벤트
  $searchButton.on('click', function () {
    // userTypeArea에서 선택된 버튼 확인
    var selectedUserType = $('.userTypeArea .selectedButton').text(); // 'Tourist' 또는 'Guide'

    // where와 when의 텍스트 값 가져오기
    var whereText = $('.where > h3').text(); // 국가 또는 도시
    var whenText = $('.when > h3').text(); // 예: 최신순, 가격순 등
	
	// 검색어를 입력하지 않았을 때 Select Destination이 넘어가는 것 방지
	if (whereText === "Select Destination") {
		whereText = "";
	}
    // 기본 검색 URL 설정
    var baseUrl = '';
    if ($touristButton.hasClass('selectedButton')) {
      baseUrl = '/guidetour/list?';
    } else if ($guideButton.hasClass('selectedButton')) {
      baseUrl = '/usertour/list?';
    }

    // URL 파라미터를 담을 변수
    var queryParams = '';

    // pageNo를 먼저 추가 (기본값은 0)
    queryParams += 'pageNo=0';

    // when(검색 기준)에 맞는 검색 기준을 추가
    if (whenText) {
      queryParams += `&orderby=${encodeURIComponent(whenText)}`;
    }

    // searchType을 추가
    queryParams += `&searchType=${encodeURIComponent(searchType)}`;

    // searchKeyword를 추가
    var searchKeyword = ''; // 기본값

    // 'where' 텍스트 값이 입력 필드인지 텍스트 값인지 확인
    if ($where.find('input').length > 0) {
      searchKeyword = $('.where input').val(); // 입력 필드에서 값 가져오기
    } else {
      searchKeyword = whereText; // 텍스트 영역에서 값 가져오기
    }

    if (searchKeyword) {
      queryParams += `&searchKeyword=${encodeURIComponent(searchKeyword)}`;
    }

    // 최종 URL로 리다이렉션
    location.href = baseUrl + queryParams;
  });

  // 초기 설정
  updatePlaceholder();
  setInitialDestination();
});
