$().ready(function () {
  const $touristButton = $(".touristButton");
  const $guideButton = $(".guideButton");
  const $touristText = $(".touristText");
  const $guideText = $(".guideText");
  const $searchButton = $(".tourSearchButton");
  const $searchButtonText = $(".tourSearchButtonText");

  function selectButton($selectedButton) {
    $touristButton.removeClass("selectedButton");
    $guideButton.removeClass("selectedButton");
    $selectedButton.addClass("selectedButton");
  }

  // 처음 접속 시 touristButton이 선택되도록 설정
  $(document).ready(function () {
    selectButton($touristButton);
  });

  $touristButton.on("click", function () {
    selectButton($touristButton);
    // $touristText.removeClass("hidden");
    // $guideText.addClass("hidden");
  });

  $guideButton.on("click", function () {
    selectButton($guideButton);
    // $touristButton.addClass("hidden");
    // $guideText.removeClass("hidden");
  });

  $searchButton.on("click", function () {
    $searchButton.addClass("ishovered");
    $searchButtonText.addClass("ishovered");
    $.ajax({
      url: "/api/top-destinations", // 실제 데이터가 반환될 API 엔드포인트
      method: "GET",
      success: function (data) {},
    });
  });
});
