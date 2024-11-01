$().ready(function () {
  const $touristButton = $(".touristButton");
  const $guideButton = $(".guideButton");

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
  });

  $guideButton.on("click", function () {
    selectButton($guideButton);
  });
});
