$().ready(function () {
  // tourSearchButton 클릭 시 이벤트
  $('.tourSearchButton').on('click', function () {
    // userTypeArea에서 선택된 버튼 확인
    var selectedUserType = $('.userTypeArea .selectedButton').text() || ''; // 'Tourist' 또는 'Guide'

    // where와 when의 텍스트 값 가져오기
    var whereText = $('.where > h3').text() || ''; // 국가 또는 도시
    var whenText = $('.when > h3').text() || ''; // 예: 최신순, 가격순 등

    // 기본 검색 URL 설정
    var baseUrl =
      selectedUserType === 'Tourist' ? '/guidetour/list?' : '/usertour/list?';

    // URL 파라미터를 담을 변수
    var queryParams = '';

    // where(국가/도시)와 when(검색 기준)에 따라 URL 파라미터 설정
    if (whereText) {
      // 'where'가 '국가'일 경우 'searchType=country'로, '도시'일 경우 'searchType=city'로 설정
      var searchType =
        whereText === '국가' ? 'country' : whereText === '도시' ? 'city' : '';
      var searchKeyword = $('.where input').val() || ''; // 실제 검색 키워드를 입력받음

      if (searchType && searchKeyword) {
        queryParams += `searchType=${encodeURIComponent(
          searchType
        )}&searchKeyword=${encodeURIComponent(searchKeyword)}`;
      }
    }

    // when에 맞는 검색 기준을 추가
    if (whenText) {
      queryParams += `&orderby=${encodeURIComponent(whenText)}`;
    }

    // 기본값으로 페이지 번호 추가
    queryParams += '&pageNo=0';

    // 최종 URL로 리다이렉션
    location.href = baseUrl + queryParams;
  });
});
