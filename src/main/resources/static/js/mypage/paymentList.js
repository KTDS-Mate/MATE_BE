/*
	data = {
		"trstId": trstId,
		"tourType" : 'TOURIST',
		"payState" : 'COMPLETE',
		"startDate": '2023-03-01',
		"endDate": '2024-05-01',
		"searchType": '최근일주일',
	};
*/
$().ready(function () {
  if ($("#date-hidden").val() != "기간검색") {
    $(".date-range").html("");
  }

  $(".search-button").on("click", function () {
    movePage(0);
  });

  $(".date-buttons")
    .find('input[type="button"]')
    .on("click", function () {
      if ($(this).val() === "전체조회") {
        return;
      }
      $(".date-buttons").find('input[type="button"]').removeClass("checked");
      $(this).addClass("checked");

      $("#date-hidden").val($(this).val());
      $(".date-range").html("");

      if ($("#date-hidden").val() === "기간검색") {
        var customDateForm = `
			<input id="startDate" type="date" class="startDate" value="" name="startDate" />
			~
			<input id="endDate" type="date" class="endDate" value="" name="endDate"/>
			`;
        $(".date-range").append(customDateForm);
      }

      // if(buttonVal === '1week' )
      // 여기서 오늘 날자 가져오는 것을 이용하여 일주일 전을 startDt로 잡는다.
      // endDt는 주지않는다. 어차피 endDt 없으면 자동으로 sysdate가져가게 할 것임.
    });
});

function movePage(pageNo) {
  $(".page-no").val(pageNo);

  $(".search-form")
    .attr({
      method: "GET",
      action: "/mypage/payment/list",
    })
    .submit();
}
