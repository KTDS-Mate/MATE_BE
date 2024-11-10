$(document).ready(function () {
  const areaOne = $('.recommendCitiesAreaOne');
  const areaTwo = $('.recommendCitiesAreaTwo');
  const areaThree = $('.recommendCitiesAreaThree');

  // 추천 가이드 투어 데이터를 가져와서 각 영역에 삽입
  function loadRandomGuideTours() {
    $.ajax({
      url: '/guidetour/random', // 가이드 투어 목록을 랜덤으로 가져오는 엔드포인트
      type: 'GET',
      dataType: 'json',
      success: function (data) {
        console.log('Data received:', data); // 데이터를 확인할 수 있는 로그 추가

        // 서버에서 반환된 데이터가 배열인지 확인
        let guideTours = Array.isArray(data) ? data : []; // 데이터가 배열인 경우 그대로 사용

        // 배열이 아니면 빈 배열로 처리
        if (!Array.isArray(guideTours)) {
          guideTours = [];
          console.warn(
            'guideTours was not an array, it was converted to an array:',
            guideTours
          );
        }

        // 'guideTours'가 빈 배열인 경우에도 처리할 수 있도록 추가 검증
        if (guideTours.length > 0) {
          // areaOne, areaTwo, areaThree 각각에 대해 반복
          [areaOne, areaTwo, areaThree].forEach(function (area, index) {
            area.empty(); // 기존 내용 초기화

            // 각 영역에 대해 랜덤으로 4개만 가져오기
            const startIndex = index * 4;
            const endIndex = startIndex + 4;
            const randomTours = guideTours.slice(startIndex, endIndex);

            console.log('Random tours:', randomTours); // 선택된 투어들을 로그로 확인

            randomTours.forEach(function (tour) {
              // 필수 값이 비어있는지 확인하고 기본값을 설정
              const cityName = tour.cityName || 'Unknown City'; // cityName이 없으면 'Unknown City'로 설정
              const countryName = tour.countryName || 'Unknown Country'; // countryName이 없으면 'Unknown Country'로 설정
              const imageUrl = tour.imageUrl || '예시여행이미지.png'; // imageUrl이 없으면 기본 이미지로 설정

              // 필수 값이 있는지 확인
              if (tour && tour.gdTrPstId && tour.gdTrTtl) {
                // 추천 투어 영역 div 생성
                const tourDiv = $('<div>', {
                  class: 'recommendGuideTourArea',
                });

                // 이미지 추가: <img> 태그 사용
                const imgTag = $('<img>', {
                  src: `/img/tourboard/${imageUrl}`, // 이미지 URL 처리
                  alt: `${tour.gdTrTtl} 이미지`, // alt 속성 추가
                  class: 'tour-image', // 클래스 추가 (추후 CSS로 스타일링 가능)
                });

                // 도시명, 국가명, 가이드 투어 제목을 포함한 정보 추가
                const tourInfo = `
                  <div class="tourInfo">
                    <h4>${tour.gdTrTtl}</h4> <!-- 가이드 투어 제목 -->
                  </div>
                `;

                // 이미지와 투어 정보를 tourDiv에 추가
                tourDiv.append(imgTag);
                tourDiv.append(tourInfo);

                // 클릭 시 투어 상세 페이지로 이동
                tourDiv.on('click', function () {
                  window.location.href = `/guidetour/info?gdTrPstId=${tour.gdTrPstId}`;
                });

                // 해당 영역에 투어 정보 추가
                area.append(tourDiv);
              } else {
                console.error('Tour data is missing or incomplete:', tour);
              }
            });
          });
        } else {
          console.error(
            'Guide tours data is not in expected array format or is empty'
          );
        }
      },

      error: function (error) {
        console.error('Error:', error);
      },
    });
  }

  loadRandomGuideTours();
});
