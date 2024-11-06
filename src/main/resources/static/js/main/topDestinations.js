$().ready(function () {
  // AJAX 요청으로 상위 10개 여행지 데이터 가져오기
  console.log("111");
  $.ajax({
    url: "/api/top-destinations", // 실제 데이터가 반환될 API 엔드포인트
    method: "GET",
    success: function (data) {
      const destinationsContainer = $("#topDestinations");
      // 데이터 배열을 순회하며 각 여행지 추가
      $.each(data, function (index, destination) {
        const destinationItem = $('<div class="destinationItem"></div>');

        // 각 도시의 이름, 관광 수, 요청 수를 추가
        const cityName = $("<h3></h3>").text(destination.cityName);
        const numberOfTours = $("<p></p>").text(
          "Number of Tours: " + destination.numberOfTours
        );
        const numberOfRequests = $("<p></p>").text(
          "Number of Requests: " + destination.numberOfRequests
        );

        destinationItem
          .append(cityName)
          .append(numberOfTours)
          .append(numberOfRequests);
        destinationsContainer.append(destinationItem);
      });
    },
    error: function (xhr, status, error) {
      console.error("데이터를 가져오는 데 실패했습니다:", error);
      $("#topDestinations").html(
        "<p>여행지 정보를 가져오는 데 문제가 발생했습니다.</p>"
      );
    },
  });
});
